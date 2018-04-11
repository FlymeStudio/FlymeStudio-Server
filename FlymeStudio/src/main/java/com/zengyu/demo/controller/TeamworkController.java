package com.zengyu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zengyu.demo.service.TeamworkService;

/**
 * 团队控制层
 * 
 * @author zengyu
 *
 */
@Controller
@RequestMapping(value = "/Teamwork", produces = { "text/html;charset=UTF-8;", "application/json;" })
public class TeamworkController {
	private TeamworkService teamworkService;

	@Autowired
	public TeamworkController(TeamworkService teamworkService) {
		this.teamworkService = teamworkService;
	}

	/**
	 * 获取团队信息
	 * 
	 * @param id
	 *            团队编号
	 * @return
	 */
	@RequestMapping(value = "/team", method = RequestMethod.GET)
	@ResponseBody
	public String getTeamInfo(@RequestParam int id) {
		return teamworkService.getTeamInfo(id);
	}

	/**
	 * 查看个人团队
	 * 
	 * @param tel
	 *            电话
	 * @return
	 */
	@RequestMapping(value = "/myteams", method = RequestMethod.GET)
	@ResponseBody
	public String viewTeams(@RequestParam String tel) {
		return teamworkService.viewTeams(tel);
	}

	/**
	 * 查找用户
	 * 
	 * @param content
	 *            查找内容
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	public String searchUser(@RequestParam String content) {
		return teamworkService.searchUser(content);
	}

	/**
	 * 邀请加入团队
	 * 
	 * @param sender
	 *            发送方
	 * @param receiver
	 *            接收方
	 * @param id
	 *            团队编号
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public String invite(@RequestParam String sender, @RequestParam String receiver, @RequestParam int id) {
		return teamworkService.invite(sender, receiver, id);
	}

	/**
	 * 解散团队
	 * 
	 * @param id
	 *            团队编号
	 * @return
	 */
	@RequestMapping(value = "/myteam", method = RequestMethod.DELETE)
	@ResponseBody
	public String disband(@RequestParam int id) {
		return teamworkService.disband(id);
	}

	/**
	 * 查看成员任务
	 * 
	 * @param tel
	 *            成员电话
	 * @return
	 */
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	@ResponseBody
	public String viewMemberProjects(@RequestParam String tel) {
		return teamworkService.viewMemberProjects(tel);
	}

	/**
	 * 查看成员总结
	 * 
	 * @param tel
	 *            电话
	 * @return
	 */
	@RequestMapping(value = "/summaries", method = RequestMethod.GET)
	@ResponseBody
	public String viewMemberSummaries(@RequestParam String tel) {
		return teamworkService.viewMemberSummaries(tel);
	}

	/**
	 * 设置权限
	 * 
	 * @param tel
	 *            成员电话
	 * @param id
	 *            团队编号
	 * @param permission
	 *            成员权限
	 * @return
	 */
	@RequestMapping(value = "/permission", method = RequestMethod.PUT)
	@ResponseBody
	public String setPermission(@RequestParam String tel, @RequestParam int id, @RequestParam int permission) {
		return teamworkService.setPermission(tel, id, permission);
	}

	/**
	 * 移除成员
	 * 
	 * @param tel
	 *            成员电话
	 * @param id
	 *            团队编号
	 * @return
	 */
	@RequestMapping(value = "/member", method = RequestMethod.DELETE)
	@ResponseBody
	public String remove(@RequestParam String tel, @RequestParam int id) {
		return teamworkService.remove(tel, id);
	}

	/**
	 * 查找团队
	 * 
	 * @param content
	 *            查找内容
	 * @return
	 */
	@RequestMapping(value = "/teams", method = RequestMethod.GET)
	@ResponseBody
	public String searchTeam(@RequestParam String content) {
		return teamworkService.searchTeam(content);
	}

	/**
	 * 申请加入团队
	 * 
	 * @param sender
	 *            发送方
	 * @param id
	 *            团队编号
	 * @return
	 */
	@RequestMapping(value = "/team", method = RequestMethod.PUT)
	@ResponseBody
	public String join(@RequestParam String sender, @RequestParam int id) {
		return teamworkService.join(sender, id);
	}

	/**
	 * 创建团队
	 * 
	 * @param tel
	 *            电话
	 * @param name
	 *            团队名
	 * @return
	 */
	@RequestMapping(value = "/myteam", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestParam String tel, @RequestParam String name) {
		return teamworkService.create(tel, name);
	}
}
