package com.zengyu.demo.model;

import java.io.Serializable;

/**
 * 团队成员持久层
 * 
 * @author zengyu
 *
 */
public class MemberVO implements Serializable {
	private static final long serialVersionUID = 3192970041482110048L;

	/**
	 * 成员编号
	 */
	private int id;

	/**
	 * 成员权限，1位
	 */
	private int permission;

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public int getPermission() {
		return permission;
	}
}
