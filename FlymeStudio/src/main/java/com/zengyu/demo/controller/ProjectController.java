package com.zengyu.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.zengyu.demo.dao.ProjectDao;
import com.zengyu.demo.others.ResponseObject;

@Controller
@RequestMapping("/Project")
public class ProjectController {
	private Logger logger;
	private ProjectDao projectDao;

	@Autowired
	public ProjectController(ProjectDao projectDao) {
		this.projectDao = projectDao;
		logger = Logger.getLogger(this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	@ResponseBody
	public String get(@RequestParam String tel) {
		logger.trace("tel:\t" + tel);
		ResponseObject responseObject = new ResponseObject();
		JSONArray data = projectDao.get(tel);
		if (data != null) {
			responseObject.setResult(true);
			responseObject.setData(data);
		}
		return responseObject.toJSONString();
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestParam String tel, @RequestParam String type, @RequestParam String date,
			@RequestParam String title, @RequestParam String content, @RequestParam String plans) {
		ResponseObject responseObject = new ResponseObject();
		boolean result = projectDao.create(tel, type, date, title, content, plans);
		responseObject.setResult(result);
		return responseObject.toJSONString();
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public String search(@RequestParam String type, @RequestParam String date, @RequestParam String title,
			@RequestParam String content, @RequestParam String plans) {
		ResponseObject responseObject = new ResponseObject();
		JSONArray data = projectDao.search(type, date, title, content, plans);
		if (data != null) {
			responseObject.setResult(true);
			responseObject.setData(data);
		}
		return responseObject.toJSONString();
	}

	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	@ResponseBody
	public String modify(@RequestParam String tel, @RequestParam String id, @RequestParam String type,
			@RequestParam String date, @RequestParam String title, @RequestParam String content,
			@RequestParam String plans) {
		ResponseObject responseObject = new ResponseObject();
		boolean result = projectDao.modify(tel, id, type, date, title, content, plans);
		responseObject.setResult(result);
		return responseObject.toJSONString();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestParam String tel, @RequestParam String id) {
		ResponseObject responseObject = new ResponseObject();
		boolean result = projectDao.delete(tel, id);
		responseObject.setResult(result);
		return responseObject.toJSONString();
	}
}
