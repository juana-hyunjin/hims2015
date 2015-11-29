package com.syu.hims.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.syu.hims.dto.Reservation;

/**
 * 예약관리기능을 담당하는 DAO클래스
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
	 * 예약번호로 해당하는 데이터 검색하는 메서드
	 * @param bookNo
	 * @return
	 */
	public List<Reservation> searchData(int rsvNo) {
		System.out.println("## Debug_in_ReservationDAO실행: searchData()");
		System.out.println("DAO로 넘어온 예약번호값: " + rsvNo);
		
		return sqlSession.selectList("searchData", rsvNo);
	}
	
}
