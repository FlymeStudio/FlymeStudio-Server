package database.template;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import database.dao.InformationDao;

public class InformationTemplate implements InformationDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);

	}

	public void modify(String name, String tel, String email, String password) {
		// TODO Auto-generated method stub

	}

}
