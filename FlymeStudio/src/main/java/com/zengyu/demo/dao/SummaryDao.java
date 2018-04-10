package com.zengyu.demo.dao;

import java.util.List;

import com.zengyu.demo.model.SummaryVO;

public interface SummaryDao {
	int addSummary(String tel, int type, String date, String title, String content);

	int deleteSummary(String tel, int id);

	SummaryVO querySummaryById(int id);

	List<SummaryVO> querySummaryByDetail(String tel, int type, String date, String title, String content);

	List<SummaryVO> querySummaries(String tel);

	int updateSummary(String tel, int id, int type, String date, String title, String content);
}
