package database.service;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.fastjson.JSONArray;

import database.dao.ProjectDao;

public class ProjectService extends AbstractService implements ProjectDao {
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);

	}

	public JSONArray get(String tel) {
		return null;
		// TODO Auto-generated method stub

	}

	public boolean create(String tel, String type, String date, String title, String content, String plans) {
		return false;
		// TODO Auto-generated method stub

	}

	public JSONArray search(String type, String data, String title, String content, String plans) {
		return null;
		// TODO Auto-generated method stub

	}

	public boolean modify(String tel, String id, String type, String date, String title, String content, String plans) {
		return false;
		// TODO Auto-generated method stub

	}

	public boolean delete(String tel, String id) {
		return false;
		// TODO Auto-generated method stub

	}

}
