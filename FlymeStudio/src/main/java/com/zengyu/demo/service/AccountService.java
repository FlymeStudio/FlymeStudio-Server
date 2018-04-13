package com.zengyu.demo.service;

/**
 * 帐号活动层接口
 * 
 * @author zengyu
 *
 */
public interface AccountService {
	/**
	 * 登录
	 * 
	 * @param user
	 *            工号或电话或邮箱
	 * @param password
	 *            密码
	 * @return
	 */
	String signIn(String user, String password);

	/**
	 * 注册
	 * 
	 * @param num
	 *            工号
	 * @param tel
	 *            电话
	 * @param name
	 *            姓名
	 * @param email
	 *            邮箱
	 * @param password
	 *            密码
	 * @return
	 */
	String signUp(String num, String tel, String name, String email, String password);

	/**
	 * 注销
	 * 
	 * @param id
	 *            编号
	 * @return
	 */
	String signOut(int id);

	/**
	 * 找回
	 * 
	 * @param num
	 *            工号
	 * @param tel
	 *            电话
	 * @param name
	 *            姓名
	 * @param email
	 *            邮箱
	 * @return
	 */
	String retrieve(String num, String tel, String name, String email);
}
