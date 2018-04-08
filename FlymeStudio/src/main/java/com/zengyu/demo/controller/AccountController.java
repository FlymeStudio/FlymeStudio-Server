package com.zengyu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zengyu.demo.dao.AccountDao;
import com.zengyu.demo.others.ResponseObject;

@Controller
@RequestMapping(value = "/Account", produces = { "text/html;charset=UTF-8;", "application/json;" })
public class AccountController {
	private AccountDao accountDao;

	@Autowired
	public AccountController(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	@ResponseBody
	public String signIn(@RequestParam String id, @RequestParam String password) {
		System.out.println("id:\t" + id + "\tpassword:\t" + password);
		ResponseObject responseObject = new ResponseObject();
		JSONObject data = accountDao.signIn(id, password);
		System.out.println("name:\t" + data.getString("name"));
		if (data != null) {
			responseObject.setResult(true);
			responseObject.setData(data);
		}
		return responseObject.toJSONString();
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	@ResponseBody
	public String signUp(@RequestParam String name, @RequestParam String tel, @RequestParam String email,
			@RequestParam String password) {
		System.out.println("name:\t" + name + "\ttel:\t" + tel + "\temail:\t" + email + "\tpassword:\t" + password);
		ResponseObject responseObject = new ResponseObject();
		boolean result = accountDao.signUp(name, tel, email, password);
		responseObject.setResult(result);
		return responseObject.toJSONString();
	}

	@RequestMapping(value = "/signOut", method = RequestMethod.POST)
	@ResponseBody
	public String signOut(@RequestParam String tel) {
		System.out.println("tel:\t" + tel);
		ResponseObject responseObject = new ResponseObject();
		boolean result = accountDao.signOut(tel);
		responseObject.setResult(result);
		return responseObject.toJSONString();
	}

	@RequestMapping(value = "/retrieve", method = RequestMethod.POST)
	@ResponseBody
	public String retrieve(@RequestParam String name, @RequestParam String tel, @RequestParam String email) {
		System.out.println("name:\t" + name + "\ttel:\t" + tel);
		JSONObject jsonObject = new JSONObject();
		boolean data = accountDao.retrieve(name, tel, email);
		jsonObject.put("result", data);
		return jsonObject.toJSONString();
	}
}
