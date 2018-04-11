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
	 * @return
	 */
	int addSummary(String tel, int type, String date, String title, String content);

	/**
	 * 删除总结
	 * 
	 * @param tel
	 *            电话
	 * @param id
	 *            编号
	 * @return
	 */
	int deleteSummary(String tel, int id);

	/**
	 * 通过编号查询总结
	 * 
	 * @param id
	 *            编号
	 * @return
	 */
	SummaryVO querySummaryById(int id);

	/**
	 * 通过详情查找总结
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
	List<SummaryVO> querySummaryByDetail(String tel, int type, String date, String title, String content);

	/**
	 * 查询个人总结
	 * 
	 * @param tel
	 *            电话
	 * @return
	 */
	List<SummaryVO> querySummaries(String tel);

	/**
	 * 更新总结
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
	 * @return
	 */
	int updateSummary(String tel, int id, int type, String date, String title, String content);
}
