package com.zengyu.demo.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.zengyu.demo.model.PlanVO;
import com.zengyu.demo.model.ProjectMapper;
import com.zengyu.demo.model.ProjectVO;
import com.zengyu.demo.others.Const;

/**
 * 任务访问层
 * 
 * @author zengyu
 *
 */
@Repository(value = "projectDao")
public class ProjectImpl extends AbstractImpl implements ProjectDao {

	public int addProject(String tel, int type, String date, String title, String content, List<PlanVO> plans) {
		if (queryProjectByDetail(tel, type, date, title) != null) {
			return 0;
		} else {
			String plansStrign = JSON.toJSONString(plans);
			String SQL = "insert into " + Const.Project.TABLE_NAME + " values(?,?,?,?,?,?,?)";
			return jdbcTemplate.update(SQL, null, tel, type, date, title, content, plansStrign);
		}
	}

	public int deleteProject(String tel, int id) {
		String SQL = "delete from " + Const.Project.TABLE_NAME + " where " + Const.Project.COLUMN_TEL + " = ? and "
				+ Const.Project.COLUMN_ID + " = ?";
		return jdbcTemplate.update(SQL, tel, id);
	}

	public ProjectVO queryProjectById(int id) {
		String SQL = "select * from " + Const.Project.TABLE_NAME + " where " + Const.Project.COLUMN_ID + " = ?";
		ProjectVO projectVO = null;
		try {
			projectVO = jdbcTemplate.queryForObject(SQL, new ProjectMapper(), id);
		} catch (EmptyResultDataAccessException e) {
			// TODO
		} catch (IncorrectResultSizeDataAccessException e) {
			// TODO
		}
		return projectVO;
	}

	public List<ProjectVO> queryProjectByDetail(String tel, int type, String date, String title) {
		String SQL = "select * from " + Const.Project.TABLE_NAME + " where " + Const.Project.COLUMN_TEL + " = ? and "
				+ Const.Project.COLUMN_TYPE + " = ? and " + Const.Project.COLUMN_DATE + " = ? and "
				+ Const.Project.COLUMN_TITLE + " = ?";
		return jdbcTemplate.query(SQL, new ProjectMapper(), tel, type, date, title);
	}

	public List<ProjectVO> queryProjects(String tel) {
		String SQL = "select * from " + Const.Project.TABLE_NAME + " where " + Const.Project.COLUMN_TEL + " = ?";
		return jdbcTemplate.query(SQL, new ProjectMapper(), tel);
	}

	public int updateProject(String tel, int id, int type, String date, String title, String content,
			List<PlanVO> plans) {
		String plansStrign = JSON.toJSONString(plans);
		String SQL = "update " + Const.Project.TABLE_NAME + " set " + Const.Project.COLUMN_TYPE + " = ?, "
				+ Const.Project.COLUMN_DATE + " = ?, " + Const.Project.COLUMN_TITLE + " = ?, "
				+ Const.Project.COLUMN_CONTENT + " = ?, " + Const.Project.COLUMN_PLANS + " = ? where "
				+ Const.Project.COLUMN_TEL + " = ? and " + Const.Project.COLUMN_ID + " = ?";
		return jdbcTemplate.update(SQL, type, date, title, content, plansStrign, tel, id);
	}
}
