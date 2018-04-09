package com.zengyu.demo.service;

public interface TeamworkService {
	String getTeamInfo(String id);

	String replyMsg(String tel, String messageId, boolean result);

	String viewTeams(String tel);

	String searchUser(String tel, String content);

	String invite(String tel, String toTel, String teamId);

	String disband(String tel, String teamId);

	String viewMemberProjects(String tel, String memberTel);

	String viewMemberSummaries(String tel, String memberTel);

	String setPermission(String tel, String memberTel, String teamId, int permission);

	String remove(String tel, String memberTel, String teamId);

	String searchTeam(String tel, String content);

	String join(String tel, String teamId);

	String create(String tel, String name);
}
