<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>uploadImg</title>
<meta name="decorator" content="default"/>
<link href="${ctx}/static/css/reset.css" rel="stylesheet">
<script src="${ctx}/static/jquery-plugins/jquery.ajaxfileupload.js" type="text/javascript"></script>
</head>
<body>

	<br>
	<div class="container-fluid">
		<div id="imgDiv" class="row">
			
		</div>
		<form>
			<div class="form-group">
				<span class="btn btn-default btn-file">
				    上传图片 <input type="file" id="upload" name="upload" />
				</span>
			</div>
		</form>
	</div>	

	<script type="text/javascript">
	$(function() {
		//删除图片
		$("#imgDiv").delegate(".close","click",function(){
			$(this).parent().parent().remove();
			//TODO 删除服务器端
		})

		$('input[type="file"]').ajaxfileupload({
			'action' : '${ctx}/common/uploadImg',
			'params' : {
				'extra' : 'info'
			},
			'onComplete' : function(result) {
				if(result.success){
					var html = '';
					html += '<div class="col-md-2">';
					html += '	<div class="thumbnail">';
					html += '		<button type="button" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
					html += '		<img src="'+result.msg+'" />';
					html += '	</div>';
					html += '</div>';
					$("#imgDiv").append(html);
				}else{
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
