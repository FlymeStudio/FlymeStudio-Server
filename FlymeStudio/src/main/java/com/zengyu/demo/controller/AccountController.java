package com.zengyu.demo.controller;

import java.util.logging.Logger;

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
	static Logger logger = Logger.getLogger(AccountController.class.getSimpleName());
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
		logger.info("signIn:\t id=" + id + "\t password=" + password);
		return accountService.signIn(id, password);
	}

	/**
	 * 注册
	 * 
	 * @param num
	 *            工号
	 * @param name
	 *            姓名
	 * @param tel
	 *            电话
	 * @param email
	 *            邮箱
	 * @param password
	 *            密码
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public String signUp(@RequestParam String num, @RequestParam String name, @RequestParam String tel,
			@RequestParam String email, @RequestParam String password) {
		logger.info("signUp:\t num=" + num + "\t name=" + name + "=\t tel=" + tel + "\t email=" + email + "\t password=" + password);
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
		logger.info("signOut:\t tel=" + tel);
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
		logger.info("retrieve:\t tel=" + tel + "\t name=" + name + "\t email=" + email);
		return accountService.retrieve(tel, name, email);
	}
}
