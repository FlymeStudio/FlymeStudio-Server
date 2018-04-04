package com.zengyu.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zengyu.demo.dao.InformationDao;

@Controller
@RequestMapping("/Information")
public class InformationController {
	private Logger logger;
	private InformationDao informationDao;

	@Autowired
	public InformationController(InformationDao informationDao) {
		this.informationDao = informationDao;
		logger = Logger.getLogger(this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	@ResponseBody
	public String modify(@RequestParam String name, @RequestParam String tel, @RequestParam String email,
			@RequestParam String password) {
		logger.trace("name:\t" + name + "\ttel:\t" + tel + "\temail:\t" + email + "\tpassword:\t" + password);
		JSONObject jsonObject = new JSONObject();
		boolean data = informationDao.modify(name, tel, email, password);
		jsonObject.put("result", data);
		return jsonObject.toJSONString();
	}
}
