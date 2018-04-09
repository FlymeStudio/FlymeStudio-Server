package com.zengyu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zengyu.demo.service.TeamworkService;

@Controller
@RequestMapping(value = "/Teamwork", produces = { "text/html;charset=UTF-8;", "application/json;" })
public class TeamworkController {
	private TeamworkService teamworkService;

	@Autowired
	public TeamworkController(TeamworkService teamworkService) {
		this.teamworkService = teamworkService;
	}

	@RequestMapping(value = "/getTeamInfo", method = RequestMethod.POST)
	@ResponseBody
	public String getTeamInfo(@RequestParam String id) {
		return teamworkService.getTeamInfo(id);
	}

	@RequestMapping(value = "/replyMsg", method = RequestMethod.POST)
	@ResponseBody
	public String replyMsg(@RequestParam String tel, @RequestParam String messageId, @RequestParam boolean result) {
		return teamworkService.replyMsg(tel, messageId, result);
	}

	@RequestMapping(value = "/viewTeams", method = RequestMethod.POST)
	@ResponseBody
	public String viewTeams(@RequestParam String tel) {
		return teamworkService.viewTeams(tel);
	}

	@RequestMapping(value = "/searchUser", method = RequestMethod.POST)
	@ResponseBody
	public String searchUser(@RequestParam String tel, @RequestParam String content) {
		return teamworkService.searchUser(tel, content);
	}

	@RequestMapping(value = "/invite", method = RequestMethod.POST)
	@ResponseBody
	public String invite(@RequestParam String tel, @RequestParam String toTel, @RequestParam String teamId) {
		return teamworkService.invite(tel, toTel, teamId);
	}

	@RequestMapping(value = "/disband", method = RequestMethod.DELETE)
	@ResponseBody
	public String disband(@RequestParam String tel, @RequestParam String teamId) {
		return teamworkService.disband(tel, teamId);
	}

	@RequestMapping(value = "/viewMemberProjects", method = RequestMethod.POST)
	@ResponseBody
	public String viewMemberProjects(@RequestParam String tel, @RequestParam String memberTel) {
		return teamworkService.viewMemberProjects(tel, memberTel);
	}

	@RequestMapping(value = "/viewMemberSummaries", method = RequestMethod.POST)
	@ResponseBody
	public String viewMemberSummaries(@RequestParam String tel, @RequestParam String memberTel) {
		return teamworkService.viewMemberSummaries(tel, memberTel);
	}

	@RequestMapping(value = "/setPermission", method = RequestMethod.PUT)
	@ResponseBody
	public String setPermission(@RequestParam String tel, @RequestParam String memberTel, @RequestParam String teamId,
			@RequestParam int permission) {
		return teamworkService.setPermission(tel, memberTel, teamId, permission);
	}

	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	@ResponseBody
	public String remove(@RequestParam String tel, @RequestParam String memberTel, @RequestParam String teamId) {
		return teamworkService.remove(tel, memberTel, teamId);
	}

	@RequestMapping(value = "/searchTeam", method = RequestMethod.POST)
	@ResponseBody
	public String searchTeam(@RequestParam String tel, @RequestParam String content) {
		return teamworkService.searchTeam(tel, content);
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@ResponseBody
	public String join(@RequestParam String tel, @RequestParam String teamId) {
		return teamworkService.join(tel, teamId);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestParam String tel, @RequestParam String name) {
		return teamworkService.create(tel, name);
	}
}
