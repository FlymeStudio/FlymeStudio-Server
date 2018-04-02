package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import database.dao.AccountDao;

@Controller
@RequestMapping("/Account")
public class AccountController {
	private AccountDao accountDao;

	@Autowired
	public AccountController(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	@ResponseBody
	public String signIn(@RequestParam String id, @RequestParam String password) {
		JSONObject jsonObject = new JSONObject();
		boolean isDataExist = false;
		JSONObject data = accountDao.signIn(id, password);
		if (data != null) {
			isDataExist = true;
			jsonObject.put("data", data);
		}
		jsonObject.put("result", isDataExist);
		return jsonObject.toJSONString();
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	@ResponseBody
	public String signUp(@RequestParam String name, @RequestParam String tel, @RequestParam String email,
			@RequestParam String password) {
		JSONObject jsonObject = new JSONObject();
		boolean data = accountDao.signUp(name, tel, email, password);
		jsonObject.put("result", data);
		return jsonObject.toJSONString();
	}

	@RequestMapping(value = "/signOut", method = RequestMethod.POST)
	@ResponseBody
	public String signOut(@RequestParam String tel) {
		JSONObject jsonObject = new JSONObject();
		boolean data = accountDao.signOut(tel);
		jsonObject.put("result", data);
		return jsonObject.toJSONString();
	}

	@RequestMapping(value = "/retrieve", method = RequestMethod.POST)
	@ResponseBody
	public String retrieve(@RequestParam String name, @RequestParam String tel, @RequestParam String email) {
		JSONObject jsonObject = new JSONObject();
		boolean data = accountDao.retrieve(name, tel, email);
		jsonObject.put("result", data);
		return jsonObject.toJSONString();
	}
}
