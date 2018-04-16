package com.zengyu.demo.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping(value = "/Teamwork", produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
@CrossOrigin(origins = "*", maxAge = 3600)
public class TeamworkController {
	static Logger logger = Logger.getLogger(TeamworkController.class.getSimpleName());
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
	 * @String responseStr =
	 */
	@RequestMapping(value = "/team/all", method = RequestMethod.GET)
	@ResponseBody
	public String getTeamInfo(@RequestParam int id) {
		logger.info("getTeamInfo:\t id=" + id);
		String responseStr = teamworkService.getTeamInfo(id);
		logger.info("getTeamInfo response:\t" + responseStr);
		return responseStr;
	}

	/**
	 * 查看个人团队
	 * 
	 * @param user
	 *            用户编号
	 * @String responseStr =
	 */
	@RequestMapping(value = "/teams/my", method = RequestMethod.GET)
	@ResponseBody
	public String viewTeams(@RequestParam int user) {
		logger.info("viewTeams:\t user=" + user);
		String responseStr = teamworkService.viewTeams(user);
		logger.info("viewTeams response:\t" + responseStr);
		return responseStr;
	}

	/**
	 * 查找用户
	 * 
	 * @param content
	 *            查找内容
	 * @String responseStr =
	 */
	@RequestMapping(value = "/user/all", method = RequestMethod.GET)
	@ResponseBody
	public String searchUser(@RequestParam String content) {
		logger.info("searchUser:\t content=" + content);
		String responseStr = teamworkService.searchUser(content);
		logger.info("searchUser response:\t" + responseStr);
		return responseStr;
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
	 * @String responseStr =
	 */
	@RequestMapping(value = "/user/all", method = RequestMethod.POST)
	@ResponseBody
	public String invite(@RequestParam int sender, @RequestParam int receiver, @RequestParam int id,
			HttpServletResponse response) {
		logger.info("invite:\t sender=" + sender + "\t receiver=" + receiver + "\t id=" + id);
		String responseStr = teamworkService.invite(sender, receiver, id);
		logger.info("invite response:\t" + responseStr);
		return responseStr;
	}

	/**
	 * 解散团队
	 * 
	 * @param id
	 *            团队编号
	 * @String responseStr =
	 */
	@RequestMapping(value = "/team/my", method = RequestMethod.DELETE)
	@ResponseBody
	public String disband(@RequestParam int id) {
		logger.info("disband:\t id=" + id);
		String responseStr = teamworkService.disband(id);
		logger.info("disband response:\t" + responseStr);
		return responseStr;
	}

	/**
	 * 查看成员任务
	 * 
	 * @param user
	 *            用户编号
	 * @String responseStr =
	 */
	@RequestMapping(value = "/projects/member", method = RequestMethod.GET)
	@ResponseBody
	public String viewMemberProjects(@RequestParam int user) {
		logger.info("viewMemberProjects:\t user=" + user);
		String responseStr = teamworkService.viewMemberProjects(user);
		logger.info("viewMemberProjects response:\t" + responseStr);
		return responseStr;
	}

	/**
	 * 查看成员总结
	 * 
	 * @param user
	 *            用户编号
	 * @String responseStr =
	 */
	@RequestMapping(value = "/summaries/member", method = RequestMethod.GET)
	@ResponseBody
	public String viewMemberSummaries(@RequestParam int user) {
		logger.info("viewMemberSummaries:\t user=" + user);
		String responseStr = teamworkService.viewMemberSummaries(user);
		logger.info("viewMemberSummaries response:\t" + responseStr);
		return responseStr;
	}

	/**
	 * 设置权限
	 * 
	 * @param id
	 *            团队编号
	 * @param user
	 *            成员编号
	 * @param permission
	 *            成员权限
	 * @String responseStr =
	 */
	@RequestMapping(value = "/permission/member", method = RequestMethod.PUT)
	@ResponseBody
	public String setPermission(@RequestParam int id, @RequestParam int user, @RequestParam int permission,
			HttpServletResponse response) {
		logger.info("setPermission:\t id=" + id + "\t user=" + user + "\t permission=" + permission);
		String responseStr = teamworkService.setPermission(id, user, permission);
		logger.info("setPermission response:\t" + responseStr);
		return responseStr;
	}

	/**
	 * 移除成员
	 * 
	 * @param id
	 *            团队编号
	 * @param user
	 *            成员编号
	 * @String responseStr =
	 */
	@RequestMapping(value = "/team/member", method = RequestMethod.DELETE)
	@ResponseBody
	public String remove(@RequestParam int id, @RequestParam int user) {
		logger.info("remove:\t id=" + id + "\t user=" + user);
		String responseStr = teamworkService.remove(id, user);
		logger.info("remove response:\t" + responseStr);
		return responseStr;
	}

	/**
	 * 查找团队
	 * 
	 * @param content
	 *            查找内容
	 * @String responseStr =
	 */
	@RequestMapping(value = "/teams/all", method = RequestMethod.GET)
	@ResponseBody
	public String searchTeam(@RequestParam String content) {
		logger.info("searchTeam:\t content=" + content);
		String responseStr = teamworkService.searchTeam(content);
		logger.info("searchTeam response:\t" + responseStr);
		return responseStr;
	}

	/**
	 * 申请加入团队
	 * 
	 * @param sender
	 *            发送方
	 * @param id
	 *            团队编号
	 */
	@RequestMapping(value = "/team/all", method = RequestMethod.POST)
	@ResponseBody
	public String join(@RequestParam int sender, @RequestParam int id) {
		logger.info("join:\t sender=" + sender + "\t id=" + id);
		String responseStr = teamworkService.join(sender, id);
		logger.info("join response:\t" + responseStr);
		return responseStr;
	}

	/**
	 * 创建团队
	 * 
	 * @param user
	 *            用户编号
	 * @param name
	 *            团队名
	 * @String responseStr =
	 */
	@RequestMapping(value = "/team/my", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestParam int user, @RequestParam String name) {
		logger.info("create:\t user=" + user + "\t name=" + name);
		String responseStr = teamworkService.create(user, name);
		logger.info("create response:\t" + responseStr);
		return responseStr;
	}
}
