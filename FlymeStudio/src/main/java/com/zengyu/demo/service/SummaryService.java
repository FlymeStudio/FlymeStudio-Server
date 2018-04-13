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
	 * @param userId
	 *            用户编号
	 * @return
	 */
	String get(int userId);

	/**
	 * 创建总结
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
	 * @return
	 */
	String create(int userId, int type, long date, String title, String content);

	/**
	 * 删除总结
	 * 
	 * @param summaryId
	 *            总结编号
	 * @param userId
	 *            用户编号
	 * @return
	 */
	String delete(int summaryId, int userId);

	/**
	 * 修改总结
	 * 
	 * @param summaryId
	 *            总结编号
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
	 * @return
	 */
	String modify(int summaryId, int userId, int type, long date, String title, String content);
}
