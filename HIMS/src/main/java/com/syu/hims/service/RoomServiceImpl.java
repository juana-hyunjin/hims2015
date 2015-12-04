package com.syu.hims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syu.hims.dao.RoomDAOImpl;
import com.syu.hims.dto.RoomType;


@Service
public class RoomServiceImpl implements RoomService {
	private RoomDAOImpl dao;
	
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
}
