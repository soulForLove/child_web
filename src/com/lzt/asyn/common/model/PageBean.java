
package com.lzt.asyn.common.model;


public class PageBean {

	private int page = 1; // 当前页
	private int rows = 20;// 每页记录数
	private int beginRowNum;
	// private int endRowNum;

	// 初始化首记录索引
	private void initBeginRowNum() {
		this.beginRowNum = rows * (page - 1);
	}

	public void setPage(int page) {
		this.page = page;
		initBeginRowNum();
	}

	public void setRows(int rows) {
		this.rows = rows;
		initBeginRowNum();
	}

	public int getPage() {
		return page;
	}

	public int getRows() {
		return rows;
	}

	public int getBeginRowNum() {
		return beginRowNum;
	}

	public void setBeginRowNum(int beginRowNum) {
		this.beginRowNum = beginRowNum;
	}

}
