package database.template;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import database.dao.ProjectDao;

public class ProjectTemplate implements ProjectDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);

	}

	public void get(String tel) {
		// TODO Auto-generated method stub

	}

	public void create(String tel, String type, String date, String title, String content, String plans) {
		// TODO Auto-generated method stub

	}

	public void search(String type, String data, String title, String content, String plans) {
		// TODO Auto-generated method stub

	}

	public void modify(String tel, String id, String type, String date, String title, String content, String plans) {
		// TODO Auto-generated method stub

	}

	public void delete(String tel, String id) {
		// TODO Auto-generated method stub

	}

}
