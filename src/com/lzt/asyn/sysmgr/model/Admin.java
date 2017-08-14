package com.lzt.asyn.sysmgr.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.lzt.asyn.common.model.PageBean;

public class Admin extends PageBean implements Serializable {
	private Long adminId; // 用户标识
	private String loginName; // 登录名或工号
	private String tel; // 手机号
	private String email; // Email
	private String password; // 密码 MD5加密
	private String adminName; // 姓名

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
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
