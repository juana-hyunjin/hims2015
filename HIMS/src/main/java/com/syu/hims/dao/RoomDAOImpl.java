package com.syu.hims.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
