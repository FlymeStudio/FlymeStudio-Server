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
	public String getTeamInfo(@RequestParam int id) {
		return teamworkService.getTeamInfo(id);
	}

	@RequestMapping(value = "/viewTeams", method = RequestMethod.POST)
	@ResponseBody
	public String viewTeams(@RequestParam String tel) {
		return teamworkService.viewTeams(tel);
	}

	@RequestMapping(value = "/searchUser", method = RequestMethod.POST)
	@ResponseBody
	public String searchUser(@RequestParam String content) {
		return teamworkService.searchUser(content);
	}

	@RequestMapping(value = "/invite", method = RequestMethod.POST)
	@ResponseBody
	public String invite(@RequestParam String sender, @RequestParam String receiver, @RequestParam int id) {
		return teamworkService.invite(sender, receiver, id);
	}

	@RequestMapping(value = "/disband", method = RequestMethod.DELETE)
	@ResponseBody
	public String disband(@RequestParam int id) {
		return teamworkService.disband(id);
	}

	@RequestMapping(value = "/viewMemberProjects", method = RequestMethod.POST)
	@ResponseBody
	public String viewMemberProjects(@RequestParam String tel) {
		return teamworkService.viewMemberProjects(tel);
	}

	@RequestMapping(value = "/viewMemberSummaries", method = RequestMethod.POST)
	@ResponseBody
	public String viewMemberSummaries(@RequestParam String tel) {
		return teamworkService.viewMemberSummaries(tel);
	}

	@RequestMapping(value = "/setPermission", method = RequestMethod.PUT)
	@ResponseBody
	public String setPermission(@RequestParam String tel, @RequestParam int id, @RequestParam int permission) {
		return teamworkService.setPermission(tel, id, permission);
	}

	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	@ResponseBody
	public String remove(@RequestParam String tel, @RequestParam int id) {
		return teamworkService.remove(tel, id);
	}

	@RequestMapping(value = "/searchTeam", method = RequestMethod.POST)
	@ResponseBody
	public String searchTeam(@RequestParam String content) {
		return teamworkService.searchTeam(content);
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@ResponseBody
	public String join(@RequestParam String sender, @RequestParam int id) {
		return teamworkService.join(sender, id);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestParam String tel, @RequestParam String name) {
		return teamworkService.create(tel, name);
	}
}
