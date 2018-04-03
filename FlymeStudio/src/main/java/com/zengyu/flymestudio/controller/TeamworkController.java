package com.zengyu.flymestudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zengyu.flymestudio.dao.TeamworkDao;

@Controller
@RequestMapping("/Teamwork")
public class TeamworkController {
	private TeamworkDao teamworkDao;

	@Autowired
	public TeamworkController(TeamworkDao teamworkDao) {
		this.teamworkDao = teamworkDao;
	}

	@RequestMapping(value = "/getTeamInfo", method = RequestMethod.POST)
	@ResponseBody
	public String getTeamInfo(@RequestParam String id) {
		JSONObject jsonObject = new JSONObject();
		boolean isDataExist = false;
		JSONObject data = teamworkDao.getTeamInfo(id);
		if (data != null) {
			isDataExist = true;
			jsonObject.put("data", data);
		}
		jsonObject.put("result", isDataExist);
		return jsonObject.toJSONString();
	}

	@RequestMapping(value = "/replyMsg", method = RequestMethod.POST)
	@ResponseBody
	public String replyMsg(@RequestParam String tel, @RequestParam String messageId, @RequestParam boolean result) {
		JSONObject jsonObject = new JSONObject();
		boolean data = teamworkDao.replyMsg(tel, messageId, result);
		jsonObject.put("result", data);
		return jsonObject.toJSONString();
	}

	@RequestMapping(value = "/viewTeams", method = RequestMethod.POST)
	@ResponseBody
	public String viewTeams(@RequestParam String tel) {
		JSONObject jsonObject = new JSONObject();
		boolean isDataExist = false;
		JSONArray data = teamworkDao.viewTeams(tel);
		if (data != null) {
			isDataExist = true;
			jsonObject.put("data", data);
		}
		jsonObject.put("result", isDataExist);
		return jsonObject.toJSONString();
	}

	@RequestMapping(value = "/searchUser", method = RequestMethod.POST)
	@ResponseBody
	public String searchUser(@RequestParam String tel, @RequestParam String content) {
		JSONObject jsonObject = new JSONObject();
		boolean isDataExist = false;
		JSONArray data = teamworkDao.searchUser(tel, content);
		if (data != null) {
			isDataExist = true;
			jsonObject.put("data", data);
		}
		jsonObject.put("result", isDataExist);
		return jsonObject.toJSONString();
	}

	@RequestMapping(value = "/invite", method = RequestMethod.POST)
	@ResponseBody
	public String invite(@RequestParam String tel, @RequestParam String toTel, @RequestParam String teamId) {
		JSONObject jsonObject = new JSONObject();
		boolean data = teamworkDao.invite(tel, toTel, teamId);
		jsonObject.put("result", data);
		return jsonObject.toJSONString();
	}

	@RequestMapping(value = "/disband", method = RequestMethod.DELETE)
	@ResponseBody
	public String disband(@RequestParam String tel, @RequestParam String teamId) {
		JSONObject jsonObject = new JSONObject();
		boolean data = teamworkDao.disband(tel, teamId);
		jsonObject.put("result", data);
		return jsonObject.toJSONString();
	}

	@RequestMapping(value = "/viewMemberProjects", method = RequestMethod.POST)
	@ResponseBody
	public String viewMemberProjects(@RequestParam String tel, @RequestParam String memberTel) {
		JSONObject jsonObject = new JSONObject();
		boolean isDataExist = false;
		JSONArray data = teamworkDao.viewMemberProjects(tel, memberTel);
		if (data != null) {
			isDataExist = true;
			jsonObject.put("data", data);
		}
		jsonObject.put("result", isDataExist);
		return jsonObject.toJSONString();
	}

	@RequestMapping(value = "/viewMemberSummaries", method = RequestMethod.POST)
	@ResponseBody
	public String viewMemberSummaries(@RequestParam String tel, @RequestParam String memberTel) {
		JSONObject jsonObject = new JSONObject();
		boolean isDataExist = false;
		JSONArray data = teamworkDao.viewMemberSummaries(tel, memberTel);
		if (data != null) {
			isDataExist = true;
			jsonObject.put("data", data);
		}
		jsonObject.put("result", isDataExist);
		return jsonObject.toJSONString();
	}

	@RequestMapping(value = "/setPermission", method = RequestMethod.PUT)
	@ResponseBody
	public String setPermission(@RequestParam String tel, @RequestParam String memberTel, @RequestParam String teamId,
			@RequestParam int permission) {
		JSONObject jsonObject = new JSONObject();
		boolean data = teamworkDao.setPermission(tel, memberTel, teamId, permission);
		jsonObject.put("result", data);
		return jsonObject.toJSONString();
	}

	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	@ResponseBody
	public String remove(@RequestParam String tel, @RequestParam String memberTel, @RequestParam String teamId) {
		JSONObject jsonObject = new JSONObject();
		boolean data = teamworkDao.remove(tel, memberTel, teamId);
		jsonObject.put("result", data);
		return jsonObject.toJSONString();
	}

	@RequestMapping(value = "/searchTeam", method = RequestMethod.POST)
	@ResponseBody
	public String searchTeam(@RequestParam String tel, @RequestParam String content) {
		JSONObject jsonObject = new JSONObject();
		boolean isDataExist = false;
		JSONArray data = teamworkDao.searchTeam(tel, content);
		if (data != null) {
			isDataExist = true;
			jsonObject.put("data", data);
		}
		jsonObject.put("result", isDataExist);
		return jsonObject.toJSONString();
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@ResponseBody
	public String join(@RequestParam String tel, @RequestParam String teamId) {
		JSONObject jsonObject = new JSONObject();
		boolean data = teamworkDao.join(tel, teamId);
		jsonObject.put("result", data);
		return jsonObject.toJSONString();
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestParam String tel, @RequestParam String name) {
		JSONObject jsonObject = new JSONObject();
		boolean data = teamworkDao.create(tel, name);
		jsonObject.put("result", data);
		return jsonObject.toJSONString();
	}
}
