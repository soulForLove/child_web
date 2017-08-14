<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>会员中心</title>
<link rel="stylesheet" href="${ctx}/static/css/detail.css" />
<script src="${ctx}/static/jquery/1.11.3/jquery.min.js"
	type="text/javascript"></script>

</head>
<body>
	<div class="topbox">
		
		<c:if test="${loginuser!=null}">
		<div id="loginDiv">
			<b class='welcome'>${loginuser.userName },你好,欢迎登录！<a href="${ctx}/Webuser/personalCenter">个人中心</a>&nbsp;&nbsp;&nbsp;</b><button class='exit'>退出</button>
		</div>
		</c:if>
	</div>
	<div class="news-detail">
		<div class="header">
			<div class="headerbox">
				<div class="headerleft"></div>
				<div class="headerright">
					<img src="${ctx}/static/images/gdybs.jpg" alt="" />
				</div>
			</div>
		</div>
		<div class="nav">
			<div class="navbox ">
				<ul class="topul">
					<li><a href="${ctx}/Webindex">首页</a></li>
					<li><a href="http://www.shuxiangw.com/news.aspx" target="_blank">新闻资讯</a></li>
					<li><a href="http://school.shuxiangw.com/" target="_blank">书香校园</a></li>
					<li><a href="http://www.shuxiangw.com/readingbase.aspx" target="_blank">阅读基地</a></li>
					<li><a href="http://shop.shuxiangw.com/" target="_blank">图书商城</a></li>
					<li><a href="http://www.shuxiangw.com/share.aspx" target="_blank">资源共享</a></li>
					<li><a href="http://bbs.shuxiangw.com/" target="_blank">会员论坛</a></li>
					<li><a href="http://www.shuxiangw.com/about.aspx" target="_blank">关于我们</a></li>
				</ul>
			</div>
		</div>
		<div class="details">
			<div class="tip">
				<p>
					您当前的位置： <a href="${ctx}/Webindex">首页</a>> <a
						href="#">个人中心</a>
				</p>
			</div>
			<div class="news">
				<div  class="">
					<div class="newsnav">
						<p>个人中心</p>
						<ul>
							<li><a href="${ctx}/Webuser/getUserById/${loginuser.userId}" target="Frame">个人信息</a></li>
							<li><a href="${ctx}/Webuser/updatePwd" target="Frame">密码修改</a></li>
							<li><a href="${ctx}/Webuser/report/${loginuser.userId}" target="Frame" class="History" >举报记录</a></li>
							<!-- <li><a class="history" style="cursor:hand;">历史记录</a></li>-->						
							<li><a href="${ctx}/Webuser/watch/${loginuser.userId}" target="Frame" class="History" >历史浏览记录</a></li>
							<li><a href="${ctx}/Webuser/discuss/${loginuser.userId}" target="Frame" class="History" >历史留言记录</a></li>
						</ul>
					</div>
				</div>
				<!-- <div id="openClose" class="close">&nbsp;</div> --><!-- 分界线 -->
				<div  class="message">
					<iframe id="Frame" name="Frame" src="${ctx}/Webuser/getUserById/${loginuser.userId}" style="overflow: visible;" scrolling="yes" frameborder="no" width="100%" height="500px"></iframe>
				</div>
			</div>
		</div>
		<div class="friendlink">
			<ul class="friendul">
				<li><a>友情链接 :</a></li>
				<li><a target="_blank" href="http://book.sina.com.cn/"
					title="新浪读书"> 新浪读书</a></li>
				<li><a href="http://www.fjedu.gov.cn/">福建省教育厅</a></li>
				<li><a target="_blank" href="http://www.fjdsyz.com/"
					title="福建省读书援助协会"> 福建省读书协会</a></li>
				<li><a target="_blank" href="http://118.244.213.179:8028/"
					title="海峡教育装备基地"> 海峡教育基地</a></li>
				<li><a target="_blank" href="http://www.szsky.com/"
					title="全民阅读网"> 全民阅读网</a></li>
				<li><a target="_blank" href="http://gaokao.fjedu.gov.cn/"
					title="阳光高考"> 阳光高考</a></li>
				<li><a target="_blank" href="http://www.qnwz.cn/index.html"
					title="青年文摘"> 青年文摘</a></li>
				<div class="friendlinkbox">
			</ul>
		</div>
		<div class="footer">
			&copy福建师范大学协和学院信息技术系网络工程 <br> 联系地址：福建省福州市闽侯上街旗山校区 邮编：351088 <br>
			联系电话：18305983713 <br>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			//js怎么接受NewsController发送的model
			$(".newsnav>ul").find("li").each(function(){
				$(this).mouseover(function(){
					$(this).css("background","#eee");
					$(this).siblings().css("background","white");
				});
			});
			
			$(".exit").click(function(){
				if(window.confirm('你确定要退出吗？')){
					$.ajaxPostJson("${ctx}/Webuser/logout", {},function(result){
						window.location.href="http://localhost:8080/child_web/Webindex";
					});
	             }
			});
		});
	</script>
</body>
</html>