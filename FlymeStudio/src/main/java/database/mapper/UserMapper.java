package database.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import bean.UserBean;

public class UserMapper implements RowMapper<UserBean> {

	public UserBean mapRow(ResultSet arg0, int arg1) throws SQLException {
		UserBean bean = new UserBean();
		bean.setTel(arg0.getInt("tel"));
		bean.setName(arg0.getString("name"));
		bean.setEmail(arg0.getString("email"));
		bean.setPassword(arg0.getString("password"));
		return bean;
	}
}
