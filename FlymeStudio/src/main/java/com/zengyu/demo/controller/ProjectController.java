package com.zengyu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zengyu.demo.service.ProjectService;

@Controller
@RequestMapping(value = "/Project", produces = { "text/html;charset=UTF-8;", "application/json;" })
public class ProjectController {
	private ProjectService projectDao;

	@Autowired
	public ProjectController(ProjectService projectDao) {
		this.projectDao = projectDao;
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	@ResponseBody
	public String get(@RequestParam String tel) {
		return projectDao.get(tel);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestParam String tel, @RequestParam String type, @RequestParam String date,
			@RequestParam String title, @RequestParam String content, @RequestParam String plans) {
		return projectDao.create(tel, type, date, title, content, plans);
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public String search(@RequestParam String type, @RequestParam String date, @RequestParam String title,
			@RequestParam String content, @RequestParam String plans) {
		return projectDao.search(type, date, title, content, plans);
	}

	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	@ResponseBody
	public String modify(@RequestParam String tel, @RequestParam String id, @RequestParam String type,
			@RequestParam String date, @RequestParam String title, @RequestParam String content,
			@RequestParam String plans) {
		return projectDao.modify(tel, id, type, date, title, content, plans);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestParam String tel, @RequestParam String id) {
		return projectDao.delete(tel, id);
	}
}
