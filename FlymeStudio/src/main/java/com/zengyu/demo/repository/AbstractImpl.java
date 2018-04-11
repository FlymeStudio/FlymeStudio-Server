package com.zengyu.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 访问层公共属性
 * 
 * @author zengyu
 *
 */
public abstract class AbstractImpl {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
}
