/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.54
 * Generated at: 2016-01-17 11:23:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.adminMgr;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.lzt.asyn.sysmgr.model.*;

public final class Sindex_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<title>少儿资讯管理后台</title>\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html lang=\"zh-CN\">\r\n");
      out.write("  <head>\r\n");
      out.write("    \r\n");
      out.write("<style>\r\n");
      out.write("\t/** 重写bootstrap */\r\n");
      out.write("\t.container-fluid{padding: 0px 3px 0px 3px;}\r\n");
      out.write("\t.navbar-fixed-top{/* position:static; */}\r\n");
      out.write("\t.navbar-header{padding-left: 33px;width: 180px;}\r\n");
      out.write("\t/** 自定义 */\r\n");
      out.write("\tbody{padding-bottom: 70px;}\r\n");
      out.write("\t#header{margin-bottom: 3px;}\r\n");
      out.write("\t#content{margin-top:50px;}\r\n");
      out.write("\t.sidebar .sidebar-nav.navbar-collapse {padding-right: 0; padding-left: 0;}\r\n");
      out.write("\t.sidebar .sidebar-search {padding: 15px;}\r\n");
      out.write("\t.sidebar ul li {border-bottom: 1px solid #e7e7e7;}\r\n");
      out.write("\t.sidebar ul li a.active {background-color: #eee;}\r\n");
      out.write("\t.sidebar .arrow {float: right;}\r\n");
      out.write("\t.sidebar .fa.arrow:before { content: \"\\f104\";}\r\n");
      out.write("\t.sidebar .active>a>.fa.arrow:before {content: \"\\f107\";}\r\n");
      out.write("\t.sidebar .nav-2-level li,.sidebar .nav-3-level li {border-bottom: 0!important;}\r\n");
      out.write("\t.sidebar .nav-2-level li a {padding-left: 37px;}\r\n");
      out.write("\t.sidebar .nav-3-level li a {padding-left: 52px;}\r\n");
      out.write("\t@media(min-width:768px) {\r\n");
      out.write("\t    #left  {position: absolute; width: 180px;margin-top: 3px;z-index: 1;}\r\n");
      out.write("\t\t#right {position: inherit; margin-left:186px;padding: 5px;border-left: 1px solid #e7e7e7;}\r\n");
      out.write("\t    .navbar-top-links .dropdown-messages,\r\n");
      out.write("\t    .navbar-top-links .dropdown-tasks,\r\n");
      out.write("\t    .navbar-top-links .dropdown-alerts {margin-left: auto;}\r\n");
      out.write("\t}\r\n");
      out.write("\t#openClose {position: absolute;width:6px;height:100%;margin-left:180px;cursor:pointer;background:silver;}\r\n");
      out.write("</style>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/metismenu/2.0.3/metisMenu.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\tvar ctx = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\tconsole.log(\"index\"+$(window).height());\r\n");
      out.write("\t\t$(\"#mainFrame\").css('height',$(window).height()-100);\r\n");
      out.write("\t\t// 一级菜单\r\n");
      out.write("\t\t$(\"#menuTop a\").click(function() {\r\n");
      out.write("\t\t\t$(\"#menuTop li\").removeClass(\"active\");\r\n");
      out.write("\t\t\t$(this).parent().addClass(\"active\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//初始化菜单\r\n");
      out.write("\t\teval('var nodes = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${menuList}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(";');\r\n");
      out.write("\t\tvar menuHtml = \"\";\r\n");
      out.write("\t\tfor(var i=0;i<nodes.length;i++){\r\n");
      out.write("\t\t\tmenuHtml += getMenuHtmlCascade(nodes[i],1);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$('#side-menu').append(menuHtml).metisMenu();\r\n");
      out.write("\t});\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction getMenuHtmlCascade(node,level){\r\n");
      out.write("\t\tvar hasChild = node.children && node.children.length>0; \r\n");
      out.write("\t\tvar html = '<li><a '+(node.url==''?'href=\"#\"':'href=\"'+ctx+node.url+'\" target=\"mainFrame\"')+'><i class=\"fa '+node.icon +'\"></i>'+node.name+(hasChild?'<i class=\"fa arrow\"></i>':'')+'</a>';\r\n");
      out.write("\t\t\tif(hasChild){\r\n");
      out.write("\t\t\t\thtml+='<ul class=\"nav nav-'+(level+1)+'-level collapse\">';\r\n");
      out.write("\t\t\t\tfor(var i=0;i<node.children.length;i++){\r\n");
      out.write("\t\t\t\t\thtml+=getMenuHtmlCascade(node.children[i], level+1);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\thtml+='</ul>';\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\thtml+= '</li>';\r\n");
      out.write("\t\treturn html;\r\n");
      out.write("\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  \t<div id=\"main\">\r\n");
      out.write("\t\t<div id=\"header\" role=\"navigation\" class=\"navbar navbar-default navbar-fixed-top\">\r\n");
      out.write("\t\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t\t<a class=\"navbar-brand\" href=\"#\">少儿资讯平台</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"collapse navbar-collapse\">\r\n");
      out.write("\t\t\t\t\t<ul id=\"menuTop\" class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t\t\t<li class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t");

						SuperAdmin admin = (SuperAdmin) request.getSession().getAttribute("loginSAdmin");
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"fa fa-user\"></i>您好, ");
      out.print(admin.getAdminName());
      out.write("<span class=\"caret\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Sindex/updateInfoFace\" target=\"mainFrame\">个人信息</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Sindex/updatePwdFace\" target=\"mainFrame\">修改密码</a></li><!-- 怎样取得id传过去 -->\r\n");
      out.write("\t\t\t\t\t\t\t\t<li role=\"separator\" class=\"divider\"></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/login\">注销</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li>&nbsp;&nbsp;&nbsp;</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"content\" class=\"container-fluid\">\r\n");
      out.write("\t\t\t<div class=\"row-fluid\">\r\n");
      out.write("\t\t\t\t<div id=\"left\" class=\"sidebar\">\r\n");
      out.write("\t\t\t\t\t<div class=\"sidebar-nav navbar-collapse\">\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"nav in\" id=\"side-menu\">\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- <div id=\"openClose\" class=\"close\">&nbsp;</div> --><!-- 分界线 -->\r\n");
      out.write("\t\t\t\t<div id=\"right\">\r\n");
      out.write("\t\t\t\t\t<iframe id=\"mainFrame\" name=\"mainFrame\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Sindex/SnewsMgr\" style=\"overflow: visible;\" scrolling=\"yes\" frameborder=\"no\" width=\"100%\" height=\"600\"></iframe>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<nav class=\"navbar navbar-default navbar-fixed-bottom\">\r\n");
      out.write("\t  <div class=\"container text-center\" style=\"margin-top:10px\">\r\n");
      out.write("\t\t\tCopyright © 2015 <a href=\"#\">Linzhongtai</a> All Rights Reserved.</p>\r\n");
      out.write("\t  </div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("  </body>\r\n");
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
    // /WEB-INF/views/adminMgr/Sindex.jsp(8,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /WEB-INF/views/adminMgr/Sindex.jsp(8,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
