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

	public String get(int userId) {
		ResponseObject responseObject = new ResponseObject();
		List<ProjectVO> projectVOs = projectDao.queryProjects(userId);
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

	public String create(int userId, int type, long date, String title, String content, String plans) {
		ResponseObject responseObject = new ResponseObject();
		try {
			JSONArray jsonArray = JSONArray.parseArray(plans);
			if (jsonArray != null) {
				int count = projectDao.addProject(userId, type, date, title, content, jsonArray.toJavaList(PlanVO.class));
				if (count > 0) {
					responseObject.setResult(true);
				}
			}
		} catch (JSONException e) {
			// TODO
			e.printStackTrace();
		}
		return responseObject.toJSONString();
	}

	public String delete(int id, int userId) {
		ResponseObject responseObject = new ResponseObject();
		int count = projectDao.deleteProject(id, userId);
		if (count > 0) {
			responseObject.setResult(true);
		}
		return responseObject.toJSONString();
	}

	public String modify(int id, int userId, int type, long date, String title, String content, String plans) {
		ResponseObject responseObject = new ResponseObject();
		try {
			JSONArray jsonArray = JSONArray.parseArray(plans);
			if (jsonArray != null) {
				int count = projectDao.updateProject(id, userId, type, date, title, content,
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
