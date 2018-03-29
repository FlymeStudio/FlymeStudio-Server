package database.dao;

public interface ProjectDao {
	void get(String tel);

	void create(String tel, String type, String date, String title, String content, String plans);

	void search(String type, String data, String title, String content, String plans);

	void modify(String tel, String timestamp, String type, String date, String title, String content, String plans);

	void delete(String tel, String timestamp);
}
