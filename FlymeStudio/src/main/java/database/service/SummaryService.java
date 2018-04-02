package database.service;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import database.dao.SummaryDao;

public class SummaryService extends AbstractService implements SummaryDao {
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);

	}

}
