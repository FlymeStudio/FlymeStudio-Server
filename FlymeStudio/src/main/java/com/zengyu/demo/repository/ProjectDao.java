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
	 * @param userId
	 *            用户编号
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
	int addProject(int userId, int type, long date, String title, String content, List<PlanVO> plans);

	/**
	 * 删除任务
	 * 
	 * @param projectId
	 *            任务编号
	 * @param userId
	 *            用户编号
	 * @return
	 */
	int deleteProject(int projectId, int userId);

	/**
	 * 通过编号查询任务
	 * 
	 * @param projectId
	 *            任务编号
	 * @return
	 */
	ProjectVO queryProjectById(int projectId);

	/**
	 * 通过详情查找任务
	 * 
	 * @param userId
	 *            用户编号
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
	List<ProjectVO> queryProjectByDetail(int userId, int type, long date, String title);

	/**
	 * 查询个人任务
	 * 
	 * @param userId
	 *            用户编号
	 * @return
	 */
	List<ProjectVO> queryProjects(int userId);

	/**
	 * 更新任务
	 * 
	 * @param projectId
	 *            任务编号
	 * @param userId
	 *            用户编号
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
	int updateProject(int projectId, int userId, int type, long date, String title, String content, List<PlanVO> plans);
}
