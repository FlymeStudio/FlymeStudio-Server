package com.zengyu.demo.dao;

import java.util.List;

import com.zengyu.demo.model.PlanVO;
import com.zengyu.demo.model.ProjectVO;

public interface ProjectDao {
	int addProject(String tel, int type, String date, String title, String content, List<PlanVO> plans);

	int deleteProject(String id, String tel);

	ProjectVO queryProjectById(String id);

	ProjectVO queryProjectByDetail(String tel, int type, String date, String title);

	List<ProjectVO> queryProjects(String tel);

	int updateProject(String id, String tel, int type, String date, String title, String content, List<PlanVO> plans);
}
