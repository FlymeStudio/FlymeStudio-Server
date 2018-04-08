package com.zengyu.demo.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zengyu.demo.dao.AccountDao;
import com.zengyu.demo.model.MessageMapper;
import com.zengyu.demo.model.MessageVO;
import com.zengyu.demo.model.UserMapper;
import com.zengyu.demo.model.UserVO;
import com.zengyu.demo.others.Const;

@Service
public class AccountService extends AbstractService implements AccountDao {

	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JSONObject signIn(String id, String password) {
		JSONObject jsonObject = null;
		try {
			// 查询是否存在该用户
			String SQL1 = "select * from " + Const.User.TABLE_NAME + " where (" + Const.User.COLUMN_TEL + " = ? or "
					+ Const.User.COLUMN_EMAIL + " = ?) and " + Const.User.COLUMN_PASSWORD + " = ?";

			UserVO userVO = jdbcTemplate.queryForObject(SQL1, new UserMapper(), id, id, password);
			if (userVO != null) {
				jsonObject = new JSONObject();
				jsonObject.put(Const.User.COLUMN_TEL, userVO.getTel());
				jsonObject.put(Const.User.COLUMN_NAME, userVO.getName());
				jsonObject.put(Const.User.COLUMN_EMAIL, userVO.getEmail());
				// 查询该用户是否存在消息
				String SQL2 = "select * from " + Const.Message.TABLE_NAME + " where id = ?";

				List<MessageVO> messageVOs = jdbcTemplate.query(SQL2, new MessageMapper(), userVO.getTel());
				JSONArray jsonArray = new JSONArray();
				if (messageVOs != null && messageVOs.size() > 0) {
					jsonArray = JSONArray.parseArray(messageVOs.toString());
				}
				jsonObject.put(Const.User.COLUMN_MESSAGES, jsonArray);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	public boolean signUp(String name, String tel, String email, String password) {
		boolean result = false;
		try {
			// 查询用户是否已存在
			String SQL1 = "select * from " + Const.User.TABLE_NAME + " where " + Const.User.COLUMN_TEL + " = ? or "
					+ Const.User.COLUMN_EMAIL + " = ?";

			List<UserVO> userVOs = jdbcTemplate.query(SQL1, new UserMapper(), tel, email);
			if (userVOs == null || userVOs.size() == 0) {
				// 插入新用户
				String SQL2 = "insert into " + Const.User.TABLE_NAME + " values(?,?,?,?)";

				int count = jdbcTemplate.update(SQL2, name, tel, email, password);
				if (count > 0) {
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean signOut(String tel) {
		// TODO
		return true;
	}

	public boolean retrieve(String name, String tel, String email) {
		// TODO
		return true;
	}
}
