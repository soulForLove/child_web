package com.lzt.asyn.sysmgr.model;

import java.io.Serializable;

import com.lzt.asyn.common.model.PageBean;

public class History extends PageBean implements Serializable{
	private Long hisId;
	private Long userId;
	private Long newsId;
	private String time;
	private String loginIp;
	private String detail;
	private Integer type;//0：浏览记录   1：留言记录   
	private String userName;//用户名
	private String title;//资讯标题
	private String newstype;//资讯类别
	
	
	public String getNewstype() {
		return newstype;
	}
	public void setNewstype(String newstype) {
		this.newstype = newstype;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Long getHisId() {
		return hisId;
	}
	public void setHisId(Long hisId) {
		this.hisId = hisId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getNewsId() {
		return newsId;
	}
	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	
}
