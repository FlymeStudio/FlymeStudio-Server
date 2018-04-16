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
	int addUser(String num, String tel, String name, String email, String password);

	/**
	 * 删除用户
	 * 
	 * @param id
	 *            编号
	 * @return
	 */
	int deleteUser(int id);

	/**
	 * 通过帐号和密码查找用户
	 * 
	 * @param user
	 *            工号或电话或邮箱
	 * @param password
	 *            密码
	 * @return
	 */
	UserVO queryUserByAccountAndPassword(String user, String password);

	/**
	 * 通过编号查找用户
	 * 
	 * @param num
	 *            编号
	 * @return
	 */
	UserVO queryUserById(int id);

	/**
	 * 通过工号查找用户
	 * 
	 * @param num
	 *            工号
	 * @return
	 */
	UserVO queryUserByNum(String num);

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
	 * 查找用户
	 * 
	 * @param content
	 *            查找内容
	 * @return
	 */
	List<UserVO> queryUser(String content);

	/**
	 * 更新用户信息
	 * 
	 * @param id
	 *            编号
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
	int updateUserInformation(int id, String tel, String name, String email, String password);

	/**
	 * 更新用户所属团队
	 * 
	 * @param id
	 *            编号
	 * @param teams
	 *            所属团队
	 * @return
	 */
	int updateUserTeams(int id, List<Integer> teams);
}
