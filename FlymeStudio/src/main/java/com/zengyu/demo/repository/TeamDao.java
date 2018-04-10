package com.zengyu.demo.repository;

import java.util.List;

import com.zengyu.demo.model.TeamVO;

public interface TeamDao {
	int addTeam(String name, String tel);

	int deleteTeam(int id);

	TeamVO queryTeamById(int id);

	TeamVO queryTeamByName(String tel, String name);

	List<TeamVO> queryTeams(String tel);

	List<TeamVO> queryTeamsByIdOrName(String content);

	int addTeamMember(String tel, int id);

	int updateMemberPermission(String tel, int id, int permission);

	int deleteTeamMember(String tel, int id);
}
