package com.syu.hims.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.syu.hims.dto.Reservation;
import com.syu.hims.dto.Room;
import com.syu.hims.service.ReservationServiceImpl;

@Controller
public class ReservationController {
	private ReservationServiceImpl service;
	@Autowired
	public void setService(ReservationServiceImpl service) {
		this.service = service;
	}
	
	@RequestMapping("rsv.rsvMainView.do")
	public String rsvMainView() {
		return "rsv/rsvMain";
	}
	
	/**
	 * 예약번호로 해당하는 데이터 검색하는 메서드
	 * @param rsvNo
	 * @return
	 */
	@RequestMapping(value="rsv.search.do", produces="text/plain;charset=UTF-8")
	public @ResponseBody String searchData(String bookNo) {
		System.out.println("## Debung in RsvController: searchData() 실행");
		List<Reservation> list = service.searchData(bookNo);
		/* 방 배정 여부 확인(assignYN) */
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		return json;
	}
	
	/**
	 * 예약가능한 방을 조회하는 메서드
	 * @param request
	 * @return
	 */
	@RequestMapping(value="rsv.searchAvailRoom.do", produces="text/plain;charset=UTF-8")
	public @ResponseBody String searchAvailRoom(String floor, String bookNo) {
		System.out.println("##Debug_in_rsvController: searchAvailroom()실행");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("floor", floor);
		map.put("bookNo", bookNo);
		
		ArrayList<Room> list = service.searchAvailRoom(map);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		return json;
	}
	
	/**
	 * 관리자가 방을 배정하는 메서드
	 * (Availability를 X로 전환)
	 * @param request
	 * @return
	 */
	@RequestMapping(value="rsv.assignRoom.do", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String assignRoom (Integer roomNo, String bookNo) {
		System.out.println("##Debug_in_rsvControler: assignRoom()실행");
		HashMap<String, Object> map = new HashMap<String, Object> ();
		map.put("roomNo", roomNo);
		map.put("bookNo", bookNo);
		service.assignRoom(map, roomNo);
		
		Gson gson = new Gson();
		String json = gson.toJson(map);
		return json;
	}
	
	@RequestMapping(value="rsv.checkout.do", produces="text/plain;charset=UTF-8")
	public void checkOutRoom(String bookNo) {
		System.out.println("##Debug_in_rsvController: checkoutRoom()실행");
		service.checkOutRoom(bookNo);
	}
	
	
}
