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
	 * @param tel
	 *            电话
	 * @return
	 */
	int addTeam(String name, String tel);

	/**
	 * 删除团队
	 * 
	 * @param id
	 *            编号
	 * @return
	 */
	int deleteTeam(int id);

	/**
	 * 通过编号查询团队
	 * 
	 * @param id
	 *            编号
	 * @return
	 */
	TeamVO queryTeamById(int id);

	/**
	 * 通过名称查询团队
	 * 
	 * @param tel
	 *            电话
	 * @param name
	 *            团队名
	 * @return
	 */
	TeamVO queryTeamByName(String tel, String name);

	/**
	 * 查询个人团队
	 * 
	 * @param tel
	 *            电话
	 * @return
	 */
	List<TeamVO> queryTeams(String tel);

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
	 * @param tel
	 *            电话
	 * @param id
	 *            编号
	 * @return
	 */
	int addTeamMember(String tel, int id);

	/**
	 * 更新团队成员权限
	 * 
	 * @param tel
	 *            电话
	 * @param id
	 *            编号
	 * @param permission
	 *            权限
	 * @return
	 */
	int updateMemberPermission(String tel, int id, int permission);

	/**
	 * 删除团队成员
	 * 
	 * @param tel
	 *            电话
	 * @param id
	 *            编号
	 * @return
	 */
	int deleteTeamMember(String tel, int id);
}
