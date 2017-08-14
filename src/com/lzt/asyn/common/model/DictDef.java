package com.lzt.asyn.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DictDef {

	private String entryId; // 条目标识
	private String entryName; // 条目名称
	private String parentEntryId; // 父条目标识
	private Integer dictType; // 字典类型
	private Integer dictClass; // 字典类别
	@JsonIgnore
	private String entryDesc; // 条目描述
	@JsonIgnore
	private String entryDesc2;

	public Integer getDictType() {
		return dictType;
	}

	public void setDictType(Integer dictType) {
		this.dictType = dictType;
	}

	public Integer getDictClass() {
		return dictClass;
	}

	public void setDictClass(Integer dictClass) {
		this.dictClass = dictClass;
	}

	public String getEntryId() {
		return entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public String getEntryDesc() {
		return entryDesc;
	}

	public void setEntryDesc(String entryDesc) {
		this.entryDesc = entryDesc;
	}

	public String getEntryDesc2() {
		return entryDesc2;
	}

	public void setEntryDesc2(String entryDesc2) {
		this.entryDesc2 = entryDesc2;
	}

	public String getParentEntryId() {
		return parentEntryId;
	}

	public void setParentEntryId(String parentEntryId) {
		this.parentEntryId = parentEntryId;
	}

}
