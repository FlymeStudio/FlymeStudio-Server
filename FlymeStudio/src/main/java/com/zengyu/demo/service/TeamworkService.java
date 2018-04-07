package com.zengyu.demo.service;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zengyu.demo.dao.TeamworkDao;

@Service
public class TeamworkService extends AbstractService implements TeamworkDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JSONObject getTeamInfo(String id) {
		return null;
	}

	public boolean replyMsg(String tel, String messageId, boolean result) {
		return false;
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
