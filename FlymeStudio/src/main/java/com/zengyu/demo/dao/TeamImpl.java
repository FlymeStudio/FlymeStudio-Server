package com.zengyu.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.fastjson.JSON;
import com.zengyu.demo.model.MemberVO;
import com.zengyu.demo.model.TeamMapper;
import com.zengyu.demo.model.TeamVO;
import com.zengyu.demo.others.Const;

public class TeamImpl extends AbstractImpl implements TeamDao {
	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int addTeam(String name, String tel) {
		if (queryTeamByName(tel, name) != null) {
			return 0;
		} else {
			List<MemberVO> members = new ArrayList<MemberVO>();
			MemberVO memberVO = new MemberVO();
			memberVO.setTel(tel);
			memberVO.setPermission(2);
			members.add(memberVO);
			String membersString = JSON.toJSONString(members);
			String SQL = "insert into " + Const.Team.TABLE_NAME + " values(?,?,?,?)";
			return jdbcTemplate.update(SQL, null, name, tel, membersString);
		}
	}

	public int deleteTeam(String id) {
		String SQL = "delete from " + Const.Team.TABLE_NAME + " where " + Const.Team.COLUMN_ID + " = ?";
		return jdbcTemplate.update(SQL, id);
	}

	public TeamVO queryTeamById(String id) {
		String SQL = "select * from " + Const.Team.TABLE_NAME + " where " + Const.Team.COLUMN_ID + " = ?";
		return jdbcTemplate.queryForObject(SQL, new TeamMapper(), id);
	}

	public TeamVO queryTeamByName(String tel, String name) {
		String SQL = "select * from " + Const.Team.TABLE_NAME + " where " + Const.Team.COLUMN_TEL + " = ? and "
				+ Const.Team.COLUMN_NAME + " = ?";
		return jdbcTemplate.queryForObject(SQL, new TeamMapper(), tel, name);
	}

	public List<TeamVO> queryTeams(String tel) {
		String SQL = "select * from " + Const.Team.TABLE_NAME + " where " + Const.Team.COLUMN_TEL + " = ?";
		return jdbcTemplate.query(SQL, new TeamMapper(), tel);
	}

	public int addTeamMember(String id, String tel) {
		TeamVO teamVO = queryTeamById(id);
		if (teamVO == null) {
			return 0;
		}
		MemberVO memberVO = new MemberVO();
		memberVO.setTel(tel);
		memberVO.setPermission(0);
		for (int i = 0; i < teamVO.getMembers().size(); i++) {
			if (teamVO.getMembers().get(i).getTel() == tel) {
				return 0;
			}
		}
		teamVO.getMembers().add(memberVO);
		String membersString = JSON.toJSONString(teamVO.getMembers());
		String SQL = "update " + Const.Team.TABLE_NAME + " set " + Const.Team.COLUMN_MEMBERS + " = ? where "
				+ Const.Team.COLUMN_TEL + " = ?";
		return jdbcTemplate.update(SQL, membersString, tel);
	}

	public int updateMemberPermission(String id, String tel, int permission) {
		TeamVO teamVO = queryTeamById(id);
		if (teamVO == null) {
			return 0;
		}
		for (int i = 0; i < teamVO.getMembers().size(); i++) {
			if (teamVO.getMembers().get(i).getTel() == tel) {
				teamVO.getMembers().get(i).setPermission(permission);
				break;
			}
		}
		String membersString = JSON.toJSONString(teamVO.getMembers());
		String SQL = "update " + Const.Team.TABLE_NAME + " set " + Const.Team.COLUMN_MEMBERS + " = ? where "
				+ Const.Team.COLUMN_TEL + " = ?";
		return jdbcTemplate.update(SQL, membersString, tel);
	}

	public int deleteTeamMember(String id, String tel) {
		TeamVO teamVO = queryTeamById(id);
		if (teamVO == null) {
			return 0;
		}
		for (int i = 0; i < teamVO.getMembers().size(); i++) {
			if (teamVO.getMembers().get(i).getTel() == tel) {
				teamVO.getMembers().remove(i);
				break;
			}
		}
		String membersString = JSON.toJSONString(teamVO.getMembers());
		String SQL = "update " + Const.Team.TABLE_NAME + " set " + Const.Team.COLUMN_MEMBERS + " = ? where "
				+ Const.Team.COLUMN_TEL + " = ?";
		return jdbcTemplate.update(SQL, membersString, tel);
	}

}
