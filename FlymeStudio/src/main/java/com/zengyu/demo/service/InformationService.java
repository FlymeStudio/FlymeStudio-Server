package com.zengyu.demo.service;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.zengyu.demo.dao.InformationDao;

@Service
public class InformationService extends AbstractService implements InformationDao {

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean modify(String name, String tel, String email, String password) {
		return false;
		// TODO Auto-generated method stub
	}
}
