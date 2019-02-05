
<%@page import="beans.admin.AddEditPlansAdminBean"%>
<%@page import="services.admin.ManagePlansAdminServices"%>
<html>
    <head>
        <title>View Plan Details</title>
    </head>
    <body>
        <%
            ManagePlansAdminServices objManagePlansAdminServices=new ManagePlansAdminServices();
            AddEditPlansAdminBean objManagePlansAdminBean=null;
        %>
        
        
        <%
            if(request.getParameter("edit_id")!=null)
                               {
                int id=Integer.parseInt(request.getParameter("edit_id"));
                objManagePlansAdminBean=objManagePlansAdminServices.getPlanDetailById(id);
                if(objManagePlansAdminBean!=null){
        %>
        <form action="#" method="post">
            <table align="center">
                <tr>
                    <td align="center">
                        <h3><u>View Plan Details</u></h3>
                    </td>
                </tr>
                <tr>
                    <td>
                        <fieldset>
                            <table align="center" cellpadding="5">
                                <tr>
                                    <td>Plan Name</td>
                                    <td><label><%=objManagePlansAdminBean.getTxtPlanName()%></label></td>
                                </tr>
                                <tr>
                                    <td>Space Allowed</td>
                                    <td><label><%=objManagePlansAdminBean.getTxtSpaceAllowed()%></label></td>
                                </tr>
                                <tr>
                                    <td>Validity</td>
                                    <td><label><%=objManagePlansAdminBean.getTxtValidity()%></label></td>
                                </tr>
                                <tr>
                                    <td>Cost</td>
                                    <td><label><%=objManagePlansAdminBean.getTxtCost()%></label></td>                                          
                                </tr>
                                <tr>
                                    <td>Status</td>
                                    <td><label><%=objManagePlansAdminBean.getRbStatus()%></label></td>
                                </tr>
                                <tr>
                                    <td align="center" colspan="2">
                                        <input type="button" name="btnBack" value="Back" class="button" onclick="history.go(-1)"/>
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
        </form>
    </body>
</html>