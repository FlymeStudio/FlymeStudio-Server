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
	 * @param id
	 *            团队编号
	 * @return
	 */
	String getTeamInfo(int id);

	/**
	 * 查看个人团队
	 * 
	 * @param tel
	 *            电话
	 * @return
	 */
	String viewTeams(String tel);

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
	 * @param sender
	 *            发送方
	 * @param receiver
	 *            接收方
	 * @param id
	 *            团队编号
	 * @return
	 */
	String invite(String sender, String receiver, int id);

	/**
	 * 解散团队
	 * 
	 * @param id
	 *            团队编号
	 * @return
	 */
	String disband(int id);

	/**
	 * 查看成员任务
	 * 
	 * @param tel
	 *            成员电话
	 * @return
	 */
	String viewMemberProjects(String tel);

	/**
	 * 查看成员总结
	 * 
	 * @param tel
	 *            电话
	 * @return
	 */
	String viewMemberSummaries(String tel);

	/**
	 * 设置权限
	 * 
	 * @param tel
	 *            成员电话
	 * @param id
	 *            团队编号
	 * @param permission
	 *            成员权限
	 * @return
	 */
	String setPermission(String tel, int id, int permission);

	/**
	 * 移除成员
	 * 
	 * @param tel
	 *            成员电话
	 * @param id
	 *            团队编号
	 * @return
	 */
	String remove(String tel, int id);

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
	 * @param id
	 *            团队编号
	 * @return
	 */
	String join(String sender, int id);

	/**
	 * 创建团队
	 * 
	 * @param tel
	 *            电话
	 * @param name
	 *            团队名
	 * @return
	 */
	String create(String tel, String name);
}
