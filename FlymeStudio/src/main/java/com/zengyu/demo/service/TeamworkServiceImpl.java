package com.zengyu.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zengyu.demo.dao.MessageDao;
import com.zengyu.demo.dao.MessageImpl;
import com.zengyu.demo.dao.ProjectDao;
import com.zengyu.demo.dao.ProjectImpl;
import com.zengyu.demo.dao.SummaryDao;
import com.zengyu.demo.dao.SummaryImpl;
import com.zengyu.demo.dao.TeamDao;
import com.zengyu.demo.dao.TeamImpl;
import com.zengyu.demo.dao.UserDao;
import com.zengyu.demo.dao.UserImpl;
import com.zengyu.demo.model.ProjectVO;
import com.zengyu.demo.model.SummaryVO;
import com.zengyu.demo.model.TeamVO;
import com.zengyu.demo.model.UserVO;
import com.zengyu.demo.others.ResponseObject;

@Service
public class TeamworkServiceImpl implements TeamworkService {

	public String getTeamInfo(int id) {
		ResponseObject responseObject = new ResponseObject();
		TeamDao teamDao = new TeamImpl();
		TeamVO teamVO = teamDao.queryTeamById(id);
		if (teamVO != null) {
			responseObject.setData(teamVO);
		}
		return responseObject.toJSONString();
	}

	public String viewTeams(String tel) {
		ResponseObject responseObject = new ResponseObject();
		TeamDao teamDao = new TeamImpl();
		List<TeamVO> teamVOs = teamDao.queryTeams(tel);
		if (teamVOs != null) {
			JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(teamVOs));
			responseObject.setData(jsonArray);
		}
		return responseObject.toJSONString();
	}

	public String searchUser(String content) {
		ResponseObject responseObject = new ResponseObject();
		UserDao userDao = new UserImpl();
		List<UserVO> userVOs = userDao.queryUserWithoutPassword(content);
		if (userVOs != null) {
			JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(userVOs));
			responseObject.setData(jsonArray);
		}
		return responseObject.toJSONString();
	}

	public String invite(String sender, String receiver, int id) {
		ResponseObject responseObject = new ResponseObject();
		MessageDao messageDao = new MessageImpl();
		int count = messageDao.addMessage(1, sender, receiver, id);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String disband(int id) {
		ResponseObject responseObject = new ResponseObject();
		TeamDao teamDao = new TeamImpl();
		int count = teamDao.deleteTeam(id);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String viewMemberProjects(String tel) {
		ResponseObject responseObject = new ResponseObject();
		ProjectDao projectDao = new ProjectImpl();
		List<ProjectVO> projectVOs = projectDao.queryProjects(tel);
		if (projectVOs != null) {
			JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(projectVOs));
			responseObject.setData(jsonArray);
		}
		return responseObject.toJSONString();
	}

	public String viewMemberSummaries(String tel) {
		ResponseObject responseObject = new ResponseObject();
		SummaryDao summaryDao = new SummaryImpl();
		List<SummaryVO> summaryVOs = summaryDao.querySummaries(tel);
		if (summaryVOs != null) {
			JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(summaryVOs));
			responseObject.setData(jsonArray);
		}
		return responseObject.toJSONString();
	}

	public String setPermission(String tel, int id, int permission) {
		ResponseObject responseObject = new ResponseObject();
		TeamDao teamDao = new TeamImpl();
		int count = teamDao.updateMemberPermission(tel, id, permission);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String remove(String tel, int id) {
		ResponseObject responseObject = new ResponseObject();
		TeamDao teamDao = new TeamImpl();
		int count = teamDao.deleteTeamMember(tel, id);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String searchTeam(String content) {
		ResponseObject responseObject = new ResponseObject();
		TeamDao teamDao = new TeamImpl();
		List<TeamVO> teamVOs = teamDao.queryTeamsByIdOrName(content);
		if (teamVOs != null) {
			JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(teamVOs));
			responseObject.setData(jsonArray);
		}
		return responseObject.toJSONString();
	}

	public String join(String sender, int id) {
		ResponseObject responseObject = new ResponseObject();
		TeamDao teamDao = new TeamImpl();
		TeamVO teamVO = teamDao.queryTeamById(id);
		if (teamVO != null) {
			MessageDao messageDao = new MessageImpl();
			int count = messageDao.addMessage(2, sender, teamVO.getTel(), id);
			if (count > 0) {
				responseObject.setResult(true);
			}
		}
		return responseObject.toJSONString();
	}

	public String create(String tel, String name) {
		ResponseObject responseObject = new ResponseObject();
		TeamDao teamDao = new TeamImpl();
		int count = teamDao.addTeam(name, tel);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

}
