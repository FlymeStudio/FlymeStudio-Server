package com.zengyu.demo.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
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

	public int addProject(int userId, int type, long date, String title, String content, List<PlanVO> plans) {
		if (queryProjectByDetail(userId, type, date, title) == null) {
			try {
				String plansStrign = JSON.toJSONString(plans);
				String SQL = "insert into " + Const.Project.TABLE_NAME + " values(?,?,?,?,?,?,?)";
				return jdbcTemplate.update(SQL, null, userId, type, date, title, content, plansStrign);
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int deleteProject(int projectId, int userId) {
		String SQL = "delete from " + Const.Project.TABLE_NAME + " where " + Const.Project.COLUMN_ID + " = ? and "
				+ Const.Project.COLUMN_USER_ID + " = ?";
		try {
			return jdbcTemplate.update(SQL, projectId, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ProjectVO queryProjectById(int projectId) {
		String SQL = "select * from " + Const.Project.TABLE_NAME + " where " + Const.Project.COLUMN_ID + " = ?";
		try {
			return jdbcTemplate.queryForObject(SQL, new ProjectMapper(), projectId);
		} catch (EmptyResultDataAccessException e) {
			// TODO
		} catch (IncorrectResultSizeDataAccessException e) {
			// TODO
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ProjectVO> queryProjectByDetail(int userId, int type, long date, String title) {
		String SQL = "select * from " + Const.Project.TABLE_NAME + " where " + Const.Project.COLUMN_USER_ID
				+ " = ? and " + Const.Project.COLUMN_TYPE + " = ? and " + Const.Project.COLUMN_DATE + " = ? and "
				+ Const.Project.COLUMN_TITLE + " = ?";
		try {
			return jdbcTemplate.query(SQL, new ProjectMapper(), userId, type, date, title);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ProjectVO> queryProjects(int userId) {
		String SQL = "select * from " + Const.Project.TABLE_NAME + " where " + Const.Project.COLUMN_USER_ID + " = ?";
		try {
			return jdbcTemplate.query(SQL, new ProjectMapper(), userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateProject(int projectId, int userId, int type, long date, String title, String content,
			List<PlanVO> plans) {
		try {
			String plansStrign = JSON.toJSONString(plans);
			String SQL = "update " + Const.Project.TABLE_NAME + " set " + Const.Project.COLUMN_TYPE + " = ?, "
					+ Const.Project.COLUMN_DATE + " = ?, " + Const.Project.COLUMN_TITLE + " = ?, "
					+ Const.Project.COLUMN_CONTENT + " = ?, " + Const.Project.COLUMN_PLANS + " = ? where "
					+ Const.Project.COLUMN_ID + " = ? and " + Const.Project.COLUMN_USER_ID + " = ?";
			return jdbcTemplate.update(SQL, type, date, title, content, plansStrign, projectId, userId);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
