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
	 * �����ȣ�� �ش��ϴ� ������ �˻��ϴ� �޼���
	 * @param bookNo
	 * @return
	 */
	public List<Reservation> searchData(String bookNo) {
		System.out.println("##Debug_in_RSVService: searchData()����");
		List<Reservation> list = dao.searchData(bookNo);
		list.get(0).setMemo(" ");
		return list;
	}
	
	/**
	 * ���డ���� ���� ��ȸ�ϴ� �޼���
	 * @param map
	 * @return
	 */
	public ArrayList<Room> searchAvailRoom(HashMap map) {
		System.out.println("##Debug_in_RsvService: searchAvailRoom()����");
		return dao.searchAvailRoom(map);
	}
	
	/**
	 * ���� �����ϴ� �޼���
	 * @param roomNo
	 * @return
	 */
	public boolean assignRoom(HashMap map, int roomNo) {
		System.out.println("##Debug_in_rsvService: assignRoom()����");
		return dao.assignRoom(map, roomNo);
	}
	
	/**
	 * �� �������θ� Ȯ���ϴ� �޼���
	 * @param roomNo
	 * @return
	 */
	public boolean assignYN(String bookNo) {
		return dao.assginYN(bookNo);
	}
}
