<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<style type="text/css">
.cell-style {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
</style>
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
				adminName : "required",
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
				adminName : "请输入账户号",
				email : {
					required : "请输入Email地址",
					email : "请输入正确的email地址"
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
		var $table = $('#table');
		$table.bootstrapTable({
			url : '${ctx}/admin/pageQueryAdmin',
			method : 'post',
			sidePagination : 'server',
			queryParamsType : 'self',
			queryParams : function(params) {
				var pageParam = {
					page : params.pageNumber,
					rows : params.pageSize
				};
				var searchParam = $(".form-search").getSearchFormObject();
				return $.extend(pageParam, searchParam);
			},
			striped : true,
			pagination : true,
			pageList : [ 5, 10, 50 ],
			pageSize : 5,
			pageNumber : 1,
			height : getHeight(),
			columns : [ {
				field : 'adminId',
				title : '编号',
				width : '10%',
				align : 'center'
			}, {
				field : 'loginName',
				title : '登录名',
				width : '15%',
				align : 'center'
			}, {
				field : 'tel',
				title : '手机号',
				width : '20%',
				align : 'center'
			}, {
				field : 'email',
				title : '邮箱',
				width : '25%',
				cellStyle:cellStyle,
				align : 'center'
			}, {
				field : 'adminName',
				title : '姓名',
				width : '20%',
				align : 'center'
			},{
				field : 'adminId',
				title : '操作',
				formatter : operateFormatter,
				events : operateEvents,
				width : '10%',
				align : 'center'
			} ]
		});
		$table.on('load-success.bs.table', function(data) {
			//console.log("load-success...");
		});
		function cellStyle(value, row, index) {
			return {
				classes : 'cell-style'
			};
		}
		// 保存
		$("#btnSave").click(function() {
			if ($("#myform").valid()) {
				var obj = $(".form-save").getFormObject();
				$.ajaxPostJson("${ctx}/admin/saveOrUpdateAdmin", obj,
						function(result) {
								$('#table').bootstrapTable("refresh");
								$('#myModal').modal('hide');
								showMessage("操作成功!");
						});
			
			}
		});
		// 新增
		$(".add").click(function() {
			$(".form-save").clearForm();
			$('#myModalLabel').html('新增');
			$('#myModal').modal('show');
		});
		//查询
		$("#btnSearch").click(function() {
			$table.bootstrapTable("selectPage", 1);
		});

	});
	window.operateEvents = {
		'click .edit' : function(e, value, row, index) {
			$('#myModal').modal('show');
			$('#myModalLabel').html('修改');
			$.ajaxPostJson("${ctx}/admin/getAdminById/" + row.adminId, {},
					function(result) {
						if (result) {
							$(".form-save").setFormObject(result);
						}
					});
		},
		'click .remove' : function(e, value, row, index) {
			$('#confirmModal').modal('show');
			$("#btnConfirm").click(
					function() {
						$.ajaxPostJson("${ctx}/admin/deleteAdmin/"
								+ row.adminId, {}, function(result) {
							$('#table').bootstrapTable("refresh");
							$('#confirmModal').modal('hide');
							showMessage("操作成功!");
						});
					})
		}
	};
	function getHeight() {
		return $(window).height() - $('#toolbarDiv').outerHeight(true) - 150;
	}
	// 修改、删除
	function operateFormatter(value, row, index) {
		return [
				'<a class="edit" href="javascript:void(0)" title="编辑"><i class="glyphicon glyphicon-edit"></i></a>',
				'<a class="remove" href="javascript:void(0)" title="删除"><i class="glyphicon glyphicon-remove"></i></a>', ]
				.join('&nbsp;&nbsp;');
	}
	function alarm() {

		alert("只允许上传jpg,gif,bmp类型的文件");
	}
	function checkExt() {
		var allowArray = new Array("jpg", "gif", "bmp");
		var photo = document.getElementById("photo").value;
		var fileExt = photo.substr(photo.lastIndexOf(".") + 1);
		var flag = false;
		for (var i = 0; i < allowArray.length; i++) {
			if (allowArray[i] != fileExt.toLowerCase()) {

				flag = false;
			}
		}
		if (flag == false) {
			alert("不允许上传的文件类型，只允许上传jpg,gif,bmp类型的文件");
		}
		return flag;
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-heading" id="toolbarDiv">
					<div class="row">
						<div class="col-md-3 col-lg-3">
							<button type="button" class="btn btn-primary btn-md add">添加</button>
							<!-- data-toggle="modal" data-target="#myModal" -->
						</div>
						<div class="col-md-9 col-lg-9 text-right">
							<form class="form-search form-inline" action="#">
								<div class="form-group">
									<label for="search_adminName">姓名：</label> <input type="text"
										class="form-control" id="search_adminName" placeholder="请输入姓名" />
								</div>
								<div class="form-group">
									<label for="search_tel">手机号：</label> <input type="text"
										class="form-control" id="search_tel" placeholder="请输入手机号" />
								</div>
								<button type="button" class="btn btn-default" id="btnSearch">查询</button>
							</form>
						</div>
					</div>
				</div>

				<div class="panel-body">
					<table id="table"
						class="table table-bordered table-striped table-condensed table-hover"style="table-layout: fixed;">
					</table>
				</div>
			</div>
		</div>

	</div>
	<!-- Modal 新增修改-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加</h4>
				</div>
				<div class="modal-body">
					<form class="form-save form-horizontal" method="post" action="#"
						id="myform" enctype="multipart/form-data">
						<input type="hidden" id="adminId" name="adminId"> 
						<div class="form-group">
							<label for="loginName" class="col-md-4 control-label">登录名：</label>
							<div class="col-md-8">
								<input type="text" class="form-control" id="loginName"
									name="loginName" placeholder="登录名">
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-md-4 control-label">密码：</label>
							<div class="col-md-8">
								<input type="password" class="form-control" id="password"
									name="password" placeholder="密码">
							</div>
						</div>
						<div class="form-group">
							<label for="adminName" class="col-md-4 control-label">姓名：</label>
							<div class="col-md-8">
								<input type="text" class="form-control" id="adminName"
									name="adminName" placeholder="姓名">
							</div>
						</div>
						<div class="form-group">
							<label for="tel" class="col-md-4 control-label">手机号：</label>
							<div class="col-md-8">
								<input type="text" class="form-control" id="tel" name="tel"
									placeholder="手机号">
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-md-4 control-label">邮箱：</label>
							<div class="col-md-8">
								<input type="email" class="form-control" id="email" name="email"
									placeholder="邮箱">
							</div>
						</div>
						
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="btnSave">保存</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
