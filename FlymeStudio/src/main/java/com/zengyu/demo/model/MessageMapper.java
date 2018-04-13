package com.zengyu.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zengyu.demo.others.Const;

/**
 * 消息映射
 * 
 * @author zengyu
 *
 */
public class MessageMapper implements RowMapper<MessageVO> {

	public MessageVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MessageVO bean = new MessageVO();
		bean.setId(rs.getInt(Const.Message.COLUMN_ID));
		bean.setType(rs.getInt(Const.Message.COLUMN_TYPE));
		bean.setSenderId(rs.getInt(Const.Message.COLUMN_SENDER_ID));
		bean.setRecieverId(rs.getInt(Const.Message.COLUMN_RECEIVER_ID));
		bean.setTeamId(rs.getInt(Const.Message.COLUMN_TEAM_ID));
		return bean;
	}
}
