package com.zengyu.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zengyu.demo.repository.SummaryDao;

@Service
public class SummaryServiceImpl implements SummaryService {
	@Resource(name = "summaryDao")
	private SummaryDao summaryDao;

}
