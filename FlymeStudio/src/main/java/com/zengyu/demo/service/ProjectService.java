package com.zengyu.demo.service;

public interface ProjectService {
	String get(String tel);

	String create(String tel, int type, String date, String title, String content, String plans);

	String search(String tel, int type, String date, String title, String content);

	String modify(String tel, int id, int type, String date, String title, String content, String plans);

	String delete(String tel, int id);
}
