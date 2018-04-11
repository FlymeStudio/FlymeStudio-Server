package com.zengyu.demo.service;

/**
 * 总结活动层接口
 * 
 * @author zengyu
 *
 */
public interface SummaryService {
	/**
	 * 获取个人总结
	 * 
	 * @param tel
	 *            电话
	 * @return
	 */
	String get(String tel);

	/**
	 * 创建总结
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
	 * @return
	 */
	String create(String tel, int type, String date, String title, String content);

	/**
	 * 删除总结
	 * 
	 * @param tel
	 *            电话
	 * @param id
	 *            编号
	 * @return
	 */
	String delete(String tel, int id);
	
	/**
	 * 查找总结
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
	 * @return
	 */
	String search(String tel, int type, String date, String title, String content);

	/**
	 * 修改总结
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
	 * @return
	 */
	String modify(String tel, int id, int type, String date, String title, String content);
}
