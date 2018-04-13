package com.zengyu.demo.service;

/**
 * 团队活动层接口
 * 
 * @author zengyu
 *
 */
public interface TeamworkService {
	/**
	 * 获取团队信息
	 * 
	 * @param teamId
	 *            团队编号
	 * @return
	 */
	String getTeamInfo(int teamId);

	/**
	 * 查看个人团队
	 * 
	 * @param userId
	 *            用户编号
	 * @return
	 */
	String viewTeams(int userId);

	/**
	 * 查找用户
	 * 
	 * @param content
	 *            查找内容
	 * @return
	 */
	String searchUser(String content);

	/**
	 * 邀请加入团队
	 * 
	 * @param senderId
	 *            发送方
	 * @param receiverId
	 *            接收方
	 * @param teamId
	 *            团队编号
	 * @return
	 */
	String invite(int senderId, int receiverId, int teamId);

	/**
	 * 解散团队
	 * 
	 * @param teamId
	 *            团队编号
	 * @return
	 */
	String disband(int teamId);

	/**
	 * 查看成员任务
	 * 
	 * @param userId
	 *            成员编号
	 * @return
	 */
	String viewMemberProjects(int userId);

	/**
	 * 查看成员总结
	 * 
	 * @param userId
	 *            成员编号
	 * @return
	 */
	String viewMemberSummaries(int userId);

	/**
	 * 设置权限
	 * 
	 * @param teamId
	 *            团队编号
	 * @param userId
	 *            成员编号
	 * @param permission
	 *            成员权限
	 * @return
	 */
	String setPermission(int teamId, int userId, int permission);

	/**
	 * 移除成员
	 * 
	 * @param teamId
	 *            团队编号
	 * @param userId
	 *            成员编号
	 * @return
	 */
	String remove(int teamId, int userId);

	/**
	 * 查找团队
	 * 
	 * @param content
	 *            查找内容
	 * @return
	 */
	String searchTeam(String content);

	/**
	 * 申请加入团队
	 * 
	 * @param sender
	 *            发送方
	 * @param teamId
	 *            团队编号
	 * @return
	 */
	String join(int senderId, int teamId);

	/**
	 * 创建团队
	 * 
	 * @param userId
	 *            用户编号
	 * @param name
	 *            团队名
	 * @return
	 */
	String create(int userId, String name);
}
