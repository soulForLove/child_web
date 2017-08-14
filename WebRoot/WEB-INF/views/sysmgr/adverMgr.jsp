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
				title : "required",
				bookId : {
					required : true,
					number : true
				}
			},
			messages : {
				title : "请输入标题",
				bookId : {
					required : "请输入图书编号",
					number : "请输入合法数字"
				}
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
									<label for="search_audit">审核进度：</label> 
									<select class="form-control" id="search_audit">
										<option value="">请选择</option>
										<option value="0">审核中</option>
										<option value="1">审核已通过</option>
										<option value="2">审核未通过</option>
									</select>
								</div>
								<div class="form-group">
									<label for="search_title">标题：</label> <input type="text"
										class="form-control" id="search_title" placeholder="请输入标题" />
								</div>
								<button type="button" class="btn btn-default" id="btnSearch">查询</button>
							</form>
						</div>
					</div>
				</div>

				<div class="panel-body">
					<table id="table"
						class="table table-bordered table-striped table-condensed table-hover"
						style="table-layout: fixed;">
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
						id="myform" >
						<input type="hidden" id="adverId" name="adverId">
						<div class="form-group">
							<label for="bookId" class="col-sm-3 control-label">图书名称：</label>
							<div class="col-sm-9">
								<select id="bookId" name="bookId" class="form-control">
									<option value="">请选择</option>
									<c:forEach items="${booklist}" var="book">
										<option value="${book.bookId}">${book.bookName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="title" class="col-sm-3 control-label">标题：</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="title" name="title"
									placeholder="标题">
							</div>
						</div><!-- 
						<div class="form-group">
							<label class="col-sm-3 control-label">图片：</label>
							<div class="col-sm-9">
								<div id="imgDiv" class="row"></div>
							</div>
						</div> -->
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="btnSave">提交审核</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(function() {
		var $table = $('#table');
		$table.bootstrapTable({
			url : '${ctx}/adver/pageQueryAdver',
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
				field : 'adverId',
				title : '编号',
				width : '10%',
				align : 'center'
			}, {
				field : 'bookName',
				title : '图书名称',
				width : '20%',
				cellStyle:cellStyle,
				align : 'center'
			}, {
				field : 'title',
				title : '标题',
				width : '30%',
				cellStyle:cellStyle,
				align : 'center'
			}, {
				field : 'link',
				title : '链接',
				width : '20%',
				cellStyle:cellStyle,
				align : 'center'
			},  {
				field : 'audit',
				title : '状态',
				width : '10%',
				formatter : function operateFormatter(value, row, index) {
					if(value==0){
						return "审核中";
					}else if(value==1){
						return "审核已通过";
					}else if(value==2){
						return "审核未通过";
					}
				},
				align : 'center'
			}, {
				field : 'adverId',
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
					//if ($("#myform").valid()) {
						var obj = $(".form-save").getFormObject();
						/* var imgUrlList = [];
						$("#imgDiv img").each(function(i) {
							imgUrlList.push($(this).attr("src"));
						});
						$.extend(obj, {
							"imgUrlList" : imgUrlList
						}); */
						$.extend(obj,{"audit":0});
						$.ajaxPostJson("${ctx}/adver/saveOrUpdateAdver", obj,function(result) {
									$('#table').bootstrapTable("refresh");
									$('#myModal').modal('hide');
									showMessage("操作成功!");
								});
				//	}
				});
		// 新增
		$(".add").click(function() {
			$("#adverId").val("");
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
			$.ajaxPostJson("${ctx}/adver/getAdverById/" + row.adverId,{},function(result) {
								if (result) {
									$(".form-save").setFormObject(result);
									/* var html = '';
									for (imgUrl in result.imgUrlList) {
										html += '<div class="col-md-4">';
										html += '	<div class="thumbnail">';
										html += '		<img src="'+result.imgUrlList[imgUrl]+'" />';
										html += '	</div>';
										html += '</div>';
									}
									$("#imgDiv").empty().append(html); */
								}
							});
		},
		'click .remove' : function(e, value, row, index) {
			$('#confirmModal').modal('show');
			$("#btnConfirm").click(
					function() {
						$.ajaxPostJson("${ctx}/adver/deleteAdver/"
								+ row.adverId, {}, function(result) {
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
	/* $(function() {
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
	}); */
</script>
</body>
</html>
