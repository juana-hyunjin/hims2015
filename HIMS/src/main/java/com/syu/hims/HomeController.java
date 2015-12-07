package com.syu.hims;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@RequestMapping("common.index.do")
	public String index(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return "common/index";
	}
}