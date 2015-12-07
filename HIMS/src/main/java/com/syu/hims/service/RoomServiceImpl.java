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
	 * ������ �������� ��ȸ�ϴ� �޼���
	 * @param floor
	 * @return
	 */
	public List<RoomType> searchRoomInfo(String floor) {
		System.out.println("## Debug_in_RoomService: searchRoomInfo����");
		return dao.searchRoomInfo(floor);
	}
	
	/**
	 * �����߰��� ���� ������ ���ε带 ó���ϴ� �޼���
	 * @param dto
	 * @return
	 */
	public boolean addRoomPics(RoomPics dto) {
		System.out.println("## Debug_in_RoomService: addRoomPics()����");
		if(dao.addRoomPics(dto) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * ���Ǹ���͸��� ���� ������
	 * ���� ��밡�ɿ��θ� ��ȸ�ϴ� �޼���
	 * @param floor
	 * @return
	 */
	public List<Room> monitoring(String floor) {
		System.out.println("## Debug_in_RoomService: monitoring()����");
		return dao.monitoring(floor);
	}

	/**
	 * ���Ǹ���͸��� ������� ���� ������ ���� �˻�
	 * @param floor
	 * @return
	 */
	public List<Reservation> monitoringInfo(String floor) {
		System.out.println("## Debug_in_RoomService: monitoringInfo()����");
		return dao.monitoringInfo(floor);
	}
}
