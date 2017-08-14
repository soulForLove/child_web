package com.lzt.asyn.sysmgr.model;

import java.io.Serializable;
import java.util.List;
import com.lzt.asyn.common.model.PageBean;

public class Book extends PageBean implements Serializable {
	private Long bookId;
	private String bookName;
	private Double bookPrice;
	private String summary;
	private String publishInfo;
	private String link;

	private List<String> imgUrlList;//图片信息

	public List<String> getImgUrlList() {
		return imgUrlList;
	}

	public void setImgUrlList(List<String> imgUrlList) {
		this.imgUrlList = imgUrlList;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getPublishInfo() {
		return publishInfo;
	}

	public void setPublishInfo(String publishInfo) {
		this.publishInfo = publishInfo;
	}



	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
