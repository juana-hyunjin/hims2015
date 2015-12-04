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
	 * ���̵� �ߺ�Ȯ��
	 * @param userid
	 * @return
	 */
	public boolean checkId(String userid) {
		System.out.println("## Debug_in_MemberService: checkID()����");
		return dao.checkId(userid);
	}
	
	/**
	 * �α���
	 * @param map
	 * @return
	 */
	public String login(String userid, String userpw) {
		System.out.println("## Debug_in_MemberService: login()����");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("userpw", userpw);
		return dao.login(map);
	}
}
