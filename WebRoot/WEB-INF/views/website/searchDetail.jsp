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
<style type="text/css">
body {
width: 100%;
margin: 0px;
padding: 0px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="details">
			<div class="clr"></div>
			<div class="main1">
				<div class="detailByList">
					<ul class="detailByList-ul">
						<h1 class="main_tit">
							站内搜索<strong>Search</strong><br> <br> <i>搜索关健字： <b class="blue">${keyWord }</b>
								，共有 <b class="red">${searchResult.total}</b> 条记录
							</i>
						</h1>
						<div>
							<c:forEach items="${searchResult.rows}" var="news"
								varStatus="status" begin="0" end="9">
								<li>${status.index+1}、<a
									href="${ctx}/Webnews/newsDetail/${news.newstype}/${news.newsId}" class="getNews" target="_blank">${news.title}</a>
									<span class="time">${news.time}</span>
								</li>
							</c:forEach> 
						</div>
					</ul>
				</div>
				<div class="tcdPageCode"></div>
			</div>
		</div>
	</div>
	<script>
		var total = ${searchResult.total};
		var num = null;
		if (total % 10 == 0) {
			num = total / 10;
		} else {
			num = total / 10 + 1;
		}
		if (total > 10) {
			$(".tcdPageCode")
					.createPage(
							{
								pageCount : parseInt(num),
								current : 1,
								backFn : function(p) {
									var obj = {
										page : p,
										rows : 10
									};
									obj.newstype = $('#newstype').val();
									$
											.ajaxPostJson(
													"${ctx}/Webnews/pageQueryNews",
													obj,
													function(result) {
														var str = "";
														var rows = result.rows;
														if (rows
																&& rows.length > 0) {
															/* str +="<input type='hidden' name='newstype' id='newstype' value='"+rows[0].newstype+"'/>";
															str +="<p>"+rows[0].newstype+"</p>"; */
															for (var i = 0; i < rows.length; i++) {
																str += "<li>"
																		+ ((p - 1)
																				* 10
																				+ i + 1)
																		+ "、<a href='${ctx}/Webnews/newsDetail/"+rows[i].newstype+"/"+rows[i].newsId
	        				+"' target='_blank'>"
																		+ rows[i].title
																		+ "</a>"
																		+ "<span class='time'>"
																		+ rows[i].time
																		+ "</span></li>";
															}
														}
														$(
																".detailByList-ul>div")
																.empty()
																.append(str);
														$(function() {
															$(
																	".detailByList>ul>div>li")
																	.find(
																			".time")
																	.each(
																			function() {
																				var text = $(
																						this)
																						.html();
																				$(
																						this)
																						.html(
																								tranDateStr(text));
																			});
														});
														function tranDateStr(
																dateStr) {
															return dateStr
																	&& dateStr.length == 14 ? dateStr
																	.substr(0,
																			4)
																	+ '-'
																	+ dateStr
																			.substr(
																					4,
																					2)
																	+ '-'
																	+ dateStr
																			.substr(
																					6,
																					2)
																	+ ' '
																	+ dateStr
																			.substr(
																					8,
																					2)
																	+ ':'
																	+ dateStr
																			.substr(
																					10,
																					2)
																	+ ':'
																	+ dateStr
																			.substr(
																					12,
																					2)
																	: NULL_VALUE;
														}
													});
								}
							});
		}
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
					$(function() {
						$(".detailByList>ul>div>li").find(".time").each(
								function() {
									var text = $(this).html();
									$(this).html(tranDateStr(text));
								});
					});
					function tranDateStr(dateStr) {
						return dateStr && dateStr.length == 14 ? dateStr
								.substr(0, 4)
								+ '-'
								+ dateStr.substr(4, 2)
								+ '-'
								+ dateStr.substr(6, 2)
								+ ' '
								+ dateStr.substr(8, 2)
								+ ':'
								+ dateStr.substr(10, 2)
								+ ':'
								+ dateStr.substr(12, 2) : NULL_VALUE;
					}
				});
	</script>
</body>
</html>