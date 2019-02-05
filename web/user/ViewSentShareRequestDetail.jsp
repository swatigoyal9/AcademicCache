
<%@page import="beans.user.SentShareRequestMaintenanceBean"%>
<%@page import="services.user.SentShareRequestMaintenanceServices"%>
<html>
    <head>
        <title></title>

    </head>
    <body>
        <table align="center">
            <tr>
                <td>
                    <fieldset>
                        <legend><strong><em>View Sent Share Request Detail</em></strong></legend>

                        <table border="0" cellpadding="5" align="center" >
                            <%
            SentShareRequestMaintenanceServices objSentShareRequestMaintenanceServices=new SentShareRequestMaintenanceServices();
            SentShareRequestMaintenanceBean objSentShareRequestMaintenanceBean=null;
            if(request.getParameter("edit_id")!=null)
                               {
                int id=Integer.parseInt(request.getParameter("edit_id"));
             objSentShareRequestMaintenanceBean=objSentShareRequestMaintenanceServices.getSentShareRequestById(id);
                if(objSentShareRequestMaintenanceBean!=null){
        %>
                            <tr>
                                <td><b>Title</b></td>
                                <td><%=objSentShareRequestMaintenanceBean.getTitle()%></td>
                            </tr>
                            <tr>
                                <td><b>Requested Date</b></td>
                                <td><%=objSentShareRequestMaintenanceBean.getRequest_date()%></td>
                            </tr>
                            <tr>
                                <td><b>Type</b></td>
                                <td><%=objSentShareRequestMaintenanceBean.getType()%></td>
                            </tr>
                            <tr>
                                <td><b>Comment</b></td>
                                <td><%=objSentShareRequestMaintenanceBean.getComment()%></td>
                            </tr>
                            <tr>
                                <td><b>Status</b></td>
                                <td><%=objSentShareRequestMaintenanceBean.getRequest_status()%></td>
                            </tr>
                            <tr>
                                <td><b>Download Link</b></td>
                                <td><a href="../DownloadServlet?id=<%=objSentShareRequestMaintenanceBean.getId()%>&type=<%=objSentShareRequestMaintenanceBean.getType()%>"><b>Click Here</b></a></td>
                            </tr>
                            <%
                                                       }
            }
                            %>
                        </table>
                    </fieldset>                        
                </td>
            </tr>
            <tr>
                <td align="right"><input type="button"  value="Cancel" name="btnCancel" onclick="history.go(-1)" class="button"></td>
            </tr>
        </table>
    </body>
</html>

