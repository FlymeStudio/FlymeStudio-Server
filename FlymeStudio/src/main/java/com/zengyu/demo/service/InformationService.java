package com.zengyu.demo.service;

public interface InformationService {
	String modify(String old, String name, String tel, String email, String password);

	String replyMsg(int id, boolean result);
}
