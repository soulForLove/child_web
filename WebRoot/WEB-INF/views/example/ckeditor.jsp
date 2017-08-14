<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
	var ctx = '${ctx}';
</script>
<html>
<head>
<title>ckeditor</title>
<script src="${ctx}/static/ckeditor/ckeditor.js" type="text/javascript"></script>
</head>
<body>
	
	<br>
	<div class="container-fluid">
		<form class="form-inline" action="#">
			<textarea name="editor1" id="editor1" rows="10" cols="80">
	             This is my textarea to be replaced with CKEditor.lzt
	        </textarea>
	        
			<button type="submit" id="btn" class="btn btn-default">提交</button>
		</form>

	</div>

	<script type="text/javascript">
		$(function() {
			//初始化
			CKEDITOR.replace('editor1' );
			
			//取值
			$("#btn").click(function(){
				alert(CKEDITOR.instances.editor1.getData());
			});
			//赋值
			CKEDITOR.instances.editor1.setData($("#editor1").html());
		});
	</script>

</body>
</html>
