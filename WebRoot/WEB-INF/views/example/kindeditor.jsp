<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
	var ctx = '${ctx}';
</script>
<html>
<head>
<link rel="stylesheet"
	href="${ctx}/static/kindeditor/themes/default/default.css" />

<link rel="stylesheet"
	href="${ctx}/static/kindeditor/plugins/code/prettify.css" />

<script charset="utf-8" src="${ctx}/static/kindeditor/kindeditor.js">
	
</script>

<script charset="utf-8" src="${ctx}/static/kindeditor/lang/zh_CN.js">
	
</script>

<script charset="utf-8"
	src="${ctx}/static/kindeditor/plugins/code/prettify.js">
	
</script>
<script>
	KindEditor
			.ready(function(K) {
				var editor1 = K
						.create(
								'textarea[name="details"]',
								{
									cssPath : '${ctx}/static/kindeditor/plugins/code/prettify.css',
									uploadJson : '${ctx}/static/kindeditor/jsp/upload_json.jsp',
									fileManagerJson : '${ctx}/static/kindeditor/jsp/file_manager_json.jsp',
									allowFileManager : true,
									afterCreate : function() {
										var self = this;
										K.ctrl(document, 13, function() {
											self.sync();
											document.forms['example'].submit();
										});
										K.ctrl(self.edit.doc, 13, function() {
											self.sync();
											document.forms['example'].submit();
										});
									}
								});
				prettyPrint();
			});
</script>
</head>
<body>

	<br>
	<div class="container-fluid">
		<form class="form-inline" action="#">
			<textarea name="details" cols="100" rows="8"></textarea>
			<br /> <input type="submit" name="button" value="提交" /> (提交快捷键:
			Ctrl + Enter)

		</form>

	</div>



</body>
</html>
