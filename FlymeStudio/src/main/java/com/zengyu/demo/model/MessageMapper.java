package com.zengyu.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * 消息映射
 * 
 * @author zengyu
 *
 */
public class MessageMapper implements RowMapper<MessageVO> {

	public MessageVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MessageVO bean = new MessageVO();
		bean.setId(rs.getInt("id"));
		bean.setType(rs.getInt("type"));
		bean.setSender(rs.getString("sender"));
		bean.setReciever(rs.getString("receiver"));
		bean.setTeamid(rs.getInt("teamid"));
		return bean;
	}
}
