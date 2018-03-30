package bean;

public class UserBean {
	/**
	 * 用户电话，11位
	 */
	private int tel;

	/**
	 * 用户姓名，最大4位
	 */
	private String name;

	/**
	 * 用户邮箱，最大32位
	 */
	private String email;

	/**
	 * 用户密码，最大8位
	 */
	private String password;

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int getTel() {
		return tel;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}
