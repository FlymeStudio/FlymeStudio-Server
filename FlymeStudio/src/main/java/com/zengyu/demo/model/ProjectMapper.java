package com.zengyu.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.alibaba.fastjson.JSONArray;
import com.zengyu.demo.others.Const;

/**
 * 任务映射
 * 
 * @author zengyu
 *
 */
public class ProjectMapper implements RowMapper<ProjectVO> {

	public ProjectVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProjectVO bean = new ProjectVO();
		bean.setId(rs.getInt(Const.Project.COLUMN_ID));
		bean.setUserId(rs.getInt(Const.Project.COLUMN_USER_ID));
		bean.setPercent(0);
		bean.setType(rs.getInt(Const.Project.COLUMN_TYPE));
		bean.setDate(rs.getLong(Const.Project.COLUMN_DATE));
		bean.setTitle(rs.getString(Const.Project.COLUMN_DATE));
		bean.setContent(rs.getString(Const.Project.COLUMN_CONTENT));
		JSONArray array = JSONArray.parseArray(rs.getString(Const.Project.COLUMN_PLANS));
		if (array != null) {
			bean.setPlans(array.toJavaList(PlanVO.class));
		}
		return bean;
	}
}
