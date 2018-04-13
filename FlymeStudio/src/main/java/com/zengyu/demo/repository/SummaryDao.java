package com.zengyu.demo.repository;

import java.util.List;

import com.zengyu.demo.model.SummaryVO;

/**
 * 总结访问层接口
 * 
 * @author zengyu
 *
 */
public interface SummaryDao {
	/**
	 * 添加总结
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
	 * @return
	 */
	int addSummary(int userId, int type, long date, String title, String content);

	/**
	 * 删除总结
	 * 
	 * @param summaryId
	 *            总结编号
	 * @param userId
	 *            用户编号
	 * @return
	 */
	int deleteSummary(int summaryId, int userId);

	/**
	 * 通过编号查询总结
	 * 
	 * @param summaryId
	 *            编号
	 * @return
	 */
	SummaryVO querySummaryById(int summaryId);

	/**
	 * 通过详情查找总结
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
	List<SummaryVO> querySummaryByDetail(int userId, int type, long date, String title);

	/**
	 * 查询个人总结
	 * 
	 * @param userId
	 *            用户编号
	 * @return
	 */
	List<SummaryVO> querySummaries(int userId);

	/**
	 * 更新总结
	 * 
	 * @param summaryId
	 *            编号
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
	 * @return
	 */
	int updateSummary(int summaryId, int userId, int type, long date, String title, String content);
}
