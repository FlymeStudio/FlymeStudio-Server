package com.zengyu.demo.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zengyu.demo.service.SummaryService;

/**
 * 总结控制层
 * 
 * @author zengyu
 *
 */
@Controller
@RequestMapping(value = "/Summary", produces = { "text/html;charset=UTF-8;", "application/json;" })
public class SummaryController {
	static Logger logger = Logger.getLogger(SummaryController.class.getSimpleName());
	private SummaryService summaryService;

	@Autowired
	public SummaryController(SummaryService summaryService) {
		this.summaryService = summaryService;
	}

	/**
	 * 获取个人总结
	 * 
	 * @param user
	 *            用户编号
	 * @String responseStr =
	 */
	@RequestMapping(value = "/summaries/all", method = RequestMethod.GET)
	@ResponseBody
	public String get(@RequestParam int user, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		logger.info("get:\t user=" + user);
		String responseStr = summaryService.get(user);
		logger.info("get response:\t" + responseStr);
		return responseStr;
	}

	/**
	 * 创建总结
	 * 
	 * @param user
	 *            用户编号
	 * @param type
	 *            类型
	 * @param date
	 *            日期
	 * @param title
	 *            标题
	 * @param content
	 *            内容
	 * @String responseStr =
	 */
	@RequestMapping(value = "/summary/my", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestParam int user, @RequestParam int type, @RequestParam long date,
			@RequestParam String title, @RequestParam String content, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		logger.info("create:\t user=" + user + "\t type=" + type + "\t date=" + date + "\t title=" + title
				+ "\t content=" + content);
		String responseStr = summaryService.create(user, type, date, title, content);
		logger.info("create response:\t" + responseStr);
		return responseStr;
	}

	/**
	 * 删除总结
	 * 
	 * @param id
	 *            任务编号
	 * @param user
	 *            用户编号
	 * @String responseStr =
	 */
	@RequestMapping(value = "/summary/my", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestParam int id, @RequestParam int user, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		logger.info("delete:\t id=" + id + "\t user=" + user);
		String responseStr = summaryService.delete(id, user);
		logger.info("delete response:\t" + responseStr);
		return responseStr;
	}

	/**
	 * 修改总结
	 * 
	 * @param id
	 *            任务编号
	 * @param user
	 *            用户编号
	 * @param type
	 *            类型
	 * @param date
	 *            日期
	 * @param title
	 *            标题
	 * @param content
	 *            内容
	 * @String responseStr =
	 */
	@RequestMapping(value = "/summary/my", method = RequestMethod.PUT)
	@ResponseBody
	public String modify(@RequestParam int id, @RequestParam int user, @RequestParam int type, @RequestParam long date,
			@RequestParam String title, @RequestParam String content, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		logger.info("modify:\t id=" + id + "\t user=" + user + "\t type=" + type + "\t date=" + date + "\t title="
				+ title + "\t content=" + content);
		String responseStr = summaryService.modify(id, user, type, date, title, content);
		logger.info("modify response:\t" + responseStr);
		return responseStr;
	}
}
