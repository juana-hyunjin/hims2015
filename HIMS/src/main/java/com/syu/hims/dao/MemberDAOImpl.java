package com.syu.hims.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * ȸ����������� ����ϴ� DAO Ŭ����
 * 
 * @author JOO
 *
 */
@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private static final MemberDAOImpl INSTANCE = new MemberDAOImpl();
	public static MemberDAOImpl getInstance() {
		return INSTANCE;
	}
	
	/**
	 * ���̵� �ߺ�Ȯ��
	 * @param userid
	 * @return
	 */
	public boolean checkId(String userid) {
		System.out.println("## Debug_in_MemberDAO����: checkID()");
		int count = sqlSession.selectOne("checkId", userid);
		/* ����� 0�̻��̸� �ߺ��� ���̵� �ִٴ� �� -> true ��ȯ  */
		if(count>0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * �α��� ó��
	 * @param map
	 * @return
	 */
	public String login(HashMap<String, String> map) {
		System.out.println("## Debug_in_MemberDAO����: login()");
		return sqlSession.selectOne("selectLogin", map);
	}
}
