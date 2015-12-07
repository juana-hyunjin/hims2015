package com.syu.hims.dao;

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
	 * 층별로 방정보를 조회하는 메서드
	 * @param floor
	 * @return
	 */
	public List<RoomType> searchRoomInfo(String floor) {
		System.out.println("## Debugn_in_RoomDAO실행: searchRoomInfo실행");
		System.out.println("해당 넘어온 floor값: " + floor);
		return sqlSession.selectList("searchRoomlist", floor);
	}
	
	/**
	 * 객실추가 기능에서 객실 사진업로드를 처리하는 메서드
	 * @param dto
	 * @return
	 */
	public int addRoomPics(RoomPics dto) {
		System.out.println("## Debug_ in_RoomDAO: addRoomPics()실행");
		return sqlSession.insert("addRoomPics", dto);
	}
	
	/**
	 * 객실모니터링을 위해 층별로
	 * 객실 사용가능여부를 검색하는 메서드
	 * @param floor
	 * @return
	 */
	public List<Room> monitoring(String floor) {
		System.out.println("## debug_inRoomDAO:  monitoring()실행");
		System.out.println("##debug: 넘어온 floor값 " + floor);
		return sqlSession.selectList("monitoring", floor);
	}
	
	/**
	 * 객실모니터링시 사용중인 방의 예약자 정보검색
	 * @param floor
	 * @return
	 */
	public List<Reservation> monitoringInfo(String floor) {
		System.out.println("## debug_in_RoomDAO: monitoringInfo()실행");
		System.out.println("##debug: 넘어온 floo값" + floor);
		return sqlSession.selectList("monitorRsvInfo", floor);
 	}
}
