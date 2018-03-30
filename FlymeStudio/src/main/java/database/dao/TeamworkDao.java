package database.dao;

import javax.sql.DataSource;

public interface TeamworkDao {
	void setDataSource(DataSource dataSource);

	void getTeamInfo(String id);

	void replyMsg(String tel, String messageId, boolean result);

	void viewTeams(String tel);

	void searchUser(String tel, String content);

	void invite(String tel, String toTel, String teamId);

	void disband(String tel, String teamId);

	void viewMemberProjects(String tel, String memberTel);

	void viewMemberSummaries(String tel, String memberTel);

	void setPermission(String tel, String memberTel, String teamId, int permission);

	void remove(String tel, String memberTel, String teamId);

	void searchTeam(String tel, String content);

	void join(String tel, String teamId);

	void create(String tel, String name);
}
