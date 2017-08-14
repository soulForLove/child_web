<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>管理员登录</title>
<link href="${ctx}/static/css/login.css" type="text/css"
	rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div id="loginbox">
			<form id="loginForm" class="form-vertical text-center" method="post"
				action="${ctx}/login" style="margin-top: 30px;">
				<div class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span> <input type="text" id="name"
						name="name" class="form-control input-medium required"
						placeholder="登录名">
				</div>
				<div class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-lock"></i></span> <input type="password"
						id="password" name="password"
						class="form-control input-medium required" placeholder="密码">
				</div>
				<div class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-sunglasses"></i></span>
						 <select  id="identity" name="identity" class="form-control input-medium required" style="width:120px !important;border-top-right-radius:4px !important;border-bottom-right-radius:4px !important;" maxlength="4">
						 	<option value="0">管理员</option>
						 	<option value="1">超级管理员</option>
						 </select>
				</div>
				<!-- 验证码 -->
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-picture"></i></span>
					<input type="text" id="validateCode" name="validateCode" class="form-control input-captcha" placeholder="验证码" style="width:100px !important;border-top-right-radius:4px !important;border-bottom-right-radius:4px !important;" maxlength="4">
					<img src="${ctx}/common/validateCodeServlet" onclick="$(this).attr('src','${ctx}/common/validateCodeServlet?'+new Date().getTime());" style="margin-top:3px;"/>
				</div>
				
				<%
					String error = (String) request.getAttribute("error");
					if(error!=null){
				%>
				<div class="input-group alert alert-danger input-medium controls">
					<button class="close" data-dismiss="alert">×</button><%=error %>
				</div>
				<%
					}
				%>
				<div class="form-actions form-line-split">
					<span class="pull-center"> <input type="submit"
						class="btn btn-primary" style="width: 116px;" value="登 录" />
					</span> <span class="pull-center"> <input type="reset"
						class="btn btn-default" style="width: 116px;" id="btnRecover"
						value="忘记密码" />
					</span>
				</div>
			</form>
			<!-- ======忘记密码div====== -->
			<form id="recoverForm" class="form-vertical"
				action="javascript:void(0);">

				<p>请您填写Email,作为证据找回密码.</p>
				<div class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-envelope"></i></span> <input type="email"
						class="form-control" placeholder="请输入E-mail" />
				</div>
				<div class="form-line-split-2">
					<span class="pull-center"> <a href="javascript:void(0);"
						class="flip-link" id="btnReturnLogin"> <input type="button"
							class="btn btn-default" style="width: 116px !important;"
							value="返回" /></a>
					</span> <span class="pull-center"> <input type="submit"
						class="btn btn-primary" style="width: 116px !important;"
						value="确定" />
					</span>
				</div>
			</form>
		</div>
	</div>
	<input type="hidden" id="error" value="${error}" />
	<script>
		$(document).ready(function() {
			/* $("#loginForm").validate({
				rules: {
					name: {required:true},
					password: {required:true},
					validateCode: {required:true}
				},
				messages: {
					name: {required: "请填写用户名."},password: {required: "请填写密码."},
					validateCode: {remote: "验证码不正确.", required: "请填写验证码."}
				}
			}); */ 
			//$("#loginForm").validate();
			var loginForm = $('#loginForm');
			var recoverForm = $('#recoverForm');
			var speed = 400;
			$('#btnRecover').click(function() {
				loginForm.fadeTo(speed, 0.01).css('z-index', '100');
				recoverForm.fadeTo(speed, 1).css('z-index', '200');
			});
			$('#btnReturnLogin').click(function() {
				recoverForm.fadeTo(speed, 0.01).css('z-index', '100');
				loginForm.fadeTo(speed, 1).css('z-index', '200');
			});
			//回车键提交
			document.onkeydown = function(evt){
			   var evt = window.event?window.event:evt;
			   if (evt.keyCode==13) {
			    		if(loginForm.css("zIndex")==200){
				           document.forms["loginForm"].submit();
			    		}else{
			    			$("#btnReset").click();
			    		} 	
			   }
			}
		});
	</script>
</body>
</html>