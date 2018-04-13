package com.zengyu.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
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

/**
 * 团队活动层
 * 
 * @author zengyu
 *
 */
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

	public String getTeamInfo(int teamId) {
		ResponseObject responseObject = new ResponseObject();
		TeamVO teamVO = teamDao.queryTeamById(teamId);
		if (teamVO != null) {
			responseObject.setData(teamVO);
		}
		return responseObject.toJSONString();
	}

	public String viewTeams(int userId) {
		ResponseObject responseObject = new ResponseObject();
		List<TeamVO> teamVOs = teamDao.queryTeams(userId);
		if (teamVOs != null) {
			try {
				JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(teamVOs));
				responseObject.setData(jsonArray);
			} catch (JSONException e) {
				// TODO
			}
		}
		return responseObject.toJSONString();
	}

	public String searchUser(String content) {
		ResponseObject responseObject = new ResponseObject();
		List<UserVO> userVOs = userDao.queryUser(content);
		if (userVOs != null) {
			try {
				JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(userVOs));
				responseObject.setData(jsonArray);
			} catch (JSONException e) {
				// TODO
			}
		}
		return responseObject.toJSONString();
	}

	public String invite(int senderId, int receiverId, int teamId) {
		ResponseObject responseObject = new ResponseObject();
		int count = messageDao.addMessage(1, senderId, receiverId, teamId);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String disband(int teamId) {
		ResponseObject responseObject = new ResponseObject();
		int count = teamDao.deleteTeam(teamId);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String viewMemberProjects(int userId) {
		ResponseObject responseObject = new ResponseObject();
		List<ProjectVO> projectVOs = projectDao.queryProjects(userId);
		if (projectVOs != null) {
			try {
				JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(projectVOs));
				responseObject.setData(jsonArray);
			} catch (JSONException e) {
				// TODO
			}
		}
		return responseObject.toJSONString();
	}

	public String viewMemberSummaries(int userId) {
		ResponseObject responseObject = new ResponseObject();
		List<SummaryVO> summaryVOs = summaryDao.querySummaries(userId);
		if (summaryVOs != null) {
			try {
				JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(summaryVOs));
				responseObject.setData(jsonArray);
			} catch (JSONException e) {
				// TODO
			}
		}
		return responseObject.toJSONString();
	}

	public String setPermission(int teamId, int userId, int permission) {
		ResponseObject responseObject = new ResponseObject();
		int count = teamDao.updateMemberPermission(teamId, userId, permission);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String remove(int teamId, int userId) {
		ResponseObject responseObject = new ResponseObject();
		int count = teamDao.deleteTeamMember(teamId, userId);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String searchTeam(String content) {
		ResponseObject responseObject = new ResponseObject();
		List<TeamVO> teamVOs = teamDao.queryTeamsByIdOrName(content);
		if (teamVOs != null) {
			try {
				JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(teamVOs));
				responseObject.setData(jsonArray);
			} catch (JSONException e) {
				// TODO
			}
		}
		return responseObject.toJSONString();
	}

	public String join(int senderId, int teamId) {
		ResponseObject responseObject = new ResponseObject();
		TeamVO teamVO = teamDao.queryTeamById(teamId);
		if (teamVO != null) {
			int count = messageDao.addMessage(2, senderId, teamVO.getUserId(), senderId);
			if (count > 0) {
				responseObject.setResult(true);
			}
		}
		return responseObject.toJSONString();
	}

	public String create(int userId, String name) {
		ResponseObject responseObject = new ResponseObject();
		int count = teamDao.addTeam(name, userId);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}
}
