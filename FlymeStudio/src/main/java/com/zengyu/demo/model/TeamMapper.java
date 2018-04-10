package com.zengyu.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.alibaba.fastjson.JSONArray;

public class TeamMapper implements RowMapper<TeamVO> {

	public TeamVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TeamVO bean = new TeamVO();
		bean.setId(rs.getInt("id"));
		bean.setName(rs.getString("name"));
		bean.setTel(rs.getString("tel"));
		JSONArray array = JSONArray.parseArray(rs.getString("members"));
		bean.setMembers(array.toJavaList(MemberVO.class));
		return bean;
	}
}
