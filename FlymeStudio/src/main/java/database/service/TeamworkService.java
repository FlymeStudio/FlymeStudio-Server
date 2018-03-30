package database.service;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import database.dao.TeamworkDao;

public class TeamworkService implements TeamworkDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);

	}

	public void getTeamInfo(String id) {
		// TODO Auto-generated method stub

	}

	public void replyMsg(String tel, String messageId, boolean result) {
		// TODO Auto-generated method stub

	}

	public void viewTeams(String tel) {
		// TODO Auto-generated method stub

	}

	public void searchUser(String tel, String content) {
		// TODO Auto-generated method stub

	}

	public void invite(String tel, String toTel, String teamId) {
		// TODO Auto-generated method stub

	}

	public void disband(String tel, String teamId) {
		// TODO Auto-generated method stub

	}

	public void viewMemberProjects(String tel, String memberTel) {
		// TODO Auto-generated method stub

	}

	public void viewMemberSummaries(String tel, String memberTel) {
		// TODO Auto-generated method stub

	}

	public void setPermission(String tel, String memberTel, String teamId, int permission) {
		// TODO Auto-generated method stub

	}

	public void remove(String tel, String memberTel, String teamId) {
		// TODO Auto-generated method stub

	}

	public void searchTeam(String tel, String content) {
		// TODO Auto-generated method stub

	}

	public void join(String tel, String teamId) {
		// TODO Auto-generated method stub

	}

	public void create(String tel, String name) {
		// TODO Auto-generated method stub

	}

}
