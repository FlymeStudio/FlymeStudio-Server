package bean;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;

public class ProjectBean {
	/**
	 * 任务编号，最大11位
	 */
	@Autowired
	private int id;

	/**
	 * 创建人电话，11位
	 */
	@Autowired
	private int tel;

	/**
	 * 任务类型，1位
	 */
	@Autowired
	private int type;

	/**
	 * 任务日期
	 */
	@Autowired
	private Date date;

	/**
	 * 任务标题，最大16位
	 */
	@Autowired
	private String title;

	/**
	 * 任务描述
	 */
	@Autowired
	private String content;

	/**
	 * 任务计划
	 */
	@Autowired
	private JSONObject plans;

	public int getId() {
		return id;
	}

	public int getTel() {
		return tel;
	}

	public int getType() {
		return type;
	}

	public Date getDate() {
		return date;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public JSONObject getPlans() {
		return plans;
	}
}
