package database.template;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import database.dao.AccountDao;

public class AccountTemplate implements AccountDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);

	}

	public void signIn(String id, String password) {
		// TODO Auto-generated method stub

	}

	public void signUp(String name, String tel, String email, String password) {
		// TODO Auto-generated method stub

	}

	public void signOut(String tel) {
		// TODO Auto-generated method stub

	}

	public void retrieve(String name, String tel, String email) {
		// TODO Auto-generated method stub

	}

}
