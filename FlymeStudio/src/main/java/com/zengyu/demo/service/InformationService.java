package com.zengyu.demo.service;

/**
 * 信息活动层接口
 * 
 * @author zengyu
 *
 */
public interface InformationService {
	/**
	 * 修改信息
	 * 
	 * @param old
	 *            旧电话
	 * @param tel
	 *            新电话
	 * @param name
	 *            新姓名
	 * @param email
	 *            新邮箱
	 * @param password
	 *            新密码
	 * @return
	 */
	String modify(String old, String tel, String name, String email, String password);

	/**
	 * 回复消息
	 * 
	 * @param id
	 *            编号
	 * @param result
	 *            回复结果
	 * @return
	 */
	String reply(int id, boolean result);
}
