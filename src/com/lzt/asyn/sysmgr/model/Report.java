package com.lzt.asyn.sysmgr.model;

import java.io.Serializable;

import com.lzt.asyn.common.model.PageBean;

public class Report extends PageBean implements Serializable {
	private Long reportId;
	private Long userId;//举报人
	private Long NewsId;//被举报资讯
	private String detail;//举报内容
	private String time;//举报时间
	private String ip;
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Long getReportId() {
		return reportId;
	}
	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getNewsId() {
		return NewsId;
	}
	public void setNewsId(Long newsId) {
		NewsId = newsId;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
