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
	public List<Reservation> searchData(String bookNo) {
		System.out.println("## Debug_in_ReservationDAO����: searchData()");
		System.out.println("DAO�� �Ѿ�� �����ȣ��: " + bookNo);

		return sqlSession.selectList("searchData", bookNo);
	}

	/**
	 * ���డ���� ���� ��ȸ�ϴ� �޼���
	 * @param bookNo
	 * @return
	 */
	public ArrayList<Room> searchAvailRoom(HashMap map) {
		System.out.println("## Debug_in_ReservationDAO����: searchRoom()");
		System.out.println("DAO�� �Ѿ�� �ؽø�(�뼭ġ): " + map);

		ArrayList<Room> list = new ArrayList<Room>();
		list.addAll(sqlSession.selectList("searchAvailRoom", map));
		System.out.println("������ ��ѹ�: " + list.get(0).getRoomNo());
		return list;
	}

	/**
	 * ���� �����ϴ� �޼���
	 * @param roomNo
	 * @return
	 */
	public boolean assignRoom(HashMap map, int roomNo) {
		System.out.println("##Debug_in_rsvDAO: assignRoom()����");
		if(sqlSession.update("assignRoom1", roomNo)>0) {
			sqlSession.update("assignRoom2", map);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ����� ���θ�  Ȯ���ϴ� �޼���
	 * @param roomNo
	 * @return
	 */
	public boolean assginYN(String bookNo) {
		System.out.println("##Debug_in_rsvDAO: assignYN()����");
		int count = sqlSession.selectOne("assignYN", bookNo);
		System.out.println("assignYN()���� �����count: " + count);
		if(count > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * üũ�ƿ��� ó���ϴ� �޼���
	 * @return
	 */
	public boolean checkOutRoom(String rsvNo) {
		System.out.println("## Debug_in_rsvDAO: checkoutRoom()����");
		System.out.println("##debug dao / �����ȣ: " + rsvNo);
		int count = sqlSession.update("checkoutRoom", rsvNo);
		System.out.println("##debug: count: " + count);
		if(count > 0) {
			return true;
		} else {
			return false;
		}
	}

}
