package com.zengyu.demo.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
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

	public int addUser(String num, String tel, String name, String email, String password) {
		String SQL = "insert into " + Const.User.TABLE_NAME + " values(?,?,?,?,?,?,?)";
		try {
			return jdbcTemplate.update(SQL, null, num, tel, name, email, password, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteUser(int id) {
		String SQL = "delete from " + Const.User.TABLE_NAME + " where " + Const.User.COLUMN_ID + " = ?";
		try {
			return jdbcTemplate.update(SQL, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public UserVO queryUserByAccountAndPassword(String user, String password) {
		String SQL = "select * from " + Const.User.TABLE_NAME + " where (" + Const.User.COLUMN_NUM + " = ? or "
				+ Const.User.COLUMN_TEL + " = ? or " + Const.User.COLUMN_EMAIL + " = ?) and "
				+ Const.User.COLUMN_PASSWORD + " = ?";
		try {
			return jdbcTemplate.queryForObject(SQL, new UserMapper(), user, user, user, password);
		} catch (EmptyResultDataAccessException e) {
			// TODO
		} catch (IncorrectResultSizeDataAccessException e) {
			// TODO
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public UserVO queryUserById(int id) {
		String SQL = "select * from " + Const.User.TABLE_NAME + " where " + Const.User.COLUMN_ID + " = ?";
		try {
			return jdbcTemplate.queryForObject(SQL, new UserMapper(), id);
		} catch (EmptyResultDataAccessException e) {
			// TODO
		} catch (IncorrectResultSizeDataAccessException e) {
			// TODO
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public UserVO queryUserByNum(String num) {
		String SQL = "select * from " + Const.User.TABLE_NAME + " where " + Const.User.COLUMN_NUM + " = ?";
		try {
			return jdbcTemplate.queryForObject(SQL, new UserMapper(), num);
		} catch (EmptyResultDataAccessException e) {
			// TODO
		} catch (IncorrectResultSizeDataAccessException e) {
			// TODO
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public UserVO queryUserByTel(String tel) {
		String SQL = "select * from " + Const.User.TABLE_NAME + " where " + Const.User.COLUMN_TEL + " = ?";
		try {
			return jdbcTemplate.queryForObject(SQL, new UserMapper(), tel);
		} catch (EmptyResultDataAccessException e) {
			// TODO
		} catch (IncorrectResultSizeDataAccessException e) {
			// TODO
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public UserVO queryUserByEmail(String email) {
		String SQL = "select * from " + Const.User.TABLE_NAME + " where " + Const.User.COLUMN_EMAIL + " = ?";
		try {
			return jdbcTemplate.queryForObject(SQL, new UserMapper(), email);
		} catch (EmptyResultDataAccessException e) {
			// TODO
		} catch (IncorrectResultSizeDataAccessException e) {
			// TODO
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<UserVO> queryUser(String content) {
		String SQL = "select * from " + Const.User.TABLE_NAME + " where " + Const.User.COLUMN_NUM + " = ? or "
				+ Const.User.COLUMN_TEL + " = ? or " + Const.User.COLUMN_NAME + " = ? or " + Const.User.COLUMN_EMAIL
				+ " = ?";
		try {
			return jdbcTemplate.query(SQL, new UserMapper(), content, content, content, content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateUserInformation(int id, String tel, String name, String email, String password) {
		String SQL = "update " + Const.User.TABLE_NAME + " set " + Const.User.COLUMN_TEL + " = ?, "
				+ Const.User.COLUMN_NAME + " = ?, " + Const.User.COLUMN_EMAIL + " = ?, " + Const.User.COLUMN_PASSWORD
				+ " = ? where " + Const.User.COLUMN_ID + " = ?";
		try {
			return jdbcTemplate.update(SQL, tel, name, email, password, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateUserTeams(int id, List<Integer> teams) {
		try {
			String teamsString = JSON.toJSONString(teams);
			String SQL = "update " + Const.User.TABLE_NAME + " set " + Const.User.COLUMN_TEAMS + " = ? where "
					+ Const.User.COLUMN_ID + " = ?";
			return jdbcTemplate.update(SQL, teamsString, id);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
