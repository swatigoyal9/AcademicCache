<%@page import="beans.admin.AddEditPlansAdminBean"%>
<%@page import="beans.admin.ManagePlansAdminBean"%>
<%@page import="services.admin.ManagePlansAdminServices"%>
<%@page import="java.util.List"%>
<html>
    <head>
        <title>Manage Plans Admin</title>
    </head>
    <body>
        <form action="ManagePlansAdmin_mp.jsp">
            <table align="center">
                <tr>
                    <td colspan="2" align="center">
                        <h3><u>Manage Plans</u></h3>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <input type="button" name="btnAddNewPlan" value="Add New Plan" onclick="window.location='AddNewPlan_mp.jsp'" class="button"/>
                    </td>
                    <td align="right">
                        Plan Name
                        <input type="text" name="txtPlanName" id="txtPlanName"/>
                        <input type="submit" name="sbtnSearch" value="Search" class="button"/>
                        &nbsp;<input  value="List All" id="sbtnListAll" name="sbtnListAll" type="submit" class="button"/>
                        
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <table align="center" border="1"  cellpadding="10" cellspacing="0" width="100%" class="tblStyle">
                            <tr>
                                <th>S/No.</th>
                                <th>Plan&nbsp;Name</th>
                                <th>Space</th>
                                <th>Cost</th>
                                <th>Validity</th>
                                <th>Status</th>
                                <th>Links</th>
                            </tr>
                            
                              <%
                           List<ManagePlansAdminBean> list=null;
                         String status="";
                         String linkStatus="";
                          ManagePlansAdminServices objManagePlansAdminServices=new ManagePlansAdminServices();
                          list=objManagePlansAdminServices.getAllManagePlansAdmin();
                           
           
            if(request.getParameter("sbtnSearch")!=null){
                String name=request.getParameter("txtPlanName");
                list=objManagePlansAdminServices.getPlanDetailByName(name);
               
             }
            else
            {
                list = objManagePlansAdminServices.getAllManagePlansAdmin();
                
            }
                          if(request.getParameter("sbtnListAll")!=null){
                             list = objManagePlansAdminServices.getAllManagePlansAdmin();
                          }
                          if(list.size()>0)
                                                           {
                              for(int i=0;i<list.size();i++)
                                                                   {
                          ManagePlansAdminBean objManagePlansAdminBean=(ManagePlansAdminBean)list.get(i);
                          if(objManagePlansAdminBean.getStatus().equalsIgnoreCase("Active"))
                          {
                              status="Active";
                              linkStatus="Inactivate";
                          }
                          if(objManagePlansAdminBean.getStatus().equalsIgnoreCase("Inactive"))
                          {
                              status="Inactive";
                              linkStatus="Activate";
                          }
                          
                          %>
                          <tr>
                               <td><%=i+1%></td>
                               <td><%=objManagePlansAdminBean.getPlan_name()%></td>
                               <td><%=objManagePlansAdminBean.getSpace_allowed() %></td>
                               <td><%=objManagePlansAdminBean.getCost()%></td>
                               <td><%=objManagePlansAdminBean.getValidity_months()%></td>
                               <td><%=objManagePlansAdminBean.getStatus()%></td>
                               <td><a href="AddEditPlanController.jsp?edit_id=<%=objManagePlansAdminBean.getPlan_id()%>&userStatus=<%=objManagePlansAdminBean.getStatus()%>"><%=linkStatus%></a>&nbsp;|&nbsp;<a href="ViewPlanDetails_mp.jsp?edit_id=<%=objManagePlansAdminBean.getPlan_id()%>">ViewPlanDetails</a></td>
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