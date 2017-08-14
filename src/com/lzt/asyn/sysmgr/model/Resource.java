
package com.lzt.asyn.sysmgr.model;

public class Resource {

	private Integer resId; // 资源标识
	private String resName; // 资源名称
	private Integer parentRes; // 父资源 根节点没有父资源为-1
	private Integer resLevel; // 级别，从1开始
	private Integer resType; // 资源类型： 1.菜单，2.url，3.按钮，5.Portlet
	private String resIndex; // 资源序列，用于排序 一个级别两位，最大支持8层级别
	private String resTarget; // 目标地址： 如菜单URL
	private Integer isLeaf; // 是否叶子 0.非叶子 1.叶子
	private String iconSmall; // 小图标地址
	private String iconLarge; // 大图标地址
	private String styleClass; // 样式
	private Integer isShortcut = 0; // 是否快捷菜单
	private Integer status; // 状态 1.正常 0.失效
	private String resDesc; // 资源描述
	private String createTime;

	private short authorized;// 是否授权,给角色分配极限时打勾用

	public short getAuthorized() {
		return authorized;
	}

	public void setAuthorized(short authorized) {
		this.authorized = authorized;
	}

	public Integer getResId() {
		return resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public Integer getParentRes() {
		return parentRes;
	}

	public void setParentRes(Integer parentRes) {
		this.parentRes = parentRes;
	}

	public Integer getResLevel() {
		return resLevel;
	}

	public void setResLevel(Integer resLevel) {
		this.resLevel = resLevel;
	}

	public Integer getResType() {
		return resType;
	}

	public void setResType(Integer resType) {
		this.resType = resType;
	}

	public String getResIndex() {
		return resIndex;
	}

	public void setResIndex(String resIndex) {
		this.resIndex = resIndex;
	}

	public String getResTarget() {
		return resTarget;
	}

	public void setResTarget(String resTarget) {
		this.resTarget = resTarget;
	}

	public Integer getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getIconSmall() {
		return iconSmall;
	}

	public void setIconSmall(String iconSmall) {
		this.iconSmall = iconSmall;
	}

	public String getIconLarge() {
		return iconLarge;
	}

	public void setIconLarge(String iconLarge) {
		this.iconLarge = iconLarge;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public Integer getIsShortcut() {
		return isShortcut;
	}

	public void setIsShortcut(Integer isShortcut) {
		this.isShortcut = isShortcut;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getResDesc() {
		return resDesc;
	}

	public void setResDesc(String resDesc) {
		this.resDesc = resDesc;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
