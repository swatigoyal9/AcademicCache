
<%@page import="services.admin.AdminHomeServices"%>
<%@page import="services.admin.ManageEmployeeServices"%>
<%@page import="beans.admin.ManageEmployeeBean"%>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
         <%
            String employeeId=(String)session.getAttribute("employeeId");
            ManageEmployeeBean objBean=new ManageEmployeeBean();
           System.out.println(employeeId);
            AdminHomeServices objAdminHomeServices=new AdminHomeServices();
            objBean=objAdminHomeServices.getProfileDetailById(employeeId);
                if(objBean!=null){
        %>
        <form action="ProfileDetailsController.jsp" method="post" >
            <table align="center">
                <tr>
                    <td align="center"></td>
                </tr>
                <tr>
                    <td><label id="lblMsg">message</label></td>
                </tr>
                <tr>
                    <td>
                        <fieldset><legend><strong><em>Update Profile Details</em></strong></legend>
                            <table border="0" cellpadding="5" cellspacing="0" width="100%">
                                <tr>
                                    <td><label><input type="text" name="employee_id" value="<%=employeeId%>" hidden/></label></td>
                                </tr>
                                <tr>
                                    <td><strong>Username</strong></td>
                                    <td><label><input type="text" name="username" value="<%=objBean.getUsername()%>"></label></td>
                                </tr>
                                <tr>
                                    <td><strong>Name</strong></td>
                                    <td><input type="text" name="name" id="name" value="<%=objBean.getName()%>"/></td>
                                </tr>
                                 <tr>
                                    <td><strong>Email Id</strong></td>
                                    <td><input type="text" name="email" id="email" value="<%=objBean.getEmail()%>"/></td>
                                </tr>
                                 <tr>
                                    <td><strong>Contact Number</strong></td>
                                    <td><input type="text" name="contact_number" id="contact_number" value="<%=objBean.getContact_number()%>"/></td>
                                </tr>
                                 <tr>
                                    <td><strong>User Type</strong></td>
                                    <td><input type="text" name="user_type" id="user_type" value="<%=objBean.getUser_type()%>"/></td>
                                </tr>
                                 <tr>
                                    <td><strong>User Status</strong></td>
                                    <td><input type="text" name="user_status" id="user_status" value="<%=objBean.getUser_status()%>"/></td>
                                </tr>
                                 <tr>
                                    <td><strong>Password</strong></td>
                                    <td><input type="text" name="password" id="password" value="<%=objBean.getPassword()%>"/></td>
                                </tr>
                                 </table>
                        </fieldset>
                    </td>
                </tr>
                <tr>
                    <td colspan="1" align="center" height="40" valign="bottom">
                        <input type="submit" name="sbtnUpdate" value="Update" id="sbtnUpdate" class="button"/>
                        <input type="button" name="btnCancel" value="Cancel" id="btnCancel" class="button" onclick="history.go(-1)"/>
                    </td>
                </tr>
<%
   }
%>
            </table>
        </form>
    </body>
</html>