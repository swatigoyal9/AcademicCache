<%@page import="beans.admin.ManageRegisteredUserBean"%>
<%@page import="services.admin.ManageRegisteredUserServices"%>
<html>
    <head>
        <title>View User Details</title>
    </head>
    <body>
        <%
            ManageRegisteredUserServices objManageRegisteredUserServices=new ManageRegisteredUserServices();
            ManageRegisteredUserBean objManageRegisteredUserBean=null;
        %>
        
        
        <%
            if(request.getParameter("edit_id")!=null)
                               {
                int id=Integer.parseInt(request.getParameter("edit_id"));
                objManageRegisteredUserBean=objManageRegisteredUserServices.getUserDetailById(id);
                if(objManageRegisteredUserBean!=null){
        %>
        <table align="center">
            <tr>
                <td align="center">
                    <h3><u>View User Details</u></h3>
                </td>
            </tr>
            <tr>
                <td>
                    <fieldset>
                        <table align="center" cellpadding="5">
                            <tr>
                                                <td><input type="text" name="user_id" value="<%=objManageRegisteredUserBean.getUser_id()%>" hidden/></td>
                                            </tr>
                            <tr>
                                <td><b>Username</b></td>
                                <td><label><%=objManageRegisteredUserBean.getUsername()%></label></td>
                            </tr>
                            <tr>
                                <td><b>Name</b></td>
                                <td><label><%=objManageRegisteredUserBean.getName()%></label></td>    
                            </tr>
                            <tr>
                                <td><b>User Status</b></td>
                                <td><label><%=objManageRegisteredUserBean.getUser_status()%></label></td>
                            </tr>

                            <tr>
                                <td><b>Qualification</b></td>
                                <td><label><%=objManageRegisteredUserBean.getQualification()%></label></td>
                            </tr>
                            <tr>
                                <td><b>Country</b></td>
                                <td><label><%=objManageRegisteredUserBean.getCountry()%></label></td>
                            </tr>
                            <tr>
                                <td><b>State</b></td>
                                <td><label><%=objManageRegisteredUserBean.getState()%></label></td>
                            </tr>
                            <tr>
                                <td><b>City</b></td>
                                <td><label><%=objManageRegisteredUserBean.getCity()%></label></td>
                            </tr>
                            <tr>
                                <td><b>Registration Date</b></td>
                                <td><label><%=objManageRegisteredUserBean.getRegistration_date()%></label></td>
                            </tr>
                            <tr>
                                <td align="center" colspan="2">
                                    <input type="button" name="btnCancel" value="Cancel" class="button" onclick="history.go(-1)"/>
                                </td>
                            </tr>
                            <%
                                                       }
                               }
                            %>
                        </table> 
                    </fieldset>
                </td>
            </tr>
        </table>
    </body>
</html>