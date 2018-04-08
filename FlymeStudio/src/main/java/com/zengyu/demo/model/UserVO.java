package com.zengyu.demo.model;

import java.util.List;

public class UserVO {
	/**
	 * 用户电话，11位
	 */
	private String tel;

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

	/**
	 * 用户消息
	 */
	private List<MessageVO> messages;

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel() {
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

	public void setMessages(List<MessageVO> messages) {
		this.messages = messages;
	}

	public List<MessageVO> getMessages() {
		return messages;
	}
}
