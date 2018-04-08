package com.zengyu.demo.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.zengyu.demo.dao.ProjectDao;
import com.zengyu.demo.model.ProjectMapper;
import com.zengyu.demo.model.ProjectVO;
import com.zengyu.demo.others.Const;

@Service
public class ProjectService extends AbstractService implements ProjectDao {

	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JSONArray get(String tel) {
		JSONArray jsonArray = new JSONArray();
		try {
			// 获取所有任务
			String SQL = "select * from " + Const.Project.TABLE_NAME + " where " + Const.User.COLUMN_TEL + " = ?";

			List<ProjectVO> projectVOs = jdbcTemplate.query(SQL, new ProjectMapper(), tel);
			if (projectVOs != null && projectVOs.size() > 0) {
				jsonArray = JSONArray.parseArray(projectVOs.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonArray;
	}

	public boolean create(String tel, String type, String date, String title, String content, String plans) {
		boolean result = false;
		try {
			// 判断是否已创建该任务
			String SQL1 = "select * from " + Const.Project.TABLE_NAME + " where " + Const.Project.COLUMN_TEL + " = ? and "
					+ Const.Project.COLUMN_TYPE + " = ? and " + Const.Project.COLUMN_DATE + " = ? and "
					+ Const.Project.COLUMN_TITLE + " = ?";

			List<ProjectVO> projectVOs = jdbcTemplate.query(SQL1, new ProjectMapper(), tel, type, date, title);
			if (projectVOs == null || projectVOs.size() == 0) {
				// 插入新任务
				String SQL2 = "insert into " + Const.Project.TABLE_NAME + " values(?,?,?,?,?,?,?)";

				int count = jdbcTemplate.update(SQL2, tel, 0, type, date, title, content, plans);
				if (count > 0) {
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public JSONArray search(String type, String data, String title, String content, String plans) {
		return null;
	}

	public boolean modify(String tel, String id, String type, String date, String title, String content, String plans) {
		boolean result = false;
		try {
			// 更新任务
			String SQL = "update " + Const.Project.TABLE_NAME + " set " + Const.Project.COLUMN_TYPE + " = ?, "
					+ Const.Project.COLUMN_DATE + " = ?, " + Const.Project.COLUMN_TITLE + " = ?, "
					+ Const.Project.COLUMN_CONTENT + " = ?, " + Const.Project.COLUMN_PLANS + " = ? where "
					+ Const.Project.COLUMN_TEL + " = ? and " + Const.Project.COLUMN_ID + " = ?";

			int count = jdbcTemplate.update(SQL, type, date, title, content, plans, tel, id);
			if (count > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean delete(String tel, String id) {
		boolean result = false;
		try {
			// 删除任务
			String SQL = "delete from " + Const.Project.TABLE_NAME + " where " + Const.Project.COLUMN_ID + " = ? and "
					+ Const.Project.COLUMN_TEL + " = ?";

			int count = jdbcTemplate.update(SQL, id, tel);
			if (count > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
