package com.lzt.asyn.sysmgr.model;

import java.io.Serializable;
import java.util.List;

import com.lzt.asyn.common.model.PageBean;

public class Adver extends PageBean implements Serializable {
	private Long adverId;
	private Long bookId;
	private String title;
	private String link;
	private List<String> imgUrlList;// 图片信息
	private String bookName;
	private Integer audit;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public List<String> getImgUrlList() {
		return imgUrlList;
	}

	public void setImgUrlList(List<String> imgUrlList) {
		this.imgUrlList = imgUrlList;
	}

	public Long getAdverId() {
		return adverId;
	}

	public void setAdverId(Long adverId) {
		this.adverId = adverId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
