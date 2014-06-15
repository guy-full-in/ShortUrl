package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registr_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_form_method_cssClass_commandName_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_errors_path_element_cssClass_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_form_form_method_cssClass_commandName_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_form_errors_path_element_cssClass_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_form_form_method_cssClass_commandName_action.release();
    _jspx_tagPool_form_errors_path_element_cssClass_nobody.release();
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Registration Page</title>\r\n");
      out.write("    <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/bootstrap.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/style.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<div>\r\n");
      out.write("    <nav class=\"navbar navbar-default\" role=\"navigation\">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("            <div style=\"margin-top: 5px\">\r\n");
      out.write("                <a class=\"navbar-brand\" href=\"/\">ShortUrl</a>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <ul class=\"nav navbar-nav\">\r\n");
      out.write("                <li>\r\n");
      out.write("                    <button type=\"button\" class=\"btn btn-link navbar-btn\" onclick=\"javascript:history.back()\">Вернуться\r\n");
      out.write("                        назад\r\n");
      out.write("                    </button>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("    <h3 align=\"center\">Регистрация</h3><br>\r\n");
      out.write("\r\n");
      out.write("    <div align=\"center\">\r\n");
      out.write("        ");
      //  form:form
      org.springframework.web.servlet.tags.form.FormTag _jspx_th_form_form_0 = (org.springframework.web.servlet.tags.form.FormTag) _jspx_tagPool_form_form_method_cssClass_commandName_action.get(org.springframework.web.servlet.tags.form.FormTag.class);
      _jspx_th_form_form_0.setPageContext(_jspx_page_context);
      _jspx_th_form_form_0.setParent(null);
      _jspx_th_form_form_0.setCssClass("form-horizontal");
      _jspx_th_form_form_0.setMethod("POST");
      _jspx_th_form_form_0.setCommandName("user");
      _jspx_th_form_form_0.setAction("/registr");
      int[] _jspx_push_body_count_form_form_0 = new int[] { 0 };
      try {
        int _jspx_eval_form_form_0 = _jspx_th_form_form_0.doStartTag();
        if (_jspx_eval_form_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("            ");
            //  form:errors
            org.springframework.web.servlet.tags.form.ErrorsTag _jspx_th_form_errors_0 = (org.springframework.web.servlet.tags.form.ErrorsTag) _jspx_tagPool_form_errors_path_element_cssClass_nobody.get(org.springframework.web.servlet.tags.form.ErrorsTag.class);
            _jspx_th_form_errors_0.setPageContext(_jspx_page_context);
            _jspx_th_form_errors_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
            _jspx_th_form_errors_0.setPath("*");
            _jspx_th_form_errors_0.setCssClass("error");
            _jspx_th_form_errors_0.setElement("div");
            int[] _jspx_push_body_count_form_errors_0 = new int[] { 0 };
            try {
              int _jspx_eval_form_errors_0 = _jspx_th_form_errors_0.doStartTag();
              if (_jspx_th_form_errors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
            } catch (Throwable _jspx_exception) {
              while (_jspx_push_body_count_form_errors_0[0]-- > 0)
                out = _jspx_page_context.popBody();
              _jspx_th_form_errors_0.doCatch(_jspx_exception);
            } finally {
              _jspx_th_form_errors_0.doFinally();
              _jspx_tagPool_form_errors_path_element_cssClass_nobody.reuse(_jspx_th_form_errors_0);
            }
            out.write("\r\n");
            out.write("            <div class=\"form-group\">\r\n");
            out.write("                <label for=\"username\" class=\"col-sm-5 control-label\">Логин</label>\r\n");
            out.write("\r\n");
            out.write("                <div class=\"col-sm-2\">\r\n");
            out.write("                    <input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\" placeholder=\"Логин\">\r\n");
            out.write("                </div>\r\n");
            out.write("            </div>\r\n");
            out.write("\r\n");
            out.write("            <div class=\"form-group\">\r\n");
            out.write("                <label for=\"email\" class=\"col-sm-5 control-label\">E-mail</label>\r\n");
            out.write("\r\n");
            out.write("                <div class=\"col-sm-2\">\r\n");
            out.write("                    <input type=\"text\" class=\"form-control\" id=\"email\" name=\"email\" placeholder=\"E-mail\">\r\n");
            out.write("                </div>\r\n");
            out.write("            </div>\r\n");
            out.write("\r\n");
            out.write("            <div class=\"form-group\">\r\n");
            out.write("                <label for=\"password\" class=\"col-sm-5 control-label\">Пароль</label>\r\n");
            out.write("\r\n");
            out.write("                <div class=\"col-sm-2\">\r\n");
            out.write("                    <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" placeholder=\"Пароль\">\r\n");
            out.write("                </div>\r\n");
            out.write("            </div>\r\n");
            out.write("            <div class=\"form-group\">\r\n");
            out.write("                <label for=\"confirmPassword\" style=\"margin-top: -10px\" class=\"col-sm-5 control-label\">Подтверждение<br>\r\n");
            out.write("                    пароля</label>\r\n");
            out.write("\r\n");
            out.write("                <div class=\"col-sm-2\">\r\n");
            out.write("                    <input type=\"password\" class=\"form-control\" id=\"confirmPassword\" name=\"confirmPassword\"\r\n");
            out.write("                           placeholder=\"Подтверждения пароля\">\r\n");
            out.write("                </div>\r\n");
            out.write("            </div>\r\n");
            out.write("            <div class=\"form-group\">\r\n");
            out.write("                <div class=\"col-sm-offset-4 col-sm-4\">\r\n");
            out.write("                    <button type=\"submit\" class=\"btn btn-success\">Регистрация</button>\r\n");
            out.write("                </div>\r\n");
            out.write("            </div>\r\n");
            out.write("        ");
            int evalDoAfterBody = _jspx_th_form_form_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_form_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_form_form_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_form_form_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_form_form_0.doFinally();
        _jspx_tagPool_form_form_method_cssClass_commandName_action.reuse(_jspx_th_form_form_0);
      }
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
}
