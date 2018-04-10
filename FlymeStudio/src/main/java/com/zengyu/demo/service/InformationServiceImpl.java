package com.zengyu.demo.service;

import org.springframework.stereotype.Service;

import com.zengyu.demo.dao.MessageDao;
import com.zengyu.demo.dao.MessageImpl;
import com.zengyu.demo.dao.TeamDao;
import com.zengyu.demo.dao.TeamImpl;
import com.zengyu.demo.dao.UserDao;
import com.zengyu.demo.dao.UserImpl;
import com.zengyu.demo.model.MessageVO;
import com.zengyu.demo.others.ResponseObject;

@Service
public class InformationServiceImpl implements InformationService {

	public String modify(String old, String name, String tel, String email, String password) {
		ResponseObject responseObject = new ResponseObject();
		UserDao userDao = new UserImpl();
		int count = userDao.updateUserInformation(old, tel, name, email, password);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String replyMsg(int id, boolean result) {
		ResponseObject responseObject = new ResponseObject();
		MessageDao messageDao = new MessageImpl();
		MessageVO messageVO = messageDao.queryMessageById(id);
		if (messageVO != null) {
			TeamDao teamDao = new TeamImpl();
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
