package com.syu.hims.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syu.hims.dao.ReservationDAOImpl;
import com.syu.hims.dto.Reservation;
import com.syu.hims.dto.Room;

@Service
public class ReservationServiceImpl implements ReservationService {
	private ReservationDAOImpl dao;
	
	@Autowired
	public void setDao(ReservationDAOImpl dao) {
		this.dao = dao;
	}
	
	/**
	 * 예약번호로 해당하는 데이터 검색하는 메서드
	 * @param bookNo
	 * @return
	 */
	public List<Reservation> searchData(String bookNo) {
		System.out.println("##Debug_in_RSVService: searchData()실행");
		List<Reservation> list = dao.searchData(bookNo);
		list.get(0).setMemo(" ");
		return list;
	}
	
	/**
	 * 예약가능한 방을 조회하는 메서드
	 * @param map
	 * @return
	 */
	public ArrayList<Room> searchAvailRoom(HashMap map) {
		System.out.println("##Debug_in_RsvService: searchAvailRoom()실행");
		return dao.searchAvailRoom(map);
	}
	
	/**
	 * 방을 배정하는 메서드
	 * @param roomNo
	 * @return
	 */
	public boolean assignRoom(HashMap map, int roomNo) {
		System.out.println("##Debug_in_rsvService: assignRoom()실행");
		return dao.assignRoom(map, roomNo);
	}
	
	/**
	 * 방 배정여부를 확인하는 메서드
	 * @param roomNo
	 * @return
	 */
	public boolean assignYN(String bookNo) {
		return dao.assginYN(bookNo);
	}
}
