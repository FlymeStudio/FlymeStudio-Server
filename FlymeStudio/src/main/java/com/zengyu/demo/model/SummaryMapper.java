package com.zengyu.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zengyu.demo.others.Const;

/**
 * 总结映射
 * 
 * @author zengyu
 *
 */
public class SummaryMapper implements RowMapper<SummaryVO> {

	public SummaryVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		SummaryVO bean = new SummaryVO();
		bean.setId(rs.getInt(Const.Summary.COLUMN_ID));
		bean.setUserId(rs.getInt(Const.Project.COLUMN_USER_ID));
		bean.setType(rs.getInt(Const.Project.COLUMN_TYPE));
		bean.setDate(rs.getLong(Const.Project.COLUMN_DATE));
		bean.setTitle(rs.getString(Const.Project.COLUMN_DATE));
		bean.setContent(rs.getString(Const.Project.COLUMN_CONTENT));
		return bean;
	}
}
