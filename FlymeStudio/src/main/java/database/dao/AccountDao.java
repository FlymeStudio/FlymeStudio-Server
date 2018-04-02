package database.dao;

import com.alibaba.fastjson.JSONObject;

public interface AccountDao {
	JSONObject signIn(String id, String password);

	boolean signUp(String name, String tel, String email, String password);

	boolean signOut(String tel);

	boolean retrieve(String name, String tel, String email);
}
