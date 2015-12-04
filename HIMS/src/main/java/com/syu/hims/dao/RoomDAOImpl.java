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
	 * 층별로 방정보를 조회하는 메서드
	 * @param floor
	 * @return
	 */
	public List<RoomType> searchRoomInfo(String floor) {
		System.out.println("## Debugn_in_RoomDAO실행: searchRoomInfo실행");
		System.out.println("해당 넘어온 floor값: " + floor);
		return sqlSession.selectList("searchRoomlist", floor);
	}
}
