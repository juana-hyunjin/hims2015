package com.syu.hims.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.syu.hims.dto.Reservation;
import com.syu.hims.dto.Room;
import com.syu.hims.dto.RoomPics;
import com.syu.hims.dto.RoomType;
import com.syu.hims.service.RoomServiceImpl;

@Controller
public class RoomController implements ServletContextAware{
	private RoomServiceImpl service;
	private ServletContext servletContext;
	@Autowired
	public void setService(RoomServiceImpl service) {
		this.service = service;
	}
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	@RequestMapping("room.room.do")
	public String roomView() {
		return "room/selectRoom";
	}
	@RequestMapping("room.addRoomView.do")
	public String addRoomView() {
		return "room/addRoom";
	}
	@RequestMapping("room.monitoringView.do")
	public String monitoringView() {
		return "room/monitoring";
	}
	/**
	 * 층별로 방정보를 조회하는 메서드
	 * @param floor
	 * @return
	 */
	@RequestMapping(value="room.searchRoomlist.do", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String searchRoomlist(String floor) {
		System.out.println("##Debug_in_roomController: searchRoomlist()실행");
		System.out.println("##Debug: ajax에서 넘어온 floor값: " + floor);
		List<RoomType> list = service.searchRoomInfo(floor);
		System.out.println("##Debug: 서비스 실행결과list: " + list);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		return json;
	}

	/**
	 * 객실을 추가하는 메서드(경준오빠가 완성해야함)
	 * @param request
	 * @return
	 */
	@RequestMapping(value="room.addRoom.do", produces="text/plain;charset=UTF-8")
	public ModelAndView addRoom(HttpServletRequest request, RoomPics dto) throws Exception {
		System.out.println("##Debug_in_roomController: addRoom()실행");
		ModelAndView mv = new ModelAndView();
		int roomTypeNo = Integer.parseInt((String) request.getParameter("typeName"));
		String typeName = "";
		if(roomTypeNo==1) {
			typeName = "SINGLE ROOM";
		} else if(roomTypeNo==2) {
			typeName = "TWIN ROOM";
		} else if(roomTypeNo==3) {
			typeName = "DOUBLE ROOM";
		} else if(roomTypeNo==4) {
			typeName = "DELUX ROOM";
		} else if(roomTypeNo==5) {
			typeName = "SUITE ROOM";
		} else if(roomTypeNo==6) {
			typeName = "PRESIDENT ROOM";
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("roomNo", Integer.parseInt((String)request.getParameter("roomNo")));
		map.put("roomTypeNo", Integer.parseInt((String) request.getParameter("typeName")));
		map.put("limitNum", Integer.parseInt((String)request.getParameter("limitNum")));
		map.put("bed", request.getParameter("bed"));
		map.put("floor", request.getParameter("floor"));
		map.put("typeName", typeName);
		map.put("bed", request.getParameter("bed"));
		map.put("price", request.getParameter("price"));
		
		boolean flag = service.addRoom(map);
		System.out.println("##debug addroom 결과: " + flag);
		
		MultipartFile multi = dto.getFile();
		
		if(!multi.isEmpty()) { //파일업로드가 되었다면
			String orgName = multi.getOriginalFilename();
			String newName = System.currentTimeMillis() + multi.getSize() + orgName;
			String picsPath = servletContext.getRealPath("/upload");
			System.out.println("##debug: " + picsPath);
			File file = new File(picsPath + newName);
			dto.setOrgName(orgName);
			dto.setNewName(newName);
			dto.setRoomTypeNo(roomTypeNo);
			dto.setPicsPath("/upload");
			multi.transferTo(file);
			if(service.addRoomPics(dto)) {
				System.out.println("##debug: 객실사진업로드 성공");
				
			} else {
				System.out.println("##debug:  객실사진업로드 실패");
			}
		}
		mv.setViewName("room/selectRoom");
		return mv;
	}
	
	/**
	 * 객실 모니터링을 위한 메서드
	 * @param floor
	 * @return
	 */
	@RequestMapping(value="room.monitoring.do", produces="text/plain;charset=UTF-8")
	public @ResponseBody String monitoring(String floor) {
		System.out.println("##debug_in_RoomController: monitoring()실행");
		System.out.println("##Debug: ajax에서 넘어온 floor값: " + floor);
		ArrayList<Room> list = (ArrayList<Room>) service.monitoring(floor);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		return json;
	}
	
	/**
	 * 객실 사용시 사용자 예약정보를 검색하는 메서드
	 * @param floor
	 * @return
	 */
	@RequestMapping(value="room.monitoringInfo.do")
	public @ResponseBody String monitoringInfo(String floor) {
		System.out.println("##debug_in_roomController: monitoringInfo()실행");
		ArrayList<Reservation> list = (ArrayList<Reservation>) service.monitoringInfo(floor);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		return json;
	}
	
	/**
	 * 메인에 삽입을 위한
	 * 현재 객실사용 회원 리스트
	 * @return
	 */
	public ModelAndView rsvlistMain() {
		System.out.println("## Debug_in_homeController: rsvlistMain()실행");
		return null;
	}
	
	/**
	 * 메인삽입
	 * 층별 현재 객실 사용 회원 리스트
	 * @param request
	 * @return
	 */
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		ArrayList<Reservation> list = (ArrayList<Reservation>) service.monitoringInfo("4");
		mv.addObject(list);
		return mv;
	}
}
