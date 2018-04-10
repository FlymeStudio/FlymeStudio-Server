package com.zengyu.demo.others;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

public class ResponseObject extends JSONObject {
	private static final long serialVersionUID = -976860431515213703L;

	public ResponseObject() {
		this.put("result", false);
	}

	public void setResult(boolean result) {
		this.put("result", result);
	}

	public void setData(Serializable data) {
		this.put("data", data);
		this.put("result", true);
	}
}
