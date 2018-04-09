package com.zengyu.demo.service;

public interface ProjectService {
	String get(String tel);

	String create(String tel, String type, String date, String title, String content, String plans);

	String search(String type, String date, String title, String content, String plans);

	String modify(String tel, String id, String type, String date, String title, String content, String plans);

	String delete(String tel, String id);
}
