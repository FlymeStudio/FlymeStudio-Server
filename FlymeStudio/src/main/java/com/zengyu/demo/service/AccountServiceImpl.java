package com.zengyu.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zengyu.demo.model.UserVO;
import com.zengyu.demo.others.ResponseObject;
import com.zengyu.demo.repository.UserDao;

@Service
public class AccountServiceImpl implements AccountService {
	@Resource(name = "userDao")
	private UserDao userDao;

	public String signIn(String id, String password) {
		ResponseObject responseObject = new ResponseObject();
		UserVO userVO = userDao.queryUserByIdAndPassword(id, password);
		if (userVO != null) {
			responseObject.setData(userVO);
		}
		return responseObject.toJSONString();
	}

	public String signUp(String name, String tel, String email, String password) {
		ResponseObject responseObject = new ResponseObject();
		int count = userDao.addUser(tel, name, email, password);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	// TEST
	public String signOut(String tel) {
		ResponseObject responseObject = new ResponseObject();
		UserVO userVO = userDao.queryUserByTel(tel);
		if (userVO != null) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String retrieve(String name, String tel, String email) {
		// TODO
		return null;
	}
}
