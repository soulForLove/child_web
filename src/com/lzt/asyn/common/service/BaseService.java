package com.lzt.asyn.common.service;

import java.util.List;
public abstract class BaseService<T> {

	/**
	 * 数据字典翻译
	 */
	protected void translate(List<T> list) {
		if (list != null) {
			for (T obj : list) {
				translate(obj);
			}
		}
	}

	/**
	 * 数据字典翻译
	 */
	protected abstract void translate(T obj);

}
