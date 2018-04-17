package com.zengyu.demo.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Repository;

import com.zengyu.demo.model.MessageMapper;
import com.zengyu.demo.model.MessageVO;
import com.zengyu.demo.others.Const;

/**
 * 消息访问层
 * 
 * @author zengyu
 *
 */
@Repository(value = "messageDao")
public class MessageImpl extends AbstractImpl implements MessageDao {

	public int addMessage(int messageType, int senderId, int receiverId, int teamId) {
		String SQL = "insert into " + Const.Message.TABLE_NAME + " values(?,?,?,?,?)";
		try {
			return jdbcTemplate.update(SQL, null, messageType, senderId, receiverId, teamId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteMessage(int messageId) {
		String SQL = "delete from " + Const.Message.TABLE_NAME + " where " + Const.Message.COLUMN_ID + " = ?";
		try {
			return jdbcTemplate.update(SQL, messageId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public MessageVO queryMessageById(int messageId) {
		String SQL = "select * from " + Const.Message.TABLE_NAME + " where " + Const.Message.COLUMN_ID + " = ?";
		try {
			return jdbcTemplate.queryForObject(SQL, new MessageMapper(), messageId);
		} catch (EmptyResultDataAccessException e) {
			// TODO
		} catch (IncorrectResultSizeDataAccessException e) {
			// TODO
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public MessageVO queryMessageByDetail(int messageType, int senderId, int receiverId, int teamId) {
		String SQL = "select * from " + Const.Message.TABLE_NAME + " where " + Const.Message.COLUMN_TYPE + " = ? and "
				+ Const.Message.COLUMN_SENDER_ID + " = ? and " + Const.Message.COLUMN_RECEIVER_ID + " = ? and "
				+ Const.Message.COLUMN_TEAM_ID + " = ?";
		try {
			return jdbcTemplate.queryForObject(SQL, new MessageMapper(), messageType, senderId, receiverId, teamId);
		} catch (EmptyResultDataAccessException e) {
			// TODO
		} catch (IncorrectResultSizeDataAccessException e) {
			// TODO
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<MessageVO> queryMessages(int userId) {
		String SQL = "select * from " + Const.Message.TABLE_NAME + " where " + Const.Message.COLUMN_RECEIVER_ID
				+ " = ?";
		try {
			return jdbcTemplate.query(SQL, new MessageMapper(), userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
