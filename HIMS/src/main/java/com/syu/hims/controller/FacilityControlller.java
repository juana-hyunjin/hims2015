package com.syu.hims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FacilityControlller {
	@RequestMapping("facility.facility.do")
	public String FacilityView() {
		return "facility/selectFacility";
	}
	@RequestMapping("facility.addFacView.do")
	public String addFacView() {
		return "facility/addFacility";
	}
}
