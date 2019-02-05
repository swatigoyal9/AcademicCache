<%@page import="beans.user.WebLinkMaintenanceBean"%>
<%@page import="services.user.WebLinkMaintenanceServices"%>
<%@page import="java.util.List"%>
<html>
    <head>
        <title>Web Link Maintenance</title>
    </head>
    <body>
        <table border="1" cellpadding="0" cellspacing="0" align="center" rules='none'>
            <tr>
                <td align="center"><h1>Manage Web Links</h1></td>
            </tr>
            <tr>
                <td>
                    <form action="WebLinkMaintenance_mp.jsp" method="post">
                        <table border="0" cellpadding="5" cellspacing="0" width="100%">
                            <tr>
                                <td align="left">
                                    <input  id="btnAddNewWebLink" value="Add New Web Link" name="btnAddNewWebLink"  type="button" onclick="window.location='AddNewWebLink_mp.jsp'" class="button">&nbsp;
                                </td>
                                <td align="right">
                                    Title&nbsp;&nbsp;<input id="txtName" size="10" name="txtName" type="text">
                                    &nbsp;<input id="sbtnList" value="List" name="sbtnList" type="submit" class="button">
                                    &nbsp;<input  value="List All" id="sbtnListAll" name="sbtnListAll" type="submit" class="button">
                                </td>
                            </tr>
                           
                        </table>
                    </form>
                </td>
            </tr>
            <tr>
                <td><label id="lblMsg">message</label></td>
            </tr>
            <tr>
                <td>
                    <table border="1" cellpadding="3" cellspacing="0" width="100%" class="tblStyle">  
                        <tr>
                            <th>S.No.</th>
                            <th>Title</th>
                            <th>Category</th>
                            <th>Creation&nbsp;Date</th>
                            <th>&nbsp;</th>
                        </tr>
                         <%
                           List<WebLinkMaintenanceBean> list=null;
                         
                          WebLinkMaintenanceServices objWebLinkMaintenanceServices=new WebLinkMaintenanceServices();
                          list=objWebLinkMaintenanceServices.getAllWebLinkMaintenance();
                          if(request.getParameter("sbtnList")!=null){
                String name=request.getParameter("txtName");
                list=objWebLinkMaintenanceServices.getWebLinkDetailByName(name);
               
             }
            else
            {
                list = objWebLinkMaintenanceServices.getAllWebLinkMaintenance();
                
            }
                          if(request.getParameter("sbtnListAll")!=null){
                             list = objWebLinkMaintenanceServices.getAllWebLinkMaintenance(); 
                          }
                          if(list.size()>0)
                                                           {
                              for(int i=0;i<list.size();i++)
                                                                   {
                          WebLinkMaintenanceBean objWebLinkMaintenanceBean=(WebLinkMaintenanceBean)list.get(i);
                          %>
                          <tr>
                               <td><%=i+1%></td>
                               <td><%=objWebLinkMaintenanceBean.getTitle()%></td>
                               <td><%=objWebLinkMaintenanceBean.getCaregory() %></td>
                               <td><%=objWebLinkMaintenanceBean.getCreation_date()%></td>
                               <td><a href="WebLinkDetails_mp.jsp?edit_id=<%=objWebLinkMaintenanceBean.getId()%>">View&nbsp;&amp;&nbsp;Update</a>&nbsp;|&nbsp;<a href="ShareResource_mp.jsp?w_id=<%=objWebLinkMaintenanceBean.getId()%>&type=web">Share</a>&nbsp;|&nbsp;<a href="AddEditWebLinkController.jsp?delete_id=<%=objWebLinkMaintenanceBean.getId()%>">Remove</a></td>
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