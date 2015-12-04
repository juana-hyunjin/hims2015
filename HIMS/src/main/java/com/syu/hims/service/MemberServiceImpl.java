package com.syu.hims.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syu.hims.dao.MemberDAOImpl;

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
}
