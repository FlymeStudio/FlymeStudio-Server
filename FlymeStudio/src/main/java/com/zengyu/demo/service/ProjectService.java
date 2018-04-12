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
	 * @param tel
	 *            电话
	 * @return
	 */
	String get(String tel);

	/**
	 * 创建任务
	 * 
	 * @param tel
	 *            电话
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
	String create(String tel, int type, String date, String title, String content, String plans);

	/**
	 * 删除任务
	 * 
	 * @param tel
	 *            电话
	 * @param id
	 *            编号
	 * @return
	 */
	String delete(String tel, int id);

	/**
	 * 修改任务
	 * 
	 * @param tel
	 *            电话
	 * @param id
	 *            编号
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
	String modify(String tel, int id, int type, String date, String title, String content, String plans);
}
