<%@page import="beans.admin.ManageEmployeeBean"%>
<%@page import="services.admin.AdminHomeServices"%>
<html>
    <head>
        <title>Home Admin</title>
    </head>
    <body>
          <form action="#" method="GET">
            <%
                String userId=(String)session.getAttribute("employeeId");
                              //   int id=Integer.parseInt(userId);
                              System.out.println(userId);
            AdminHomeServices objAdminHomeServices=new AdminHomeServices();
            ManageEmployeeBean objManageEmployeeBean=new ManageEmployeeBean();
               objManageEmployeeBean=objAdminHomeServices.getAdminHomeDetails(userId);
                if(objManageEmployeeBean!=null){
        %>
            <table align="center" >
                <tr>
                    <td colspan="3" align="center">
                        <h3><u>Home</u></h3>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table cellpadding="5">
                            <tr>
                                <td colspan="2">
                                    <fieldset>
                                        <table align="center" cellpadding="5" >
                                            <tr>
                                                <td><b/>Name</td>
                                                <td><label><%=objManageEmployeeBean.getName()%></label></td>
                                            </tr>
                                            <tr>
                                                <td><b/>Gender</td>
                                                <td><label><%=objManageEmployeeBean.getGender()%></label></td>
                                                <td><b/>Email Id</td>
                                                <td><label><%=objManageEmployeeBean.getEmail()%></label></td>
                                            </tr>
                                            <tr>
                                                <td><b/>Status</td>
                                                <td><label><%=objManageEmployeeBean.getUser_status()%></label></td>    
                                            </tr>
                                           
                                            <tr>
                                                <td><b/>Contact Number</td>
                                                <td><label><%=objManageEmployeeBean.getContact_number()%></label></td>
                                        </table> 
                                    </fieldset>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
                                            <%
                                                                                       }
                                            %>
        </form>
    </body>
</html>
