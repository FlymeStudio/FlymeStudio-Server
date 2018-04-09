package com.zengyu.demo.service;

public interface AccountService {
	String signIn(String id, String password);

	String signUp(String name, String tel, String email, String password);

	String signOut(String tel);

	String retrieve(String name, String tel, String email);
}
