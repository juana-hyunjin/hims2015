package com.syu.hims.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.syu.hims.dto.Event;

@Repository
public class EventDAOImpl implements EventDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private static final EventDAOImpl INSTANCE = new EventDAOImpl();
	public static EventDAOImpl getInstance() {
		return INSTANCE;
	}
	
	/**
	 * Time Event의 해당 data list 검색
	 * @return
	 */
	public List<Event> selectTimeEvent() {
		System.out.println("##Debug_in_EventDAO: selectTimeEvent()실행");
		return sqlSession.selectList("selectTimeEvent");
	}
	
	/**
	 * Time Event 추가
	 * @param dto
	 * @return
	 */
	public int addTimeEvent(Event dto) {
		System.out.println("##Debug_in_EventDAO:  addTimeEvent()실행");
		return sqlSession.insert("addTimeEvent", dto);
	}
	
	/**
	 * Time Event 삭제
	 * @param map
	 * @return
	 */
	public int deleteTimeEvent(HashMap map) {
		System.out.println("## Debug_in_EventDAO: deleteTimeEvnet()실행");
		return sqlSession.delete("deleteTimeEvent", map);
	}
	
	/**
	 * 비콘에 따른 부대시설 이름 검색
	 * @param beaconMinor
	 * @return
	 */
	public List<Event> selectFacByBeacon (int beaconMinor) {
		System.out.println("## Debug_in_EventDAO: selectFacByBeacon()실행");
		return sqlSession.selectList("selectFacByBeacon", beaconMinor);
	}
}
