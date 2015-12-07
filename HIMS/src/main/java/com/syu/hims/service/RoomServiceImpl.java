package com.syu.hims.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syu.hims.dao.RoomDAOImpl;
import com.syu.hims.dto.Reservation;
import com.syu.hims.dto.Room;
import com.syu.hims.dto.RoomPics;
import com.syu.hims.dto.RoomType;


@Service
public class RoomServiceImpl implements RoomService {
	private RoomDAOImpl dao;
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	public void setDao(RoomDAOImpl dao) {
		this.dao = dao;
	}

	/**
	 * 층별로 방정보를 조회하는 메서드
	 * @param floor
	 * @return
	 */
	public List<RoomType> searchRoomInfo(String floor) {
		System.out.println("## Debug_in_RoomService: searchRoomInfo실행");
		return dao.searchRoomInfo(floor);
	}
	
	/**
	 * 객실추가시 객실 사진을 업로드를 처리하는 메서드
	 * @param dto
	 * @return
	 */
	public boolean addRoomPics(RoomPics dto) {
		System.out.println("## Debug_in_RoomService: addRoomPics()실행");
		if(dao.addRoomPics(dto) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 객실모니터링을 위해 층별로
	 * 객실 사용가능여부를 조회하는 메서드
	 * @param floor
	 * @return
	 */
	public List<Room> monitoring(String floor) {
		System.out.println("## Debug_in_RoomService: monitoring()실행");
		return dao.monitoring(floor);
	}

	/**
	 * 객실모니터링시 사용중인 방의 예약자 정보 검색
	 * @param floor
	 * @return
	 */
	public List<Reservation> monitoringInfo(String floor) {
		System.out.println("## Debug_in_RoomService: monitoringInfo()실행");
		return dao.monitoringInfo(floor);
	}
}
