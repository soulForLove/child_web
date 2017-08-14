package com.lzt.asyn.sysmgr.model;

import java.io.Serializable;

import com.lzt.asyn.common.model.PageBean;

public class News extends PageBean implements Serializable {
	private Long newsId;
	private String title;
	private String detail;
	private int newstype;//1:教育资讯，2：活动资讯，3：体育资讯，4：营养资讯，5：阅读资讯，6：热点资讯
	private String publisher;// 发布者
	private String time;// 发布时间
	private Integer audit;//0:新增审核 1：审核已通过  2：审核未通过  3：被举报
	public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}

	/*private List<String> imgUrlList;//图片信息

	public List<String> getImgUrlList() {
		return imgUrlList;
	}

	public void setImgUrlList(List<String> imgUrlList) {
		this.imgUrlList = imgUrlList;
	}*/

	
	
	public Long getNewsId() {
		return newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
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

	public int getNewstype() {
		return newstype;
	}

	public void setNewstype(int newstype) {
		this.newstype = newstype;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
