
<%@page import="java.util.List"%>
<%@page import="services.admin.ManageEmployeeServices"%>
<%@page import="beans.admin.ManageEmployeeBean"%>
<html>
    <head>
        <title>Manage Employee</title>
    </head>
    <body>
        <form action="#">
            <table align="center">
                <tr>
                    <td colspan="2"   align="center">
                        <h3><u>Manage Employee</u></h3>
                    </td>
                </tr>
                <tr>
                    <td align="left"  >
                        <input type="button" name="btnAddNewEmployee" value="Add New Employee" onclick="window.location='AddNewEmployee_mp.jsp'" class="button"/>
                    </td>
                    <td align="right">
                        Name
                        <input type="text" name="txtSearch" id="txtSearch"/>
                        <input type="submit" name="sbtnSearch" value="Search" class="button"/>
                        &nbsp;<input  value="List All" id="sbtnListAll" name="sbtnListAll" type="submit" class="button"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <table align="center" border="1"  cellpadding="5" cellspacing="0" width="100%" class="tblStyle">
                            <tr>
                                <th>S/No.</th>
                                <th>Username</th>
                                <th>Name</th>
                                <th>Contact&nbsp;Number</th>
                                <th>User Type</th>
                                <th>Date&nbsp;Of&nbsp;Joining</th>
                                <th>Status</th>
                                <th>Links</th>
                            </tr>
                             <%
                           List<ManageEmployeeBean> list=null;
                         String status="";
                         String linkStatus="";
                          ManageEmployeeServices objManageEmployeeServices=new ManageEmployeeServices();
                          list=objManageEmployeeServices.getAllManageEmployee();
                          if(request.getParameter("sbtnSearch")!=null){
                String name=request.getParameter("txtSearch");
                list=objManageEmployeeServices.getEmployeeDetailByName(name);
               
             }
            else
            {
                list = objManageEmployeeServices.getAllManageEmployee();
                
            }
                          if(request.getParameter("sbtnListAll")!=null){
                             list=objManageEmployeeServices.getAllManageEmployee(); 
                          }
                          if(list.size()>0)
                                                           {
                              for(int i=0;i<list.size();i++)
                                                                   {
                          ManageEmployeeBean objManageEmployeeBean=(ManageEmployeeBean)list.get(i);
                          if(objManageEmployeeBean.getUser_status().equalsIgnoreCase("Active"))
                          {
                              status="Active";
                              linkStatus="Inactivate";
                          }
                          if(objManageEmployeeBean.getUser_status().equalsIgnoreCase("Inactive"))
                          {
                              status="Inactive";
                              linkStatus="Activate";
                          }
                          
                          %>
                          <tr>
                               <td><%=i+1%></td>
                               <td><%=objManageEmployeeBean.getUsername()%></td>
                               <td><%=objManageEmployeeBean.getName() %></td>
                               <td><%=objManageEmployeeBean.getContact_number()%></td>
                               <td><%=objManageEmployeeBean.getUser_type()%></td>
                               <td><%=objManageEmployeeBean.getDoj()%></td>
                               <td><%=status%></td>
                              <td><a href="AddEditEmployeeController.jsp?edit_id=<%=objManageEmployeeBean.getEmployee_id()%>&userStatus=<%=objManageEmployeeBean.getUser_status()%>"><%=linkStatus%></a>&nbsp;|&nbsp;<a href="ViewAndEditEmployeeDetail_mp.jsp?edit_id=<%=objManageEmployeeBean.getEmployee_id()%>">ViewDetails</a></td>
                           </tr>
                           <%
                                                     }
                                                           }
                          else
                      {
                         %>
                         <tr><td colspan="8">No Record Found</td></tr>
                     <% }
                           %>
                        </table>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>