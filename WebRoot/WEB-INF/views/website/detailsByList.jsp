<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<link rel="stylesheet" href="${ctx}/static/css/detail.css" />
<script src="${ctx}/static/jquery-plugins/jquery.page.js" type="text/javascript"></script>

<style>
*{ margin:0; padding:0; list-style:none;}
</style>
</head>
<body>
	<div class="detailByList">
		<ul class="detailByList-ul">
			<input type="hidden" name="newstype" id="newstype" value="${Type}"/>
			<p>${type}</p>
			<div>
			<c:forEach items="${detailByList.rows}" var="news" varStatus="status" begin="0" end="9">
					<li>
						${status.index+1}、<a href="${ctx}/Webnews/getNewsById/${news.newsId}" target="_self">${news.title}</a>
						<span class="time">${news.time}</span>
					</li>
			</c:forEach>
			</div>
		</ul>
	</div>
	<div class="tcdPageCode">
    </div>
    <script>
    var total = ${detailByList.total};
	var num=null;
	if(total%10==0){
		 num=total/10;
	}else{
		 num=total/10+1;
	}
	if(total>10){
	    $(".tcdPageCode").createPage({
	        pageCount:parseInt(num),
	        current:1,
	        backFn:function(p){
	        	var obj = {
	        			page:p,
	        			rows:10
	        	};
	        	obj.newstype=$('#newstype').val();
	            $.ajaxPostJson("${ctx}/Webnews/pageQueryNews",obj,function(result){
	            	var str = "";
	            	var rows = result.rows;
	            	if(rows && rows.length>0){
	            		/* str +="<input type='hidden' name='newstype' id='newstype' value='"+rows[0].newstype+"'/>";
	            		str +="<p>"+rows[0].newstype+"</p>"; */
	            		for(var i=0;i<rows.length;i++){
	        				str +="<li>"+((p-1)*10+i+1)+"、<a href='${ctx}/Webnews/getNewsById/"+rows[i].newsId
	        				+"' target='_self'>"+rows[i].title+"</a>"
	        				+"<span class='time'>"+rows[i].time+"</span></li>";
	        			}
	            	}
	            	$(".detailByList-ul>div").empty().append(str);
	            	$(function(){
	            		$(".detailByList>ul>div>li").find(".time").each(function(){
	            			var text=$(this).html();
	            			$(this).html(tranDateStr(text));
	            		});
	            	});
	            	function tranDateStr(dateStr) {
	            		return dateStr && dateStr.length == 14 ? dateStr.substr(0, 4) + '-' + dateStr.substr(4, 2) + '-' + dateStr.substr(6, 2) + ' ' + dateStr.substr(8,2) + ':' + dateStr.substr(10,2) + ':' + dateStr.substr(12,2): NULL_VALUE;
	            	}
	            });
	        }
	    });
	}
</script>
<script type="text/javascript">
$(document).ready(function(){
	$(function(){
		$(".detailByList>ul>div>li").find(".time").each(function(){
			var text=$(this).html();
			$(this).html(tranDateStr(text));
		});
	});
	function tranDateStr(dateStr) {
		return dateStr && dateStr.length == 14 ? dateStr.substr(0, 4) + '-' + dateStr.substr(4, 2) + '-' + dateStr.substr(6, 2) + ' ' + dateStr.substr(8,2) + ':' + dateStr.substr(10,2) + ':' + dateStr.substr(12,2): NULL_VALUE;
	}
});
</script>
</body>
</html>