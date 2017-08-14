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
				userId:"required",
				title:"required",
				detail:"required"
				
			},
			messages : {
				userId:"请选择用户ID",
				title:"请输入标题",
				detail:"请输入详细内容"
			}
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		var $table = $('#table');
		$table.bootstrapTable({
			url : '${ctx}/serviceInfo/pageQueryServiceInfo',
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
			pageList : [ 10, 20, 50 ],
			pageSize : 10,
			pageNumber : 1,
			height : getHeight(),
			columns : [ {
				field : 'serviceId',
				title : '编号',
				width : '10%',
				align : 'center'
			}, {
				field : 'userName',
				title : '用户名',
				width : '10%',
				align : 'center'
			}, {
				field : 'title',
				title : '标题',
				cellStyle:cellStyle,
				width : '20%',
				align : 'center'
			},  {
				field : 'submitTime',
				title : '提交时间',
				width : '20%',
				formatter : Utils.tranTimeStr,
				align : 'center'
			},{
				field : 'handleTime',
				title : '处理时间',
				width : '20%',
				formatter : Utils.tranTimeStr,
				align : 'center'
			},{
				field : 'ip',
				title : 'IP',
				width : '10%',
				align : 'center'
			}, {
				field : 'serviceId',
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
		$("#btnSave").click(
				function() {
					if ($("#myform").valid()) {
						var obj = $(".form-save").getFormObject();
						$.ajaxPostJson("${ctx}/serviceInfo/saveOrUpdateServiceInfo",
								obj, function(result) {
									$('#table').bootstrapTable("refresh");
									$('#myModal').modal('hide');
									showMessage("操作成功!");
								});
					}
				});
		// 新增
		$(".add").click(function() {
			$(".form-save").clearForm();
			$("#serviceId").val("");
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
			$('#myUserLabel').html('用户名');
			$('#myModal').modal('show');
			$('#myModalLabel').html('修改');
			$.ajaxPostJson("${ctx}/serviceInfo/getServiceInfoById/" + row.serviceId,
					{}, function(result) {
						if (result) {
							$(".form-save").setFormObject(result);
						}
					});
		},
		'click .remove' : function(e, value, row, index) {
			$('#confirmModal').modal('show');
			$("#btnConfirm").click(
					function() {
						$.ajaxPostJson("${ctx}/serviceInfo/deleteServiceInfo/"
								+ row.serviceId, {}, function(result) {
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
						</div>
						<div class="col-md-9 col-lg-9 text-right">
							<form class="form-search form-inline" action="#">

								<div class="form-group">
									<label for="search_title">标题：</label> 
									<input type="text" class="form-control" id="search_title" name="search_title" placeholder="请输入标题" />
								</div>
								<button type="button" class="btn btn-default" id="btnSearch">查询</button>
							</form>
						</div>
					</div>
				</div>

				<div class="panel-body">
					<table id="table"
						class="table table-bordered table-striped table-condensed table-hover" style="table-layout:fixed;">
					</table>
				</div>
			</div>
		</div>
	</div>
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
						id="myform">
						<input type="hidden" id="serviceId" name="serviceId" />

						<div class="form-group">
							<label for="title" class="col-sm-3 control-label">标题：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="title"
									name="title">
							</div>
						</div>
						<div class="form-group">
							<label for="title" class="col-sm-3 control-label">用户ID：</label>
							<div class="col-sm-9">
								<select id="userId" name="userId" class="form-control">
									<option value="">请选择</option>
									<c:forEach items="${userlist}" var="user">
										<option value="${user.userId}">${user.userId}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="detail" class="col-sm-3 control-label">详细：</label>
							<div class="col-sm-9">
								<textarea class="form-control" rows="6" id="detail"
									name="detail" style="resize: none;"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="handleTime" class="col-sm-3 control-label">处理时间：</label>
							<div class="col-sm-9">
								<input type="datetime-local" id="handleTime" name="handleTime">
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
