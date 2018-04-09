package com.zengyu.demo.dao;

import java.util.List;

import com.zengyu.demo.model.UserVO;

public interface UserDao {
	int addUser(String tel, String name, String email, String password);

	int deleteUser(String tel);

	UserVO queryUserByTel(String tel);

	int updateUserInformation(String oldTel, String tel, String name, String email, String password);

	int updateUserTeams(String tel, List<String> teams);
}
