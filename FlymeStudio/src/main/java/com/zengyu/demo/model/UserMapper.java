package com.zengyu.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.alibaba.fastjson.JSONArray;
import com.zengyu.demo.others.Const;

/**
 * 用户映射
 * 
 * @author zengyu
 *
 */
public class UserMapper implements RowMapper<UserVO> {

	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO bean = new UserVO();
		bean.setId(rs.getInt(Const.User.COLUMN_ID));
		bean.setNum(rs.getString(Const.User.COLUMN_NUM));
		bean.setTel(rs.getString(Const.User.COLUMN_TEL));
		bean.setName(rs.getString(Const.User.COLUMN_NAME));
		bean.setEmail(rs.getString(Const.User.COLUMN_EMAIL));
		bean.setPassword(rs.getString(Const.User.COLUMN_PASSWORD));
		JSONArray array = JSONArray.parseArray(rs.getString(Const.User.COLUMN_TEAMS));
		if (array != null) {
			bean.setTeams(array.toJavaList(Integer.class));
		}
		return bean;
	}
}
