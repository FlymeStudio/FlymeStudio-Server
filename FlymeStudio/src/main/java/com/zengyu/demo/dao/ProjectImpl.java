package com.zengyu.demo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.fastjson.JSON;
import com.zengyu.demo.model.PlanVO;
import com.zengyu.demo.model.ProjectMapper;
import com.zengyu.demo.model.ProjectVO;
import com.zengyu.demo.others.Const;

public class ProjectImpl extends AbstractImpl implements ProjectDao {
	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int addProject(String tel, int type, String date, String title, String content, List<PlanVO> plans) {
		if (queryProjectByDetail(tel, type, date, title) != null) {
			return 0;
		} else {
			String plansStrign = JSON.toJSONString(plans);
			String SQL = "insert into " + Const.Project.TABLE_NAME + " values(?,?,?,?,?,?,?)";
			return jdbcTemplate.update(SQL, null, tel, type, date, title, content, plansStrign);
		}
	}

	public int deleteProject(String id, String tel) {
		String SQL = "delete from " + Const.Project.TABLE_NAME + " where " + Const.Project.COLUMN_ID + " = ? and "
				+ Const.Project.COLUMN_TEL + " = ?";
		return jdbcTemplate.update(SQL, id, tel);
	}

	public ProjectVO queryProjectById(String id) {
		String SQL = "select * from " + Const.Project.TABLE_NAME + " where " + Const.Project.COLUMN_ID + " = ?";
		return jdbcTemplate.queryForObject(SQL, new ProjectMapper(), id);
	}

	public ProjectVO queryProjectByDetail(String tel, int type, String date, String title) {
		String SQL = "select * from " + Const.Project.TABLE_NAME + " where " + Const.Project.COLUMN_TEL + " = ? and "
				+ Const.Project.COLUMN_TYPE + " = ? and " + Const.Project.COLUMN_DATE + " = ? and "
				+ Const.Project.COLUMN_TITLE + " = ?";
		return jdbcTemplate.queryForObject(SQL, new ProjectMapper(), tel, type, date, title);
	}

	public List<ProjectVO> queryProjects(String tel) {
		String SQL = "select * from " + Const.Project.TABLE_NAME + " where " + Const.User.COLUMN_TEL + " = ?";
		return jdbcTemplate.query(SQL, new ProjectMapper(), tel);
	}

	public int updateProject(String id, String tel, int type, String date, String title, String content,
			List<PlanVO> plans) {
		String plansStrign = JSON.toJSONString(plans);
		String SQL = "update " + Const.Project.TABLE_NAME + " set " + Const.Project.COLUMN_TYPE + " = ?, "
				+ Const.Project.COLUMN_DATE + " = ?, " + Const.Project.COLUMN_TITLE + " = ?, "
				+ Const.Project.COLUMN_CONTENT + " = ?, " + Const.Project.COLUMN_PLANS + " = ? where "
				+ Const.Project.COLUMN_TEL + " = ? and " + Const.Project.COLUMN_ID + " = ?";
		return jdbcTemplate.update(SQL, type, date, title, content, plansStrign, tel, id);
	}
}
