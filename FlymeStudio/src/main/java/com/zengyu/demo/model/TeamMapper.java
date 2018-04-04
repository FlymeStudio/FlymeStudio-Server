package com.zengyu.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.alibaba.fastjson.JSONArray;

public class TeamMapper implements RowMapper<TeamVO> {

	public TeamVO mapRow(ResultSet arg0, int arg1) throws SQLException {
		TeamVO bean = new TeamVO();
		bean.setId(arg0.getInt("id"));
		bean.setName(arg0.getString("name"));
		bean.setTel(arg0.getInt("tel"));
		JSONArray array = JSONArray.parseArray(arg0.getString("members"));
		bean.setMembers(array.toJavaList(MemberVO.class));
		return bean;
	}
}
