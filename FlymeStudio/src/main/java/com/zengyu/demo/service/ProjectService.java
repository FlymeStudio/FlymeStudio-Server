package com.zengyu.demo.service;

/**
 * 任务活动层接口
 * 
 * @author zengyu
 *
 */
public interface ProjectService {
	/**
	 * 获取个人任务
	 * 
	 * @param userId
	 *            用户编号
	 * @return
	 */
	String get(int userId);

	/**
	 * 创建任务
	 * 
	 * @param userId
	 *            用户编号
	 * @param type
	 *            类型
	 * @param date
	 *            日期
	 * @param title
	 *            标题
	 * @param content
	 *            内容
	 * @param plans
	 *            计划
	 * @return
	 */
	String create(int userId, int type, long date, String title, String content, String plans);

	/**
	 * 删除任务
	 * 
	 * @param projectId
	 *            任务编号
	 * @param userId
	 *            用户编号
	 * @return
	 */
	String delete(int projectId, int userId);

	/**
	 * 修改任务
	 * 
	 * @param projectId
	 *            任务编号
	 * @param userId
	 *            用户编号
	 * @param type
	 *            类型
	 * @param date
	 *            日期
	 * @param title
	 *            标题
	 * @param content
	 *            内容
	 * @param plans
	 *            计划
	 * @return
	 */
	String modify(int projectId, int userId, int type, long date, String title, String content, String plans);
}
