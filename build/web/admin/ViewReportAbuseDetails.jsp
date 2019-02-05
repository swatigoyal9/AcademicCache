<%@page import="beans.admin.ManageReportAbuseBean"%>
<%@page import="services.admin.ManageReportAbuseServices"%>
<%@page import="java.util.*,Beans.Admin.*,Services.Admin.*" %>
<html>
    <head>
        <title>View Report Abuse Details</title>
    </head>
    <body>
        <%
            ManageReportAbuseServices objServices=new ManageReportAbuseServices();
            ManageReportAbuseBean objBean=new ManageReportAbuseBean();
            objBean=objServices.getCurrentResourceAbuse(request.getParameter("user_id"),request.getParameter("title"),request.getParameter("report_id"));
            System.out.println("in viewdetails");

        %>
        <form action="ManageReportAbuseController.jsp" method="get">
            <table align="center">
                <tr>
                    <td>
                        <table align="center">
                            <tr>
                                <td>
                                    <h3><u>View Report Abuse Details</u></h3>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <fieldset>
                            <legend><strong><em>Resource Details</em></strong></legend>
                            <table align="center" cellpadding="5" rules="group" >
                                <tr>
                                    <td><b>Resource&nbsp;Title</b></td>
                                    <td><label><%=objBean.getTxtTitle()%></label></td>
                                </tr>
                                <tr>
                                    <td><b>Resource&nbsp;Type</b></td>
                                    <td><%=objBean.getTxtType()%></td>
                                </tr>
                                <tr>
                                    <td><b>Resource&nbsp;Size</b></td>
                                    <td><label><%=objBean.getTxtSize()%> MB</label></td>
                                </tr>
                                <tr>
                                    <td><b>Uploaded&nbsp;By</b></td>
                                    <td><label><%=objBean.getTxtName()%></label></td>
                                </tr>
                                <tr>
                                    <td><b>Report&nbsp;Status</b></td>
                                    <td><label><%=objBean.getUserStatus()%></label></td>
                                </tr>
                            </table>
                        </fieldset>
                    </td>
                </tr>
                <tr>
                    <td>
                        <fieldset>
                            <legend><strong><em>Report Abuse Details</em></strong></legend>
                            <table align="center" cellpadding="5">
                                <tr>
                                    <td><b>Report Abuse By</b></td>
                                    <td><label><%=objBean.getTxtReportUser()%></label></td>
                                </tr>
                                <tr>
                                    <td><b>Report Subject</b></td>
                                    <td><%=objBean.getTxtType()%></td>
                                </tr>
                                <tr>
                                    <td valign="top"><b>Description</b></td>
                                    <td><textarea name="taDescription" id="taDescription" rows="3" cols="23" readonly="readonly"><%=objBean.getTxtDescription()%></textarea></td>
                                </tr>
                                <tr>
                                    <td><b>Report Date</b></td>
                                    <td><label><%=objBean.getReportDate()%></label></td>
                                </tr>
                                <tr>
                                    <td><b>Attachment</b></td>
                                    <td>
                                        <%
                                                if(objBean.getTxtFileName().equalsIgnoreCase("File Not Exists"))
                                                {   
                                        %>
                                                    "File Not Exists"
                                        <%
                                                }
                                                else
                                                 {    
                                        %>
                                        
                                        <a href="../DownloadServlet?report_id=<%=objBean.getTxtReportId()%>">Download</a>
                                        <%
                                        
                                                 }
                                         %>
                                    </td>
                                </tr>
                            </table>
                        </fieldset>
                    </td>
                </tr>
                <tr>
                    <td>
                        <fieldset>
                            <legend><strong><em>Response</em></strong></legend>
                            <table align="center" cellpadding="5">
                                <tr>
                                    <td valign="top"><b>Response</b></td>
                                    <td><textarea name="taResponse" id="taResponse" rows="3" cols="23"></textarea></td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <input type="hidden" name="txtResourceId" value="<%=objBean.getTxtResourceId()%>"/>
                                        <input type="hidden" name="txtReportId" value="<%=objBean.getTxtReportId()%>"/>
                                        <input type="hidden" name="user_id" value="<%=request.getParameter("user_id")%>"/>
                                        <input type="hidden" name="title" value="<%=objBean.getTxtTitle()%>"/>
                                        <input type="hidden" name="type" value="<%=objBean.getTxtType()%>"/>
                                        <input type="submit" name="sbtnDelete" value="Delete Resource" class="button"/>
                                        <input type="submit" name="sbtnBlock" value="Block User" class="button"/>
                                        <input type="submit" name="sbtnCancel" value="Cancel Report Abuse" class="button"/>
                                        <input type="button" name="btnBack" value="Back" class="button" onclick="window.location='ManageReportAbuse_mp.jsp'"/>
                                    </td>
                                </tr>
                            </table>
                        </fieldset>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>