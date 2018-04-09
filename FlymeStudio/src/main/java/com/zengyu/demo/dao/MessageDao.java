package com.zengyu.demo.dao;

import java.util.List;

import com.zengyu.demo.model.MessageVO;

public interface MessageDao {
	int addMessage(int type, String sender, String receiver, String teamid);

	int deleteMessage(String id);

	MessageVO queryMessageById(String id);

	MessageVO queryMessageByDetail(int type, String sender, String receiver, String teamid);

	List<MessageVO> queryMessages(String tel);
}
