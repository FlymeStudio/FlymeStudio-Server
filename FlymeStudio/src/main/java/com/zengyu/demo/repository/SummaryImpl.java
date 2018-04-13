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

	public int addSummary(int userId, int type, long date, String title, String content) {
		if (querySummaryByDetail(userId, type, date, title) == null) {
			String SQL = "insert into " + Const.Summary.TABLE_NAME + " values(?,?,?,?,?,?)";
			try {
				return jdbcTemplate.update(SQL, null, userId, type, date, title, content);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int deleteSummary(int summaryId, int userId) {
		String SQL = "delete from " + Const.Summary.TABLE_NAME + " where " + Const.Summary.COLUMN_ID + " = ? and "
				+ Const.Project.COLUMN_USER_ID + " = ?";
		try {
			return jdbcTemplate.update(SQL, summaryId, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public SummaryVO querySummaryById(int summaryId) {
		String SQL = "select * from " + Const.Summary.TABLE_NAME + " where " + Const.Summary.COLUMN_ID + " = ?";
		try {
			return jdbcTemplate.queryForObject(SQL, new SummaryMapper(), summaryId);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		} catch (IncorrectResultSizeDataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<SummaryVO> querySummaryByDetail(int userId, int type, long date, String title) {
		String SQL = "select * from " + Const.Summary.TABLE_NAME + " where " + Const.Summary.COLUMN_USER_ID
				+ " = ? and " + Const.Summary.COLUMN_TYPE + " = ? and " + Const.Summary.COLUMN_DATE + " = ? and "
				+ Const.Summary.COLUMN_TITLE + " = ?";
		try {
			return jdbcTemplate.query(SQL, new SummaryMapper(), userId, type, date, title);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<SummaryVO> querySummaries(int userId) {
		String SQL = "select * from " + Const.Summary.TABLE_NAME + " where " + Const.Summary.COLUMN_USER_ID + " = ?";
		try {
			return jdbcTemplate.query(SQL, new SummaryMapper(), userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateSummary(int summaryId, int userId, int type, long date, String title, String content) {
		String SQL = "update " + Const.Project.TABLE_NAME + " set " + Const.Project.COLUMN_TYPE + " = ?, "
				+ Const.Project.COLUMN_DATE + " = ?, " + Const.Project.COLUMN_TITLE + " = ?, "
				+ Const.Project.COLUMN_CONTENT + " = ?, " + Const.Project.COLUMN_ID + " = ? and "
				+ Const.Project.COLUMN_USER_ID + " = ?";
		try {
			return jdbcTemplate.update(SQL, type, date, title, content, summaryId, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
