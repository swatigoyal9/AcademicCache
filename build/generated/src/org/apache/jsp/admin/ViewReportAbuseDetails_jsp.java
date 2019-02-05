package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import beans.admin.ManageReportAbuseBean;
import services.admin.ManageReportAbuseServices;
import java.util.*;
import Beans.Admin.*;
import Services.Admin.*;

public final class ViewReportAbuseDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>View Report Abuse Details</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            ManageReportAbuseServices objServices=new ManageReportAbuseServices();
            ManageReportAbuseBean objBean=new ManageReportAbuseBean();
            objBean=objServices.getCurrentResourceAbuse(request.getParameter("user_id"),request.getParameter("title"),request.getParameter("report_id"));
            System.out.println("in viewdetails");

        
      out.write("\n");
      out.write("        <form action=\"ManageReportAbuseController.jsp\" method=\"get\">\n");
      out.write("            <table align=\"center\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <table align=\"center\">\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <h3><u>View Report Abuse Details</u></h3>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <fieldset>\n");
      out.write("                            <legend><strong><em>Resource Details</em></strong></legend>\n");
      out.write("                            <table align=\"center\" cellpadding=\"5\" rules=\"group\" >\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><b>Resource&nbsp;Title</b></td>\n");
      out.write("                                    <td><label>");
      out.print(objBean.getTxtTitle());
      out.write("</label></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><b>Resource&nbsp;Type</b></td>\n");
      out.write("                                    <td>");
      out.print(objBean.getTxtType());
      out.write("</td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><b>Resource&nbsp;Size</b></td>\n");
      out.write("                                    <td><label>");
      out.print(objBean.getTxtSize());
      out.write(" MB</label></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><b>Uploaded&nbsp;By</b></td>\n");
      out.write("                                    <td><label>");
      out.print(objBean.getTxtName());
      out.write("</label></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><b>Report&nbsp;Status</b></td>\n");
      out.write("                                    <td><label>");
      out.print(objBean.getUserStatus());
      out.write("</label></td>\n");
      out.write("                                </tr>\n");
      out.write("                            </table>\n");
      out.write("                        </fieldset>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <fieldset>\n");
      out.write("                            <legend><strong><em>Report Abuse Details</em></strong></legend>\n");
      out.write("                            <table align=\"center\" cellpadding=\"5\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><b>Report Abuse By</b></td>\n");
      out.write("                                    <td><label>");
      out.print(objBean.getTxtReportUser());
      out.write("</label></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><b>Report Subject</b></td>\n");
      out.write("                                    <td>");
      out.print(objBean.getTxtType());
      out.write("</td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td valign=\"top\"><b>Description</b></td>\n");
      out.write("                                    <td><textarea name=\"taDescription\" id=\"taDescription\" rows=\"3\" cols=\"23\" readonly=\"readonly\">");
      out.print(objBean.getTxtDescription());
      out.write("</textarea></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><b>Report Date</b></td>\n");
      out.write("                                    <td><label>");
      out.print(objBean.getReportDate());
      out.write("</label></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><b>Attachment</b></td>\n");
      out.write("                                    <td>\n");
      out.write("                                        ");

                                                if(objBean.getTxtFileName().equalsIgnoreCase("File Not Exists"))
                                                {   
                                        
      out.write("\n");
      out.write("                                                    \"File Not Exists\"\n");
      out.write("                                        ");

                                                }
                                                else
                                                 {    
                                        
      out.write("\n");
      out.write("                                        \n");
      out.write("                                        <a href=\"../DownloadServlet?report_id=");
      out.print(objBean.getTxtReportId());
      out.write("\">Download</a>\n");
      out.write("                                        ");

                                        
                                                 }
                                         
      out.write("\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                            </table>\n");
      out.write("                        </fieldset>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <fieldset>\n");
      out.write("                            <legend><strong><em>Response</em></strong></legend>\n");
      out.write("                            <table align=\"center\" cellpadding=\"5\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td valign=\"top\"><b>Response</b></td>\n");
      out.write("                                    <td><textarea name=\"taResponse\" id=\"taResponse\" rows=\"3\" cols=\"23\"></textarea></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td colspan=\"2\" align=\"center\">\n");
      out.write("                                        <input type=\"hidden\" name=\"txtResourceId\" value=\"");
      out.print(objBean.getTxtResourceId());
      out.write("\"/>\n");
      out.write("                                        <input type=\"hidden\" name=\"txtReportId\" value=\"");
      out.print(objBean.getTxtReportId());
      out.write("\"/>\n");
      out.write("                                        <input type=\"hidden\" name=\"user_id\" value=\"");
      out.print(request.getParameter("user_id"));
      out.write("\"/>\n");
      out.write("                                        <input type=\"hidden\" name=\"title\" value=\"");
      out.print(objBean.getTxtTitle());
      out.write("\"/>\n");
      out.write("                                        <input type=\"hidden\" name=\"type\" value=\"");
      out.print(objBean.getTxtType());
      out.write("\"/>\n");
      out.write("                                        <input type=\"submit\" name=\"sbtnDelete\" value=\"Delete Resource\" class=\"button\"/>\n");
      out.write("                                        <input type=\"submit\" name=\"sbtnBlock\" value=\"Block User\" class=\"button\"/>\n");
      out.write("                                        <input type=\"submit\" name=\"sbtnCancel\" value=\"Cancel Report Abuse\" class=\"button\"/>\n");
      out.write("                                        <input type=\"button\" name=\"btnBack\" value=\"Back\" class=\"button\" onclick=\"window.location='ManageReportAbuse_mp.jsp'\"/>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                            </table>\n");
      out.write("                        </fieldset>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
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
