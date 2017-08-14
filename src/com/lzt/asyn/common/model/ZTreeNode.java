
package com.lzt.asyn.common.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZTreeNode {

	private Long pid;
	private Long id;
	private String name;
	private boolean checked = false;
	private boolean isParent = false;
	private List<ZTreeNode> children;
	private String url;
	private String icon;

	public ZTreeNode() {
		super();
	}

	public ZTreeNode(Long pid, Long id, String name) {
		super();
		this.pid = pid;
		this.id = id;
		this.name = name;
	}

	// 角色分配权限
	public ZTreeNode(Long pid, Long id, String name, boolean checked) {
		super();
		this.pid = pid;
		this.id = id;
		this.name = name;
		this.checked = checked;
	}

	// 主页菜单展示
	public ZTreeNode(Long pid, Long id, String name, String url, String icon) {
		super();
		this.pid = pid;
		this.id = id;
		this.name = name;
		this.url = url;
		this.icon = icon;
	}
	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	@JsonProperty(value = "isParent")
	public boolean isParent() {
		return isParent;
	}

	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}

	public List<ZTreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<ZTreeNode> children) {
		this.children = children;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
