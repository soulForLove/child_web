/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.54
 * Generated at: 2015-12-07 15:26:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.website;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class updatePwd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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

      out.write('\n');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta name=\"decorator\" content=\"default\" />\n");
      out.write("<title>修改密码</title>\n");
      out.write("<script>\n");
      out.write("\t//jquery validate表单验证\n");
      out.write("\t$(function() {\n");
      out.write("\t\t$(\"#updateform\").validate({\n");
      out.write("\t\t\trules : {\n");
      out.write("\t\t\t\tpasswordOld : \"required\",\n");
      out.write("\t\t\t\tpasswordNew : {\n");
      out.write("\t\t\t\t\trequired : true,\n");
      out.write("\t\t\t\t\tminlength : 6\n");
      out.write("\t\t\t\t},\n");
      out.write("\t\t\t\tpasswordNewConfirm : {\n");
      out.write("\t\t\t\t\trequired : true,\n");
      out.write("\t\t\t\t\tminlength : 6,\n");
      out.write("\t\t\t\t\tequalTo : \"#passwordNew\"\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t},\n");
      out.write("\t\t\tmessages : {\n");
      out.write("\t\t\t\tpasswordOld : \"请输入原始密码\",\n");
      out.write("\t\t\t\tpasswordNew : {\n");
      out.write("\t\t\t\t\trequired : \"请输入密码\",\n");
      out.write("\t\t\t\t\tminlength : \"至少为六位\"\n");
      out.write("\t\t\t\t},\n");
      out.write("\t\t\t\tpasswordNewConfirm : {\n");
      out.write("\t\t\t\t\trequired : \"请输入密码\",\n");
      out.write("\t\t\t\t\tminlength : \"至少为六位\",\n");
      out.write("\t\t\t\t\tequalTo : \"两次密码不一致\"\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t});\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div class=\"container\" >\n");
      out.write("\t\t<br>\n");
      out.write("\t\t<div id=\"box\">\n");
      out.write("\t\t\t<form class=\"form-save form-horizontal\" method=\"post\" action=\"#\" id=\"updateform\" name=\"updateform\">\n");
      out.write("\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t<label for=\"passwordOld\" class=\"col-md-3 control-label\">原始密码：</label>\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-9\">\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" id=\"passwordOld\" name=\"passwordOld\"\n");
      out.write("\t\t\t\t\t\t\tclass=\"form-control \" placeholder=\"原始密码\"/>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t<label for=\"passwordNew\" class=\"col-md-3 control-label\">新密码：</label>\n");
      out.write("\t\t\t\t\t<div class=\"col-md-9\">\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" id=\"passwordNew\" name=\"passwordNew\"\n");
      out.write("\t\t\t\t\t\t\tclass=\"form-control \" placeholder=\"新密码\"/>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t<label for=\"passwordNewConfirm\" class=\"col-md-3 control-label\">确认密码：</label>\n");
      out.write("\t\t\t\t\t<div class=\"col-md-9\">\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" id=\"passwordNewConfirm\"\n");
      out.write("\t\t\t\t\t\t\tname=\"passwordNewConfirm\" class=\"form-control\" placeholder=\"确认密码\"/>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t<label for=\"content\" class=\"col-md-3 control-label\"></label>\n");
      out.write("\t\t\t\t\t<div class=\"col-md-9\">\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" id=\"btnSave\">确认修改</button>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t<script>\n");
      out.write("\t\t$(document).ready(function() {\n");
      out.write("\t\t\t$(\"#btnSave\").click(function() {\n");
      out.write("\t\t\t\tvar passwordOld = $(\"#passwordOld\").val();\n");
      out.write("\t\t\t\tvar passwordNew = $(\"#passwordNew\").val();\n");
      out.write("\t\t\t\tif ($(\"#updateform\").valid()) {\n");
      out.write("\t\t\t\t\t$.ajaxPost(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Webuser/updatePwd\", {\n");
      out.write("\t\t\t\t\t\t\"passwordOld\" : passwordOld,\n");
      out.write("\t\t\t\t\t\t\"passwordNew\" : passwordNew\n");
      out.write("\t\t\t\t\t}, function(result) {\t\n");
      out.write("\t\t\t\t\t\tif(result){\n");
      out.write("\t\t\t\t\t\t\talert(\"修改成功!\");\n");
      out.write("\t\t\t\t\t\t\ttop.location.reload(); \n");
      out.write("\t\t\t\t\t\t\t$(\"#passwordOld\").val(\"\");\n");
      out.write("\t\t\t\t\t\t\t$(\"#passwordNew\").val(\"\");\n");
      out.write("\t\t\t\t\t\t\t$(\"#passwordNewConfirm\").val(\"\");\n");
      out.write("\t\t\t\t\t\t\t/* setTimeout(function(){history.back();},1000); */\n");
      out.write("\t\t\t\t\t\t}else{\n");
      out.write("\t\t\t\t\t\t\talert(\"原始密码错误！\");\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t});\n");
      out.write("\t\t\t\t}\n");
      out.write("\n");
      out.write("\t\t\t});\n");
      out.write("\t\t});\n");
      out.write("\t</script>\n");
      out.write("</body>\n");
      out.write("</html>");
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
    // /WEB-INF/views/website/updatePwd.jsp(3,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /WEB-INF/views/website/updatePwd.jsp(3,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }
}