package com.zengyu.demo.service;

import org.springframework.stereotype.Service;

import com.zengyu.demo.dao.UserDao;
import com.zengyu.demo.dao.UserImpl;
import com.zengyu.demo.model.UserVO;
import com.zengyu.demo.others.ResponseObject;

@Service
public class AccountServiceImpl implements AccountService {

	public String signIn(String id, String password) {
		ResponseObject responseObject = new ResponseObject();
		UserDao userDao = new UserImpl();
		UserVO userVO = userDao.queryUserByIdAndPassword(id, password);
		if (userVO != null) {
			responseObject.setData(userVO);
		}
		return responseObject.toJSONString();
	}

	public String signUp(String name, String tel, String email, String password) {
		ResponseObject responseObject = new ResponseObject();
		UserDao userDao = new UserImpl();
		int count = userDao.addUser(tel, name, email, password);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	// TEST
	public String signOut(String tel) {
		ResponseObject responseObject = new ResponseObject();
		UserDao userDao = new UserImpl();
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
