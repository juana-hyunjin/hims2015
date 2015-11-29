package com.syu.hims.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syu.hims.dao.ReservationDAOImpl;
import com.syu.hims.dto.Reservation;

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
	public List<Reservation> searchData(int rsvNo) {
		System.out.println("##Debug_in_RSVService: searchData()����");
		return dao.searchData(rsvNo);
	}
}
