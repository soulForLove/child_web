<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>少儿分类资讯网站</title>
<link rel="stylesheet" href="${ctx}/static/css/reset.css" />
<link rel="stylesheet" href="${ctx}/static/css/KidBookPlatForm.css" />
<link rel="stylesheet" href="${ctx}/static/css/detail.css" />
<script type="text/javascript" src="${ctx}/static/service/js/kefu.js"></script>
<link href="${ctx}/static/service/css/style.css" type="text/css"
	rel="stylesheet" />
<script src="${ctx}/static/jquery-plugins/jquery.page.js"
	type="text/javascript"></script>

</head>
<body>
	<div class="topbox">
		<c:if test="${loginuser==null}">
			<div id="loginbar" style="float: left;">
				&nbsp; 账户：<input type="text" id="loginName" name="loginName">
				密码：<input type="password" id="password" name="password">
				&nbsp;
				<button id="login">登录</button>
				<a href="${ctx}/Webuser/register">注册</a>
			</div>
		</c:if>
		<c:if test="${loginuser!=null}">
			<div id="loginDiv" style="float: left;">
				<b class='welcome'>${loginuser.userName },你好,欢迎登录！<a
					href="${ctx}/Webuser/personalCenter">个人中心</a>&nbsp;&nbsp;&nbsp;
				</b>
				<button class='exit'>退出</button>
			</div>
		</c:if>
		<div class="searchBar">
			<form action="${ctx}/Webnews/queryKeyWord" method="post">
				<input type="text" name="keyWord" id="keyWord" placeholder="标题关键词">
				<input type="submit" value="搜索">
			</form>
		</div>

	</div>
	<div class="header">
		<div class="headerbox">
			<div class="headerleft"></div>
			<div class="headerright">
				<img src="${ctx}/static/images/gdybs.jpg" alt="" />
			</div>
		</div>
	</div>
	<div class="nav">
		<div class="navbox">
			<ul class="topul">
				<li><a href="${ctx}/Webindex">新闻资讯</a></li>
				<li><a href="http://school.shuxiangw.com/" target="_blank">书香校园</a></li>
				<li><a href="http://www.shuxiangw.com/readingbase.aspx"
					target="_blank">阅读基地</a></li>
				<li><a href="http://shop.shuxiangw.com/" target="_blank">图书商城</a></li>
				<li><a href="http://www.shuxiangw.com/share.aspx"
					target="_blank">资源共享</a></li>
				<li><a href="http://bbs.shuxiangw.com/" target="_blank">会员论坛</a></li>
				<li><a
					href="http://www.shuxiangw.com/usercenter.aspx?action=index"
					target="_blank">会员专区</a></li>
				<li><a href="http://www.shuxiangw.com/about.aspx"
					target="_blank">关于我们</a></li>
			</ul>
		</div>
	</div>
	<div class="container">
		<div class="details">
			<div class="ad1">
				<img src="${ctx}/static/images/adone.jpg" alt="" />
			</div>
			<div class="clr"></div>
			<div class="main1">
				<iframe id="Frame" name="Frame" src="${ctx}/Webnews/queryBySearchDetail" width="100%" height="700px"  ></iframe>
			</div>
		</div>
	</div>
</body>
</html>