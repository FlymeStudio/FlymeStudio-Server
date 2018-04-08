package com.zengyu.demo.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zengyu.demo.dao.TeamworkDao;
import com.zengyu.demo.model.TeamMapper;
import com.zengyu.demo.model.TeamVO;
import com.zengyu.demo.others.Const;

@Service
public class TeamworkService extends AbstractService implements TeamworkDao {

	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JSONObject getTeamInfo(String id) {
		JSONObject jsonObject = null;
		try {
			// 查询团队信息
			String SQL = "select * from " + Const.Team.TABLE_NAME + " where " + Const.Team.COLUMN_ID + " = ?";

			TeamVO teamVO = jdbcTemplate.queryForObject(SQL, new TeamMapper(), id);
			if (teamVO != null) {
				jsonObject = new JSONObject();
				jsonObject.put(Const.Team.COLUMN_ID, teamVO.getId());
				jsonObject.put(Const.Team.COLUMN_NAME, teamVO.getId());
				jsonObject.put(Const.Team.COLUMN_TEL, teamVO.getId());
				JSONArray jsonArray = new JSONArray();
				if (teamVO.getMembers() != null && teamVO.getMembers().size() > 0) {
					jsonArray = JSONArray.parseArray(teamVO.getMembers().toString());
				}
				jsonObject.put(Const.Team.COLUMN_MEMBERS, jsonArray);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	public boolean replyMsg(String tel, String messageId, boolean result) {
		boolean responseResult = false;
		
		// 处理信息
		String SQL = "";
		
		
		return responseResult;
	}

	public JSONArray viewTeams(String tel) {
		return null;
	}

	public JSONArray searchUser(String tel, String content) {
		return null;
	}

	public boolean invite(String tel, String toTel, String teamId) {
		return false;
	}

	public boolean disband(String tel, String teamId) {
		return false;
	}

	public JSONArray viewMemberProjects(String tel, String memberTel) {
		return null;
	}

	public JSONArray viewMemberSummaries(String tel, String memberTel) {
		return null;
	}

	public boolean setPermission(String tel, String memberTel, String teamId, int permission) {
		return false;
	}

	public boolean remove(String tel, String memberTel, String teamId) {
		return false;
	}

	public JSONArray searchTeam(String tel, String content) {
		return null;
	}

	public boolean join(String tel, String teamId) {
		return false;
	}

	public boolean create(String tel, String name) {
		return false;
	}

}
