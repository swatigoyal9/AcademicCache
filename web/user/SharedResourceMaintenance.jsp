<%@page import="beans.user.SharedResourceMaintenanceBean"%>
<%@page import="services.user.SharedResourceMaintenanceServices"%>
<%@page import="java.util.List"%>
<html>
    <head>
        <title>Shared Resource Maintenance Page</title>
    </head>
    <body>
        <table border="1" align="center" width="80%" rules="none" cellpadding="5">
            <tr>
                <td>
                    <h3 align="center">Manage Shared Resources</h3>
                </td>
            </tr>
            <tr>
                <td><label id="lblMsg">message</label></td>
            </tr>
            <tr>
                <td>
                    <table border="1" align="center"  width="100%" cellpadding="5" cellspacing="0" class="tblStyle">
                        <tr>
                            <th>S.No.</th>
                            <th>Title</th>
                            <th>Type</th>
                            <th>Share Date</th>
                            <th>&nbsp;</th>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Thinking In Java</td>
                            <td>Books</td>
                            <td>2013-01-04</td>
                            <td>
                                <a href="ShareDetail_mp.jsp">View Detail</a>&nbsp;<b>|</b>&nbsp; <a href="">Remove</a>
                            </td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>Learn Java</td>
                            <td>Audio</td>
                            <td>2013-01-04</td>
                            <td>
                                <a href="ShareDetail_mp.jsp">View Detail</a>&nbsp;<b>|</b>&nbsp; <a href="">Remove</a>
                            </td>
                        </tr>
                          <%
                           List list=null;
                          SharedResourceMaintenanceServices objSharedResourceMaintenanceServices=new SharedResourceMaintenanceServices();
                          list=objSharedResourceMaintenanceServices.getAllSharedResourceMaintenance();
                          if(list.size()>0)
                                                           {
                              for(int i=0;i<list.size();i++)
                                                                   {
                          SharedResourceMaintenanceBean objSharedResourceMaintenanceBean=(SharedResourceMaintenanceBean)list.get(i);
                          %>
                          <tr>
                               <td><%=i+1%></td>
                               <td><%=objSharedResourceMaintenanceBean.getTitle()%></td>
                               <td><%=objSharedResourceMaintenanceBean.getType()%></td>
                               <td><%=objSharedResourceMaintenanceBean.getDate_shared()%></td>
                               <td><a href="ShareDetail_mp.jsp?edit_id=<%=objSharedResourceMaintenanceBean.getShare_id()%>">View Detail</a>&nbsp;<b>|</b>&nbsp; <a href="SharedResourceController.jsp?delete_id=<%=objSharedResourceMaintenanceBean.getShare_id()%>">Remove</a></td>
                           </tr>
                           <%
                                                     }
                                                           }
                          else
                      {
                         %>
                         <tr><td colspan="5">No Record Found</td></tr>
                     <% }
                           %>
                    </table>
                </td>
            </tr>
        </table>
    </body>
</html>