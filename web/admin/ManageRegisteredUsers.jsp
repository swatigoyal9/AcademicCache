<%@page import="beans.admin.ManageRegisteredUserBean"%>
<%@page import="services.admin.ManageRegisteredUserServices"%>
<%@page import="java.util.List"%>
<html>
    <head>
        <title>Manage Registered Users</title>
    </head>
    <body>
        <form action="ManageRegisteredUsers_mp.jsp">
            <table align="center">
                <tr>
                    <td align="center">
                        <h3><u>Manage Registered Users</u></h3>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        Name
                        <input type="text" name="txtSearch" id="txtSearch"/>
                        <input type="submit" name="sbtnSearch" value="Search" class="button"/>
                        &nbsp;<input  value="List All" id="sbtnListAll" name="sbtnListAll" type="submit" class="button"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table align="center" border="1"  cellpadding="10" cellspacing="0" width="100%" class="tblStyle">
                            <tr>
                                <th>S/No.</th>
                                <th>Username</th>
                                <th>Name</th>
                                <th>Qualification</th>
                                <th>Registration&nbsp;Date</th>
                                <th>Status</th>
                                <th>Links</th>
                            </tr>
                            <%
                           List list=null;
                            String status="";
                         String linkStatus="";
                            ManageRegisteredUserServices objManageRegisteredUserServices=new ManageRegisteredUserServices();
                     if(request.getParameter("sbtnSearch")!=null){
                         String name=request.getParameter("txtSearch");
                             list=objManageRegisteredUserServices.searchRegistereduserByName(name);
                                                 }
                                                 else{
                         list=objManageRegisteredUserServices.getAllManageRegisteredUser();
                                                 }
                     if(request.getParameter("sbtnListAll")!=null){
                             list=objManageRegisteredUserServices.getAllManageRegisteredUser();
                          }
                          if(list.size()>0)
                                                           {
                              for(int i=0;i<list.size();i++)
                                                                   {
                          ManageRegisteredUserBean objManageRegisteredUserBean=(ManageRegisteredUserBean)list.get(i);
                           if(objManageRegisteredUserBean.getUser_status().equalsIgnoreCase("Active"))
                          {
                              status="Active";
                              linkStatus="Inactivate";
                          }
                          if(objManageRegisteredUserBean.getUser_status().equalsIgnoreCase("Inactive"))
                          {
                              status="Inactive";
                              linkStatus="Activate";
                          }
                          
                          %>
                          <tr>
                               <td><%=i+1%></td>
                               <td><%=objManageRegisteredUserBean.getUsername()%></td>
                               <td><%=objManageRegisteredUserBean.getName() %></td>
                               <td><%=objManageRegisteredUserBean.getQualification()%></td>
                               <td><%=objManageRegisteredUserBean.getRegistration_date()%></td>
                               <td><%=objManageRegisteredUserBean.getUser_status()%></td>
                               <td><a href="RegisteredController.jsp?edit_id=<%=objManageRegisteredUserBean.getUser_id()%>&userStatus=<%=objManageRegisteredUserBean.getUser_status()%>"><%=linkStatus%></a>&nbsp;|&nbsp;<a href="ViewUserDetails_mp.jsp?edit_id=<%=objManageRegisteredUserBean.getUser_id()%>">ViewDetails</a></td>
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
        </form>
    </body>
</html>