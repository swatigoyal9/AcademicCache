
<%@page import="services.admin.ManageEmployeeServices"%>
<%@page import="beans.admin.AddEditEmployeeBean"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View And Edit Employee</title>
    </head>
    <body>
        <%
            ManageEmployeeServices objManageEmployeeServices=new ManageEmployeeServices();
            AddEditEmployeeBean objAddEditEmployeeBean=null;
        %>
        
        
        <%
            if(request.getParameter("edit_id")!=null)
                               {
                int id=Integer.parseInt(request.getParameter("edit_id"));
             objAddEditEmployeeBean=objManageEmployeeServices.getEmployeeDetailById(id);
                if(objAddEditEmployeeBean!=null){
        %>
        <form action="AddEditEmployeeController.jsp">
            <table align="center">
                <tr>
                    <td align="center">
                        <h3><u>Edit Employee</u></h3>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table cellpadding="5">
                            <tr>
                                <td colspan="2">
                                    <fieldset>
                                        <table align="center" cellpadding="5">
                                            <tr>
                                                <td><input type="text" name="txtEmployeeId" value="<%=objAddEditEmployeeBean.getTxtEmployeeId()%>" hidden/></td>
                                            </tr>
                                            <tr>
                                                    <td>User Name</td><td colspan="2"><input type="text" id="txtUsername" name="txtUsername" value="<%=objAddEditEmployeeBean.getTxtUsername()%>"/></td>
                                            </tr>
                                            <tr>
                                                <%
                        String st="";
                        String st1="";
                        
                        if(objAddEditEmployeeBean.getRbStatus().equalsIgnoreCase("Active")){
                            st="checked";
                        }
                                               else if(objAddEditEmployeeBean.getRbStatus().equalsIgnoreCase("Inactive")){
                                                   st1="Checked";
                                               }
                        
                    %>
                                                <td>User Status</td>
                                                <td><input type="radio" id="rbStatus" name="rbStatus" value="Active" <%=st%>/>Active
                                                <input type="radio" name="rbStatus" id="rbStatus" value="Inactive" <%=st1%>/>Inactive</td>
                                            </tr>
                                            <tr>
                                                <%
                        String str="";
                        String str1="";
                        if(objAddEditEmployeeBean.getDdlUserType().equalsIgnoreCase("Administrator")){
                            str="Selected";
                        }
                                               else if(objAddEditEmployeeBean.getDdlUserType().equalsIgnoreCase("Employee")){
                                                   str1="Selected";
                                               }
                        
                    %>
                                                <td>User Type</td>
                                                <td>
                                                    <select id="ddlUserType" name="ddlUserType">
                                                        <option value="select">Select</option>
                                                        <option value="Administrator" <%=str%>>Administrator</option>
                                                        <option value="Employee" <%=str1%>>Employee</option>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Name</td>
                                                <td><input type="text" name="txtName" id="txtName"  value="<%=objAddEditEmployeeBean.getTxtName()%>" /></td>                                                </tr>
                                            
                                            <tr>
                                                 <%
                        String st2="";
                        String st3="";
                        if(objAddEditEmployeeBean.getRbGender().equalsIgnoreCase("Male")){
                            st2="checked";
                        }
                                               else if(objAddEditEmployeeBean.getRbGender().equalsIgnoreCase("Female")){
                                                   st3="Checked";
                                               }
                        
                    %>
                                                <td>Gender</td>
                                                <td>
                                                    <input type="radio" name="rbGender" id="rbGender" value="Male" <%=st2%>/>Male
                                                    <input type="radio" name="rbGender" id="rdGender" value="Female" <%=st3%>/>Female</td>
                                            </tr>
                                            <tr>
                                                <td>Contact No.</td>
                                                <td><input type="text" name="txtContact" id="txtContact" value="<%=objAddEditEmployeeBean.getTxtContact()%>"/></td>                                                </tr>
                                            <tr>
                                            <tr>
                                                <td>Email</td>
                                                <td><input type="text" name="txtEmail" id="txtEmail" value="<%=objAddEditEmployeeBean.getTxtEmail()%>"/></td>                                                </tr>
                                            <tr>
                                            <tr>
                                                <td>Date Of Joining</td>
                                                <td><input type="text" name="txtDateOfJoining" id="txtDateOfJoining" value="<%=objAddEditEmployeeBean.getTxtDateOfJoining()%>"/></td>                                                </tr>
                                            
                                            <tr>
                                                <td align="center" colspan="3">
                                                    <input type="submit" name="sbtnUpdate" value="Update" class="button"/>
                                                    <input type="button" name="btnCancel" value="Cancel" class="button" onclick="history.go(-1)"/>
                                                </td>
                                            </tr>
                                        </table> 
                                    </fieldset>
                            </tr>
                            <%
                                                       }
                         }
                            %>
                        </table>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>