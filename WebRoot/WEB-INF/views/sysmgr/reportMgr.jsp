<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta name="decorator" content="default" />
<script src="${ctx}/static/ckeditor/ckeditor.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		var $table = $('#table');
		$table.bootstrapTable({
			url : '${ctx}/report/pageQueryReport',
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
				field : 'reportId',
				title : '编号',
				width : '10%',
				align : 'center'
			},{
				field : 'userId',
				title : '用户编号',
				width : '20%',
				align : 'center'
			},{
				field : 'newsId',
				title : '资讯编号',
				width : '20%',
				align : 'center'
			},{
				field : 'time',
				title : '举报时间',
				width : '20%',
				formatter : Utils.tranTimeStr,
				align : 'center'
			}, {
				field : 'ip',
				title : 'IP',
				width : '20%',
				align : 'center'
			},  {
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
		
		//查询
		$("#btnSearch").click(function() {
			$table.bootstrapTable("selectPage", 1);
		});
	});
	window.operateEvents = {
			'click .look' : function(e, value, row, index) {
				$('#myModal').modal('show');
// 				$('#myModalLabel').html('详细信息');
				$.ajaxPostJson("${ctx}/report/getReportById/" + row.reportId,
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
		$(function(){
    			var text=$("#time").html();
    			$("#time").html(tranDateStr(text));
    	});
    	function tranDateStr(dateStr) {
    		return dateStr && dateStr.length == 14 ? dateStr.substr(0, 4) + '-' + dateStr.substr(4, 2) + '-' + dateStr.substr(6, 2) + ' ' + dateStr.substr(8,2) + ':' + dateStr.substr(10,2) + ':' + dateStr.substr(12,2): NULL_VALUE;
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
									<label for="search_newsId">资讯ID：</label> 
									<input id="search_newsId" name="search_newsId" class="form-control" placeholder="请输入Id">
								</div>
								<div class="form-group">
									<label for="search_userId">用户ID：</label> 
									<input id="search_userId" name="search_userId" class="form-control" placeholder="请输入用户Id">
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
					<h4 class="modal-title" id="myModalLabel">详细信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-save form-horizontal" method="post" 
						id="myform">
						<input type="hidden" id="reportId" name="reportId" />
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label">资讯ID：</label>
							<input id="newsId" name="newsId" class="form-control">
						</div>
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label">用户ID：</label>
							<input id="userId" name="userId" class="form-control">
						</div>
						<div class="form-group">
							<label for="detail" class="col-sm-2 control-label">详细：</label>
							<div class="col-sm-10">
								<textarea id="detail" name="detail"></textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
