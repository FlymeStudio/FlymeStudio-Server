package com.zengyu.flymestudio.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zengyu.flymestudio.dao.AccountDao;
import com.zengyu.flymestudio.model.MessageMapper;
import com.zengyu.flymestudio.model.MessageVO;
import com.zengyu.flymestudio.model.UserMapper;
import com.zengyu.flymestudio.model.UserVO;
import com.zengyu.flymestudio.others.Const;

@Service
public class AccountService extends AbstractService implements AccountDao {
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JSONObject signIn(String id, String password) {
		JSONObject jsonObject = null;
		String SQL1 = "select * from " + Const.User.TABLE_NAME + " where (" + Const.User.COLUMN_TEL + " = ? or "
				+ Const.User.COLUMN_EMAIL + " = ?) and " + Const.User.COLUMN_PASSWORD + " = ?";
		UserVO userBean = jdbcTemplate.queryForObject(SQL1, new UserMapper(), id, id, password);
		if (userBean != null) {
			jsonObject = new JSONObject();
			jsonObject.put(Const.User.COLUMN_TEL, userBean.getTel());
			jsonObject.put(Const.User.COLUMN_NAME, userBean.getName());
			jsonObject.put(Const.User.COLUMN_EMAIL, userBean.getEmail());
			String SQL2 = "select * from " + Const.Message.TABLE_NAME + " where id = ?";
			List<MessageVO> messageBeans = jdbcTemplate.query(SQL2, new MessageMapper(), userBean.getTel());
			JSONArray jsonArray = new JSONArray();
			if (messageBeans != null && messageBeans.size() > 0) {
				jsonArray = JSONArray.parseArray(messageBeans.toString());
			}
			jsonObject.put(Const.User.COLUMN_MESSAGES, jsonArray);
		}
		return jsonObject;
	}

	public boolean signUp(String name, String tel, String email, String password) {
		boolean result = false;
		String SQL1 = "select * from " + Const.User.TABLE_NAME + " where " + Const.User.COLUMN_TEL + " = ? or "
				+ Const.User.COLUMN_EMAIL + " = ?";
		List<UserVO> userBeans = jdbcTemplate.query(SQL1, new UserMapper(), tel, email);
		if (userBeans == null || userBeans.size() == 0) {
			String SQL2 = "insert into " + Const.User.TABLE_NAME + " values(?,?,?,?)";
			int count = jdbcTemplate.update(SQL2, name, tel, email, password);
			if (count > 0) {
				result = true;
			}
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
