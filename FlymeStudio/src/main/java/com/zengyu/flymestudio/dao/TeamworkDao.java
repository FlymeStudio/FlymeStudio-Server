package com.zengyu.flymestudio.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface TeamworkDao {
	JSONObject getTeamInfo(String id);

	boolean replyMsg(String tel, String messageId, boolean result);

	JSONArray viewTeams(String tel);

	JSONArray searchUser(String tel, String content);

	boolean invite(String tel, String toTel, String teamId);

	boolean disband(String tel, String teamId);

	JSONArray viewMemberProjects(String tel, String memberTel);

	JSONArray viewMemberSummaries(String tel, String memberTel);

	boolean setPermission(String tel, String memberTel, String teamId, int permission);

	boolean remove(String tel, String memberTel, String teamId);

	JSONArray searchTeam(String tel, String content);

	boolean join(String tel, String teamId);

	boolean create(String tel, String name);
}
