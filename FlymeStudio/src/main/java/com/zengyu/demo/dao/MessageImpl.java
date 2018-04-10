package com.zengyu.demo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zengyu.demo.model.MessageMapper;
import com.zengyu.demo.model.MessageVO;
import com.zengyu.demo.others.Const;

public class MessageImpl extends AbstractImpl implements MessageDao {
	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int addMessage(int type, String sender, String receiver, int teamid) {
		if (queryMessageByDetail(type, sender, receiver, teamid) != null) {
			return 0;
		}
		String SQL = "insert into " + Const.Message.TABLE_NAME + " values(?,?,?,?,?)";
		return jdbcTemplate.update(SQL, null, type, sender, receiver, teamid);
	}

	public int deleteMessage(int id) {
		String SQL = "delete from " + Const.Message.TABLE_NAME + " where " + Const.Message.COLUMN_ID + " = ?";
		return jdbcTemplate.update(SQL, id);
	}

	public MessageVO queryMessageById(int id) {
		String SQL = "select * from " + Const.Message.TABLE_NAME + " where " + Const.Message.COLUMN_ID + " = ?";
		return jdbcTemplate.queryForObject(SQL, new MessageMapper(), id);
	}

	public MessageVO queryMessageByDetail(int type, String sender, String receiver, int teamid) {
		String SQL = "select * from " + Const.Message.TABLE_NAME + " where " + Const.Message.COLUMN_TYPE + " = ? and "
				+ Const.Message.COLUMN_SENDER + " = ? and " + Const.Message.COLUMN_RECEIVER + " = ? and "
				+ Const.Message.COLUMN_TEAM_ID + " = ?";
		return jdbcTemplate.queryForObject(SQL, new MessageMapper(), type, sender, receiver, teamid);
	}

	public List<MessageVO> queryMessages(String tel) {
		String SQL = "select * from " + Const.Message.TABLE_NAME + " where " + Const.Message.COLUMN_RECEIVER + " = ?";
		return jdbcTemplate.query(SQL, new MessageMapper(), tel);
	}

}
