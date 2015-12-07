package com.syu.hims.controller;

import java.io.File;
import java.util.ArrayList;
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
	 * ������ �������� ��ȸ�ϴ� �޼���
	 * @param floor
	 * @return
	 */
	@RequestMapping(value="room.searchRoomlist.do", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String searchRoomlist(String floor) {
		System.out.println("##Debug_in_roomController: searchRoomlist()����");
		System.out.println("##Debug: ajax���� �Ѿ�� floor��: " + floor);
		List<RoomType> list = service.searchRoomInfo(floor);
		System.out.println("##Debug: ���� ������list: " + list);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		return json;
	}

	/**
	 * ������ �߰��ϴ� �޼���(���ؿ����� �ϼ��ؾ���)
	 * @param request
	 * @return
	 */
	@RequestMapping(value="room.addRoom.do", produces="text/plain;charset=UTF-8")
	public ModelAndView addRoom(HttpServletRequest request, RoomPics dto) throws Exception {
		System.out.println("##Debug_in_roomController: addRoom()����");
		ModelAndView mv = new ModelAndView();
		int roomNo = Integer.parseInt((String)request.getParameter("roomNo"));
		int roomTypeNo = Integer.parseInt((String) request.getParameter("typeName"));
		int limitNum = Integer.parseInt((String)request.getParameter("limitNum"));
		String bed = request.getParameter("bed");
		String floor = request.getParameter("floor");
		System.out.println("##debug: request���� �� ����: " + roomNo + roomTypeNo + limitNum + bed + floor);
		MultipartFile multi = dto.getFile();
		if(!multi.isEmpty()) { //���Ͼ��ε尡 �Ǿ��ٸ�
			String orgName = multi.getOriginalFilename();
			String newName = orgName + System.currentTimeMillis() + multi.getSize();
			String picsPath = servletContext.getRealPath("/upload");
			System.out.println("##debug: " + picsPath);
			File file = new File(picsPath + newName);
			dto.setOrgName(orgName);
			dto.setNewName(newName);
			dto.setRoomTypeNo(roomTypeNo);
			dto.setPicsPath(picsPath);
			multi.transferTo(file);
			if(service.addRoomPics(dto)) {
				System.out.println("##debug: ���ǻ������ε� ����");
				
			} else {
				System.out.println("##debug:  ���ǻ������ε� ����");
			}
		}
		
		mv.setViewName("room/selectRoom");
		return mv;
	}
	
	/**
	 * ���� ����͸��� ���� �޼���
	 * @param floor
	 * @return
	 */
	@RequestMapping(value="room.monitoring.do", produces="text/plain;charset=UTF-8")
	public @ResponseBody String monitoring(String floor) {
		System.out.println("##debug_in_RoomController: monitoring()����");
		System.out.println("##Debug: ajax���� �Ѿ�� floor��: " + floor);
		ArrayList<Room> list = (ArrayList<Room>) service.monitoring(floor);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		return json;
	}
	
	/**
	 * ���� ���� ����� ���������� �˻��ϴ� �޼���
	 * @param floor
	 * @return
	 */
	@RequestMapping(value="room.monitoringInfo.do")
	public @ResponseBody String monitoringInfo(String floor) {
		System.out.println("##debug_in_roomController: monitoringInfo()����");
		ArrayList<Reservation> list = (ArrayList<Reservation>) service.monitoringInfo(floor);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		return json;
	}
	
}
