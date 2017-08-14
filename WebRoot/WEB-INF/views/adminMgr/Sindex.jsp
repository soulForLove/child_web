<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="com.lzt.asyn.sysmgr.model.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<title>少儿资讯管理后台</title>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
  <head>
    
<style>
	/** 重写bootstrap */
	.container-fluid{padding: 0px 3px 0px 3px;}
	.navbar-fixed-top{/* position:static; */}
	.navbar-header{padding-left: 33px;width: 180px;}
	/** 自定义 */
	body{padding-bottom: 70px;}
	#header{margin-bottom: 3px;}
	#content{margin-top:50px;}
	.sidebar .sidebar-nav.navbar-collapse {padding-right: 0; padding-left: 0;}
	.sidebar .sidebar-search {padding: 15px;}
	.sidebar ul li {border-bottom: 1px solid #e7e7e7;}
	.sidebar ul li a.active {background-color: #eee;}
	.sidebar .arrow {float: right;}
	.sidebar .fa.arrow:before { content: "\f104";}
	.sidebar .active>a>.fa.arrow:before {content: "\f107";}
	.sidebar .nav-2-level li,.sidebar .nav-3-level li {border-bottom: 0!important;}
	.sidebar .nav-2-level li a {padding-left: 37px;}
	.sidebar .nav-3-level li a {padding-left: 52px;}
	@media(min-width:768px) {
	    #left  {position: absolute; width: 180px;margin-top: 3px;z-index: 1;}
		#right {position: inherit; margin-left:186px;padding: 5px;border-left: 1px solid #e7e7e7;}
	    .navbar-top-links .dropdown-messages,
	    .navbar-top-links .dropdown-tasks,
	    .navbar-top-links .dropdown-alerts {margin-left: auto;}
	}
	#openClose {position: absolute;width:6px;height:100%;margin-left:180px;cursor:pointer;background:silver;}
</style>
	<script src="${ctx}/static/metismenu/2.0.3/metisMenu.min.js" type="text/javascript"></script>
	<script type="text/javascript">
	var ctx = '${ctx}';
	$(function() {
		console.log("index"+$(window).height());
		$("#mainFrame").css('height',$(window).height()-100);
		// 一级菜单
		$("#menuTop a").click(function() {
			$("#menuTop li").removeClass("active");
			$(this).parent().addClass("active");
		});
		
		//初始化菜单
		eval('var nodes = ${menuList};');
		var menuHtml = "";
		for(var i=0;i<nodes.length;i++){
			menuHtml += getMenuHtmlCascade(nodes[i],1);
		}
		$('#side-menu').append(menuHtml).metisMenu();
	});	
	
	function getMenuHtmlCascade(node,level){
		var hasChild = node.children && node.children.length>0; 
		var html = '<li><a '+(node.url==''?'href="#"':'href="'+ctx+node.url+'" target="mainFrame"')+'><i class="fa '+node.icon +'"></i>'+node.name+(hasChild?'<i class="fa arrow"></i>':'')+'</a>';
			if(hasChild){
				html+='<ul class="nav nav-'+(level+1)+'-level collapse">';
				for(var i=0;i<node.children.length;i++){
					html+=getMenuHtmlCascade(node.children[i], level+1);
				}
				html+='</ul>';
			}
			html+= '</li>';
		return html;
	}
	</script>
  </head>
  
  <body>
  	<div id="main">
		<div id="header" role="navigation" class="navbar navbar-default navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">少儿资讯平台</a>
				</div>
				<div class="collapse navbar-collapse">
					<ul id="menuTop" class="nav navbar-nav">
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
						<%
						SuperAdmin admin = (SuperAdmin) request.getSession().getAttribute("loginSAdmin");
						%>
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button">
								<i class="fa fa-user"></i>您好, <%=admin.getAdminName()%><span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li><a href="${ctx}/Sindex/updateInfoFace" target="mainFrame">个人信息</a></li>
								<li><a href="${ctx}/Sindex/updatePwdFace" target="mainFrame">修改密码</a></li><!-- 怎样取得id传过去 -->
								<li role="separator" class="divider"></li>
								<li><a href="${ctx}/login">注销</a></li>
							</ul>
						</li>
						<li>&nbsp;&nbsp;&nbsp;</li>
					</ul>
				</div>
			</div>
		</div>
		<div id="content" class="container-fluid">
			<div class="row-fluid">
				<div id="left" class="sidebar">
					<div class="sidebar-nav navbar-collapse">
						<ul class="nav in" id="side-menu">
						</ul>
					</div>

				</div>
				<!-- <div id="openClose" class="close">&nbsp;</div> --><!-- 分界线 -->
				<div id="right">
					<iframe id="mainFrame" name="mainFrame" src="${ctx}/Sindex/SnewsMgr" style="overflow: visible;" scrolling="yes" frameborder="no" width="100%" height="600"></iframe>
				</div>
			</div>
		</div>
	</div>
	<nav class="navbar navbar-default navbar-fixed-bottom">
	  <div class="container text-center" style="margin-top:10px">
			Copyright © 2015 <a href="#">Linzhongtai</a> All Rights Reserved.</p>
	  </div>
	</nav>
  </body>
</html>
