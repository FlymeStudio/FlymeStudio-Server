package com.zengyu.demo.service;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.zengyu.demo.dao.SummaryDao;

@Service
public class SummaryService extends AbstractService implements SummaryDao {
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);

	}

}
