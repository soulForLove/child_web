/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.54
 * Generated at: 2015-12-06 14:07:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.sysmgr;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class serviceMgr_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".cell-style {\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\twhite-space: nowrap;\r\n");
      out.write("\ttext-overflow: ellipsis;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("\t//jquery validate表单验证\r\n");
      out.write("\t$().ready(function() {\r\n");
      out.write("\t\t$(\"#myform\").validate({\r\n");
      out.write("\t\t\trules : {\r\n");
      out.write("\t\t\t\tuserId:\"required\",\r\n");
      out.write("\t\t\t\ttitle:\"required\",\r\n");
      out.write("\t\t\t\tdetail:\"required\"\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tmessages : {\r\n");
      out.write("\t\t\t\tuserId:\"请选择用户ID\",\r\n");
      out.write("\t\t\t\ttitle:\"请输入标题\",\r\n");
      out.write("\t\t\t\tdetail:\"请输入详细内容\"\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\tvar $table = $('#table');\r\n");
      out.write("\t\t$table.bootstrapTable({\r\n");
      out.write("\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/serviceInfo/pageQueryServiceInfo',\r\n");
      out.write("\t\t\tmethod : 'post',\r\n");
      out.write("\t\t\tsidePagination : 'server',\r\n");
      out.write("\t\t\tqueryParamsType : 'self',\r\n");
      out.write("\t\t\tqueryParams : function(params) {\r\n");
      out.write("\t\t\t\tvar pageParam = {\r\n");
      out.write("\t\t\t\t\tpage : params.pageNumber,\r\n");
      out.write("\t\t\t\t\trows : params.pageSize\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t\t\t\tvar searchParam = $(\".form-search\").getSearchFormObject();\r\n");
      out.write("\t\t\t\treturn $.extend(pageParam, searchParam);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tstriped : true,\r\n");
      out.write("\t\t\tpagination : true,\r\n");
      out.write("\t\t\tpageList : [ 10, 20, 50 ],\r\n");
      out.write("\t\t\tpageSize : 10,\r\n");
      out.write("\t\t\tpageNumber : 1,\r\n");
      out.write("\t\t\theight : getHeight(),\r\n");
      out.write("\t\t\tcolumns : [ {\r\n");
      out.write("\t\t\t\tfield : 'serviceId',\r\n");
      out.write("\t\t\t\ttitle : '编号',\r\n");
      out.write("\t\t\t\twidth : '10%',\r\n");
      out.write("\t\t\t\talign : 'center'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tfield : 'userName',\r\n");
      out.write("\t\t\t\ttitle : '用户名',\r\n");
      out.write("\t\t\t\twidth : '10%',\r\n");
      out.write("\t\t\t\talign : 'center'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tfield : 'title',\r\n");
      out.write("\t\t\t\ttitle : '标题',\r\n");
      out.write("\t\t\t\tcellStyle:cellStyle,\r\n");
      out.write("\t\t\t\twidth : '20%',\r\n");
      out.write("\t\t\t\talign : 'center'\r\n");
      out.write("\t\t\t},  {\r\n");
      out.write("\t\t\t\tfield : 'submitTime',\r\n");
      out.write("\t\t\t\ttitle : '提交时间',\r\n");
      out.write("\t\t\t\twidth : '20%',\r\n");
      out.write("\t\t\t\tformatter : Utils.tranTimeStr,\r\n");
      out.write("\t\t\t\talign : 'center'\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tfield : 'handleTime',\r\n");
      out.write("\t\t\t\ttitle : '处理时间',\r\n");
      out.write("\t\t\t\twidth : '20%',\r\n");
      out.write("\t\t\t\tformatter : Utils.tranTimeStr,\r\n");
      out.write("\t\t\t\talign : 'center'\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tfield : 'ip',\r\n");
      out.write("\t\t\t\ttitle : 'IP',\r\n");
      out.write("\t\t\t\twidth : '10%',\r\n");
      out.write("\t\t\t\talign : 'center'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tfield : 'serviceId',\r\n");
      out.write("\t\t\t\ttitle : '操作',\r\n");
      out.write("\t\t\t\tformatter : operateFormatter,\r\n");
      out.write("\t\t\t\tevents : operateEvents,\r\n");
      out.write("\t\t\t\twidth : '10%',\r\n");
      out.write("\t\t\t\talign : 'center'\r\n");
      out.write("\t\t\t} ]\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$table.on('load-success.bs.table', function(data) {\r\n");
      out.write("\t\t\t//console.log(\"load-success...\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction cellStyle(value, row, index) {\r\n");
      out.write("\t\t\t  return {\r\n");
      out.write("\t\t\t   classes : 'cell-style'\r\n");
      out.write("\t\t\t  };\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t// 保存\r\n");
      out.write("\t\t$(\"#btnSave\").click(\r\n");
      out.write("\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\tif ($(\"#myform\").valid()) {\r\n");
      out.write("\t\t\t\t\t\tvar obj = $(\".form-save\").getFormObject();\r\n");
      out.write("\t\t\t\t\t\t$.ajaxPostJson(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/serviceInfo/saveOrUpdateServiceInfo\",\r\n");
      out.write("\t\t\t\t\t\t\t\tobj, function(result) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$('#table').bootstrapTable(\"refresh\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$('#myModal').modal('hide');\r\n");
      out.write("\t\t\t\t\t\t\t\t\tshowMessage(\"操作成功!\");\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t// 新增\r\n");
      out.write("\t\t$(\".add\").click(function() {\r\n");
      out.write("\t\t\t$(\".form-save\").clearForm();\r\n");
      out.write("\t\t\t$(\"#serviceId\").val(\"\");\r\n");
      out.write("\t\t\t$('#myModalLabel').html('新增');\r\n");
      out.write("\t\t\t$('#myModal').modal('show');\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t//查询\r\n");
      out.write("\t\t$(\"#btnSearch\").click(function() {\r\n");
      out.write("\t\t\t$table.bootstrapTable(\"selectPage\", 1);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\twindow.operateEvents = {\r\n");
      out.write("\t\t'click .edit' : function(e, value, row, index) {\r\n");
      out.write("\t\t\t$('#myUserLabel').html('用户名');\r\n");
      out.write("\t\t\t$('#myModal').modal('show');\r\n");
      out.write("\t\t\t$('#myModalLabel').html('修改');\r\n");
      out.write("\t\t\t$.ajaxPostJson(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/serviceInfo/getServiceInfoById/\" + row.serviceId,\r\n");
      out.write("\t\t\t\t\t{}, function(result) {\r\n");
      out.write("\t\t\t\t\t\tif (result) {\r\n");
      out.write("\t\t\t\t\t\t\t$(\".form-save\").setFormObject(result);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\t'click .remove' : function(e, value, row, index) {\r\n");
      out.write("\t\t\t$('#confirmModal').modal('show');\r\n");
      out.write("\t\t\t$(\"#btnConfirm\").click(\r\n");
      out.write("\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\t$.ajaxPostJson(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/serviceInfo/deleteServiceInfo/\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ row.serviceId, {}, function(result) {\r\n");
      out.write("\t\t\t\t\t\t\t$('#table').bootstrapTable(\"refresh\");\r\n");
      out.write("\t\t\t\t\t\t\t$('#confirmModal').modal('hide');\r\n");
      out.write("\t\t\t\t\t\t\tshowMessage(\"操作成功!\");\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\t};\r\n");
      out.write("\tfunction getHeight() {\r\n");
      out.write("\t\treturn $(window).height() - $('#toolbarDiv').outerHeight(true) - 150;\r\n");
      out.write("\t}\r\n");
      out.write("\t// 修改、删除\r\n");
      out.write("\tfunction operateFormatter(value, row, index) {\r\n");
      out.write("\t\treturn [\r\n");
      out.write("\t\t\t\t'<a class=\"edit\" href=\"javascript:void(0)\" title=\"编辑\"><i class=\"glyphicon glyphicon-edit\"></i></a>',\r\n");
      out.write("\t\t\t\t'<a class=\"remove\" href=\"javascript:void(0)\" title=\"删除\"><i class=\"glyphicon glyphicon-remove\"></i></a>', ]\r\n");
      out.write("\t\t\t\t.join('&nbsp;&nbsp;');\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"panel panel-primary\">\r\n");
      out.write("\t\t\t\t<div class=\"panel-heading\" id=\"toolbarDiv\">\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-3 col-lg-3\">\r\n");
      out.write("\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary btn-md add\">添加</button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-9 col-lg-9 text-right\">\r\n");
      out.write("\t\t\t\t\t\t\t<form class=\"form-search form-inline\" action=\"#\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"search_title\">标题：</label> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"search_title\" name=\"search_title\" placeholder=\"请输入标题\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-default\" id=\"btnSearch\">查询</button>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t\t\t<table id=\"table\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"table table-bordered table-striped table-condensed table-hover\" style=\"table-layout:fixed;\">\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\"\r\n");
      out.write("\t\taria-labelledby=\"myModalLabel\">\r\n");
      out.write("\t\t<div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("\t\t\t\t\t\taria-label=\"Close\">\r\n");
      out.write("\t\t\t\t\t\t<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t<h4 class=\"modal-title\" id=\"myModalLabel\">添加</h4>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t<form class=\"form-save form-horizontal\" method=\"post\" action=\"#\"\r\n");
      out.write("\t\t\t\t\t\tid=\"myform\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" id=\"serviceId\" name=\"serviceId\" />\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"title\" class=\"col-sm-3 control-label\">标题：</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"title\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"title\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"title\" class=\"col-sm-3 control-label\">用户ID：</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"userId\" name=\"userId\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"\">请选择</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"detail\" class=\"col-sm-3 control-label\">详细：</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<textarea class=\"form-control\" rows=\"6\" id=\"detail\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"detail\" style=\"resize: none;\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"handleTime\" class=\"col-sm-3 control-label\">处理时间：</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"datetime-local\" id=\"handleTime\" name=\"handleTime\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭</button>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" id=\"btnSave\">保存</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/views/sysmgr/serviceMgr.jsp(3,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /WEB-INF/views/sysmgr/serviceMgr.jsp(3,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/views/sysmgr/serviceMgr.jsp(223,9) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userlist}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    // /WEB-INF/views/sysmgr/serviceMgr.jsp(223,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("user");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.userId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.userId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
