package com.zengyu.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.alibaba.fastjson.JSONArray;

public class UserMapper implements RowMapper<UserVO> {

	public UserVO mapRow(ResultSet arg0, int arg1) throws SQLException {
		UserVO bean = new UserVO();
		bean.setTel(arg0.getString("tel"));
		bean.setName(arg0.getString("name"));
		bean.setEmail(arg0.getString("email"));
		bean.setPassword(arg0.getString("password"));
		JSONArray array = JSONArray.parseArray(arg0.getString("teams"));
		bean.setTeams(array.toJavaList(String.class));
		return bean;
	}
}
