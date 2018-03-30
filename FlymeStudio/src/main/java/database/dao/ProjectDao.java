package database.dao;

import javax.sql.DataSource;

public interface ProjectDao {
	void setDataSource(DataSource dataSource);

	void get(String tel);

	void create(String tel, String type, String date, String title, String content, String plans);

	void search(String type, String data, String title, String content, String plans);

	void modify(String tel, String id, String type, String date, String title, String content, String plans);

	void delete(String tel, String id);
}
