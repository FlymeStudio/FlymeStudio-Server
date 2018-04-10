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

	@RequestMapping(value = "/info", method = RequestMethod.PUT)
	@ResponseBody
	public String modify(@RequestParam String old, @RequestParam String name, @RequestParam String tel,
			@RequestParam String email, @RequestParam String password) {
		return informationService.modify(old, name, tel, email, password);
	}

	@RequestMapping(value = "/msg", method = RequestMethod.PUT)
	@ResponseBody
	public String replyMsg(@RequestParam int id, @RequestParam boolean result) {
		return informationService.replyMsg(id, result);
	}
}
