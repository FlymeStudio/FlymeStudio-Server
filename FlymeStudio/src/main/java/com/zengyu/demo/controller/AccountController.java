package com.zengyu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zengyu.demo.service.AccountService;

@Controller
@RequestMapping(value = "/Account", produces = { "text/html;charset=UTF-8;", "application/json;" })
public class AccountController {
	private AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	@ResponseBody
	public String signIn(@RequestParam String id, @RequestParam String password) {
		return accountService.signIn(id, password);
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	@ResponseBody
	public String signUp(@RequestParam String name, @RequestParam String tel, @RequestParam String email,
			@RequestParam String password) {
		return accountService.signUp(name, tel, email, password);
	}

	@RequestMapping(value = "/signOut", method = RequestMethod.POST)
	@ResponseBody
	public String signOut(@RequestParam String tel) {
		return accountService.signOut(tel);
	}

	@RequestMapping(value = "/retrieve", method = RequestMethod.POST)
	@ResponseBody
	public String retrieve(@RequestParam String name, @RequestParam String tel, @RequestParam String email) {
		return accountService.retrieve(name, tel, email);
	}
}
