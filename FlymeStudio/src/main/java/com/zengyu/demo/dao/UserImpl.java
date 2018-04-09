package com.zengyu.demo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.fastjson.JSON;
import com.zengyu.demo.model.UserMapper;
import com.zengyu.demo.model.UserVO;
import com.zengyu.demo.others.Const;

public class UserImpl extends AbstractImpl implements UserDao {
	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int addUser(String tel, String name, String email, String password) {
		if (queryUserByTel(tel) != null) {
			return 0;
		} else if (queryUserByEmail(email) != null) {
			return 0;
		} else {
			String SQL = "insert into " + Const.User.TABLE_NAME + " values(?,?,?,?)";
			return jdbcTemplate.update(SQL, name, tel, email, password);
		}
	}

	public int deleteUser(String tel) {
		String SQL = "delete from " + Const.User.TABLE_NAME + " where " + Const.User.COLUMN_TEL + " = ?";
		return jdbcTemplate.update(SQL, tel);
	}

	public UserVO queryUserByTel(String tel) {
		String SQL = "select * from " + Const.User.TABLE_NAME + " where " + Const.User.COLUMN_TEL + " = ?";
		return jdbcTemplate.queryForObject(SQL, new UserMapper(), tel);
	}

	public UserVO queryUserByEmail(String email) {
		String SQL = "select * from " + Const.User.TABLE_NAME + " where " + Const.User.COLUMN_EMAIL + " = ?";
		return jdbcTemplate.queryForObject(SQL, new UserMapper(), email);
	}

	public int updateUserInformation(String oldTel, String tel, String name, String email, String password) {
		if (queryUserByTel(tel) != null) {
			return 0;
		} else if (queryUserByEmail(email) != null) {
			return 0;
		} else {
			String SQL = "update " + Const.User.TABLE_NAME + " set " + Const.User.COLUMN_TEL + " = ?, "
					+ Const.User.COLUMN_NAME + " = ?, " + Const.User.COLUMN_EMAIL + " = ?, "
					+ Const.User.COLUMN_PASSWORD + " = ? where " + Const.User.COLUMN_TEL + " = ?";
			return jdbcTemplate.update(SQL, name, tel, email, password, oldTel);
		}
	}

	public int updateUserTeams(String tel, List<String> teams) {
		if (queryUserByTel(tel) != null) {
			return 0;
		} else {
			String teamsString = JSON.toJSONString(teams);
			String SQL = "update " + Const.User.TABLE_NAME + " set " + Const.User.COLUMN_TEAMS + " = ? where "
					+ Const.User.COLUMN_TEL + " = ?";
			return jdbcTemplate.update(SQL, teamsString, tel);
		}
	}
}
