package com.zengyu.demo.service;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractService {
	protected DataSource dataSource;
	protected JdbcTemplate jdbcTemplate;
	
	abstract void setDataSource(DataSource dataSource);
}
