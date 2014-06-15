package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_var_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_url_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_url_var_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>ShortUrl</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/bootstrap.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/style.css\">\r\n");
      out.write("    <link href=\"//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css\" rel=\"stylesheet\">\r\n");
      out.write("    <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("    <script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<nav class=\"navbar navbar-default\" role=\"navigation\">\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("        <div style=\"margin-top: 5px\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"/\">ShortUrl</a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        ");
      if (_jspx_meth_c_url_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${logoutUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" method=\"post\" id=\"logoutForm\">\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("            function formSubmit() {\r\n");
      out.write("                document.getElementById(\"logoutForm\").submit();\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"navbar-right\">\r\n");
      out.write("               <span style=\"font-size: 18px; padding-right: 10px\">\r\n");
      out.write("                Добро пожаловать, ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.userPrincipal.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("!\r\n");
      out.write("               </span>\r\n");
      out.write("            <button class=\"btn btn-default\" type=\"submit\" onclick=\"javascript:formSubmit()\">Выход</button>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("    <div class=\"form-inline\">\r\n");
      out.write("        <div id=\"errors\"></div>\r\n");
      out.write("        <input type=\"text\" id=\"originalLink\" name=\"originalLink\" class=\"form-control\" style=\"width: 300px\" placeholder=\"Введите URL\">\r\n");
      out.write("        <button class=\"btn btn-primary\" onclick=\"addUrl();\">Выполнить</button>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <br>\r\n");
      out.write("    <i class=\"glyphicon glyphicon-chevron-down\"> </i><br>\r\n");
      out.write("    <i class=\"glyphicon glyphicon-chevron-down\" style=\"margin-top: -5px\"> </i><br><br>\r\n");
      out.write("\r\n");
      out.write("    <form class=\"form-inline\">\r\n");
      out.write("        <input id=\"shortUrl\" type=\"text\" name=\"shortCode\" class=\"form-control\" style=\"width: 400px\" placeholder=\"Результат\" onclick=\"this.select();\">\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    /*<![CDATA[*/\r\n");
      out.write("\r\n");
      out.write("    function addUrl() {\r\n");
      out.write("        $('#errors').html('');\r\n");
      out.write("        var originalLink = $('input#originalLink').val();\r\n");
      out.write("        if (isValidURL(originalLink)) {\r\n");
      out.write("            var url = \"/url\";\r\n");
      out.write("            $.post(url, {'originalLink': originalLink}, function (url) {\r\n");
      out.write("                alert(url.shortCode);\r\n");
      out.write("                $('input#shortUrl').val('localhost:8080/'+url.shortCode);  //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\r\n");
      out.write("            });\r\n");
      out.write("        } else {\r\n");
      out.write("            var html = '<div class=\"error\">';\r\n");
      out.write("            html += 'Вы ввели некорректную ссылку';\r\n");
      out.write("            html += '</div>';\r\n");
      out.write("            $('#errors').html(html);\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function isValidURL(url) {\r\n");
      out.write("        var RegExp = /\\(?(?:(http|https|ftp):\\/\\/)?(?:((?:[^\\W\\s]|\\.|-|[:]{1})+)@{1})?((?:www.)?(?:[^\\W\\s]|\\.|-)+[\\.][^\\W\\s]{2,4}|localhost(?=\\/)|\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})(?::(\\d*))?([\\/]?[^\\s\\?]*[\\/]{1})*(?:\\/?([^\\s\\n\\?\\[\\]\\{\\}#]*(?:(?=\\.)){1}|[^\\s\\n\\?\\[\\]\\{\\}\\.#]*)?([\\.]{1}[^\\s\\?#]*)?)?(?:\\?{1}([^\\s\\n#\\[\\]]*))?([#][^\\s\\n]*)?\\)?/gi;\r\n");
      out.write("\r\n");
      out.write("        if (RegExp.test(url)) {\r\n");
      out.write("            return true;\r\n");
      out.write("        } else {\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    /*]]>*/\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_url_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_0.setPageContext(_jspx_page_context);
    _jspx_th_c_url_0.setParent(null);
    _jspx_th_c_url_0.setValue("/j_spring_security_logout");
    _jspx_th_c_url_0.setVar("logoutUrl");
    int _jspx_eval_c_url_0 = _jspx_th_c_url_0.doStartTag();
    if (_jspx_th_c_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_var_value_nobody.reuse(_jspx_th_c_url_0);
      return true;
    }
    _jspx_tagPool_c_url_var_value_nobody.reuse(_jspx_th_c_url_0);
    return false;
  }
}
