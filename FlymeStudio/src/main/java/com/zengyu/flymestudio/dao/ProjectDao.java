package com.zengyu.flymestudio.dao;

import com.alibaba.fastjson.JSONArray;

public interface ProjectDao {
	JSONArray get(String tel);

	boolean create(String tel, String type, String date, String title, String content, String plans);

	JSONArray search(String type, String date, String title, String content, String plans);

	boolean modify(String tel, String id, String type, String date, String title, String content, String plans);

	boolean delete(String tel, String id);
}
