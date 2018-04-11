package com.zengyu.demo.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Repository;

import com.zengyu.demo.model.SummaryMapper;
import com.zengyu.demo.model.SummaryVO;
import com.zengyu.demo.others.Const;

/**
 * 总结访问层
 * 
 * @author zengyu
 *
 */
@Repository(value = "summaryDao")
public class SummaryImpl extends AbstractImpl implements SummaryDao {

	public int addSummary(String tel, int type, String date, String title, String content) {
		if (querySummaryByDetail(tel, type, date, title, null) != null) {
			return 0;
		} else {
			String SQL = "insert into " + Const.Summary.TABLE_NAME + " values(?,?,?,?,?,?)";
			return jdbcTemplate.update(SQL, null, tel, type, date, title, content);
		}
	}

	public int deleteSummary(String tel, int id) {
		String SQL = "delete from " + Const.Summary.TABLE_NAME + " where " + Const.Summary.COLUMN_TEL + " = ? and "
				+ Const.Project.COLUMN_ID + " = ?";
		return jdbcTemplate.update(SQL, tel, id);
	}

	public SummaryVO querySummaryById(int id) {
		String SQL = "select * from " + Const.Summary.TABLE_NAME + " where " + Const.Summary.COLUMN_ID + " = ?";
		SummaryVO summaryVO = null;
		try {
			summaryVO = jdbcTemplate.queryForObject(SQL, new SummaryMapper(), id);
		} catch (EmptyResultDataAccessException e) {
			// TODO
		} catch (IncorrectResultSizeDataAccessException e) {
			// TODO
		}
		return summaryVO;
	}

	public List<SummaryVO> querySummaryByDetail(String tel, int type, String date, String title, String content) {
		String SQL = "select * from " + Const.Summary.TABLE_NAME + " where " + Const.Summary.COLUMN_TEL + " = ? and "
				+ Const.Summary.COLUMN_TYPE + " = ? and " + Const.Summary.COLUMN_DATE + " = ? and "
				+ Const.Summary.COLUMN_TITLE + " like %?% and " + Const.Summary.COLUMN_CONTENT + " like %?%";
		return jdbcTemplate.query(SQL, new SummaryMapper(), tel, type, date, title, content);
	}

	public List<SummaryVO> querySummaries(String tel) {
		String SQL = "select * from " + Const.Summary.TABLE_NAME + " where " + Const.Summary.COLUMN_TEL + " = ?";
		return jdbcTemplate.query(SQL, new SummaryMapper(), tel);
	}

	public int updateSummary(String tel, int id, int type, String date, String title, String content) {
		String SQL = "update " + Const.Project.TABLE_NAME + " set " + Const.Project.COLUMN_TYPE + " = ?, "
				+ Const.Project.COLUMN_DATE + " = ?, " + Const.Project.COLUMN_TITLE + " = ?, "
				+ Const.Project.COLUMN_CONTENT + " = ?, " + Const.Project.COLUMN_TEL + " = ? and "
				+ Const.Project.COLUMN_ID + " = ?";
		return jdbcTemplate.update(SQL, type, date, title, content, tel, id);
	}

}
