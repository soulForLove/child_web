package com.lzt.asyn.sysmgr.model;

import java.io.Serializable;

import com.lzt.asyn.common.model.PageBean;

public class User extends PageBean implements Serializable {
	private Long userId; // 用户标识
	private String loginName; // 登录名
	private String tel; // 手机号
	private String email; // Email
	private String password; // 密码 
	private String userName; // 姓名

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
