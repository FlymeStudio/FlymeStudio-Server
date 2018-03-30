package database.template;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import database.dao.SummaryDao;

public class SummaryTemplate implements SummaryDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);

	}

}
