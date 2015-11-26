package com.syu.hims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
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
}
