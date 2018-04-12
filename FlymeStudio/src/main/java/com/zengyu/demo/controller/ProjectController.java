package com.zengyu.demo.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zengyu.demo.service.ProjectService;

/**
 * 任务控制层
 * 
 * @author zengyu
 *
 */
@Controller
@RequestMapping(value = "/Project", produces = { "text/html;charset=UTF-8;", "application/json;" })
public class ProjectController {
	static Logger logger = Logger.getLogger(ProjectController.class.getSimpleName());
	private ProjectService projectService;

	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	/**
	 * 获取个人任务
	 * 
	 * @param tel
	 *            电话
	 * @return
	 */
	@RequestMapping(value = "/projects/all", method = RequestMethod.GET)
	@ResponseBody
	public String get(@RequestParam String tel) {
		logger.info("get:\t tel=" + tel);
		return projectService.get(tel);
	}

	/**
	 * 创建任务
	 * 
	 * @param tel
	 *            电话
	 * @param type
	 *            类型
	 * @param date
	 *            日期
	 * @param title
	 *            标题
	 * @param content
	 *            内容
	 * @param plans
	 *            计划
	 * @return
	 */
	@RequestMapping(value = "/project/my", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestParam String tel, @RequestParam int type, @RequestParam String date,
			@RequestParam String title, @RequestParam String content, @RequestParam String plans) {
		logger.info("create:\t tel=" + tel + "\t type=" + type + "\t date=" + date + "\t title=" + title + "\t content="
				+ content + "\t plans=" + plans);
		return projectService.create(tel, type, date, title, content, plans);
	}

	/**
	 * 删除任务
	 * 
	 * @param tel
	 *            电话
	 * @param id
	 *            编号
	 * @return
	 */
	@RequestMapping(value = "/project/my", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestParam String tel, @RequestParam int id) {
		logger.info("delete:\t tel=" + tel + "\t id=" + id);
		return projectService.delete(tel, id);
	}

	/**
	 * 修改任务
	 * 
	 * @param tel
	 *            电话
	 * @param id
	 *            编号
	 * @param type
	 *            类型
	 * @param date
	 *            日期
	 * @param title
	 *            标题
	 * @param content
	 *            内容
	 * @param plans
	 *            计划
	 * @return
	 */
	@RequestMapping(value = "/project/my", method = RequestMethod.PUT)
	@ResponseBody
	public String modify(@RequestParam String tel, @RequestParam int id, @RequestParam int type,
			@RequestParam String date, @RequestParam String title, @RequestParam String content,
			@RequestParam String plans) {
		logger.info("modify:\t tel=" + tel + "\t id=" + id + "\t type=" + type + "\t date=" + date + "\t title=" + title
				+ "\t content=" + content + "\t plans=" + plans);
		return projectService.modify(tel, id, type, date, title, content, plans);
	}
}
