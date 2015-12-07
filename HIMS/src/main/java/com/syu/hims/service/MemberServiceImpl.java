package com.syu.hims.service;

import java.util.HashMap;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syu.hims.dao.MemberDAOImpl;
import com.syu.hims.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {
	private MemberDAOImpl dao;
	
	@Autowired
	public void setDao(MemberDAOImpl dao) {
		this.dao = dao;
	}
	
	/**
	 * 아이디 중복확인
	 * @param userid
	 * @return
	 */
	public boolean checkId(String userid) {
		System.out.println("## Debug_in_MemberService: checkID()실행");
		return dao.checkId(userid);
	}
	
	/**
	 * 로그인
	 * @param map
	 * @return
	 */
	public String login(String userid, String userpw) {
		System.out.println("## Debug_in_MemberService: login()실행");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("userpw", userpw);
		return dao.login(map);
	}
	
	/**
	 * 관리자 승인 AP등급 리스트 만들기
	 * List라는 Member변수를 Generic을 이용해 리스트 생성
	 */
	public List<Member> adminApprovalList() {
		return dao.adminApprovalList();
	}
	
	/**
	 * 관리자 승인 요청 메서드
	 */
	public int adminApproval(String userid) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("userid", userid);
		return dao.adminApproval(hashMap);
	}
	
	/**
	 * 관리자 거절 요청 메서드
	 */
	public int adminReject(String userid) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("userid", userid);
		return dao.adminReject(hashMap);
	}
	
	/**
	 * 회원가입 요청 메서드
	 */

	public String join(Member member) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("userid", member.getUserid());
		hashMap.put("userpw", member.getUserpw());
		hashMap.put("username", member.getUsername());
		hashMap.put("email", member.getEmail());
		hashMap.put("mobile", member.getMobile());
		hashMap.put("birth", member.getBirth());
		hashMap.put("grade", "G");
		return dao.join(hashMap);
	}
	
	/**
	 * 관리자 신청한 회원이 있는지 확인
	 * @return
	 */
	public int howmanyAP() {
		System.out.println("## Debug_in_memberService: howmayAP()실행");
		return dao.howmanyAP();
	}
	
	/**
	 * 회원 정보 조회 요청 메서드
	 * @param hashmap
	 * @return
	 */
	public List<Member> infoSearch(HashMap<String,String> hashmap) {
		System.out.println("## Debug_in_memberService: infoSearch()실행");
		return dao.infoSearchList(hashmap);
	}
	
}
