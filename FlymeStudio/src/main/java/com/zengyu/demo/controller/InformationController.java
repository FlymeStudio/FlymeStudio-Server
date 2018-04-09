package com.zengyu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zengyu.demo.service.InformationService;

@Controller
@RequestMapping(value = "/Information", produces = { "text/html;charset=UTF-8;", "application/json;" })
public class InformationController {
	private InformationService informationService;

	@Autowired
	public InformationController(InformationService informationService) {
		this.informationService = informationService;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	@ResponseBody
	public String modify(@RequestParam String oldTel, @RequestParam String name, @RequestParam String tel,
			@RequestParam String email, @RequestParam String password) {
		return informationService.modify(oldTel, name, tel, email, password);
	}
}
