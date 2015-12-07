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
	 * Time Event�� �ش� data list �˻�
	 * @return
	 */
	public List<Event> selectTimeEvent() {
		System.out.println("##Debug_in_EventDAO: selectTimeEvent()����");
		return sqlSession.selectList("selectTimeEvent");
	}
	
	/**
	 * Time Event �߰�
	 * @param dto
	 * @return
	 */
	public int addTimeEvent(Event dto) {
		System.out.println("##Debug_in_EventDAO:  addTimeEvent()����");
		return sqlSession.insert("addTimeEvent", dto);
	}
	
	/**
	 * Time Event ����
	 * @param map
	 * @return
	 */
	public int deleteTimeEvent(HashMap map) {
		System.out.println("## Debug_in_EventDAO: deleteTimeEvnet()����");
		return sqlSession.delete("deleteTimeEvent", map);
	}
	
	/**
	 * ���ܿ� ���� �δ�ü� �̸� �˻�
	 * @param beaconMinor
	 * @return
	 */
	public List<Event> selectFacByBeacon (int beaconMinor) {
		System.out.println("## Debug_in_EventDAO: selectFacByBeacon()����");
		return sqlSession.selectList("selectFacByBeacon", beaconMinor);
	}
}
