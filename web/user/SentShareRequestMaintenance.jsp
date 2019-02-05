<%@page import="beans.user.SentShareRequestMaintenanceBean"%>
<%@page import="services.user.SentShareRequestMaintenanceServices"%>
<%@page import="java.util.List"%>
<html>
    <head>
        <title>Sent Share Request</title>
    </head>
    <body>
        <table border="0" align="center">
            <tr>
                <td>
                    <h1  align="center">Sent Share Requests</h1>
                </td>
            </tr>
            <tr>
                <td>
                    <table border="1" align="center"  width="100%" cellpadding="10" cellspacing="0" class="tblStyle">
                        <tr>
                            <th>S.No.</th>
                            <th>Title</th>
                            <th>Type</th>
                            <th> Request Date</th>
                            <th>Request Sent To</th>
                            <th>Status</th>
                            <th></th>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>JReports</td>
                            <td>Books</td>
                            <td>2013-01-01 10:02:01 </td>
                            <td>Ravi Pratap Singh</td>
                            <td>Approved</td>
                            <td><a href="ViewSentShareRequestDetail_mp.jsp">View Detail</a></td>
                        </tr>
                         <%
                           List list=null;
                         
                          SentShareRequestMaintenanceServices objSentShareRequestMaintenanceServices=new SentShareRequestMaintenanceServices();
                          list=objSentShareRequestMaintenanceServices.getAllSentShareRequestMaintenance();
                          if(list.size()>0)
                                                           {
                              for(int i=0;i<list.size();i++)
                                                                   {
                          SentShareRequestMaintenanceBean objSentShareRequestMaintenanceBean=(SentShareRequestMaintenanceBean)list.get(i);
                          %>
                          <tr>
                               <td><%=i+1%></td>
                               <td><%=objSentShareRequestMaintenanceBean.getTitle()%></td>
                               <td><%=objSentShareRequestMaintenanceBean.getType() %></td>
                               <td><%=objSentShareRequestMaintenanceBean.getRequest_date()%></td>
                               <td><%=objSentShareRequestMaintenanceBean.getName()%></td>
                               <td><%=objSentShareRequestMaintenanceBean.getRequest_status()%></td>
                               <td><a href="ViewSentShareRequestDetail_mp.jsp?edit_id=<%=objSentShareRequestMaintenanceBean.getId()%>">View Detail</a></td>
                           </tr>
                           <%
                                                     }
                                                           }
                          else
                      {
                         %>
                         <tr><td colspan="7">No Record Found</td></tr>
                     <% }
                           %>
                    </table>
                </td>
            </tr>
        </table>
    </body>
</html>
