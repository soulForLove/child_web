<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<link rel="stylesheet" href="${ctx}/static/css/detail.css" />
<link rel="stylesheet" href="${ctx}/static/kindeditor/themes/default/default.css" />

<link rel="stylesheet" href="${ctx}/static/kindeditor/plugins/code/prettify.css" />

<script charset="utf-8" src="${ctx}/static/kindeditor/kindeditor.js">
	
</script>

<script charset="utf-8" src="${ctx}/static/kindeditor/lang/zh_CN.js">
	
</script>

<script charset="utf-8" src="${ctx}/static/kindeditor/plugins/code/prettify.js">
	
</script>

<script type="text/javascript">
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="detail"]', {
				width:"100%",
				resizeType : 0,
				cssPath : '${ctx}/static/kindeditor/plugins/code/prettify.css',
				uploadJson : '${ctx}/static/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '${ctx}/static/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				allowImageUpload : true, 
				/* afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				} */
				afterBlur : function(){//编辑器失去焦点时直接同步，可以取到值
	                this.sync();
	            },
				items : [
							'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
							'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
							'insertunorderedlist', '|', 'emoticons',  'link']
			});
			prettyPrint();
		});
	</script>
</head>
<body>
	<div class="detailByOne">
		<p>${newstype}</p>
		<div class="title">
			<p>${news.title}</p>
			<span>&nbsp;&nbsp;&nbsp;发布时间：<span class="Publishtime">${news.time}</span></span>
			<span>发布者：${news.publisher}</span>
		</div>
		<div class="infomation">
			<!-- 资讯区 -->
			<div class="info" >
				${news.detail}
				<%-- <div id="imgDiv" >
					<c:forEach items="${news.imgUrlList}" var="newsimg">
						<img src="${newsimg}" width="120px" height="120px" />
					</c:forEach>
				</div> --%>
			</div>
			<!-- 评论区 -->
			<div class="discuss-place">
				<%-- <table width="680px;">
					<c:forEach items="${discusslist}" var="discuss" begin="0" end="4">
						<c:if test="${discuss.newsId==news.newsId}">
							<tr class="d-place">
								<td width="20%">${discuss.userName}说：</td>
								<td width="50%">${discuss.detail}</td>
								<td width="30%"><span class="time">${discuss.discusstime}</span></td>
							</tr>
						</c:if>
					</c:forEach>
				</table> --%>
				<c:forEach items="${discusslist}" var="discuss" varStatus="status" begin="0" end="9">
						<div  class="answer">
							<div class="floor_info ">
								<span class="name">
									<span class="num">${status.index+1}</span> 楼：${discuss.userName}
									<span id="pdt_admin_2" class="tx_thin2" style="display: none"></span>
								</span>
								于<span class="time">${discuss.discusstime}</span>发表
							</div>
							<div class="comment">
								<div>
									${discuss.detail}
								</div>
							</div>
						</div>
				</c:forEach>
			</div>
			<!--留言内容-->
			<div class="discussArea">
				<form action="#" method="post" class="form-save">
					<div class="news-message">
						<textarea name="detail" id="detail"></textarea> 
					</div>
					<input type="hidden" value="${news.newsId}" id="newsId" name="newsId">
					<input type="hidden" value="${loginuser.userId}" id="userId"
						name="userId">
				    <div height="20px" >
						<input id="discuss" value="留言" type="button"><input id="report" value="举报" type="button">
					</div>
				</form>
				<div id="loginbar" style="display:none;">
					&nbsp; 账户：<input type="text" id="loginName" name="loginName"> 密码：<input
						type="password" id="password" name="password"> &nbsp; 
						<button id="login" >登录</button> <a href="${ctx}/Webuser/register" target="_top">注册</a>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#discuss").click(function() {
				var obj = {
					"detail" : $("#detail").val(),
					"newsId" : $("#newsId").val(),
					"userId" : $("#userId").val(),
					"audit":0
				};
				if(obj.detail==""||obj.detail==null){
					alert("留言内容为空！");
				}else  if (obj.userId != null&&obj.userId!="") {
					$.ajaxPostJson("${ctx}/discuss/saveOrUpdateDiscuss",obj,function(result) {
						alert("留言已经提交！");
						KindEditor.instances[0].html('');
					});
				} else{
					alert("您还未登录！");
					//弹出登录框
					$(".form-save").css("display","none");
					$("#loginbar").css("display","block");
				}
			});
			$("#report").click(function() {
				var obj = {
					"detail" : $("#detail").val(),
					"newsId" : $("#newsId").val(),
					"userId" : $("#userId").val()
				};
				if(obj.detail==""||obj.detail==null){
					alert("举报内容为空！");
				}else  if (obj.userId != null&&obj.userId!="") {
					$.ajaxPostJson("${ctx}/report/saveOrUpdateReport",obj,function(result) {
						alert("举报内容已经提交！");
						KindEditor.instances[0].html('');
					});
				} else{
					alert("您还未登录！");
					//弹出登录框
					$(".form-save").css("display","none");
					$("#loginbar").css("display","block");
				}
			});
			$("#login").click(function(){
				var obj ={
						loginName:$("#loginName").val(),
						password:$("#password").val()	
					};
				$.ajaxPostJson("${ctx}/Webuser/login", obj,function(result){
						if(result && typeof(result.loginName)!='undefined'){
							top.location.reload();
							$(".form-save").css("display","block");
							$("#loginbar").css("display","none");
						}else{
							alert("账户信息有误！");
						}
				});
			});
			$(function(){
				$(".discuss-place>div").find(".time").each(function(){
					var text=$(this).html();
					$(this).html(tranDateStr(text));
				});
				var text=$(".Publishtime").html();
				$(".Publishtime").html(tranDateStr(text));
			});
			function tranDateStr(dateStr) {
				return dateStr && dateStr.length == 14 ? dateStr.substr(0, 4) + '-' + dateStr.substr(4, 2) + '-' + dateStr.substr(6, 2) + ' ' + dateStr.substr(8,2) + ':' + dateStr.substr(10,2) + ':' + dateStr.substr(12,2): NULL_VALUE;
			}
			
		});
	</script>
</body>
</html>