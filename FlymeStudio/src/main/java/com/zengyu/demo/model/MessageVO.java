package com.zengyu.demo.model;

import java.io.Serializable;

/**
 * 消息持久层
 * 
 * @author zengyu
 *
 */
public class MessageVO implements Serializable {
	private static final long serialVersionUID = -7123198805901902968L;

	/**
	 * 消息编号，数据库递增产生
	 */
	private int id;

	/**
	 * 消息类型，1位
	 */
	private int type;

	/**
	 * 发送人编号
	 */
	private int senderId;

	/**
	 * 接收人编号
	 */
	private int recieverId;

	/**
	 * 团队编号
	 */
	private int teamId;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setRecieverId(int recieverId) {
		this.recieverId = recieverId;
	}

	public int getRecieverId() {
		return recieverId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getTeamId() {
		return teamId;
	}
}
