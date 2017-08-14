package com.lzt.asyn.sysmgr.model;

import java.io.Serializable;

import com.lzt.asyn.common.model.PageBean;

public class Discuss extends PageBean implements Serializable {
	private Long discussId;
	private Long newsId;
	private Long userId;
	private String detail;
	private String discusstime;
	private String ip;
	
	private int newstype;
	private String userName;
	private Integer audit;
	
	public Integer getAudit() {
		return audit;
	}
	public void setAudit(Integer audit) {
		this.audit = audit;
	}
	public int getNewstype() {
		return newstype;
	}
	public void setNewstype(int newstype) {
		this.newstype = newstype;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getDiscussId() {
		return discussId;
	}
	public void setDiscussId(Long discussId) {
		this.discussId = discussId;
	}
	public Long getNewsId() {
		return newsId;
	}
	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public String getDiscusstime() {
		return discusstime;
	}
	public void setDiscusstime(String discusstime) {
		this.discusstime = discusstime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
