package com.zengyu.demo.repository;

import java.util.List;

import com.zengyu.demo.model.PlanVO;
import com.zengyu.demo.model.ProjectVO;

public interface ProjectDao {
	int addProject(String tel, int type, String date, String title, String content, List<PlanVO> plans);

	int deleteProject(String tel, int id);

	ProjectVO queryProjectById(int id);

	List<ProjectVO> queryProjectByDetail(String tel, int type, String date, String title, String content);

	List<ProjectVO> queryProjects(String tel);

	int updateProject(String tel, int id, int type, String date, String title, String content, List<PlanVO> plans);
}
