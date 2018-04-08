package com.zengyu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zengyu.demo.dao.SummaryDao;

@Controller
@RequestMapping(value = "/Summary", produces = { "text/html;charset=UTF-8;", "application/json;" })
public class SummaryController {
	private SummaryDao summaryDao;

	@Autowired
	public SummaryController(SummaryDao summaryDao) {
		this.summaryDao = summaryDao;
	}

}
