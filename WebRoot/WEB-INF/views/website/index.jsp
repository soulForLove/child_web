<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>少儿分类资讯网站</title>
<link rel="stylesheet" href="${ctx}/static/css/reset.css" />
<link rel="stylesheet" href="${ctx}/static/css/KidBookPlatForm.css" />
<link rel="stylesheet" href="${ctx}/static/css/detail.css" />
<script type="text/javascript" src="${ctx}/static/service/js/kefu.js"></script>
<link href="${ctx}/static/service/css/style.css" type="text/css" rel="stylesheet" />
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
				<li><a href="http://www.shuxiangw.com/news.aspx" target="_blank">新闻资讯</a></li>
				<li><a href="http://school.shuxiangw.com/" target="_blank">书香校园</a></li>
				<li><a href="http://www.shuxiangw.com/readingbase.aspx" target="_blank">阅读基地</a></li>
				<li><a href="http://shop.shuxiangw.com/" target="_blank">图书商城</a></li>
				<li><a href="http://www.shuxiangw.com/share.aspx" target="_blank">资源共享</a></li>
				<li><a href="http://bbs.shuxiangw.com/" target="_blank">会员论坛</a></li>
				<li><a href="http://www.shuxiangw.com/usercenter.aspx?action=index" target="_blank">会员专区</a></li>
				<li><a href="http://www.shuxiangw.com/about.aspx" target="_blank">关于我们</a></li>
			</ul>
		</div>
	</div>
	<div class="container">

		<div class="details">
			<div class="ad1">
				<img src="${ctx}/static/images/201408191939325508.jpg" alt="" />
			</div>

			<div class="clr"></div>

			<div class="main1">

				<div class="left1">
					<div class="title">
						<img src="${ctx}/static/images/circle.gif" alt="" />
						<h1>教育资讯</h1>
						<a href="${ctx}/Webnews/newsDetail/1/0"> 更多</a>
					</div>
					<div class="mainbox">
						<ul>
							<c:forEach items="${newslist1}" var="news" begin="0" end="9" varStatus="status"> 
								<c:if test="${news.newstype==1}" >
									  <li><span></span><a title="" href="${ctx}/Webnews/newsDetail/1/${news.newsId}">${news.title}</a><span class="time">${news.time}</span></li>
								</c:if>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="right1">
					<div class="title">
						<img src="${ctx}/static/images/circle.gif" alt="" />
						<h1>活动资讯</h1>
						<a href="${ctx}/Webnews/newsDetail/2/0"> 更多</a>
					</div>
					<div class="mainbox">
						<ul>
							<c:forEach items="${newslist2}" var="news"  begin="0" end="9"> 
								<c:if test="${news.newstype==2}">
										<li><span></span><a title="" href="${ctx}/Webnews/newsDetail/2/${news.newsId}">${news.title}</a><span class="time">${news.time}</span></li>
								</c:if>
							</c:forEach>
						</ul>
					</div>

				</div>
				<div class="clr"></div>
				<div class="ad2">
					<img src="${ctx}/static/images/201408191939137540.jpg" alt="" />
				</div>
				<div class="clr"></div>
				<div class="main2">
					<div class="left2">
						<div class="title">
							<img src="${ctx}/static/images/circle.gif" alt="" />
							<h1>体育资讯</h1>
							<a href="${ctx}/Webnews/newsDetail/3/0"> 更多</a>
						</div>
						<div class="mainbox">
							<ul>
								<c:forEach items="${newslist3}" var="news"  begin="0" end="9"> 
								<c:if test="${news.newstype==3}">
									<li><a title="" href="${ctx}/Webnews/newsDetail/3/${news.newsId}">${news.title}</a><span class="time">${news.time}</span></li>
								</c:if>
							</c:forEach>
							</ul>
						</div>
					</div>
					<div class="right2">
						<div class="title">
							<img src="${ctx}/static/images/circle.gif" alt="" />
							<h1>营养资讯</h1>
							<a href="${ctx}/Webnews/newsDetail/4/0"> 更多</a>
						</div>
						<div class="mainbox">
							<ul>
								<c:forEach items="${newslist4}" var="news"  begin="0" end="9"> 
								<c:if test="${news.newstype==4}">
									<li><span></span><a title="" href="${ctx}/Webnews/newsDetail/4/${news.newsId}">${news.title}</a><span class="time">${news.time}</span></li>
								</c:if>
							</c:forEach>
							</ul>

						</div>
					</div>


					<div class="clr"></div>


					<div class="ad3">
						<img src="${ctx}/static/images/201408191938468946.jpg" alt="" />
					</div>

				</div>
				<div class="clr"></div>
				<div class="main3">
					<div class="left3">
						<div class="title">
							<img src="${ctx}/static/images/circle.gif" alt="" />
							<h1>阅读资讯</h1>
							<a href="${ctx}/Webnews/newsDetail/5/0"> 更多</a>
						</div>
						<div class="mainbox">
							<ul>
								<c:forEach items="${newslist5}" var="news"  begin="0" end="9"> 
								<c:if test="${news.newstype==5}">
									<li><span></span><a title="" href="${ctx}/Webnews/newsDetail/5/${news.newsId}">${news.title}</a><span class="time">${news.time}</span></li>
								</c:if>
							</c:forEach>

							</ul>
						</div>
					</div>
					<div class="right3">
						<div class="title">
							<img src="${ctx}/static/images/circle.gif" alt="" />
							<h1>热点资讯</h1>
							<a href="${ctx}/Webnews/newsDetail/6/0"> 更多</a>
						</div>
						<div class="mainbox">
							<ul>
								<c:forEach items="${newslist6}" var="news"  begin="0" end="9"> 
								<c:if test="${news.newstype==6}">
									<li><span></span><a title="" href="${ctx}/Webnews/newsDetail/6/${news.newsId}">${news.title}</a><span class="time">${news.time}</span></li>
								</c:if>
							</c:forEach>
							</ul>
						</div>
					</div>
				</div>

			</div>
			<div class="clr"></div>

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

			<div class="clr"></div>
			<div class="footer">
				&copy福建师范大学协和学院信息技术系网络工程 <br> 联系地址：福建省福州市闽侯上街旗山校区 邮编：351088 <br>
				联系电话：18305983*** <br>
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
	$(document).ready(function() {
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
		$(function(){
			$(".mainbox>ul>li").find(".time").each(function(){
				var text=$(this).html();
				$(this).html(tranDateStr(text));
			});
			
		});
		
		
		function tranDateStr(dateStr) {
			return dateStr && dateStr.length == 14 ? dateStr.substr(0, 4) + '-' + dateStr.substr(4, 2) + '-' + dateStr.substr(6, 2) + ' ' + dateStr.substr(8,2) + ':' + dateStr.substr(10,2) + ':' + dateStr.substr(12,2): NULL_VALUE;
		}
	});
</script>
</body>
</html>