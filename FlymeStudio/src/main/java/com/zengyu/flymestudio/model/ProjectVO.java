package com.zengyu.flymestudio.model;

import java.sql.Date;
import java.util.List;

public class ProjectVO {
	/**
	 * 任务编号，最大11位
	 */
	private int id;

	/**
	 * 创建人电话，11位
	 */
	private int tel;

	/**
	 * 任务完成度
	 */
	private int percent;

	/**
	 * 任务类型，1位
	 */
	private int type;

	/**
	 * 任务日期
	 */
	private Date date;

	/**
	 * 任务标题，最大16位
	 */
	private String title;

	/**
	 * 任务描述
	 */
	private String content;

	/**
	 * 任务计划
	 */
	private List<PlanVO> plans;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int getTel() {
		return tel;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public int getPercent() {
		return percent;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
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

	public void setPlans(List<PlanVO> plans) {
		this.plans = plans;
	}

	public List<PlanVO> getPlans() {
		return plans;
	}
}
