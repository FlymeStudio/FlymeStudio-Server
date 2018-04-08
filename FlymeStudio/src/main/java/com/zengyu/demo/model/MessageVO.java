package com.zengyu.demo.model;

public class MessageVO{
	/**
	 * 消息编号，数据库递增产生
	 */
	private int id;

	/**
	 * 消息类型，1位
	 */
	private int type;

	/**
	 * 发送人电话，11位
	 */
	private String sender;

	/**
	 * 接收人电话，11位
	 */
	private String reciever;

	/**
	 * 团队编号，数据库递增产生
	 */
	private int teamid;

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

	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getSender() {
		return sender;
	}

	public void setReciever(String reciever) {
		this.reciever = reciever;
	}
	
	public String getReciever() {
		return reciever;
	}

	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}
	
	public int getTeamid() {
		return teamid;
	}
}
