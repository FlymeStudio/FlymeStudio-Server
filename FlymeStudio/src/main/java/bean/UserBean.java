package bean;

import org.springframework.beans.factory.annotation.Autowired;

public class UserBean {
	/**
	 * 用户电话，11位
	 */
	@Autowired
	private int tel;
	
	/**
	 * 用户姓名，最大4位
	 */
	@Autowired
	private String name;
	
	/**
	 * 用户邮箱，最大32位
	 */
	@Autowired
	private String email;
	
	/**
	 * 用户密码，最大8位
	 */
	@Autowired
	private String password;

	public int getTel() {
		return tel;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}
