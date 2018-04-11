package com.zengyu.demo.others;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

/**
 * 统一响应对象
 * 
 * @author zengyu
 *
 */
public class ResponseObject extends JSONObject {
	private static final long serialVersionUID = -976860431515213703L;

	public ResponseObject() {
		this.put("result", false);
	}

	/**
	 * 设置响应结果
	 * 
	 * @param result
	 *            响应结果
	 */
	public void setResult(boolean result) {
		this.put("result", result);
	}

	/**
	 * 设置响应数据
	 * 
	 * @param data
	 *            响应数据
	 */
	public void setData(Serializable data) {
		this.put("data", data);
		this.put("result", true);
	}
}
