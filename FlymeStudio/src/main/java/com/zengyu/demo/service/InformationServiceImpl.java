package com.zengyu.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zengyu.demo.model.MessageVO;
import com.zengyu.demo.model.UserVO;
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
					count1 += teamDao.addTeamMember(messageVO.getTeamId(), messageVO.getRecieverId());
					UserVO userVO = userDao.queryUserById(messageVO.getRecieverId());
					List<Integer> teams = userVO.getTeams();
					if (teams == null) {
						teams = new ArrayList<Integer>();
						teams.add(messageVO.getTeamId());
					} else {
						if (!teams.contains(messageVO.getTeamId())) {
							teams.add(messageVO.getTeamId());
						}
					}
					count1 += userDao.updateUserTeams(messageVO.getRecieverId(), teams);
				} else {
					count1 = 2;
				}
			} else if (messageVO.getType() == 2) {
				if (result) {
					count1 += teamDao.addTeamMember(messageVO.getTeamId(), messageVO.getSenderId());
					UserVO userVO = userDao.queryUserById(messageVO.getSenderId());
					List<Integer> teams = userVO.getTeams();
					if (teams == null) {
						teams = new ArrayList<Integer>();
						teams.add(messageVO.getTeamId());
					} else {
						if (!teams.contains(messageVO.getTeamId())) {
							teams.add(messageVO.getTeamId());
						}
					}
					count1 += userDao.updateUserTeams(messageVO.getSenderId(), teams);
				} else {
					count1 = 2;
				}
			}
			if (count1 == 2) {
				int count2 = messageDao.deleteMessage(messageId);
				if (count2 > 0) {
					responseObject.setResult(true);
				}
			}
		}
		return responseObject.toJSONString();
	}
}
