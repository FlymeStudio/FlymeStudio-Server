package com.zengyu.demo.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractImpl {
	protected DataSource dataSource;
	protected JdbcTemplate jdbcTemplate;
	
	abstract void setDataSource(DataSource dataSource);
}
