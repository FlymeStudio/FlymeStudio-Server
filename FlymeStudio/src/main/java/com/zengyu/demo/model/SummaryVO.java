package com.zengyu.demo.model;

import java.io.Serializable;

/**
 * 总结持久层
 * 
 * @author zengyu
 *
 */
public class SummaryVO implements Serializable {
	private static final long serialVersionUID = 4644202001280685491L;

	/**
	 * 任务编号，数据库递增产生
	 */
	private int id;

	/**
	 * 创建人编号
	 */
	private int userId;

	/**
	 * 总结类型，1位
	 */
	private int type;

	/**
	 * 总结日期
	 */
	private long date;

	/**
	 * 总结标题，最大16位
	 */
	private String title;

	/**
	 * 总结描述
	 */
	private String content;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setUserId(int user) {
		this.userId = user;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public long getDate() {
		return date;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}
