package com.zengyu.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.alibaba.fastjson.JSONArray;

public class ProjectMapper implements RowMapper<ProjectVO> {

	public ProjectVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProjectVO bean = new ProjectVO();
		bean.setId(rs.getInt("id"));
		bean.setTel(rs.getString("tel"));
		bean.setPercent(0);
		bean.setType(rs.getInt("type"));
		bean.setDate(Long.valueOf(rs.getString("date")));
		bean.setTitle(rs.getString("title"));
		bean.setContent(rs.getString("content"));
		JSONArray array = JSONArray.parseArray(rs.getString("plans"));
		if (array != null) {
			bean.setPlans(array.toJavaList(PlanVO.class));
		}
		return bean;
	}
}
