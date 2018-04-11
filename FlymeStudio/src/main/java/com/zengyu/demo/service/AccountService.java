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
	 * @param id
	 *            电话或者邮箱
	 * @param password
	 *            密码
	 * @return
	 */
	String signIn(String id, String password);

	/**
	 * 注册
	 * 
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
	String signUp(String tel, String name, String email, String password);

	/**
	 * 注销
	 * 
	 * @param tel
	 *            电话
	 * @return
	 */
	String signOut(String tel);

	/**
	 * 找回
	 * 
	 * @param tel
	 *            电话
	 * @param name
	 *            姓名
	 * @param email
	 *            邮箱
	 * @return
	 */
	String retrieve(String tel, String name, String email);
}
