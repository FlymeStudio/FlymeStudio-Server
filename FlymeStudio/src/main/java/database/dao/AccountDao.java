package database.dao;

import javax.sql.DataSource;

public interface AccountDao {
	void setDataSource(DataSource dataSource);
	
	void signIn(String id, String password);

	void signUp(String name, String tel, String email, String password);

	void signOut(String tel);

	void retrieve(String name, String tel, String email);
}
