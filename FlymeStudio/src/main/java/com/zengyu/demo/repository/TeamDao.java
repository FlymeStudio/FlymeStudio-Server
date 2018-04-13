package com.zengyu.demo.repository;

import java.util.List;

import com.zengyu.demo.model.TeamVO;

/**
 * 团队访问层接口
 * 
 * @author zengyu
 *
 */
public interface TeamDao {
	/**
	 * 添加团队
	 * 
	 * @param name
	 *            团队名
	 * @param userId
	 *            用户编号
	 * @return
	 */
	int addTeam(String name, int userId);

	/**
	 * 删除团队
	 * 
	 * @param teamId
	 *            编号
	 * @return
	 */
	int deleteTeam(int teamId);

	/**
	 * 通过编号查询团队
	 * 
	 * @param teamId
	 *            编号
	 * @return
	 */
	TeamVO queryTeamById(int teamId);

	/**
	 * 通过名称查询团队
	 * 
	 * @param userId
	 *            用户编号
	 * @param name
	 *            团队名
	 * @return
	 */
	TeamVO queryTeamByName(int userId, String name);

	/**
	 * 查询个人团队
	 * 
	 * @param userId
	 *            用户编号
	 * @return
	 */
	List<TeamVO> queryTeams(int userId);

	/**
	 * 通过编号或名称查找团队
	 * 
	 * @param content
	 *            查找内容
	 * @return
	 */
	List<TeamVO> queryTeamsByIdOrName(String content);

	/**
	 * 添加团队成员
	 * 
	 * @param teamId
	 *            团队编号
	 * @param userId
	 *            成员编号
	 * @return
	 */
	int addTeamMember(int teamId, int userId);

	/**
	 * 更新团队成员权限
	 * 
	 * @param teamId
	 *            编号
	 * @param userId
	 *            成员编号
	 * @param permission
	 *            权限
	 * @return
	 */
	int updateMemberPermission(int teamId, int userId, int permission);

	/**
	 * 删除团队成员
	 * 
	 * 
	 * @param teamId
	 *            编号
	 * @param userId
	 *            成员编号
	 * @return
	 */
	int deleteTeamMember(int teamId, int userId);
}
