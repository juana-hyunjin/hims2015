package com.syu.hims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.syu.hims.dto.Reservation;
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
		System.out.println("## ajax 예약번호 넘어온값: " + bookNo);
		int rsvNo = Integer.parseInt(bookNo);
		List<Reservation> list = service.searchData(rsvNo);
		System.out.println("## Debung_in RsvController list주소: " + list.get(0).getUsername());
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		return json;
	}
}
