package database.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import bean.MessageBean;

public class MessageMapper implements RowMapper<MessageBean> {

	public MessageBean mapRow(ResultSet arg0, int arg1) throws SQLException {
		MessageBean bean = new MessageBean();
		bean.setId(arg0.getInt("id"));
		bean.setType(arg0.getInt("type"));
		bean.setSender(arg0.getInt("sender"));
		bean.setReciever(arg0.getInt("receiver"));
		bean.setTeamid(arg0.getInt("teamid"));
		return bean;
	}
}
