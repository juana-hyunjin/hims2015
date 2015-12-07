package com.syu.hims.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.syu.hims.dto.Member;

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

	/**
	 * 관리자 신청한 회원 리스트 검색 
	 * @return
	 */
	public List<Member> adminApprovalList() {
		System.out.println("## Debug_in_MemberDAO실행: adminApprovalList()");
		if(!sqlSession.selectList("adminApprovalList").isEmpty()) {
			return sqlSession.selectList("adminApprovalList");
		} else {
			return null;
		}
	}

	/**
	 * 관리자 신청한 회원을 관리자로 승격
	 * @param hashMap
	 * @return
	 */
	public int adminApproval(HashMap<String, String> hashMap){
		System.out.println("## Debug_in_MemberDAO실행: adminApproval()");
		return sqlSession.update("adminApproval", hashMap);
	}

	/**
	 * 관리자 신청한 회원이 거절당했을 시
	 * 회원탈퇴로 처리하는 메서드
	 * @param hashMap
	 * @return
	 */
	public int adminReject(HashMap<String, String> hashMap) {
		System.out.println("## Debug_in_MemberDAO실행: adminReject()");
		return sqlSession.delete("adminReject", hashMap);	
	}
	
	/**
	 * 회원가입
	 * @param hashMap
	 * @return
	 */
	public String join(HashMap<String, String> hashMap) {
		System.out.println("## Debug_in_MemberDAO실행: join()");
		return sqlSession.selectOne("join", hashMap);
	}
	
	/**
	 * 관리자 신청인이 몇 명있는지 확인하는 메서드
	 * @return
	 */
	public int howmanyAP() {
		System.out.println("##Debug_in_memberDAO: howmanyAP()실행");
		return sqlSession.selectOne("howmanyAP");
	}
	
	/**
	 * 카테고리별로 회원정보 검색
	 * @param hashmap
	 * @return
	 */
	public List<Member> infoSearchList(HashMap<String,String> hashmap) {
		System.out.println("##Debug_in_memberDAO: infoSearch()실행");
		System.out.println("##debug: " + hashmap.get("category"));
		System.out.println("##debug: " + hashmap.get("searchData"));
		return sqlSession.selectList("infoSearch", hashmap);
	}
}
