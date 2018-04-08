package com.zengyu.demo.service;

import java.util.List;

import javax.sql.DataSource;

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

	public AccountService() {
		System.out.println("===============================\nAccountService is inited");
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("===============================\nsetDataSource: DataSource is null? " + (dataSource == null));
		System.out.println("===============================\nsetDataSource: JdbcTemplate is null? " + (jdbcTemplate == null));
	}

	public void init() {
		System.out.println("===============================\nAccountService inited in xml");
	}

	public void destroy() {
		System.out.println("===============================\nAccountService destroyed in xml");
	}
	
	public JSONObject signIn(String id, String password) {
		System.out.println("===============================\nsignIn: JdbcTemplate is null? " + (jdbcTemplate == null));
		JSONObject jsonObject = null;
		String SQL1 = "select * from " + Const.User.TABLE_NAME + " where (" + Const.User.COLUMN_TEL + " = ? or "
				+ Const.User.COLUMN_EMAIL + " = ?) and " + Const.User.COLUMN_PASSWORD + " = ?";
		try {
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
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	public boolean signUp(String name, String tel, String email, String password) {
		boolean result = false;
		String SQL1 = "select * from " + Const.User.TABLE_NAME + " where " + Const.User.COLUMN_TEL + " = ? or "
				+ Const.User.COLUMN_EMAIL + " = ?";
		try {
			List<UserVO> userBeans = jdbcTemplate.query(SQL1, new UserMapper(), tel, email);
			if (userBeans == null || userBeans.size() == 0) {
				String SQL2 = "insert into " + Const.User.TABLE_NAME + " values(?,?,?,?)";
				int count = jdbcTemplate.update(SQL2, name, tel, email, password);
				if (count > 0) {
					result = true;
				}
			}
		} catch (NullPointerException e) {
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
