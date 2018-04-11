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
		MessageVO messageVO = null;
		try {
			messageVO = jdbcTemplate.queryForObject(SQL, new MessageMapper(), id);
		} catch (EmptyResultDataAccessException e) {
			// TODO
		} catch (IncorrectResultSizeDataAccessException e) {
			// TODO
		}
		return messageVO;
	}

	public MessageVO queryMessageByDetail(int type, String sender, String receiver, int teamid) {
		String SQL = "select * from " + Const.Message.TABLE_NAME + " where " + Const.Message.COLUMN_TYPE + " = ? and "
				+ Const.Message.COLUMN_SENDER + " = ? and " + Const.Message.COLUMN_RECEIVER + " = ? and "
				+ Const.Message.COLUMN_TEAM_ID + " = ?";
		MessageVO messageVO = null;
		try {
			messageVO = jdbcTemplate.queryForObject(SQL, new MessageMapper(), type, sender, receiver, teamid);
		} catch (EmptyResultDataAccessException e) {
			// TODO
		} catch (IncorrectResultSizeDataAccessException e) {
			// TODO
		}
		return messageVO;
	}

	public List<MessageVO> queryMessages(String tel) {
		String SQL = "select * from " + Const.Message.TABLE_NAME + " where " + Const.Message.COLUMN_RECEIVER + " = ?";
		return jdbcTemplate.query(SQL, new MessageMapper(), tel);
	}
}
