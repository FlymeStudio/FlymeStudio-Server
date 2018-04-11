package com.zengyu.demo.controller;

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
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	@ResponseBody
	public String get(@RequestParam String tel) {
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
	@RequestMapping(value = "/project", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestParam String tel, @RequestParam int type, @RequestParam String date,
			@RequestParam String title, @RequestParam String content, @RequestParam String plans) {
		return projectService.create(tel, type, date, title, content, plans);
	}

	/**
	 * 查找任务
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
	 * @return
	 */
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	@ResponseBody
	public String search(@RequestParam String tel, @RequestParam int type, @RequestParam String date,
			@RequestParam String title, @RequestParam String content) {
		return projectService.search(tel, type, date, title, content);
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
	@RequestMapping(value = "/project", method = RequestMethod.PUT)
	@ResponseBody
	public String modify(@RequestParam String tel, @RequestParam int id, @RequestParam int type,
			@RequestParam String date, @RequestParam String title, @RequestParam String content,
			@RequestParam String plans) {
		return projectService.modify(tel, id, type, date, title, content, plans);
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
	@RequestMapping(value = "/project", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestParam String tel, @RequestParam int id) {
		return projectService.delete(tel, id);
	}
}
