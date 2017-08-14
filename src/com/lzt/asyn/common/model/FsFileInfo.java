package com.lzt.asyn.common.model;

import java.io.Serializable;

public class FsFileInfo {

	private Integer id; // 文件ID
	private String uri; // 文件路径，格式如oss://xxx，file://xxx，http://xxx
	private String bizId; // 业务主键标识
	private Integer bizType; // 业务类型：1001资讯信息...(待扩展)

	public FsFileInfo() {
		super();
	}

	public FsFileInfo(String uri, Serializable bizId, Integer bizType) {
		super();
		this.uri = uri;
		this.bizId = String.valueOf(bizId);
		this.bizType = bizType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public Integer getBizType() {
		return bizType;
	}

	public void setBizType(Integer bizType) {
		this.bizType = bizType;
	}

}
