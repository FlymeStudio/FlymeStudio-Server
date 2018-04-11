package com.zengyu.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.zengyu.demo.model.MemberVO;
import com.zengyu.demo.model.TeamMapper;
import com.zengyu.demo.model.TeamVO;
import com.zengyu.demo.others.Const;

/**
 * 团队访问层
 * 
 * @author zengyu
 *
 */
@Repository(value = "teamDao")
public class TeamImpl extends AbstractImpl implements TeamDao {

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

	public int deleteTeam(int id) {
		String SQL = "delete from " + Const.Team.TABLE_NAME + " where " + Const.Team.COLUMN_ID + " = ?";
		return jdbcTemplate.update(SQL, id);
	}

	public TeamVO queryTeamById(int id) {
		String SQL = "select * from " + Const.Team.TABLE_NAME + " where " + Const.Team.COLUMN_ID + " = ?";
		TeamVO teamVO = null;
		try {
			teamVO = jdbcTemplate.queryForObject(SQL, new TeamMapper(), id);
		} catch (EmptyResultDataAccessException e) {
			// TODO
		} catch (IncorrectResultSizeDataAccessException e) {
			// TODO
		}
		return teamVO;
	}

	public TeamVO queryTeamByName(String tel, String name) {
		String SQL = "select * from " + Const.Team.TABLE_NAME + " where " + Const.Team.COLUMN_TEL + " = ? and "
				+ Const.Team.COLUMN_NAME + " = ?";
		TeamVO teamVO = null;
		try {
			teamVO = jdbcTemplate.queryForObject(SQL, new TeamMapper(), tel, name);
		} catch (EmptyResultDataAccessException e) {
			// TODO
		} catch (IncorrectResultSizeDataAccessException e) {
			// TODO
		}
		return teamVO;
	}

	public List<TeamVO> queryTeams(String tel) {
		String SQL = "select * from " + Const.Team.TABLE_NAME + " where " + Const.Team.COLUMN_TEL + " = ?";
		return jdbcTemplate.query(SQL, new TeamMapper(), tel);
	}

	public List<TeamVO> queryTeamsByIdOrName(String content) {
		String SQL = "select * from " + Const.Team.TABLE_NAME + " where " + Const.Team.COLUMN_ID + " = ? or "
				+ Const.Team.COLUMN_NAME + " like %?%";
		return jdbcTemplate.query(SQL, new TeamMapper(), content, content);
	}

	public int addTeamMember(String tel, int id) {
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
				+ Const.Team.COLUMN_ID + " = ?";
		return jdbcTemplate.update(SQL, membersString, id);
	}

	public int updateMemberPermission(String tel, int id, int permission) {
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

	public int deleteTeamMember(String tel, int id) {
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
