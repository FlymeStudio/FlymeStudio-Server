package com.zengyu.demo.service;

public interface TeamworkService {
	String getTeamInfo(int id);

	String viewTeams(String tel);

	String searchUser(String content);

	String invite(String sender, String receiver, int id);

	String disband(int id);

	String viewMemberProjects(String tel);

	String viewMemberSummaries(String tel);

	String setPermission(String tel, int id, int permission);

	String remove(String tel, int id);

	String searchTeam(String content);

	String join(String sender, int id);

	String create(String tel, String name);
}
