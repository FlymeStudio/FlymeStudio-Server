package com.zengyu.demo.model;

import java.io.Serializable;
import java.util.List;

/**
 * 任务持久层
 * 
 * @author zengyu
 *
 */
public class ProjectVO implements Serializable {
	private static final long serialVersionUID = 8320958010304016149L;

	/**
	 * 任务编号，数据库递增产生
	 */
	private int id;

	/**
	 * 创建人电话，11位
	 */
	private String tel;

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
	private long date;

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

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel() {
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

	public void setPlans(List<PlanVO> plans) {
		this.plans = plans;
	}

	public List<PlanVO> getPlans() {
		return plans;
	}
}
