package com.zengyu.demo.dao;

import java.util.List;

import com.zengyu.demo.model.UserVO;

public interface UserDao {
	int addUser(String tel, String name, String email, String password);

	int deleteUser(String tel);

	UserVO queryUserByIdAndPassword(String id, String password);

	UserVO queryUserByTel(String tel);

	UserVO queryUserByEmail(String email);
	
	List<UserVO> queryUserWithoutPassword(String content);

	int updateUserInformation(String old, String tel, String name, String email, String password);

	int updateUserTeams(String tel, List<String> teams);
}
