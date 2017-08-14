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
a{ text-decoration:none;}
a:hover{ text-decoration:none;}
.tcdPageCode{padding: 15px 20px;text-align: left;color: #ccc;}
.tcdPageCode a{display: inline-block;color: #428bca;display: inline-block;height: 25px;	line-height: 25px;	padding: 0 10px;border: 1px solid #ddd;	margin: 0 2px;border-radius: 4px;vertical-align: middle;}
.tcdPageCode a:hover{text-decoration: none;border: 1px solid #428bca;}
.tcdPageCode span.current{display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;margin: 0 2px;color: #fff;background-color: #428bca;	border: 1px solid #428bca;border-radius: 4px;vertical-align: middle;}
.tcdPageCode span.disabled{	display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;margin: 0 2px;	color: #bfbfbf;background: #f2f2f2;border: 1px solid #bfbfbf;border-radius: 4px;vertical-align: middle;}
</style>
</head>
<body>
	<div class="detailByList">
		<table style="width:698px;" class="table">
			<tr >
				<td>编号</td><td>时间</td><td>登录IP</td><td>资讯标题</td>
			</tr>
			<tbody class="list">
				<c:forEach items="${watchList.rows}" var="watch" varStatus="status" begin="0" end="9">
						<tr class="listTr">
							<td>${status.index+1}</td>
							<td class="time">${watch.time}</td>
							<td>${watch.loginIp}</td>
							<td>
								<c:if test="${watch.title!=null}">
									<a href="${ctx}/Webnews/newsDetail/${watch.newstype}/${watch.newsId}" target="_blank">${watch.title}</a>
								</c:if>
								<c:if test="${watch.title==null}"><a href="javascipt:void(0);">该资讯不存在！</a></c:if>
							</td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="tcdPageCode"></div> 
 	<script>
    var total = ${watchList.total};
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
	        	obj.userId=${loginuser.userId};
	            $.ajaxPostJson("${ctx}/Webuser/watchPage",obj,function(result){
	            	var str = "";
	            	var rows = result.rows;
	            	if(rows && rows.length>0){
	            		for(var i=0;i<rows.length;i++){
	        				str +="<tr class='listTr'><td>"+((p-1)*10+i+1)+"</td>"
	    						+"<td ><span class='time'>"+rows[i].time+"</span></td>"
	    						+"<td><span>"+rows[i].loginIp+"</span></td>";
	    						if(rows[i].title!=null){
	    							str+="<td><a href='${ctx}/Webnews/getNewsById/"+rows[i].newsId +"target='_self'>"+rows[i].title+"</a></td></tr>";
	    						}else{
	    							str+="<td><a href='javascript:void(0);'>该资讯不存在！</a></td></tr>";
	    						}
	        			}
	            	}
	            	$(".detailByList .list").empty().append(str);
	            	$(function(){
	            		$(".detailByList .list").find(".time ").each(function(){
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
			$(".detailByList .list").find(".time ").each(function(){
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