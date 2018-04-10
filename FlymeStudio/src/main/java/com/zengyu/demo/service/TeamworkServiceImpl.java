package com.zengyu.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zengyu.demo.model.ProjectVO;
import com.zengyu.demo.model.SummaryVO;
import com.zengyu.demo.model.TeamVO;
import com.zengyu.demo.model.UserVO;
import com.zengyu.demo.others.ResponseObject;
import com.zengyu.demo.repository.MessageDao;
import com.zengyu.demo.repository.ProjectDao;
import com.zengyu.demo.repository.SummaryDao;
import com.zengyu.demo.repository.TeamDao;
import com.zengyu.demo.repository.UserDao;

@Service
public class TeamworkServiceImpl implements TeamworkService {
	@Resource(name = "teamDao")
	private TeamDao teamDao;

	@Resource(name = "userDao")
	private UserDao userDao;

	@Resource(name = "messageDao")
	private MessageDao messageDao;

	@Resource(name = "projectDao")
	private ProjectDao projectDao;

	@Resource(name = "summaryDao")
	private SummaryDao summaryDao;

	public String getTeamInfo(int id) {
		ResponseObject responseObject = new ResponseObject();
		TeamVO teamVO = teamDao.queryTeamById(id);
		if (teamVO != null) {
			responseObject.setData(teamVO);
		}
		return responseObject.toJSONString();
	}

	public String viewTeams(String tel) {
		ResponseObject responseObject = new ResponseObject();
		List<TeamVO> teamVOs = teamDao.queryTeams(tel);
		if (teamVOs != null) {
			JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(teamVOs));
			responseObject.setData(jsonArray);
		}
		return responseObject.toJSONString();
	}

	public String searchUser(String content) {
		ResponseObject responseObject = new ResponseObject();
		List<UserVO> userVOs = userDao.queryUserWithoutPassword(content);
		if (userVOs != null) {
			JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(userVOs));
			responseObject.setData(jsonArray);
		}
		return responseObject.toJSONString();
	}

	public String invite(String sender, String receiver, int id) {
		ResponseObject responseObject = new ResponseObject();
		int count = messageDao.addMessage(1, sender, receiver, id);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String disband(int id) {
		ResponseObject responseObject = new ResponseObject();
		int count = teamDao.deleteTeam(id);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String viewMemberProjects(String tel) {
		ResponseObject responseObject = new ResponseObject();
		List<ProjectVO> projectVOs = projectDao.queryProjects(tel);
		if (projectVOs != null) {
			JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(projectVOs));
			responseObject.setData(jsonArray);
		}
		return responseObject.toJSONString();
	}

	public String viewMemberSummaries(String tel) {
		ResponseObject responseObject = new ResponseObject();
		List<SummaryVO> summaryVOs = summaryDao.querySummaries(tel);
		if (summaryVOs != null) {
			JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(summaryVOs));
			responseObject.setData(jsonArray);
		}
		return responseObject.toJSONString();
	}

	public String setPermission(String tel, int id, int permission) {
		ResponseObject responseObject = new ResponseObject();
		int count = teamDao.updateMemberPermission(tel, id, permission);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String remove(String tel, int id) {
		ResponseObject responseObject = new ResponseObject();
		int count = teamDao.deleteTeamMember(tel, id);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String searchTeam(String content) {
		ResponseObject responseObject = new ResponseObject();
		List<TeamVO> teamVOs = teamDao.queryTeamsByIdOrName(content);
		if (teamVOs != null) {
			JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(teamVOs));
			responseObject.setData(jsonArray);
		}
		return responseObject.toJSONString();
	}

	public String join(String sender, int id) {
		ResponseObject responseObject = new ResponseObject();
		TeamVO teamVO = teamDao.queryTeamById(id);
		if (teamVO != null) {
			int count = messageDao.addMessage(2, sender, teamVO.getTel(), id);
			if (count > 0) {
				responseObject.setResult(true);
			}
		}
		return responseObject.toJSONString();
	}

	public String create(String tel, String name) {
		ResponseObject responseObject = new ResponseObject();
		int count = teamDao.addTeam(name, tel);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

}
