package com.zengyu.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.alibaba.fastjson.JSONArray;
import com.zengyu.demo.others.Const;

/**
 * 团队映射
 * 
 * @author zengyu
 *
 */
public class TeamMapper implements RowMapper<TeamVO> {

	public TeamVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TeamVO bean = new TeamVO();
		bean.setId(rs.getInt(Const.Team.COLUMN_ID));
		bean.setName(rs.getString(Const.Team.COLUMN_NAME));
		bean.setUserId(rs.getInt(Const.Team.COLUMN_USER_ID));
		JSONArray array = JSONArray.parseArray(rs.getString(Const.Team.COLUMN_MEMBERS));
		if (array != null) {
			bean.setMembers(array.toJavaList(MemberVO.class));
		}
		return bean;
	}
}
