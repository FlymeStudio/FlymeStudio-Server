package database.dao;

import javax.sql.DataSource;

public interface InformationDao {
	void setDataSource(DataSource dataSource);

	void modify(String name, String tel, String email, String password);
}
