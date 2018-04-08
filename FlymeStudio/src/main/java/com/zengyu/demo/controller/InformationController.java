package com.zengyu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zengyu.demo.dao.InformationDao;
import com.zengyu.demo.others.ResponseObject;

@Controller
@RequestMapping(value = "/Information", produces = { "text/html;charset=UTF-8;", "application/json;" })
public class InformationController {
	private InformationDao informationDao;

	@Autowired
	public InformationController(InformationDao informationDao) {
		this.informationDao = informationDao;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	@ResponseBody
	public String modify(@RequestParam String oldTel, @RequestParam String name, @RequestParam String tel,
			@RequestParam String email, @RequestParam String password) {
		System.out.println("oldTel:\t" + oldTel + "name:\t" + name + "\ttel:\t" + tel + "\temail:\t" + email
				+ "\tpassword:\t" + password);
		ResponseObject responseObject = new ResponseObject();
		boolean result = informationDao.modify(oldTel, name, tel, email, password);
		responseObject.setResult(result);
		return responseObject.toJSONString();
	}
}
