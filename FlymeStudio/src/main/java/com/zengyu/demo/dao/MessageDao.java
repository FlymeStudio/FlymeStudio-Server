package com.zengyu.demo.dao;

import java.util.List;

import com.zengyu.demo.model.MessageVO;

public interface MessageDao {
	int addMessage(int type, String sender, String receiver, int teamid);

	int deleteMessage(int id);

	MessageVO queryMessageById(int id);

	MessageVO queryMessageByDetail(int type, String sender, String receiver, int teamid);

	List<MessageVO> queryMessages(String tel);
}
