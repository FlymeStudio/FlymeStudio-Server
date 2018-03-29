package database.dao;

public interface AccountDao {
	void signIn(String id, String password);

	void signUp(String name, String tel, String email, String password);

	void signOut(String tel);

	void retrieve(String name, String tel, String email);
}
