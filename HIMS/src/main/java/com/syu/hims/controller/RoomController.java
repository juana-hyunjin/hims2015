package com.syu.hims.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.syu.hims.dto.RoomType;
import com.syu.hims.service.RoomServiceImpl;

@Controller
public class RoomController {
	private RoomServiceImpl service;
	@Autowired
	public void setService(RoomServiceImpl service) {
		this.service = service;
	}
	@RequestMapping("room.room.do")
	public String roomView() {
		return "room/selectRoom";
	}
	@RequestMapping("room.addRoomView.do")
	public String addRoomView() {
		return "room/addRoom";
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
	
	@RequestMapping(value="room.addRoom.do", produces="text/plain;charset=UTF-8")
	public ModelAndView addRoom(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
}
