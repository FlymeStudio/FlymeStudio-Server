package com.zengyu.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.zengyu.demo.model.PlanVO;
import com.zengyu.demo.model.ProjectVO;
import com.zengyu.demo.others.ResponseObject;
import com.zengyu.demo.repository.ProjectDao;

/**
 * 任务活动层
 * 
 * @author zengyu
 *
 */
@Service
public class ProjectServiceImpl implements ProjectService {
	@Resource(name = "projectDao")
	private ProjectDao projectDao;

	public String get(String tel) {
		ResponseObject responseObject = new ResponseObject();
		List<ProjectVO> projectVOs = projectDao.queryProjects(tel);
		if (projectVOs != null) {
			try {
				JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(projectVOs));
				responseObject.setData(jsonArray);
			} catch (JSONException e) {
				// TODO
			}
		}
		return responseObject.toJSONString();
	}

	public String create(String tel, int type, String date, String title, String content, String plans) {
		ResponseObject responseObject = new ResponseObject();
		try {
			JSONArray jsonArray = JSONArray.parseArray(plans);
			if (jsonArray != null) {
				int count = projectDao.addProject(tel, type, date, title, content, jsonArray.toJavaList(PlanVO.class));
				if (count > 0) {
					responseObject.setResult(true);
				}
			}
		} catch (JSONException e) {
			// TODO
		}
		return responseObject.toJSONString();
	}

	public String delete(String tel, int id) {
		ResponseObject responseObject = new ResponseObject();
		int count = projectDao.deleteProject(tel, id);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String search(String tel, int type, String date, String title, String content) {
		ResponseObject responseObject = new ResponseObject();
		List<ProjectVO> projectVOs = projectDao.queryProjectByDetail(tel, type, date, title, content);
		if (projectVOs != null) {
			try {
				JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(projectVOs));
				responseObject.setData(jsonArray);
			} catch (JSONException e) {
				// TODO
			}
		}
		return responseObject.toJSONString();
	}

	public String modify(String tel, int id, int type, String date, String title, String content, String plans) {
		ResponseObject responseObject = new ResponseObject();
		try {
			JSONArray jsonArray = JSONArray.parseArray(plans);
			if (jsonArray != null) {
				int count = projectDao.updateProject(tel, id, type, date, title, content,
						jsonArray.toJavaList(PlanVO.class));
				if (count > 0) {
					responseObject.setResult(true);
				}
			}
		} catch (JSONException e) {
			// TODO
		}
		return responseObject.toJSONString();
	}
}
