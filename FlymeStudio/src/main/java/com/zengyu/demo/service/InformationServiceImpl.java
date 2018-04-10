package com.zengyu.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zengyu.demo.model.MessageVO;
import com.zengyu.demo.others.ResponseObject;
import com.zengyu.demo.repository.MessageDao;
import com.zengyu.demo.repository.TeamDao;
import com.zengyu.demo.repository.UserDao;

@Service
public class InformationServiceImpl implements InformationService {
	@Resource(name = "userDao")
	private UserDao userDao;
	
	@Resource(name = "messageDao")
	private MessageDao messageDao;

	@Resource(name = "teamDao")
	private TeamDao teamDao;
	
	public String modify(String old, String name, String tel, String email, String password) {
		ResponseObject responseObject = new ResponseObject();
		int count = userDao.updateUserInformation(old, tel, name, email, password);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String replyMsg(int id, boolean result) {
		ResponseObject responseObject = new ResponseObject();
		MessageVO messageVO = messageDao.queryMessageById(id);
		if (messageVO != null) {
			int count1 = 0;
			if (messageVO.getType() == 1) {
				if (result) {
					count1 = teamDao.addTeamMember(messageVO.getReciever(), messageVO.getTeamid());
				} else {
					count1 = 1;
				}
			} else if (messageVO.getType() == 2) {
				if (result) {
					count1 = teamDao.addTeamMember(messageVO.getSender(), messageVO.getTeamid());
				} else {
					count1 = 1;
				}
			}
			if (count1 == 1) {
				int count2 = messageDao.deleteMessage(id);
				if (count2 > 0) {
					responseObject.setResult(true);
				}
			}
		}
		return responseObject.toJSONString();
	}
}
