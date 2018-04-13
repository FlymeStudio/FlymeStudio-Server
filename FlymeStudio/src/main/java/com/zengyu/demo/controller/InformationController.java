package com.zengyu.demo.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

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
	static Logger logger = Logger.getLogger(InformationController.class.getSimpleName());
	private InformationService informationService;

	@Autowired
	public InformationController(InformationService informationService) {
		this.informationService = informationService;
	}

	/**
	 * 修改信息
	 * 
	 * @param id
	 *            用户编号
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
	public String modify(@RequestParam int id, @RequestParam String tel, @RequestParam String name,
			@RequestParam String email, @RequestParam String password, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		logger.info("modify:\t id=" + id + "\t tel=" + tel + "\t name=" + name + "\t email=" + email + "\t password="
				+ password);
		String responseStr = informationService.modify(id, tel, name, email, password);
		logger.info("modify response:\t" + responseStr);
		return responseStr;
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
	@RequestMapping(value = "/message", method = RequestMethod.PUT)
	@ResponseBody
	public String reply(@RequestParam int id, @RequestParam boolean result, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		logger.info("reply:\t id=" + id + "\t result=" + result);
		String responseStr = informationService.reply(id, result);
		logger.info("reply response:\t" + responseStr);
		return responseStr;
	}
}
