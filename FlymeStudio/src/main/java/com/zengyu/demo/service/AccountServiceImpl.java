package com.zengyu.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	public String signIn(String id, String password) {
		// TODO Auto-generated method stub
		return "test";
	}

	public String signUp(String name, String tel, String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public String signOut(String tel) {
		// TODO Auto-generated method stub
		return null;
	}

	public String retrieve(String name, String tel, String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
