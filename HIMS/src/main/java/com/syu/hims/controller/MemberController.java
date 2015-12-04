package com.syu.hims.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.syu.hims.service.MemberServiceImpl;

@Controller
public class MemberController {
	private MemberServiceImpl service;
	
	@Autowired
	public void setService(MemberServiceImpl service) {
		this.service = service;
	}
	@RequestMapping("member.loginView.do")
	public String loginView() {
		return "member/login";
	}
	@RequestMapping("member.joinView.do")
	public String joinView() {
		return "member/beforeJoin";
	}
	@RequestMapping("member.joinNext.do")
	public String joinNext() {
		return "member/join";
	}
	@RequestMapping("member.member.do")
	public String memberView() {
		return "member/selectMember";
	}
	/**
	 * ���̵� �ߺ� Ȯ��
	 * @param userid
	 * @return
	 */
	@RequestMapping(value="member.checkid.do", produces="text/plain;charset=UTF-8")
	public @ResponseBody String checkId(String userid) {
		System.out.println("## Debug_in_MemberController: checkId()����");
		System.out.println(userid);
		HashMap<String, String> map = new HashMap<String, String>();
		/* result�� ���� true�̸� �ߺ��� ���̵� �ִٴ� �� */
		if(service.checkId(userid)) {
			System.out.println("## Debug_in_MemberController: checkId()������: " + service.checkId(userid));
			map.put("result", "true");
			map.put("message", "�̹� ������� ���̵��Դϴ�.");
		} else {
			map.put("result", "false");
			map.put("message", "��밡���� ���̵��Դϴ�.");
		}
		Gson gson = new Gson();
		String check = gson.toJson(map);
		System.out.println(check);
		return check;
	}
	
	/**
	 * �α��� ó����û
	 * @param userid
	 * @param userpw
	 * @return
	 */
	@RequestMapping(value="member.login.do")
	public ModelAndView login(String userid, String userpw, HttpServletRequest request) {
		System.out.println("##Debug_in_MemberController: login()����");
		ModelAndView mv = new ModelAndView();
		String grade = service.login(userid, userpw);
		if(grade.equals("M") || (grade.equals("A"))) {
			HttpSession session = request.getSession(true);
			mv.addObject("grade", grade);
			mv.setViewName("common/index");
		} else {
			mv.addObject("error", "���ε� �����ڰ� �ƴմϴ�.");
			mv.addObject("location", "member.loginView.do");
			mv.setViewName("error/error");
		}
		return mv;
	}
	
	/**
	 * �α׾ƿ� ó����û
	 * @param request
	 * @return
	 */
	@RequestMapping(value="member.logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("userid")!=null) {
			session.removeAttribute("userid");
		}
		session.invalidate();
		return "member/login";
	}
	
}
