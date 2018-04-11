package com.zengyu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zengyu.demo.service.InformationService;

/**
 * 信息控制层
 * 
 * @author zengyu
 *
 */
@Controller
@RequestMapping(value = "/Information", produces = { "text/html;charset=UTF-8;", "application/json;" })
public class InformationController {
	private InformationService informationService;

	@Autowired
	public InformationController(InformationService informationService) {
		this.informationService = informationService;
	}

	/**
	 * 修改信息
	 * 
	 * @param old
	 *            旧电话
	 * @param tel
	 *            新电话
	 * @param name
	 *            新姓名
	 * @param email
	 *            新邮箱
	 * @param password
	 *            新密码
	 * @return
	 */
	@RequestMapping(value = "/info", method = RequestMethod.PUT)
	@ResponseBody
	public String modify(@RequestParam String old, @RequestParam String tel, @RequestParam String name,
			@RequestParam String email, @RequestParam String password) {
		return informationService.modify(old, tel, name, email, password);
	}

	/**
	 * 回复消息
	 * 
	 * @param id
	 *            编号
	 * @param result
	 *            回复结果
	 * @return
	 */
	@RequestMapping(value = "/msg", method = RequestMethod.PUT)
	@ResponseBody
	public String replyMsg(@RequestParam int id, @RequestParam boolean result) {
		return informationService.replyMsg(id, result);
	}
}
