package com.syu.hims.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 회원관리기능을 담당하는 DAO 클래스
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
	 * 아이디 중복확인
	 * @param userid
	 * @return
	 */
	public boolean checkId(String userid) {
		System.out.println("## Debug_in_MemberDAO실행: checkID()");
		int count = sqlSession.selectOne("checkId", userid);
		/* 결과가 0이상이면 중복된 아이디가 있다는 뜻 -> true 반환  */
		if(count>0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 로그인 처리
	 * @param map
	 * @return
	 */
	public String login(HashMap<String, String> map) {
		System.out.println("## Debug_in_MemberDAO실행: login()");
		return sqlSession.selectOne("selectLogin", map);
	}
}
