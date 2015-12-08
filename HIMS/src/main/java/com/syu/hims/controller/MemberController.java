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


	/**
	 * ȸ������ ��û
	 */
	@RequestMapping("member.join.do")
	public String memberjoinView(HttpServletRequest request, HttpServletResponse response, Member member) throws ServletException, IOException {
		String email = request.getParameter("email1") + request.getParameter("email2");
		member.setEmail(email);
		String mobile = request.getParameter("mobile1") + request.getParameter("mobile2") + request.getParameter("mobile3");
		member.setMobile(mobile);
		if(member.getUserid().equals("") || member.getUserid().length()>=30) {
			request.setAttribute("message", "���̵�� ������ �ƴ� 15�� �̳��� �Է� �ٶ��ϴ�.");
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			return null;
		}
		else if(member.getUserpw().equals("") || member.getUserpw().length()>=20) {
			request.setAttribute("message", "��й�ȣ�� ������ �ƴ� 10�� �̳��� �Է� �ٶ��ϴ�.");
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			return null;
		}	
		else if(member.getUsername().equals("") || member.getUsername().length()>15) {
			request.setAttribute("message", "�̸� ������ �ƴ� 7�� �̳��� �Է� �ٶ��ϴ�.");
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			return null;
		}
		else if(member.getEmail().equals("") || member.getEmail().length()>30) {
			request.setAttribute("message", "�̸����� �Է¹ٶ��ϴ�.");
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			return null;
		}
		else if(member.getMobile().equals("") || member.getMobile().length()>15) {
			request.setAttribute("message", "�ڵ��� ��ȣ�� �Է¹ٶ��ϴ�.");
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			return null;
		}
		else if(member.getBirth().equals("") || member.getBirth().length()>10) {
			request.setAttribute("message", "��������� �����̾ƴ� ���ǿ� 19xx.xx.xx�� �Է��� �ֽñ� �ٶ��ϴ�");
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
	 * ������ ���� ������ �̵� ��û
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
	 * ������ ���� �޼���	
	 */
	@RequestMapping("member.adminApproval.do")
	public ModelAndView adminApproval(HttpServletRequest request) {
		System.out.println("## Debug_in_memberController: adminapproval()����");
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
	 * ������ �ź� �޼���
	 */
	@RequestMapping("member.adminReject.do")
	public ModelAndView adminReject(HttpServletRequest request) {
		System.out.println("## Debug_in_memberController: adminReject()����");
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
	 * ȸ�� ���� ��ȸ
	 * @param request
	 * @return
	 */
	@RequestMapping(value="member.infoSearch.do", produces="text/plain;charset=UTF-8")
	public @ResponseBody String infoSearch(HttpServletRequest request, HttpServletResponse response, Member member) throws ServletException, IOException {
		System.out.println("##debug_in_memberController: infoSearch()����");
		ModelAndView mv = new ModelAndView();			
		String category = request.getParameter("category");
		String searchData = request.getParameter("searchData");
		if(category.equals("�̸�")) {
			category = "USERNAME";
		} else if(category.equals("���̵�")) {
			category = "USERID";
		} else if(category.equals("�޴���")) {
			category = "MOBILE";
		} else if(category.equals("�������")) {
			category = "BIRTH";
		} else if(category.equals("���")) {
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
