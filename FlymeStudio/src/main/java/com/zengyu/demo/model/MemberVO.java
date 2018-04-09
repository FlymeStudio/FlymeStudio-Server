package com.zengyu.demo.model;

public class MemberVO {
	/**
	 * 成员电话，11位
	 */
	private String tel;

	/**
	 * 成员权限，1位
	 */
	private int permission;

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel() {
		return tel;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public int getPermission() {
		return permission;
	}
}
