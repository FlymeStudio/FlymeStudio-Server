package com.zengyu.demo.model;

public class PlanVO {
	/**
	 * 计划编号
	 */
	private int id;

	/**
	 * 计划标签，最大8位
	 */
	private String tag;

	/**
	 * 计划目标，最大32位
	 */
	private String goal;

	/**
	 * 计划完成度
	 */
	private int percent;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTag() {
		return tag;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getGoal() {
		return goal;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public int getPercent() {
		return percent;
	}
}
