package com.syu.hims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservationController {
	@RequestMapping("rsv.rsvMainView.do")
	public String rsvMainView() {
		return "rsv/rsvMain";
	}
}
