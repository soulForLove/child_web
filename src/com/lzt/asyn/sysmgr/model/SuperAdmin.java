package com.lzt.asyn.sysmgr.model;

import java.io.Serializable;

import com.lzt.asyn.common.model.PageBean;

public class SuperAdmin extends PageBean implements Serializable {
	private Long superAdminId; // 用户标识
	private String loginName; // 登录名或工号
	private String tel; // 手机号
	private String email; // Email
	private String password; // 密码 MD5加密
	private String adminName; // 姓名

	
	public Long getSuperAdminId() {
		return superAdminId;
	}

	public void setSuperAdminId(Long superAdminId) {
		this.superAdminId = superAdminId;
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

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	

}
