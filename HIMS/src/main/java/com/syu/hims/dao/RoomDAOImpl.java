package com.syu.hims.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.syu.hims.dto.Reservation;
import com.syu.hims.dto.Room;
import com.syu.hims.dto.RoomPics;
import com.syu.hims.dto.RoomType;

@Repository
public class RoomDAOImpl {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final RoomDAOImpl INSTANCE = new RoomDAOImpl();
	
	public static RoomDAOImpl getInstance() {
		return INSTANCE;
	}
	
	/**
	 * ������ �������� ��ȸ�ϴ� �޼���
	 * @param floor
	 * @return
	 */
	public List<RoomType> searchRoomInfo(String floor) {
		System.out.println("## Debugn_in_RoomDAO����: searchRoomInfo����");
		System.out.println("�ش� �Ѿ�� floor��: " + floor);
		return sqlSession.selectList("searchRoomlist", floor);
	}
	
	/**
	 * ������ �߰��ϴ� ���
	 * @param map
	 * @return
	 */
	public int addRoom(HashMap<String, Object> map) {
		System.out.println("## Debug_in_roomDAO: addRoom()����");
		if(sqlSession.insert("addRoom1", map)>0) {
			return 1;
		}
		return 0;
	}
	/**
	 * �����߰� ��ɿ��� ���� �������ε带 ó���ϴ� �޼���
	 * @param dto
	 * @return
	 */
	public int addRoomPics(RoomPics dto) {
		System.out.println("## Debug_ in_RoomDAO: addRoomPics()����");
		return sqlSession.insert("addRoomPics", dto);
	}
	
	/**
	 * ���Ǹ���͸��� ���� ������
	 * ���� ��밡�ɿ��θ� �˻��ϴ� �޼���
	 * @param floor
	 * @return
	 */
	public List<Room> monitoring(String floor) {
		System.out.println("## debug_inRoomDAO:  monitoring()����");
		System.out.println("##debug: �Ѿ�� floor�� " + floor);
		return sqlSession.selectList("monitoring", floor);
	}
	
	/**
	 * ���Ǹ���͸��� ������� ���� ������ �����˻�
	 * @param floor
	 * @return
	 */
	public List<Reservation> monitoringInfo(String floor) {
		System.out.println("## debug_in_RoomDAO: monitoringInfo()����");
		System.out.println("##debug: �Ѿ�� floo��" + floor);
		return sqlSession.selectList("monitorRsvInfo", floor);
 	}
}
