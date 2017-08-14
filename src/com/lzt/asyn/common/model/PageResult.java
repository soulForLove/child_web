package com.lzt.asyn.common.model;

import java.util.List;

public class PageResult<T> {

	protected Long total;
	protected List<T> rows;
	
	public PageResult() {
		super();
	}

	public PageResult(Long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
