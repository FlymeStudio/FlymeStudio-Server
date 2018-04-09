package com.zengyu.demo.dao;

import java.util.List;

import com.zengyu.demo.model.TeamVO;

public interface TeamDao {
	int addTeam(String name, String tel);

	int deleteTeam(String id);

	TeamVO queryTeamById(String id);

	TeamVO queryTeamByName(String tel, String name);

	List<TeamVO> queryTeams(String tel);

	int addTeamMember(String id, String tel);

	int updateMemberPermission(String id, String tel, int permission);

	int deleteTeamMember(String id, String tel);
}
