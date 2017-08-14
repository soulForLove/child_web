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

<script type="text/javascript">
	$(function() {
		var $table = $('#table');
		$table.bootstrapTable({
			url : '${ctx}/discuss/pageQueryDiscuss',
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
				field : 'discussId',
				title : '编号',
				width : '10%',
				align : 'center'
			}, {
				field : 'newstype',
				title : '资讯类别',
				width : '10%',
				formatter : function operateFormatter(value, row, index) {
					if(value==1){
						return "教育资讯";
					}else if(value==2){
						return "活动资讯";
					}else if(value==3){
						return "体育资讯";
					}else if(value==4){
						return "营养资讯";
					}else if(value==5){
						return "阅读资讯";
					}else if(value==6){
						return "热点资讯";
					}
				},
				align : 'center'
			}, {
				field : 'userName',
				title : '用户名',
				width : '10%',
				align : 'center'
			}, {
				field : 'discusstime',
				title : '留言时间',
				width : '20%',
				formatter : Utils.tranTimeStr,
				align : 'center'
			}, {
				field : 'ip',
				title : 'IP',
				width : '10%',
				align : 'center'
			},  {
				field : 'audit',
				title : '状态',
				width : '10%',
				formatter : function operateFormatter(value, row, index) {
					if(value==0){
						return "未审核";
					}else if(value==1){
						return "审核通过";
					}else if(value==2){
						return "审核未通过";
					}
				},
				align : 'center'
			},{
				field : 'discussId',
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
						$.extend(obj,{"audit":1});
						$.ajaxPostJson("${ctx}/discuss/saveDiscuss",
								obj, function(result) {
									$('#table').bootstrapTable("refresh");
									$('#myModal').modal('hide');
									showMessage("操作成功!");
								});
					}
				});
		$("#btnThrow").click(
				function() {
					if ($("#myform").valid()) {
						var obj = $(".form-save").getFormObject();
						var content = CKEDITOR.instances.detail.getData();
						$.extend(obj, {
							"detail" : content
						});
						$.extend(obj,{"audit":2});
						$.ajaxPostJson("${ctx}/discuss/saveDiscuss",
								obj, function(result) {
									$('#table').bootstrapTable("refresh");
									$('#myModal').modal('hide');
									showMessage("操作成功!");
								});
					}
				});
		
		//查询
		$("#btnSearch").click(function() {
			$table.bootstrapTable("selectPage", 1);
		});
	});
	window.operateEvents = {
		'click .look' : function(e, value, row, index) {
			$('#myModal').modal('show');
			$('#myModalLabel').html('详细信息');
			$.ajaxPostJson("${ctx}/discuss/getDiscussById/" + row.discussId,
					{}, function(result) {
						if (result) {
							CKEDITOR.instances.detail.setData(result.detail);
							$(".form-save").setFormObject(result);
						}
					});
		}
		
	};
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
	function operateFormatter(value, row, index) {
		return [
				'<a class="look" href="javascript:void(0)" title="查看详细"><i class="glyphicon glyphicon-eye-open"></i></a>',]
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
						</div>
						<div class="col-md-9 col-lg-9 text-right">
							<form class="form-search form-inline" action="#">
								<div class="form-group">
									<label for="search_audit">审核进度：</label> 
									<select class="form-control" id="search_audit">
										<option value="">请选择</option>
										<option value="0">未审核</option>
										<option value="1">审核已通过</option>
										<option value="2">审核未通过</option>
									</select>
								</div>
								<div class="form-group">
									<label for="search_newstype">资讯类别：</label> 
									<select
										id="search_newstype" name="search_newstype"
										class="form-control">
										<option value="">请选择</option>
										<option value="1">教育资讯</option>
										<option value="2">活动资讯</option>
										<option value="3">体育资讯</option>
										<option value="4">营养资讯</option>
										<option value="5">阅读资讯</option>
										<option value="6">热点资讯</option>
									</select>
<!-- 										<label for="search_newsId">资讯ID：</label> <input -->
<!-- 										id="search_newsId" name="search_newsId" -->
<!-- 										class="form-control" placeholder="请输入资讯ID"> -->
								</div>
								<div class="form-group">
									<label for="search_userName">用户名：</label> <input
										id="search_userName" name="search_userName"
										class="form-control" placeholder="请输入用户名">
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
						<input type="hidden" id="discussId" name="discussId" />
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label disable">资讯ID：</label>
							<div class="col-sm-10">
								<%-- <select id="newsId" name="newsId" class="form-control" readonly>
									<option value="">请选择</option>
									<c:forEach items="${newslist}" var="news">
										<option value="${news.newsId}">${news.newsId}</option>
									</c:forEach>
								</select> --%>
								<input id="newsId" name="newsId" class="form-control" readonly>
							</div>

						</div>
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label">用户ID：</label>
							<div class="col-sm-10">
								<%-- <select id="userId" name="userId" class="form-control" readonly>
									<option value="">请选择</option>
									<c:forEach items="${userlist}" var="user">
										<option value="${user.userId}">${user.userId}</option>
									</c:forEach>
								</select>	 --%>
								<input id="userId" name="userId" class="form-control" readonly>
							</div>
						</div>
						<div class="form-group">
							<label for="detail" class="col-sm-2 control-label">详细：</label>
							<div class="col-sm-10">
								<textarea name="detail" id="detail" name="detail" readonly></textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="btnThrow">屏蔽</button>
					<button type="button" class="btn btn-primary" id="btnSave">通过</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
