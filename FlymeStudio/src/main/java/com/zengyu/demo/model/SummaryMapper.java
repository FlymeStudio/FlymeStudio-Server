package com.zengyu.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SummaryMapper implements RowMapper<SummaryVO> {

	public SummaryVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		SummaryVO bean = new SummaryVO();
		bean.setId(rs.getInt("id"));
		bean.setTel(rs.getString("tel"));
		bean.setType(rs.getInt("type"));
		bean.setDate(Long.valueOf(rs.getString("date")));
		bean.setTitle(rs.getString("title"));
		bean.setContent(rs.getString("content"));
		return bean;
	}

}
