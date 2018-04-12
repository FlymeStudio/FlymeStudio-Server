package com.zengyu.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.zengyu.demo.model.SummaryVO;
import com.zengyu.demo.others.ResponseObject;
import com.zengyu.demo.repository.SummaryDao;

/**
 * 总结活动层
 * 
 * @author zengyu
 *
 */
@Service
public class SummaryServiceImpl implements SummaryService {
	@Resource(name = "summaryDao")
	private SummaryDao summaryDao;

	public String get(String tel) {
		ResponseObject responseObject = new ResponseObject();
		List<SummaryVO> summaryVOs = summaryDao.querySummaries(tel);
		if (summaryVOs != null) {
			try {
				JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(summaryVOs));
				responseObject.setData(jsonArray);
			} catch (JSONException e) {
				// TODO
			}
		}
		return responseObject.toJSONString();
	}

	public String create(String tel, int type, String date, String title, String content) {
		ResponseObject responseObject = new ResponseObject();
		int count = summaryDao.addSummary(tel, type, date, title, content);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String delete(String tel, int id) {
		ResponseObject responseObject = new ResponseObject();
		int count = summaryDao.deleteSummary(tel, id);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String modify(String tel, int id, int type, String date, String title, String content) {
		ResponseObject responseObject = new ResponseObject();
		int count = summaryDao.updateSummary(tel, id, type, date, title, content);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}
}
