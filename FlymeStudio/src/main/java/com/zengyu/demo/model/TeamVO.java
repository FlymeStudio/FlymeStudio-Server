package com.zengyu.demo.model;

import java.util.List;

public class TeamVO {
	/**
	 * 团队编号，最大11位
	 */
	private int id;

	/**
	 * 团队名称，最大8位
	 */
	private String name;

	/**
	 * 创建人电话，11位
	 */
	private int tel;

	/**
	 * 团队成员
	 */
	private List<MemberVO> members;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int getTel() {
		return tel;
	}

	public void setMembers(List<MemberVO> members) {
		this.members = members;
	}

	public List<MemberVO> getMembers() {
		return members;
	}
}