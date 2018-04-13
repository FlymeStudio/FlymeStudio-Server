package com.zengyu.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zengyu.demo.model.MessageVO;
import com.zengyu.demo.others.ResponseObject;
import com.zengyu.demo.repository.MessageDao;
import com.zengyu.demo.repository.TeamDao;
import com.zengyu.demo.repository.UserDao;

/**
 * 信息活动层
 * 
 * @author zengyu
 *
 */
@Service
public class InformationServiceImpl implements InformationService {
	@Resource(name = "userDao")
	private UserDao userDao;

	@Resource(name = "messageDao")
	private MessageDao messageDao;

	@Resource(name = "teamDao")
	private TeamDao teamDao;

	public String modify(int id, String tel, String name, String email, String password) {
		ResponseObject responseObject = new ResponseObject();
		int count = userDao.updateUserInformation(id, tel, name, email, password);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String reply(int messageId, boolean result) {
		ResponseObject responseObject = new ResponseObject();
		MessageVO messageVO = messageDao.queryMessageById(messageId);
		if (messageVO != null) {
			int count1 = 0;
			if (messageVO.getType() == 1) {
				if (result) {
					count1 = teamDao.addTeamMember(messageVO.getRecieverId(), messageVO.getTeamId());
				} else {
					count1 = 1;
				}
			} else if (messageVO.getType() == 2) {
				if (result) {
					count1 = teamDao.addTeamMember(messageVO.getSenderId(), messageVO.getTeamId());
				} else {
					count1 = 1;
				}
			}
			if (count1 == 1) {
				int count2 = messageDao.deleteMessage(messageId);
				if (count2 > 0) {
					responseObject.setResult(true);
				}
			}
		}
		return responseObject.toJSONString();
	}
}
