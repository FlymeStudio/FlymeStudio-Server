package bean;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;

public class TeamBean {
	/**
	 * 团队编号，最大11位
	 */
	@Autowired
	private int id;
	
	/**
	 * 团队名称，最大8位
	 */
	@Autowired
	private String name;

	/**
	 * 创建人电话，11位
	 */
	@Autowired
	private int tel;
	
	/**
	 * 团队成员
	 */
	@Autowired
	private JSONObject members;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getTel() {
		return tel;
	}
	
	public JSONObject getMembers() {
		return members;
	}
}
