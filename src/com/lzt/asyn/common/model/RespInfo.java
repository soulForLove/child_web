
package com.lzt.asyn.common.model;


public class RespInfo {

	private boolean success = true;
	private String msg = "";

	@Override
	public String toString() {
		return "{\"success\":" + success + ",\"msg\":\"" + msg + "\"}";
	}

	public RespInfo() {
		super();
	}

	public RespInfo(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
