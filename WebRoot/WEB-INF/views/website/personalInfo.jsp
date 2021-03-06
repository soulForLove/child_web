<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${ctx}/static/css/detail.css" />
<script>
	//jquery validate表单验证
	$().ready(function() {
		$("#myform").validate({
			rules : {
				loginName : "required",
				userName : "required",
				tel : {
					required : true,
					mobile : true
				},
				email : {
					required : true,
					email : true
				}

			},
			messages : {
				loginName : "请输入帐号",
				userName : "请输入账户号",
				email : {
					required : "请输入Email",
					email : "Email地址错误"
				},
				tel : {
					required : "请输入手机号",
					mobile : "手机格式错误"
				}
			}
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btnSave").click(function() {
					if ($("#myform").valid()) {
						var obj = $(".form-save").getFormObject();
						$.ajaxPostJson("${ctx}/Webuser/saveOrUpdateUser", obj,function(result) {
									alert("修改成功！");
									top.location.reload(); 
								});
					}

				});
	});
	function check(){
		var obj ={
				loginName:$("#loginName").val()
			};
		$.ajaxPostJson("${ctx}/Webuser/valid", obj,
				function(result) {
					if(result){
						alert("账户已存在！");
						$("#loginName").val(${loginuser.loginName});
					}
				});	
	}
</script>
</head>
<body>
	<div class="container">
		<br>
		<div id="box">
			<form class="form-save form-horizontal" method="post" action="#"
				id="myform">
				<input type="hidden" id="userId" name="userId" value="${loginuser.userId }"/> 
				<input type="hidden" id="password" name="password" value="${loginuser.password }"/> 
				<label for="loginName">登录名：</label> 
				<input type="text" id="loginName" name="loginName" value="${loginuser.loginName }" class="form-control" style="border-style: none;"  onBlur="check()"> 
				<hr>
				<label for="userName">姓名：</label>
				<input type="text" id="userName" name="userName" value="${loginuser.userName }" class="form-control" style="border-style: none;">
				<hr>
				<label for="tel">手机号：</label> 
				<input type="text" id="tel" name="tel" value="${loginuser.tel }" class="form-control" style="border-style: none;">
				<hr>
				<label for="email">邮箱：</label>
				<input type="email" id="email" name="email" value="${loginuser.email }" class="form-control" style="border-style: none;">
				<br><br>
		</form>
		<button type="button" class="btn btn-primary" id="btnSave">保存</button>
	</div>
	</div>
</body>
</html>