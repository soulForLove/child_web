<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	<title><sitemesh:title/></title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta http-equiv="Cache-Control" content="no-store" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />

<link href="${ctx}/static/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/static/font-awesome/4.4.0/css/font-awesome.min.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/bootstrap-table/1.8.1/bootstrap-table.min.css" rel="stylesheet">
<link href="${ctx}/static/jquery-validation/1.11.1/validate.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/css/reset.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/static/jquery/1.11.3/jquery.min.js" type="text/javascript"></script>
 <!--[if lt IE 9]>
   <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
   <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
 <![endif]-->
<!-- 
<link href="${ctx}/static/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.min.css" rel="stylesheet">
<script src="${ctx}/static/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
<script src="${ctx}/static/bootstrap-datepicker/1.5.0/locales/bootstrap-datepicker.zh-CN.min.js" type="text/javascript"></script>
 -->
<script type="text/javascript">
	var ctx = '${ctx}';
</script>
<sitemesh:head/>
</head>
<style type="text/css">
	.form-save input{width:206px !important;display:inline-block !important;}
	.form-save select{max-width:206px !important;}
	.help-inline {display: inline-block;padding-left: 5px;vertical-align: middle;}
</style>
<body>
	<sitemesh:body/>
	<div id="messageDiv" style="display:none;position:fixed;top:40%;left:40%;transform: translate(-40%, -40%);background-color:#000;color:#fff;border-radius:4px;padding:10px;filter:alpha(Opacity=60);-moz-opacity:0.6;opacity: 0.6;">
		<span>提示信息</span>
	</div>
	<!-- Confirmation Modal -->
	<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="confirmModalLabel">确认删除?</h4>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" id="btnConfirm">确认</button>
				</div>
			</div>
		</div>
	</div>
	<script src="${ctx}/static/bootstrap/3.3.5/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${ctx}/static/bootstrap-table/1.8.1/bootstrap-table.min.js" type="text/javascript"></script>
	<script src="${ctx}/static/bootstrap-table/1.8.1/bootstrap-table-zh-CN.min.js" type="text/javascript"></script>
	<script src="${ctx}/static/jquery-validation/1.11.1/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${ctx}/static/jquery-validation/jquery.validate.extend.js" type="text/javascript"></script>
	<script src="${ctx}/static/js/third/json2.js" type="text/javascript"></script>
	<script src="${ctx}/static/jquery-plugins/jquery-form-utils.js" type="text/javascript"></script>
	<script type="text/javascript" src="${ctx}/static/jquery-plugins/jquery.form.js"></script>
	<script src="${ctx}/static/js/common/Utils.js" type="text/javascript"></script>
	<script src="${ctx}/static/js/common/BizUtils.js" type="text/javascript"></script>
	<script type="text/javascript">
		function ajaxError(jqXHR, textStatus, errorThrown){
			switch (jqXHR.status){
			case(0):
				Utils.getTop().window.location.href= "${ctx}/";
				break;
			case(999):
				var respInfo = JSON.parse(jqXHR.responseText);
				alert(respInfo.msg);
				break;
			default:
				alert("未知错误");
			}
		}
		
		$.ajaxSetup({
			type: "POST",
			error: ajaxError
		});
		
		$.extend($.fn.bootstrapTable.defaults, {
			onLoadError: ajaxError
		});
		
		$(function(){
			// bootstrap-ckeditor-modal-fix.js
			$.fn.modal.Constructor.prototype.enforceFocus = function () {
			    var $modalElement = this.$element;
			    $(document).on('focusin.modal', function (e) {
			        var $parent = $(e.target.parentNode);
			        if ($modalElement[0] !== e.target && !$modalElement.has(e.target).length
			            // add whatever conditions you need here:
			            && !$parent.hasClass('cke_dialog_ui_input_select') 
			            && !$parent.hasClass('cke_dialog_ui_input_text')) {
			            $modalElement.focus();
			        }
			    })
			};
		});
	
	</script>
</body>
</html>