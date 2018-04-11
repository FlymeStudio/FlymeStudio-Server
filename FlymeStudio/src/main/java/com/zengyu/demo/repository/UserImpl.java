package com.zengyu.demo.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.zengyu.demo.model.UserMapper;
import com.zengyu.demo.model.UserVO;
import com.zengyu.demo.others.Const;

/**
 * 用户访问层
 * 
 * @author zengyu
 *
 */
@Repository(value = "userDao")
public class UserImpl extends AbstractImpl implements UserDao {

	public int addUser(String tel, String name, String email, String password) {
		if (queryUserByTel(tel) != null) {
			return 0;
		} else if (queryUserByEmail(email) != null) {
			return 0;
		} else {
			String SQL = "insert into " + Const.User.TABLE_NAME + " values(?,?,?,?,?)";
			return jdbcTemplate.update(SQL, tel, name, email, password, null);
		}
	}

	public int deleteUser(String tel) {
		String SQL = "delete from " + Const.User.TABLE_NAME + " where " + Const.User.COLUMN_TEL + " = ?";
		return jdbcTemplate.update(SQL, tel);
	}

	public UserVO queryUserByIdAndPassword(String id, String password) {
		String SQL = "select * from " + Const.User.TABLE_NAME + " where (" + Const.User.COLUMN_TEL + " = ? or "
				+ Const.User.COLUMN_EMAIL + " = ?) and " + Const.User.COLUMN_PASSWORD + " = ?";
		UserVO userVO = null;
		try {
			userVO = jdbcTemplate.queryForObject(SQL, new UserMapper(), id, id, password);
		} catch (EmptyResultDataAccessException e) {
			// TODO
		} catch (IncorrectResultSizeDataAccessException e) {
			// TODO
		}
		return userVO;
	}

	public UserVO queryUserByTel(String tel) {
		String SQL = "select * from " + Const.User.TABLE_NAME + " where " + Const.User.COLUMN_TEL + " = ?";
		UserVO userVO = null;
		try {
			userVO = jdbcTemplate.queryForObject(SQL, new UserMapper(), tel);
			if (userVO != null) {
				userVO.setPassword("");
			}
		} catch (EmptyResultDataAccessException e) {
			// TODO
		} catch (IncorrectResultSizeDataAccessException e) {
			// TODO
		}
		return userVO;
	}

	public UserVO queryUserByEmail(String email) {
		String SQL = "select * from " + Const.User.TABLE_NAME + " where " + Const.User.COLUMN_EMAIL + " = ?";
		UserVO userVO = null;
		try {
			userVO = jdbcTemplate.queryForObject(SQL, new UserMapper(), email);
			if (userVO != null) {
				userVO.setPassword("");
			}
		} catch (EmptyResultDataAccessException e) {
			// TODO
		} catch (IncorrectResultSizeDataAccessException e) {
			// TODO
		}
		return userVO;
	}

	public List<UserVO> queryUserWithoutPassword(String content) {
		String SQL = "select * from " + Const.User.TABLE_NAME + " where " + Const.User.COLUMN_TEL + " = ? or "
				+ Const.User.COLUMN_NAME + " like %?%";
		List<UserVO> userVOs = jdbcTemplate.query(SQL, new UserMapper(), content);
		if (userVOs != null) {
			for (int i = 0; i < userVOs.size(); i++) {
				userVOs.get(i).setPassword("");
			}
		}
		return userVOs;
	}

	public int updateUserInformation(String old, String tel, String name, String email, String password) {
		if (queryUserByTel(tel) != null) {
			return 0;
		} else if (queryUserByEmail(email) != null) {
			return 0;
		} else {
			String SQL = "update " + Const.User.TABLE_NAME + " set " + Const.User.COLUMN_TEL + " = ?, "
					+ Const.User.COLUMN_NAME + " = ?, " + Const.User.COLUMN_EMAIL + " = ?, "
					+ Const.User.COLUMN_PASSWORD + " = ? where " + Const.User.COLUMN_TEL + " = ?";
			return jdbcTemplate.update(SQL, name, tel, email, password, old);
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
