package com.zengyu.flymestudio.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<UserVO> {

	public UserVO mapRow(ResultSet arg0, int arg1) throws SQLException {
		UserVO bean = new UserVO();
		bean.setTel(arg0.getInt("tel"));
		bean.setName(arg0.getString("name"));
		bean.setEmail(arg0.getString("email"));
		bean.setPassword(arg0.getString("password"));
		return bean;
	}
}
