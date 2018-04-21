package com.zengyu.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
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

	public int addTeam(String name, int userId) {
		List<MemberVO> members = new ArrayList<MemberVO>();
		MemberVO memberVO = new MemberVO();
		memberVO.setId(userId);
		memberVO.setPermission(2);
		members.add(memberVO);
		try {
			String membersString = JSON.toJSONString(members);
			String SQL = "insert into " + Const.Team.TABLE_NAME + " values(?,?,?,?)";
			return jdbcTemplate.update(SQL, null, name, userId, membersString);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteTeam(int teamId) {
		String SQL = "delete from " + Const.Team.TABLE_NAME + " where " + Const.Team.COLUMN_ID + " = ?";
		try {
			return jdbcTemplate.update(SQL, teamId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public TeamVO queryTeamById(int teamId) {
		String SQL = "select * from " + Const.Team.TABLE_NAME + " where " + Const.Team.COLUMN_ID + " = ?";
		try {
			return jdbcTemplate.queryForObject(SQL, new TeamMapper(), teamId);
		} catch (EmptyResultDataAccessException e) {
			// TODO
		} catch (IncorrectResultSizeDataAccessException e) {
			// TODO
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public TeamVO queryTeamByName(int userId, String name) {
		String SQL = "select * from " + Const.Team.TABLE_NAME + " where " + Const.Team.COLUMN_USER_ID + " = ? and "
				+ Const.Team.COLUMN_NAME + " = ?";
		try {
			return jdbcTemplate.queryForObject(SQL, new TeamMapper(), userId, name);
		} catch (EmptyResultDataAccessException e) {
			// TODO
		} catch (IncorrectResultSizeDataAccessException e) {
			// TODO
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TeamVO> queryTeams(int userId) {
		String SQL = "select * from " + Const.Team.TABLE_NAME + " where " + Const.Team.COLUMN_USER_ID + " = ?";
		try {
			return jdbcTemplate.query(SQL, new TeamMapper(), userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TeamVO> queryTeamsByIdOrName(String content) {
		String SQL = "select * from " + Const.Team.TABLE_NAME + " where " + Const.Team.COLUMN_ID + " = ? or "
				+ Const.Team.COLUMN_NAME + " = ?";
		try {
			return jdbcTemplate.query(SQL, new TeamMapper(), content, content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int addTeamMember(int teamId, int userId) {
		TeamVO teamVO = queryTeamById(teamId);
		if (teamVO != null) {
			MemberVO memberVO = new MemberVO();
			memberVO.setId(userId);
			memberVO.setPermission(0);
			for (int i = 0; i < teamVO.getMembers().size(); i++) {
				if (teamVO.getMembers().get(i).getId() == userId) {
					return 0;
				}
			}
			teamVO.getMembers().add(memberVO);
			try {
				String membersString = JSON.toJSONString(teamVO.getMembers());
				String SQL = "update " + Const.Team.TABLE_NAME + " set " + Const.Team.COLUMN_MEMBERS + " = ? where "
						+ Const.Team.COLUMN_ID + " = ?";
				return jdbcTemplate.update(SQL, membersString, teamId);
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int updateMemberPermission(int teamId, int userId, int permission) {
		TeamVO teamVO = queryTeamById(teamId);
		if (teamVO != null) {
			for (int i = 0; i < teamVO.getMembers().size(); i++) {
				if (teamVO.getMembers().get(i).getId() == userId) {
					teamVO.getMembers().get(i).setPermission(permission);
					break;
				}
			}
			try {
				String membersString = JSON.toJSONString(teamVO.getMembers());
				String SQL = "update " + Const.Team.TABLE_NAME + " set " + Const.Team.COLUMN_MEMBERS + " = ? where "
						+ Const.Team.COLUMN_ID + " = ?";
				return jdbcTemplate.update(SQL, membersString, teamId);
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int deleteTeamMember(int teamId, int userId) {
		TeamVO teamVO = queryTeamById(teamId);
		if (teamVO != null) {
			for (int i = 0; i < teamVO.getMembers().size(); i++) {
				if (teamVO.getMembers().get(i).getId() == userId) {
					teamVO.getMembers().remove(i);
					break;
				}
			}
			try {
				String membersString = JSON.toJSONString(teamVO.getMembers());
				String SQL = "update " + Const.Team.TABLE_NAME + " set " + Const.Team.COLUMN_MEMBERS + " = ? where "
						+ Const.Team.COLUMN_ID + " = ?";
				return jdbcTemplate.update(SQL, membersString, teamId);
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}
