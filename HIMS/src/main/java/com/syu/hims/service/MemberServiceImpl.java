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
	
	/**
	 * ������ ���� AP��� ����Ʈ �����
	 * List��� Member������ Generic�� �̿��� ����Ʈ ����
	 */
	public List<Member> adminApprovalList() {
		return dao.adminApprovalList();
	}
	
	/**
	 * ������ ���� ��û �޼���
	 */
	public int adminApproval(String userid) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("userid", userid);
		return dao.adminApproval(hashMap);
	}
	
	/**
	 * ������ ���� ��û �޼���
	 */
	public int adminReject(String userid) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("userid", userid);
		return dao.adminReject(hashMap);
	}
	
	/**
	 * ȸ������ ��û �޼���
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
	 * ������ ��û�� ȸ���� �ִ��� Ȯ��
	 * @return
	 */
	public int howmanyAP() {
		System.out.println("## Debug_in_memberService: howmayAP()����");
		return dao.howmanyAP();
	}
	
	/**
	 * ȸ�� ���� ��ȸ ��û �޼���
	 * @param hashmap
	 * @return
	 */
	public List<Member> infoSearch(HashMap<String,String> hashmap) {
		System.out.println("## Debug_in_memberService: infoSearch()����");
		return dao.infoSearchList(hashmap);
	}
	
}
