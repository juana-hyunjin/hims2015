package com.syu.hims.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.syu.hims.dto.Member;
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
			session.setAttribute("grade", grade);
			if(grade.equals("M")) {
				int count = service.howmanyAP();
				if(count>0) {
					System.out.println("##debug: " + count);
					mv.addObject("howmanyAP", count);
				}
			}
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


	/**
	 * 회원가입 요청
	 */
	@RequestMapping("member.join.do")
	public String memberjoinView(HttpServletRequest request, HttpServletResponse response, Member member) throws ServletException, IOException {
		String email = request.getParameter("email1") + request.getParameter("email2");
		member.setEmail(email);
		String mobile = request.getParameter("mobile1") + request.getParameter("mobile2") + request.getParameter("mobile3");
		member.setMobile(mobile);
		if(member.getUserid().equals("") || member.getUserid().length()>=30) {
			request.setAttribute("message", "아이디는 공백이 아닌 15자 이내로 입력 바랍니다.");
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			return null;
		}
		else if(member.getUserpw().equals("") || member.getUserpw().length()>=20) {
			request.setAttribute("message", "비밀번호는 공백이 아닌 10자 이내로 입력 바랍니다.");
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			return null;
		}	
		else if(member.getUsername().equals("") || member.getUsername().length()>15) {
			request.setAttribute("message", "이름 공백이 아닌 7자 이내로 입력 바랍니다.");
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			return null;
		}
		else if(member.getEmail().equals("") || member.getEmail().length()>30) {
			request.setAttribute("message", "이메일을 입력바랍니다.");
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			return null;
		}
		else if(member.getMobile().equals("") || member.getMobile().length()>15) {
			request.setAttribute("message", "핸드폰 번호를 입력바랍니다.");
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			return null;
		}
		else if(member.getBirth().equals("") || member.getBirth().length()>10) {
			request.setAttribute("message", "생년월일은 공백이아닌 조건에 19xx.xx.xx로 입력해 주시기 바랍니다");
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			return null;
		}
		else {
			if(service.join(member) == null) {
				return "common/index";
			} else{
				return null;
			}
		}
	}


	/** 
	 * 관리자 승인 페이지 이동 요청
	 */

	@RequestMapping("member.adminApprovalView.do")
	public ModelAndView adminApprovalView() {
		ModelAndView mav = new ModelAndView();
		ArrayList<Member> list = (ArrayList<Member>) service.adminApprovalList();
		System.out.println("##debug: " +  list.get(0).getUserid());
		mav.addObject("list", list);
		mav.setViewName("member/adminApproval");
		return mav;
	}
	
	/** 
	 * 관리자 승인 메서드	
	 */
	@RequestMapping("member.adminApproval.do")
	public ModelAndView adminApproval(HttpServletRequest request) {
		System.out.println("## Debug_in_memberController: adminapproval()실행");
		String userid = request.getParameter("userid");
		System.out.println("##debug: " + userid);
		ModelAndView mav = new ModelAndView();
		ArrayList<Member> list = (ArrayList<Member>) service.adminApprovalList();
		System.out.println("##debug: " +  list.get(0).getUserid());
		mav.addObject("list", list);
		mav.addObject("userid", service.adminApproval(userid));
		mav.setViewName("member/adminApproval");
		return mav;
	}

	/** 
	 * 관리자 거부 메서드
	 */
	@RequestMapping("member.adminReject.do")
	public ModelAndView adminReject(HttpServletRequest request) {
		System.out.println("## Debug_in_memberController: adminReject()실행");
		String userid = request.getParameter("userid");
		ModelAndView mav = new ModelAndView();
		ArrayList<Member> list = (ArrayList<Member>) service.adminApprovalList();
		System.out.println("##debug: " +  list.get(0).getUserid());
		mav.addObject("list", list);
		mav.addObject("userid", service.adminReject(userid));
		mav.setViewName("member/adminApproval");
		return mav;
	}
	

	/**
	 * 회원 정보 조회
	 * @param request
	 * @return
	 */
	@RequestMapping(value="member.infoSearch.do", produces="text/plain;charset=UTF-8")
	public @ResponseBody String infoSearch(HttpServletRequest request, HttpServletResponse response, Member member) throws ServletException, IOException {
		System.out.println("##debug_in_memberController: infoSearch()실행");
		ModelAndView mv = new ModelAndView();			
		String category = request.getParameter("category");
		String searchData = request.getParameter("searchData");
		if(category.equals("이름")) {
			category = "USERNAME";
		} else if(category.equals("아이디")) {
			category = "USERID";
		} else if(category.equals("휴대폰")) {
			category = "MOBILE";
		} else if(category.equals("생년월일")) {
			category = "BIRTH";
		} else if(category.equals("등급")) {
			category = "GRADE";
		}
		System.out.println("##debug category, serachData: " + category + searchData);
		HashMap<String, String> hashmap = new HashMap<String, String>();
		hashmap.put("category", category);
		hashmap.put("searchData", searchData);
		List<Member> list = service.infoSearch(hashmap);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		return json;
	}

}
