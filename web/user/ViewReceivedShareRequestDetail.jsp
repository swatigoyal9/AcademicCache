<%@page import="beans.user.ReceivedShareRequestMaintenanceBean"%>
<%@page import="services.user.ReceivedShareRequestMaintenanceServices"%>
<html>
    <head>
        <title></title>
    </head>
    <body>
        <form action="ViewReceivedShareRequestDetail.jsp" method="GET">
             
          <%
            ReceivedShareRequestMaintenanceServices objReceivedShareRequestMaintenanceServices=new ReceivedShareRequestMaintenanceServices();
            if(request.getParameter("sbtnApproved")!=null)
                               {
                int id=Integer.parseInt(request.getParameter("request_id"));
                String status="Approved";
                String msg= objReceivedShareRequestMaintenanceServices.updateApprovedRecord(id,status);
                    response.sendRedirect("ViewReceivedShareRequestDetail_mp.jsp?msg1="+msg+"&edit_id="+id);
                                     }
            else if(request.getParameter("sbtnDisapproved")!=null)
                               {
                int id=Integer.parseInt(request.getParameter("request_id"));
                String status="Disapproved";
                String msg= objReceivedShareRequestMaintenanceServices.updateDisapprovedRecord(id,status);
                    response.sendRedirect("ViewReceivedShareRequestDetail_mp.jsp?msg1="+msg+"&edit_id="+id);
                                     }
            %>
            %>
        <table align="center" >
            <tr>
                <td>
                    <fieldset>
                        <legend><strong><em>View Received Share Request Detail</em></strong></legend>

                        <table cellpadding="10" width="100%">
                            <%
           
            ReceivedShareRequestMaintenanceBean objReceivedShareRequestMaintenanceBean=null;
                     if(request.getParameter("edit_id")!=null)
                               {
                int id=Integer.parseInt(request.getParameter("edit_id"));
             objReceivedShareRequestMaintenanceBean=objReceivedShareRequestMaintenanceServices.getReceivedShareRequestById(id);
                if(objReceivedShareRequestMaintenanceBean!=null){
        %>
        
        <tr>
        
            <td><input type="text" value="<%=request.getParameter("edit_id")%>" hidden="hidden" name="request_id"/></td>
        </tr>
                            <tr>
                                <td><b>Title</b></td>
                                <td><%=objReceivedShareRequestMaintenanceBean.getTitle()%></td>
                            </tr>
                            <tr>
                                <td><b>Requested Date</b></td>
                                <td><%=objReceivedShareRequestMaintenanceBean.getRequest_date()%></td>
                            </tr>
                            <tr>
                                <td><b>Type</b></td>
                                <td><%=objReceivedShareRequestMaintenanceBean.getType()%></td>
                            </tr>
                            <tr>
                                <td><b>Comment</b></td>
                                <td><%=objReceivedShareRequestMaintenanceBean.getComment()%></td>
                            </tr>
                            <tr>
                                <td><b>Status</b></td>
                                <td><%=objReceivedShareRequestMaintenanceBean.getRequest_status()%></td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
            <tr>
                <td  align="right">
                    <input type="submit" value="Approved" name="sbtnApproved" class="button"/>
                    <input type="submit"  value="Disapproved" name="sbtnDisapproved" class="button"/>
                    <input type="button"  value="Cancel" name="btnCancel" class="button" onclick="history.go(-1)"/>
                </td>
            </tr>
            <%
                       }
                         }
            %>
        </table>
        </form>
    </body>
</html>

