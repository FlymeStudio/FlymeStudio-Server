package com.zengyu.demo.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

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
	 * @param user
	 *            工号或电话或邮箱
	 * @param password
	 *            密码
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
	@ResponseBody
	public String signIn(@RequestParam String user, @RequestParam String password, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Expose-Headers", "Authorization");
		logger.info("signIn:\t id=" + user + "\t password=" + password);
		String responseStr = accountService.signIn(user, password);
		logger.info("signIn response:\t" + responseStr);
		return responseStr;
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
			@RequestParam String email, @RequestParam String password, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		logger.info("signUp:\t num=" + num + "\t name=" + name + "\t tel=" + tel + "\t email=" + email + "\t password="
				+ password);
		String responseStr = accountService.signUp(num, tel, name, email, password);
		logger.info("signUp response:\t" + responseStr);
		return responseStr;
	}

	/**
	 * 注销
	 * 
	 * @param id
	 *            编号
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	public String signOut(@RequestParam int id, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		logger.info("signOut:\t tel=" + id);
		String responseStr = accountService.signOut(id);
		logger.info("signOut response:\t" + responseStr);
		return responseStr;
	}

	/**
	 * 找回
	 * 
	 * @param num
	 *            工号
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
	public String retrieve(@RequestParam String num, @RequestParam String tel, @RequestParam String name,
			@RequestParam String email, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		logger.info("retrieve:\t num=" + num + "\t tel=" + tel + "\t name=" + name + "\t email=" + email);
		String responseStr = accountService.retrieve(num, tel, name, email);
		logger.info("retrieve response:\t" + responseStr);
		return responseStr;
	}
}
