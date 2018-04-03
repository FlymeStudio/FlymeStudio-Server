package com.zengyu.flymestudio.model;

public class MemberVO {
	/**
	 * 成员电话，11位
	 */
	private int tel;

	/**
	 * 成员姓名，最大4位
	 */
	private String name;

	/**
	 * 成员邮箱，最大32位
	 */
	private String email;

	/**
	 * 成员权限，1位
	 */
	private int permission;

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

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public int getPermission() {
		return permission;
	}
}
