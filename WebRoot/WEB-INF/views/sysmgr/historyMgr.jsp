<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta name="decorator" content="default" />
<script src="${ctx}/static/ckeditor/ckeditor.js" type="text/javascript"></script>
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
				newsId : "required",
				userId : "required"

			},
			messages : {
				newsId : "请输入资讯编号",
				userId : "请输入用户编号"
			}
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		var $table = $('#table');
		$table.bootstrapTable({
			url : '${ctx}/history/pageQueryHistory',
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
				field : 'hisId',
				title : '编号',
				width : '10%',
				align : 'center'
			},{
				field : 'userId',
				title : '用户编号',
				width : '15%',
				align : 'center'
			}, {
				field : 'newsId',
				title : '资讯编号',
				width : '15%',
				align : 'center'
			},  {
				field : 'loginIp',
				title : '登录地址',
				width : '20%',
				align : 'center'
			},{
				field : 'time',
				title : '时间',
				width : '20%',
				formatter : Utils.tranTimeStr,
				align : 'center'
			},{
				field : 'type',
				title : '类型',
				width : '10%',
				formatter : function operateFormatter(value, row, index) {
					if(value==0){
						return "浏览记录";
					}else if(value==1){
						return "留言记录";
					}
				},
				align : 'center'
			}, {
				field : 'hisId',
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

		// 保存
		$("#btnSave").click(
				function() {
					if ($("#myform").valid()) {
						var obj = $(".form-save").getFormObject();
						var content = CKEDITOR.instances.detail.getData();
						$.extend(obj, {
							"detail" : content
						});
						$.ajaxPostJson("${ctx}/history/saveOrUpdateHistory",
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
			$("#hisId").val("");
			$('#myModalLabel').html('新增');
			$('#myModal').modal('show');
			CKEDITOR.instances.detail.setData("");
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
			$.ajaxPostJson("${ctx}/history/getHistoryById/" + row.hisId,{}, function(result) {
						if (result) {
							CKEDITOR.instances.detail.setData(result.detail);
							$(".form-save").setFormObject(result);
						}
					});
		},
		'click .remove' : function(e, value, row, index) {
			$('#confirmModal').modal('show');
			$("#btnConfirm").click(
					function() {
						$.ajaxPostJson("${ctx}/history/deleteHistory/"
								+ row.hisId, {}, function(result) {
							$('#table').bootstrapTable("refresh");
							$('#confirmModal').modal('hide');
							showMessage("操作成功!");
						});
					})
		}
	};
	//
	function cellStyle(value, row, index) {
		return {
			classes : 'cell-style'
		};
	}
	$(function() {
		//初始化
		CKEDITOR.replace('detail');
	});
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
							<!-- data-toggle="modal" data-target="#myModal" -->
						</div>
						<div class="col-md-9 col-lg-9 text-right">
							<form class="form-search form-inline" action="#">
								<div class="form-group">
									<label for="search_type">类别：</label>
									<select id="search_type" name="search_type" class="form-control">
										<option value="">请选择</option>
										<option value="0">浏览记录</option>
										<option value="1">留言记录</option>
									</select>
								</div>
								<button type="button" class="btn btn-default" id="btnSearch">查询</button>
							</form>
						</div>
					</div>
				</div>

				<div class="panel-body">
					<table id="table"
						class="table table-bordered table-striped table-condensed table-hover "
						style="table-layout: fixed;">
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
						<input type="hidden" id="hisId" name="hisId" />


						<div class="form-group">
							<label for="title" class="col-sm-2 control-label disable">资讯ID：</label>
							<div class="col-sm-10">
								<select id="newsId" name="newsId" class="form-control">
									<option value="">请选择</option>
									<c:forEach items="${newslist}" var="news">
										<option value="${news.newsId}">${news.newsId}</option>
									</c:forEach>
								</select>
							</div>

						</div>
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label">用户ID：</label>
							<div class="col-sm-10">
								<select id="userId" name="userId" class="form-control">
									<option value="">请选择</option>
									<c:forEach items="${userlist}" var="user">
										<option value="${user.userId}">${user.userId}</option>
									</c:forEach>
								</select>	
							</div>
						</div>
						<div class="form-group">
							<label for="type" class="col-sm-2 control-label">类型：</label>
							<div class="col-sm-8">
								<select id="type" name="type" class="form-control">
										<option value="0">浏览记录</option>
										<option value="1">留言记录</option>
									</select>
							</div>
						</div>
						<div class="form-group">
							<label for="detail" class="col-sm-2 control-label">详细：</label>
							<div class="col-sm-10">
								<textarea  id="detail" name="detail"></textarea>
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
