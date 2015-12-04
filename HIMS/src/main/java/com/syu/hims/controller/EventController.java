package com.syu.hims.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.syu.hims.dto.Event;
import com.syu.hims.service.EventServiceImpl;

@Controller
public class EventController {
	private EventServiceImpl service;
	@Autowired
	public void setService(EventServiceImpl service) {
		this.service = service;
	}
	@RequestMapping("event.selectEvent.do")
	public String EventView() {
		return "event/selectEvent";
	}
	
	/**
	 * Time Event�� �ش� data list �˻�
	 * @return
	 */
	@RequestMapping(value="event.selectTimeEvent.do", produces="text/plain;charset=UTF-8")
	public @ResponseBody String selectTimeEvent() {
		System.out.println("## Debug_in_eventController: selectTimeEvent()����");
		List<Event> list = service.selectTimeEvent();
		System.out.println("## debug list size: " + list.size());
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		return json;
	}
	
	/**
	 * Time Event�� �߰��ϴ� �޼���
	 * @param beaconMinor
	 * @param facName
	 * @param eventTime
	 */
	@RequestMapping(value="event.addTimeEvent.do", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String addTimeEvent(String beaconMinor, String facName, String eventTime, String winner) {
		System.out.println("## Debug_in_eventController: addTimeEvent()����");
		Event dto = new Event(Integer.parseInt(beaconMinor), facName, eventTime, winner);
		Gson gson = new Gson();
		if(service.addTimeEvent(dto)) {
			String json = gson.toJson(dto);
			System.out.println(json);
			return json;
		} else {
			String json = "fail";
			return json;
		}
	}
	
	/**
	 * Time Event ����
	 * @param beaconMinor
	 * @param eventTime
	 */
	@RequestMapping(value="event.deleteTimeEvent.do", produces="text/plain;charset=UTF-8")
	public void deleteTimeEvent(String beaconMinor, String eventTime) {
		System.out.println("##Debug_in_eventcontroller: deleteTimeEvent()����");
		boolean flag = service.deleteTimeEvent(Integer.parseInt(beaconMinor), eventTime);
		System.out.println("��� �÷��׺���: " + flag);
	}
}
