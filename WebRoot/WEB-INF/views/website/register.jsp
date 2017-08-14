<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>注册</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" href="${ctx}/static/register/css/supersized.css">
<link rel="stylesheet" href="${ctx}/static/register/css/login.css">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script src="js/html5.js"></script>
<![endif]-->
<script type="text/javascript" src="${ctx}/static/register/js/tooltips.js"></script>
<script>
	//jquery validate表单验证
	$().ready(function() {
		$("#myform").validate({
			rules : {
				loginName : "required",
				password : {
					required : true,
					minlength : 6
				},
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
				password : {
					required : "请输入密码",
					minlength : "至少为六位"
				},
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
$(function() {
	$(".btnSave").click(
		function() {
			if ($("#myform").valid()) {
				var obj = $(".form-save").getFormObject();
				$.ajaxPostJson("${ctx}/Webuser/saveOrUpdateUser", obj,
						function(result) {
							alert("注册成功！");
							history.back();
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
					$("#loginName").val("");
				}
			});	
}

</script>
</head>

<body>

<div class="page-container">
	<div class="main_box">
		<div class="login_box">
			<div class="login_logo">
				
			</div>
			<div class="login_form">
				<form class="form-save form-horizontal" method="post" action="#"
						id="myform">
						<input type="hidden" id="userId" name="userId"/>
						<div class="form-group">
							<label for="loginName" class="col-sm-4 control-label">登录名：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="loginName"
									name="loginName" placeholder="登录名" onBlur="check()">
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-sm-4 control-label">密码：</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="password"
									name="password" placeholder="密码">
							</div>
						</div>
						<div class="form-group">
							<label for="userName" class="col-sm-4 control-label">姓名：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="userName"
									name="userName" placeholder="姓名">
							</div>
						</div>
						<div class="form-group">
							<label for="tel" class="col-sm-4 control-label">手机号：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="tel" name="tel"
									placeholder="手机号">
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-sm-4 control-label">邮箱：</label>
							<div class="col-sm-8">
								<input type="email" class="form-control" id="email" name="email"
									placeholder="邮箱">
							</div>
						</div>
							<label  class="col-sm-4"></label>
							
							<button type="reset" class="btn btn-default btn-lg" style="float:left;">重置</button>
				</form>
				<button class="btn btn-primary btn-lg btnSave" style="float:left;margin-left:20px;">注册</button>
			</div>
		</div>
	</div>
</div>
<!-- Javascript -->

<script src="${ctx}/static/register/js/supersized.3.2.7.min.js"></script>
<script src="${ctx}/static/register/js/supersized-init.js"></script>
<script src="${ctx}/static/register/js/scripts.js"></script>
<div style="text-align:center;">
</div>
</body>
</html>