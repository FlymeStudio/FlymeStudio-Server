package com.zengyu.demo.repository;

import java.util.List;

import com.zengyu.demo.model.UserVO;

/**
 * 用户访问层接口
 * 
 * @author zengyu
 *
 */
public interface UserDao {
	/**
	 * 添加用户
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
	int addUser(String tel, String name, String email, String password);

	/**
	 * 删除用户
	 * 
	 * @param tel
	 *            电话
	 * @return
	 */
	int deleteUser(String tel);

	/**
	 * 通过帐号和密码查找用户
	 * 
	 * @param id
	 * @param password
	 *            密码
	 * @return
	 */
	UserVO queryUserByIdAndPassword(String id, String password);

	/**
	 * 通过电话查找用户
	 * 
	 * @param tel
	 *            电话
	 * @return
	 */
	UserVO queryUserByTel(String tel);

	/**
	 * 通过邮箱查找用户
	 * 
	 * @param email
	 *            邮箱
	 * @return
	 */
	UserVO queryUserByEmail(String email);

	/**
	 * 查找用户过滤密码
	 * 
	 * @param content
	 *            查找内容
	 * @return
	 */
	List<UserVO> queryUserWithoutPassword(String content);

	/**
	 * 更新用户信息
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
	int updateUserInformation(String old, String tel, String name, String email, String password);

	/**
	 * 更新用户所属团队
	 * 
	 * @param tel
	 *            电话
	 * @param teams
	 *            所属团队
	 * @return
	 */
	int updateUserTeams(String tel, List<String> teams);
}
