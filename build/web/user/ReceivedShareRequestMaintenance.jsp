<%@page import="services.user.ReceivedShareRequestMaintenanceServices"%>
<%@page import="beans.user.ReceivedShareRequestMaintenanceBean"%>
<%@page import="java.util.List"%>
<html>
    <head>
        <title>Received Share Request Maintenance Page</title>

    </head>
    <body>
        <br/><br/><br/>
        <table border="0" align="center">
            <tr>
                <td>
                    <h1 align="center">Received Share Requests</h1>
                </td>
            </tr>
            <tr><td>
                    <table border="1" align="center"  width="100%" cellspacing="0" cellpadding="5" class="tblStyle">
                        <tr>
                            <th><b>S.No.</b></th>
                            <th><b>Title</b></th>
                            <th><b>Type</b></th>
                            <th><b>Request Date</b></th>
                            <th><b>Status</b></th>
                            <th>&nbsp;</th>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Best.Practices.Java.Design.Patterns.Automation</td>
                            <td>Books</td>
                            <td>2013-01-03 10:02:33</td>
                            <td>Disapproved</td>
                            <td><b><a href="ViewRecievedShareRequestDetail_mp.jsp">View Detail</a></b></td>
                        </tr>
                        <% 
                                List<ReceivedShareRequestMaintenanceBean> lst=null;
                                //ManageEmployeeBean objManageEmployeeBean=new ManageEmployeeBean();
                                ReceivedShareRequestMaintenanceServices objReceivedShareRequestMaintenanceServices=new ReceivedShareRequestMaintenanceServices();
                                lst=objReceivedShareRequestMaintenanceServices.getAllReceivedShareRequestMaintenance();
                                if(lst.size()>0){
                                    
                                
                                for(int i=0;i<lst.size();i++)
                                {
                                ReceivedShareRequestMaintenanceBean objReceivedShareRequestMaintenanceBean=(ReceivedShareRequestMaintenanceBean)lst.get(i);
                            %>
                            <tr><td><%=i+1%></td>
                                <td><%=objReceivedShareRequestMaintenanceBean.getTitle()%></td>
                                <td><%=objReceivedShareRequestMaintenanceBean.getType()%></td>
                                <td><%=objReceivedShareRequestMaintenanceBean.getRequest_date()%></td>
                                <td><%=objReceivedShareRequestMaintenanceBean.getRequest_status()%></td>
                                <td><b><a href="ViewReceivedShareRequestDetail_mp.jsp?edit_id=<%=objReceivedShareRequestMaintenanceBean.getRequest_id()%>">View Detail</a></b></td>
         </tr>
         <% 
                               }
                                }
                                else{
                                   %>
                                   <tr><td colspan="7">No record found</td></tr>
                   <%             }
         %>
                    </table>
                </td>
            </tr>
        </table>
    </body>
</html>

