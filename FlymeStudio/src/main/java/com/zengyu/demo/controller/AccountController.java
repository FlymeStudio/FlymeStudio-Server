package com.zengyu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zengyu.demo.service.AccountService;

/**
 * 帐号控制层
 * 
 * @author zengyu
 *
 */
@Controller
@RequestMapping(value = "/Account", produces = { "text/html;charset=UTF-8;", "application/json;" })
public class AccountController {
	private AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * 登录
	 * 
	 * @param id
	 *            电话或者邮箱
	 * @param password
	 *            密码
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String signIn(@RequestParam String id, @RequestParam String password) {
		return accountService.signIn(id, password);
	}

	/**
	 * 注册
	 * 
	 * @param tel
	 *            电话
	 * @param name
	 *            姓名
	 * @param email
	 *            邮箱
	 * @param password
	 *            密码
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public String signUp(@RequestParam String tel, @RequestParam String name, @RequestParam String email,
			@RequestParam String password) {
		return accountService.signUp(tel, name, email, password);
	}

	/**
	 * 注销
	 * 
	 * @param tel
	 *            电话
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	public String signOut(@RequestParam String tel) {
		return accountService.signOut(tel);
	}

	/**
	 * 找回
	 * 
	 * @param tel
	 *            电话
	 * @param name
	 *            姓名
	 * @param email
	 *            邮箱
	 * @return
	 */
	@RequestMapping(value = "/retrieve", method = RequestMethod.POST)
	@ResponseBody
	public String retrieve(@RequestParam String tel, @RequestParam String name, @RequestParam String email) {
		return accountService.retrieve(tel, name, email);
	}
}
