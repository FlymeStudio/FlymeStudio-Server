package com.zengyu.demo.repository;

import java.util.List;

import com.zengyu.demo.model.PlanVO;
import com.zengyu.demo.model.ProjectVO;

/**
 * 任务访问层接口
 * 
 * @author zengyu
 *
 */
public interface ProjectDao {
	/**
	 * 添加任务
	 * 
	 * @param tel
	 *            电话
	 * @param type
	 *            类型
	 * @param date
	 *            日期
	 * @param title
	 *            时间
	 * @param content
	 *            内容
	 * @param plans
	 *            计划
	 * @return
	 */
	int addProject(String tel, int type, String date, String title, String content, List<PlanVO> plans);

	/**
	 * 删除任务
	 * 
	 * @param tel
	 *            电话
	 * @param id
	 *            编号
	 * @return
	 */
	int deleteProject(String tel, int id);

	/**
	 * 通过编号查询任务
	 * 
	 * @param id
	 *            编号
	 * @return
	 */
	ProjectVO queryProjectById(int id);

	/**
	 * 通过详情查找任务
	 * 
	 * @param tel
	 *            电话
	 * @param type
	 *            类型
	 * @param date
	 *            日期
	 * @param title
	 *            标题
	 * @param content
	 *            内容
	 * @return
	 */
	List<ProjectVO> queryProjectByDetail(String tel, int type, String date, String title);

	/**
	 * 查询个人任务
	 * 
	 * @param tel
	 *            电话
	 * @return
	 */
	List<ProjectVO> queryProjects(String tel);

	/**
	 * 更新任务
	 * 
	 * @param tel
	 *            电话
	 * @param id
	 *            编号
	 * @param type
	 *            类型
	 * @param date
	 *            日期
	 * @param title
	 *            时间
	 * @param content
	 *            内容
	 * @param plans
	 *            计划
	 * @return
	 */
	int updateProject(String tel, int id, int type, String date, String title, String content, List<PlanVO> plans);
}
