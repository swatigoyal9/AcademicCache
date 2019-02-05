package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Login</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"LoginServlet\" method=\"post\">\n");
      out.write("            <table align=\"right\" > \n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <fieldset><legend><strong><em>&nbsp;Login&nbsp;</em></strong></legend>\n");
      out.write("                            <table cellpadding=\"5\" >\n");
      out.write("                                <tr> \n");
      out.write("                                    <td colspan=\"2\" align=\"left\">\n");
      out.write("                                        <label id =\"lblMsg\"></label>\n");
      out.write("                                    </td>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>User&nbsp;Name</td>\n");
      out.write("                                    <td><input  id=\"txtUsername\" name=\"txtUsername\"  type=\"text\" /></td>\n");
      out.write("\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Password</td>\n");
      out.write("                                    <td><input  id=\"txtPassword\" name=\"txtPassword\" type=\"password\" /></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td colspan=\"2\" align=\"right\" >\n");
      out.write("                                        <input id=\"sbtnLogin\"  name=\"sbtnLogin\" type=\"submit\" value=\"Login\" class=\"button\"/>\n");
      out.write("                                        <input id=\"rbtnReset\" name=\"rbtnReset\"  type=\"reset\" value=\"Reset\" class=\"button\"/>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td colspan=\"2\" align=\"center\" ><a href=\"ForgotPassword_mp.jsp\">Forgot Password ?</a>&nbsp;&nbsp;<a href=\"SignUp_mp.jsp\">Sign Up</a></td>\n");
      out.write("                                </tr>\n");
      out.write("                            </table>\n");
      out.write("                        </fieldset>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
