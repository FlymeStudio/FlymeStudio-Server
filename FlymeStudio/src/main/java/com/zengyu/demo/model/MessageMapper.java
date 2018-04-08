package com.zengyu.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MessageMapper implements RowMapper<MessageVO> {

	public MessageVO mapRow(ResultSet arg0, int arg1) throws SQLException {
		MessageVO bean = new MessageVO();
		bean.setId(arg0.getInt("id"));
		bean.setType(arg0.getInt("type"));
		bean.setSender(arg0.getString("sender"));
		bean.setReciever(arg0.getString("receiver"));
		bean.setTeamid(arg0.getInt("teamid"));
		return bean;
	}
}
