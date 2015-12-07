package com.syu.hims.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.syu.hims.dto.Reservation;
import com.syu.hims.dto.Room;

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
	public List<Reservation> searchData(String bookNo) {
		System.out.println("## Debug_in_ReservationDAO실행: searchData()");
		System.out.println("DAO로 넘어온 예약번호값: " + bookNo);

		return sqlSession.selectList("searchData", bookNo);
	}

	/**
	 * 예약가능한 방을 조회하는 메서드
	 * @param bookNo
	 * @return
	 */
	public ArrayList<Room> searchAvailRoom(HashMap map) {
		System.out.println("## Debug_in_ReservationDAO실행: searchRoom()");
		System.out.println("DAO로 넘어온 해시맵(룸서치): " + map);

		ArrayList<Room> list = new ArrayList<Room>();
		list.addAll(sqlSession.selectList("searchAvailRoom", map));
		System.out.println("가능한 룸넘버: " + list.get(0).getRoomNo());
		return list;
	}

	/**
	 * 방을 배정하는 메서드
	 * @param roomNo
	 * @return
	 */
	public boolean assignRoom(HashMap map, int roomNo) {
		System.out.println("##Debug_in_rsvDAO: assignRoom()실행");
		if(sqlSession.update("assignRoom1", roomNo)>0) {
			sqlSession.update("assignRoom2", map);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 방배정 여부를  확인하는 메서드
	 * @param roomNo
	 * @return
	 */
	public boolean assginYN(String bookNo) {
		System.out.println("##Debug_in_rsvDAO: assignYN()실행");
		int count = sqlSession.selectOne("assignYN", bookNo);
		System.out.println("assignYN()실행 결과값count: " + count);
		if(count > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 체크아웃을 처리하는 메서드
	 * @return
	 */
	public boolean checkOutRoom(String rsvNo) {
		System.out.println("## Debug_in_rsvDAO: checkoutRoom()실행");
		System.out.println("##debug dao / 예약번호: " + rsvNo);
		int count = sqlSession.update("checkoutRoom", rsvNo);
		System.out.println("##debug: count: " + count);
		if(count > 0) {
			return true;
		} else {
			return false;
		}
	}

}
