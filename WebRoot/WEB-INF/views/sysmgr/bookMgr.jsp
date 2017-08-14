<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<link href="${ctx}/static/css/reset.css" rel="stylesheet">
<script src="${ctx}/static/jquery-plugins/jquery.ajaxfileupload.js"
	type="text/javascript"></script>
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
				bookName : "required",
				bookPrice : {
					required : true,
					number : true
				},
				summary : "required",
				publishInfo : "required",
				link : "required"

			},
			messages : {
				bookName : "请输入图书名称",
				bookPrice : {
					required : "请输入图书价格",
					number : "请输入合理数字"
				},
				summary : "请输入摘要",
				publishInfo : "请输入出版商",
				link : "请输入链接"
			}
		});
	});
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
									<label for="search_bookName">图书名称：</label> <input type="text"
										class="form-control" id="search_bookName"
										placeholder="请输入图书名称" />
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
						<input type="hidden" id="bookId" name="bookId">
						<div class="form-group">
							<label for="bookName" class="col-sm-2 control-label">名称：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="bookName"
									name="bookName" placeholder="名称">
							</div>
						</div>
						<div class="form-group">
							<label for="bookPrice" class="col-sm-2 control-label">价格：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="bookPrice"
									name="bookPrice" placeholder="价格">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">图片：</label>
							<div class="col-sm-10">
								<div id="imgDiv" class="row"></div>
								<span class="btn btn-default btn-file"> 上传图片 <input
									type="file" id="upload" name="upload" />
								</span>
							</div>
						</div>
						<div class="form-group">
							<label for="summary" class="col-sm-2 control-label">摘要：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="summary"
									name="summary" placeholder="摘要">
							</div>
						</div>

						<div class="form-group">
							<label for="publishInfo" class="col-sm-2 control-label">出版商：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="publishInfo"
									name="publishInfo" placeholder="出版商">
							</div>
						</div>
						<div class="form-group">
							<label for="link" class="col-sm-2 control-label">链接：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="link" name="link"
									placeholder="链接">
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
	<script type="text/javascript">
	$(function() {
		var $table = $('#table');
		$table.bootstrapTable({
			url : '${ctx}/book/pageQueryBook',
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
				field : 'bookId',
				title : '编号',
				width : '10%',
				align : 'center'
			}, {
				field : 'bookName',
				title : '名称',
				width : '15%',
				cellStyle:cellStyle,
				align : 'center'
			}, {
				field : 'bookPrice',
				title : '价格',
				width : '10%',
				align : 'center'
			}, {
				field : 'summary',
				title : '摘要',
				width : '40%',
				cellStyle:cellStyle,
				align : 'center'
			}, {
				field : 'publishInfo',
				title : '出版商',
				width : '15%',
				cellStyle:cellStyle,
				align : 'center'
			}, {
				field : 'bookId',
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
						var imgUrlList = [];
						$("#imgDiv img").each(function(i) {
							imgUrlList.push($(this).attr("src"));
						});
						$.extend(obj, {
							"imgUrlList" : imgUrlList
						});
						$.ajaxPostJson("${ctx}/book/saveOrUpdateBook", obj,
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
			$("#bookId").val("");
			$("#imgDiv").html("");
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
			$('#myModalLabel').html('预览/修改');
			$.ajaxPostJson(
							"${ctx}/book/getBookById/" + row.bookId,
							{},
							function(result) {
								if (result) {
									$(".form-save").setFormObject(result);
									var html = '';
									for (imgUrl in result.imgUrlList) {
										html += '<div class="col-md-4">';
										html += '	<div class="thumbnail">';
										html += '		<button type="button" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
										html += '		<img src="'+result.imgUrlList[imgUrl]+'" />';
										html += '	</div>';
										html += '</div>';
									}
									$("#imgDiv").empty().append(html);
								}
							});
		},
		'click .remove' : function(e, value, row, index) {
			$('#confirmModal').modal('show');
			$("#btnConfirm").click(
					function() {
						$.ajaxPostJson("${ctx}/book/deleteBook/" + row.bookId,
								{}, function(result) {
									$('#table').bootstrapTable("refresh");
									$('#confirmModal').modal('hide');
									showMessage("操作成功!");
								});
					});
		}
	};

	function cellStyle(value, row, index) {
		return {
			classes : 'cell-style'
		};
	}

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
	$(function() {
		//删除图片
		$("#imgDiv").delegate(".close", "click", function() {
			$(this).parent().parent().remove();
			//TODO 删除服务器端
		})

		$('input[type="file"]')
				.ajaxfileupload(
						{
							'action' : '${ctx}/common/uploadImg',
							'params' : {
								'extra' : 'info'
							},
							'onComplete' : function(result) {
								if (result.success) {
									var html = '';
									html += '<div class="col-md-4">';
									html += '	<div class="thumbnail">';
									html += '		<button type="button" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
									html += '		<img src="'+result.msg+'" />';
									html += '	</div>';
									html += '</div>';
									$("#imgDiv").append(html);
								} else {
									alert(result.msg);
								}
							},
							'onStart' : function() {
								//if (weWantedTo)
								//	return false; // cancels upload
							},
							'onCancel' : function() {
							}
						});
	});
</script>
</body>
</html>
