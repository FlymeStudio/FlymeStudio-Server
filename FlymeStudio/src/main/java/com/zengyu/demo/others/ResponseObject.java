package com.zengyu.demo.others;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ResponseObject extends JSONObject {
	private static final long serialVersionUID = -976860431515213703L;

	public ResponseObject() {
		this.put("result", false);
	}

	public void setResult(boolean result) {
		this.put("result", result);
	}

	public void setData(JSONObject data) {
		this.put("data", data);
	}

	public void setData(JSONArray data) {
		this.put("data", data);
	}
}
