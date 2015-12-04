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
	 * 아이디 중복 확인
	 * @param userid
	 * @return
	 */
	@RequestMapping(value="member.checkid.do", produces="text/plain;charset=UTF-8")
	public @ResponseBody String checkId(String userid) {
		System.out.println("## Debug_in_MemberController: checkId()실행");
		System.out.println(userid);
		HashMap<String, String> map = new HashMap<String, String>();
		/* result의 값이 true이면 중복된 아이디가 있다는 뜻 */
		if(service.checkId(userid)) {
			System.out.println("## Debug_in_MemberController: checkId()실행결과: " + service.checkId(userid));
			map.put("result", "true");
			map.put("message", "이미 사용중인 아이디입니다.");
		} else {
			map.put("result", "false");
			map.put("message", "사용가능한 아이디입니다.");
		}
		Gson gson = new Gson();
		String check = gson.toJson(map);
		System.out.println(check);
		return check;
	}
	
	/**
	 * 로그인 처리요청
	 * @param userid
	 * @param userpw
	 * @return
	 */
	@RequestMapping(value="member.login.do")
	public ModelAndView login(String userid, String userpw, HttpServletRequest request) {
		System.out.println("##Debug_in_MemberController: login()실행");
		ModelAndView mv = new ModelAndView();
		String grade = service.login(userid, userpw);
		if(grade.equals("M") || (grade.equals("A"))) {
			HttpSession session = request.getSession(true);
			mv.addObject("grade", grade);
			mv.setViewName("common/index");
		} else {
			mv.addObject("error", "승인된 관리자가 아닙니다.");
			mv.addObject("location", "member.loginView.do");
			mv.setViewName("error/error");
		}
		return mv;
	}
	
	/**
	 * 로그아웃 처리요청
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
