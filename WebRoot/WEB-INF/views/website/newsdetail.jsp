<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>资讯详细页</title>
<link rel="stylesheet" href="${ctx}/static/css/detail.css" />
<script src="${ctx}/static/jquery/1.11.3/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/static/service/js/kefu.js"></script>
<link href="${ctx}/static/service/css/style.css" type="text/css" rel="stylesheet" />

<link type="text/css" href="${ctx}/static/adver/css/lrtk.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/static/adver/js/lrtk.js"></script>
</head>
<body>
	<div class="topbox">
		<c:if test="${loginuser==null}">
		<div id="loginbar" style="float:left;">
			&nbsp; 账户：<input type="text" id="loginName" name="loginName"> 密码：<input
				type="password" id="password" name="password"> &nbsp; 
				<button id="login" >登录</button> <a href="${ctx}/Webuser/register">注册</a>
		</div>
		</c:if>
		<c:if test="${loginuser!=null}">
		<div id="loginDiv" style="float:left;">
			<b class='welcome'>${loginuser.userName },你好,欢迎登录！<a href="${ctx}/Webuser/personalCenter">个人中心</a>&nbsp;&nbsp;&nbsp;</b><button class='exit'>退出</button>
		</div>
		</c:if>
		<div class="searchBar" >
			<form action="${ctx}/Webnews/queryKeyWord" method="post">
				<input type="text" name="keyWord" id="keyWord" placeholder="标题关键词">
				<input type="submit" value="搜索">
			</form>
		</div>
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
					<li><a href="http://shop.shuxiangw.com/" target="_blank">图书商城</a></li>
					<li><a href="http://www.shuxiangw.com/share.aspx" target="_blank">资源共享</a></li>
					<li><a href="http://bbs.shuxiangw.com/" target="_blank">会员论坛</a></li>
					<li><a href="http://www.shuxiangw.com/usercenter.aspx?action=index" target="_blank">会员专区</a></li>
					<li><a href="http://www.shuxiangw.com/about.aspx" target="_blank">关于我们</a></li>
				</ul>
			</div>
		</div>
		<div class="details">
			<div class="tip">
				<p>
					<%-- 您当前的位置： <a href="${ctx}/index">首页</a> <a href="#"> </a>> <a
						href="#">详细内容</a> --%>
				</p>
			</div>
			<div class="ad1">
				<img src="${ctx}/static/images/news.jpg" alt="" width="1000"
					height="140">
			</div>
			<div class="news">
				<div  class="">
					<div class="newsnav">
						<p>资讯分类</p>
						<ul>
							<li><a href="${ctx}/Webnews/pageQueryNews/1" target="Frame">教育资讯</a></li>
							<li><a href="${ctx}/Webnews/pageQueryNews/2" target="Frame">活动资讯</a></li>
							<li><a href="${ctx}/Webnews/pageQueryNews/3" target="Frame">体育资讯</a></li>
							<li><a href="${ctx}/Webnews/pageQueryNews/4" target="Frame">营养资讯</a></li>
							<li><a href="${ctx}/Webnews/pageQueryNews/5" target="Frame">阅读资讯</a></li>
							<li><a href="${ctx}/Webnews/pageQueryNews/6" target="Frame">热点资讯</a></li>
						</ul>
					</div>
				</div>
				<!-- <div id="openClose" class="close">&nbsp;</div> --><!-- 分界线 -->
				<div  class="message">
					<iframe id="Frame" name="Frame" src="${ctx}/Webnews/pageQueryNews/${newsType}" width="100%" height="500px"></iframe>
				</div>
			</div>
		</div>
		<div class="adver">
			<br/>
			<!-- 代码开始 -->
			<div class="box">
				<div class="picbox">
					<ul class="piclist mainlist">
						<c:forEach items="${adverList}" var="adver" varStatus="status" begin="0" end="11">
							<li>
								<a href="${adver.link}" target="_blank" title="${adver.bookName}">
									<img src="${adver.imgUrlList[0]}" width="220" height="105" class="bookImg"/>
								</a>
								<%-- <input type="hidden" class="bookId" value="${book.bookId }">  --%>
							</li>
						</c:forEach>
					</ul>
					<ul class="piclist swaplist">
						
					</ul>
				</div>
				<div class="og_prev"></div>
				<div class="og_next"></div>
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
			联系电话：18305983*** <br>
		</div>
	</div>
	<div id="sidekf">
				<div class="tel">
					<span>Tel:</span>18305983***
				</div>
				<div class="lnk">
					<a href="http://wpa.qq.com/msgrd?v=1&amp;uin=2306499100&amp;site=qq&amp;menu=yes"
						class="sidekf_qq"></a> <a href="http://bbs.shuxiangw.com/" target="_blank"
						class="sidekf_bbs"></a> <a href="https://mail.qq.com/cgi-bin/loginpage" class="sidekf_mail" target="_blank"></a> <a
						href="#" class="sidekf_help"></a>
				</div>
				<div class="ovh"></div>
			</div>
	<script type="text/javascript">
		$(document).ready(function(){
			var type = ${newsType};
			var newsId=${newsId};
			if(newsId != 0){
				$("#Frame").attr("src",'${ctx}/Webnews/getNewsById/'+newsId);
			}else{
				$("#Frame").attr("src",'${ctx}/Webnews/pageQueryNews/'+type);
			}
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
						location.reload();
					});
	             }else{
	                return false;
	            }
			});
			$("#login").click(function(){
				var obj ={
						loginName:$("#loginName").val(),
						password:$("#password").val()	
					};
				$.ajaxPostJson("${ctx}/Webuser/login", obj,function(result){
						if(result && typeof(result.loginName)!='undefined'){
							location.reload();
						}else{
							alert("账户信息有误！");
						}
				});
			});
			/* $(".picbox>ul").find(".bookImg").each(function(){
				$(".picbox>ul").find(".bookId").each(function(){
					$.ajaxPostJson("${ctx}/book/getBookById/" +$(this).val(),{},function(result) {
								if (result) {
									$(".bookImg").attr("src",result.imgUrlList[0]);
								}
					});
				});
			});  */
			
		});
	</script>
</body>
</html>