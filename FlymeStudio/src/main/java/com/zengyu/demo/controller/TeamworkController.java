package com.zengyu.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zengyu.demo.dao.TeamworkDao;
import com.zengyu.demo.others.ResponseObject;

@Controller
@RequestMapping("/Teamwork")
public class TeamworkController {
	private Logger logger;
	private TeamworkDao teamworkDao;

	@Autowired
	public TeamworkController(TeamworkDao teamworkDao) {
		this.teamworkDao = teamworkDao;
		logger = Logger.getLogger(this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/getTeamInfo", method = RequestMethod.POST)
	@ResponseBody
	public String getTeamInfo(@RequestParam String id) {
		logger.trace("id:\t" + id);
		ResponseObject responseObject = new ResponseObject();
		JSONObject data = teamworkDao.getTeamInfo(id);
		if (data != null) {
			responseObject.setResult(true);
			responseObject.setData(data);
		}
		return responseObject.toJSONString();
	}

	@RequestMapping(value = "/replyMsg", method = RequestMethod.POST)
	@ResponseBody
	public String replyMsg(@RequestParam String tel, @RequestParam String messageId, @RequestParam boolean result) {
		ResponseObject responseObject = new ResponseObject();
		boolean resultResponse = teamworkDao.replyMsg(tel, messageId, result);
		responseObject.setResult(resultResponse);
		return responseObject.toJSONString();
	}

	@RequestMapping(value = "/viewTeams", method = RequestMethod.POST)
	@ResponseBody
	public String viewTeams(@RequestParam String tel) {
		ResponseObject responseObject = new ResponseObject();
		JSONArray data = teamworkDao.viewTeams(tel);
		if (data != null) {
			responseObject.setResult(true);
			responseObject.setData(data);
		}
		return responseObject.toJSONString();
	}

	@RequestMapping(value = "/searchUser", method = RequestMethod.POST)
	@ResponseBody
	public String searchUser(@RequestParam String tel, @RequestParam String content) {
		ResponseObject responseObject = new ResponseObject();
		JSONArray data = teamworkDao.searchUser(tel, content);
		if (data != null) {
			responseObject.setResult(true);
			responseObject.setData(data);
		}
		return responseObject.toJSONString();
	}

	@RequestMapping(value = "/invite", method = RequestMethod.POST)
	@ResponseBody
	public String invite(@RequestParam String tel, @RequestParam String toTel, @RequestParam String teamId) {
		ResponseObject responseObject = new ResponseObject();
		boolean result = teamworkDao.invite(tel, toTel, teamId);
		responseObject.setResult(result);
		return responseObject.toJSONString();
	}

	@RequestMapping(value = "/disband", method = RequestMethod.DELETE)
	@ResponseBody
	public String disband(@RequestParam String tel, @RequestParam String teamId) {
		ResponseObject responseObject = new ResponseObject();
		boolean result = teamworkDao.disband(tel, teamId);
		responseObject.setResult(result);
		return responseObject.toJSONString();
	}

	@RequestMapping(value = "/viewMemberProjects", method = RequestMethod.POST)
	@ResponseBody
	public String viewMemberProjects(@RequestParam String tel, @RequestParam String memberTel) {
		ResponseObject responseObject = new ResponseObject();
		JSONArray data = teamworkDao.viewMemberProjects(tel, memberTel);
		if (data != null) {
			responseObject.setResult(true);
			responseObject.setData(data);
		}
		return responseObject.toJSONString();
	}

	@RequestMapping(value = "/viewMemberSummaries", method = RequestMethod.POST)
	@ResponseBody
	public String viewMemberSummaries(@RequestParam String tel, @RequestParam String memberTel) {
		ResponseObject responseObject = new ResponseObject();
		JSONArray data = teamworkDao.viewMemberSummaries(tel, memberTel);
		if (data != null) {
			responseObject.setResult(true);
			responseObject.setData(data);
		}
		return responseObject.toJSONString();
	}

	@RequestMapping(value = "/setPermission", method = RequestMethod.PUT)
	@ResponseBody
	public String setPermission(@RequestParam String tel, @RequestParam String memberTel, @RequestParam String teamId,
			@RequestParam int permission) {
		ResponseObject responseObject = new ResponseObject();
		boolean result = teamworkDao.setPermission(tel, memberTel, teamId, permission);
		responseObject.setResult(result);
		return responseObject.toJSONString();
	}

	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	@ResponseBody
	public String remove(@RequestParam String tel, @RequestParam String memberTel, @RequestParam String teamId) {
		ResponseObject responseObject = new ResponseObject();
		boolean result = teamworkDao.remove(tel, memberTel, teamId);
		responseObject.setResult(result);
		return responseObject.toJSONString();
	}

	@RequestMapping(value = "/searchTeam", method = RequestMethod.POST)
	@ResponseBody
	public String searchTeam(@RequestParam String tel, @RequestParam String content) {
		ResponseObject responseObject = new ResponseObject();
		JSONArray data = teamworkDao.searchTeam(tel, content);
		if (data != null) {
			responseObject.setResult(true);
			responseObject.setData(data);
		}
		return responseObject.toJSONString();
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@ResponseBody
	public String join(@RequestParam String tel, @RequestParam String teamId) {
		ResponseObject responseObject = new ResponseObject();
		boolean result = teamworkDao.join(tel, teamId);
		responseObject.setResult(result);
		return responseObject.toJSONString();
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestParam String tel, @RequestParam String name) {
		ResponseObject responseObject = new ResponseObject();
		boolean result = teamworkDao.create(tel, name);
		responseObject.setResult(result);
		return responseObject.toJSONString();
	}
}
