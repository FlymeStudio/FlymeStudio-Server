package com.zengyu.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zengyu.demo.model.MessageVO;
import com.zengyu.demo.model.TeamVO;
import com.zengyu.demo.model.UserVO;
import com.zengyu.demo.others.ResponseObject;
import com.zengyu.demo.repository.MessageDao;
import com.zengyu.demo.repository.TeamDao;
import com.zengyu.demo.repository.UserDao;

/**
 * 帐号活动层
 * 
 * @author zengyu
 *
 */
@Service
public class AccountServiceImpl implements AccountService {
	@Resource(name = "userDao")
	private UserDao userDao;

	@Resource(name = "messageDao")
	private MessageDao messageDao;

	@Resource(name = "teamDao")
	private TeamDao teamDao;

	public String signIn(String user, String password) {
		ResponseObject responseObject = new ResponseObject();
		UserVO userVO = userDao.queryUserByAccountAndPassword(user, password);
		if (userVO != null) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", userVO.getId());
			jsonObject.put("num", userVO.getNum());
			jsonObject.put("tel", userVO.getTel());
			jsonObject.put("name", userVO.getName());
			jsonObject.put("email", userVO.getEmail());
			jsonObject.put("password", userVO.getPassword());
			List<MessageVO> messageVOs = messageDao.queryMessages(userVO.getId());
			JSONArray jsonArray = new JSONArray();
			for (int i = 0; i < messageVOs.size(); i++) {
				JSONObject object = new JSONObject();
				object.put("messageId", messageVOs.get(i).getId());
				object.put("type", messageVOs.get(i).getType());

				UserVO sender = userDao.queryUserById(messageVOs.get(i).getSenderId());
				object.put("senderNum", sender.getNum());
				object.put("senderName", sender.getName());

				TeamVO teamVO = teamDao.queryTeamById(messageVOs.get(i).getTeamId());
				object.put("teamName", teamVO.getName());

				jsonArray.add(object);
			}
			jsonObject.put("messages", jsonArray.toJSONString());
			responseObject.setData(jsonObject);
		}
		return responseObject.toJSONString();
	}

	public String signUp(String num, String tel, String name, String email, String password) {
		ResponseObject responseObject = new ResponseObject();
		int count = userDao.addUser(num, tel, name, email, password);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	// TEST
	public String signOut(int id) {
		ResponseObject responseObject = new ResponseObject();
		UserVO userVO = userDao.queryUserById(id);
		if (userVO != null) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String retrieve(String num, String tel, String name, String email) {
		// TODO
		return null;
	}
}
