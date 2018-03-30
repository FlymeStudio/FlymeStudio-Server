package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import database.dao.AccountDao;

@Controller
@RequestMapping("/")
public class AccountController {
	private AccountDao accountDao;
	
	@Autowired
	public AccountController(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	
}
