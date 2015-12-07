package com.syu.hims.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.syu.hims.dto.Member;

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

	/**
	 * ������ ��û�� ȸ�� ����Ʈ �˻� 
	 * @return
	 */
	public List<Member> adminApprovalList() {
		System.out.println("## Debug_in_MemberDAO����: adminApprovalList()");
		if(!sqlSession.selectList("adminApprovalList").isEmpty()) {
			return sqlSession.selectList("adminApprovalList");
		} else {
			return null;
		}
	}

	/**
	 * ������ ��û�� ȸ���� �����ڷ� �°�
	 * @param hashMap
	 * @return
	 */
	public int adminApproval(HashMap<String, String> hashMap){
		System.out.println("## Debug_in_MemberDAO����: adminApproval()");
		return sqlSession.update("adminApproval", hashMap);
	}

	/**
	 * ������ ��û�� ȸ���� ���������� ��
	 * ȸ��Ż��� ó���ϴ� �޼���
	 * @param hashMap
	 * @return
	 */
	public int adminReject(HashMap<String, String> hashMap) {
		System.out.println("## Debug_in_MemberDAO����: adminReject()");
		return sqlSession.delete("adminReject", hashMap);	
	}
	
	/**
	 * ȸ������
	 * @param hashMap
	 * @return
	 */
	public String join(HashMap<String, String> hashMap) {
		System.out.println("## Debug_in_MemberDAO����: join()");
		return sqlSession.selectOne("join", hashMap);
	}
	
	/**
	 * ������ ��û���� �� ���ִ��� Ȯ���ϴ� �޼���
	 * @return
	 */
	public int howmanyAP() {
		System.out.println("##Debug_in_memberDAO: howmanyAP()����");
		return sqlSession.selectOne("howmanyAP");
	}
	
	/**
	 * ī�װ����� ȸ������ �˻�
	 * @param hashmap
	 * @return
	 */
	public List<Member> infoSearchList(HashMap<String,String> hashmap) {
		System.out.println("##Debug_in_memberDAO: infoSearch()����");
		System.out.println("##debug: " + hashmap.get("category"));
		System.out.println("##debug: " + hashmap.get("searchData"));
		return sqlSession.selectList("infoSearch", hashmap);
	}
}
