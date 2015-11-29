package com.syu.hims.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.syu.hims.dto.Reservation;

/**
 * ������������ ����ϴ� DAOŬ����
 * @author Juana
 */
@Repository
public class ReservationDAOImpl implements ReservationDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private static final ReservationDAOImpl INSTANCE = new ReservationDAOImpl();
	public static ReservationDAOImpl getInstance() {
		return INSTANCE;
	}
	
	/**
	 * �����ȣ�� �ش��ϴ� ������ �˻��ϴ� �޼���
	 * @param bookNo
	 * @return
	 */
	public List<Reservation> searchData(int rsvNo) {
		System.out.println("## Debug_in_ReservationDAO����: searchData()");
		System.out.println("DAO�� �Ѿ�� �����ȣ��: " + rsvNo);
		
		return sqlSession.selectList("searchData", rsvNo);
	}
	
}
