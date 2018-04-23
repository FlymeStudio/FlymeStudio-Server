package com.zengyu.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
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
			JSONObject team = new JSONObject();
			team.put("count", teamVO.getMembers().size());
			UserVO admin = userDao.queryUserById(teamVO.getUserId());
			team.put("administratorName", admin.getName());
			team.put("administratorNum", admin.getNum());
			responseObject.setData(team);
		}
		return responseObject.toJSONString();
	}

	public String viewTeams(int userId) {
		ResponseObject responseObject = new ResponseObject();
		JSONObject data = new JSONObject();
		JSONArray managedTeams = new JSONArray();
		JSONArray joinedTeams = new JSONArray();
		UserVO userVO = userDao.queryUserById(userId);
		if (userVO.getTeams() != null) {
			for (int i = 0; i < userVO.getTeams().size(); i++) {
				JSONObject team = new JSONObject();
				TeamVO teamVO = teamDao.queryTeamById(userVO.getTeams().get(i));
				team.put("id", teamVO.getId());
				team.put("name", teamVO.getName());
				team.put("administratorId", teamVO.getUserId());
				UserVO admin = userDao.queryUserById(teamVO.getUserId());
				team.put("administratorName", admin.getName());
				JSONArray members = new JSONArray();
				boolean isManaged = false;
				for (int j = 0; j < teamVO.getMembers().size(); j++) {
					int id = teamVO.getMembers().get(j).getId();
					if (id == userId && teamVO.getMembers().get(j).getPermission() > 0) {
						isManaged = true;
					}
					JSONObject memberObj = new JSONObject();
					UserVO member = userDao.queryUserById(id);
					memberObj.put("id", id);
					memberObj.put("num", member.getNum());
					memberObj.put("tel", member.getTel());
					memberObj.put("name", member.getName());
					memberObj.put("email", member.getEmail());
					memberObj.put("permission", teamVO.getMembers().get(j).getPermission());
					members.add(memberObj);
				}
				team.put("members", members);
				if (isManaged) {
					managedTeams.add(team);
				} else {
					joinedTeams.add(team);
				}
			}
		}
		data.put("managedTeams", managedTeams);
		data.put("joinedTeams", joinedTeams);
		responseObject.setData(data);
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
		if (messageDao.queryMessageByDetail(1, senderId, receiverId, teamId) == null) {
			int count = messageDao.addMessage(1, senderId, receiverId, teamId);
			if (count > 0) {
				responseObject.setResult(true);
			}
		}
		return responseObject.toJSONString();
	}

	public String disband(int teamId) {
		ResponseObject responseObject = new ResponseObject();
		TeamVO teamVO = teamDao.queryTeamById(teamId);
		if (teamVO.getMembers().size() == 1) {
			UserVO userVO = userDao.queryUserById(teamVO.getUserId());
			int count1 = teamDao.deleteTeam(teamId);
			if (count1 > 0) {
				List<Integer> teams = userVO.getTeams();
				for (int i = 0; i < teams.size(); i++) {
					if (teams.get(i) == teamId) {
						teams.remove(i);
						break;
					}
				}
				int count2 = userDao.updateUserTeams(userVO.getId(), teams);
				if (count2 > 0) {
					responseObject.setResult(true);
				}
			}
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
			UserVO userVO = userDao.queryUserById(userId);
			List<Integer> teams = userVO.getTeams();
			for (int i = 0; i < teams.size(); i++) {
				if (teams.get(i) == teamId) {
					teams.remove(i);
					break;
				}
			}
			int count2 = userDao.updateUserTeams(userVO.getId(), teams);
			if (count2 > 0) {
				responseObject.setResult(true);
			}
		}
		return responseObject.toJSONString();
	}

	public String searchTeam(String content) {
		ResponseObject responseObject = new ResponseObject();
		List<TeamVO> teamVOs = teamDao.queryTeamsByIdOrName(content);
		JSONArray jsonArray = new JSONArray();
		if (teamVOs != null) {
			for (int i = 0; i < teamVOs.size(); i++) {
				JSONObject team = new JSONObject();
				team.put("id", teamVOs.get(i).getId());
				team.put("name", teamVOs.get(i).getName());
				UserVO admin = userDao.queryUserById(teamVOs.get(i).getUserId());
				team.put("administrator", admin.getName());
				team.put("count", teamVOs.get(i).getMembers().size());
				jsonArray.add(team);
			}
		}
		responseObject.setData(jsonArray);
		return responseObject.toJSONString();
	}

	public String join(int senderId, int teamId) {
		ResponseObject responseObject = new ResponseObject();
		TeamVO teamVO = teamDao.queryTeamById(teamId);
		if (teamVO != null) {
			boolean isMember = false;
			for (int i = 0; i < teamVO.getMembers().size(); i++) {
				if (teamVO.getMembers().get(i).getId() == senderId) {
					isMember = true;
					break;
				}
			}
			if (!isMember) {
				if (messageDao.queryMessageByDetail(2, senderId, teamVO.getUserId(), teamId) == null) {
					int count = messageDao.addMessage(2, senderId, teamVO.getUserId(), teamId);
					if (count > 0) {
						responseObject.setResult(true);
					}
				}
			}
		}
		return responseObject.toJSONString();
	}

	public String create(int userId, String name) {
		ResponseObject responseObject = new ResponseObject();
		if (teamDao.queryTeamByName(userId, name) == null) {
			if (teamDao.queryTeamByName(userId, name) == null) {
				int count1 = teamDao.addTeam(name, userId);
				if (count1 > 0) {
					TeamVO teamVO = teamDao.queryTeamByName(userId, name);
					UserVO user = userDao.queryUserById(userId);
					List<Integer> teams = user.getTeams();
					if (teams == null) {
						teams = new ArrayList<Integer>();
					}
					teams.add(teamVO.getId());
					int count2 = userDao.updateUserTeams(userId, teams);
					if (count2 > 0) {
						responseObject.setResult(true);
					}
				}
			}
		}
		return responseObject.toJSONString();
	}
}
