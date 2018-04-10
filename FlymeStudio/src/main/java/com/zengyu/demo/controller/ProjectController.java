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
	private ProjectService projectService;

	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	@ResponseBody
	public String get(@RequestParam String tel) {
		return projectService.get(tel);
	}

	@RequestMapping(value = "/project", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestParam String tel, @RequestParam int type, @RequestParam String date,
			@RequestParam String title, @RequestParam String content, @RequestParam String plans) {
		return projectService.create(tel, type, date, title, content, plans);
	}

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	@ResponseBody
	public String search(@RequestParam String tel, @RequestParam int type, @RequestParam String date,
			@RequestParam String title, @RequestParam String content) {
		return projectService.search(tel, type, date, title, content);
	}

	@RequestMapping(value = "/project", method = RequestMethod.PUT)
	@ResponseBody
	public String modify(@RequestParam String tel, @RequestParam int id, @RequestParam int type,
			@RequestParam String date, @RequestParam String title, @RequestParam String content,
			@RequestParam String plans) {
		return projectService.modify(tel, id, type, date, title, content, plans);
	}

	@RequestMapping(value = "/project", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestParam String tel, @RequestParam int id) {
		return projectService.delete(tel, id);
	}
}
