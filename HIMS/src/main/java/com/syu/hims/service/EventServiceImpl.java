package com.syu.hims.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syu.hims.dao.EventDAOImpl;
import com.syu.hims.dto.Event;

@Service
public class EventServiceImpl implements EventService {
	private EventDAOImpl dao;
	@Autowired
	public void setDao(EventDAOImpl dao) {
		this.dao = dao;
	}
	
	/**
	 * Time Event�� �ش� data list �˻�
	 * @return
	 */
	public List<Event> selectTimeEvent() {
		return dao.selectTimeEvent();
	}
	
	/**
	 * Time Event �߰�
	 * @param dto
	 * @return
	 */
	public boolean addTimeEvent(Event dto) {
		System.out.println("## Debug_in_EventService: addTimeEvent()����");
		if(dao.addTimeEvent(dto)>0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Time Event ����
	 * @return
	 */
	public boolean deleteTimeEvent(int beaconMinor, String eventTime) {
		System.out.println("## Debug in EventService: deleteTimeEvent()����");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("beaconMinor", beaconMinor);
		map.put("eventTime", eventTime);
		if(dao.deleteTimeEvent(map)>0) {
			return true;
		} else {
			return false;
		}
	}
}
