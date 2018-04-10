package com.zengyu.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.alibaba.fastjson.JSONArray;

public class UserMapper implements RowMapper<UserVO> {

	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO bean = new UserVO();
		bean.setTel(rs.getString("tel"));
		bean.setName(rs.getString("name"));
		bean.setEmail(rs.getString("email"));
		bean.setPassword(rs.getString("password"));
		JSONArray array = JSONArray.parseArray(rs.getString("teams"));
		bean.setTeams(array.toJavaList(String.class));
		return bean;
	}
}
