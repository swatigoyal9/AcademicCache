<%@page import="beans.user.SharedResourceMaintenanceBean"%>
<%@page import="services.user.SharedResourceMaintenanceServices"%>
<html>
    <head>
        <title>Share Detail Page</title>
    </head>
    <body>
        <form>
            <h3 align="center">Share Detail</h3>
            <table border="1" align="center" rules="none" cellpadding="5">
                 <%
            SharedResourceMaintenanceServices objSharedResourceMaintenanceServices=new SharedResourceMaintenanceServices();
            SharedResourceMaintenanceBean objSharedResourceMaintenanceBean=null;
            if(request.getParameter("edit_id")!=null)
                               {
                int id=Integer.parseInt(request.getParameter("edit_id"));
             objSharedResourceMaintenanceBean=objSharedResourceMaintenanceServices.getSharedResourceById(id);
                if(objSharedResourceMaintenanceBean!=null){
        %>
                <tr>
                    <td><b>Title</b></td>
                    <td><%=objSharedResourceMaintenanceBean.getTitle()%></td>
                </tr>
                <tr>
                    <td><b>Type</b></td>
                    <td colspan="2"><%=objSharedResourceMaintenanceBean.getType()%></td>
                </tr>
                <tr>
                    <td><b>Share Date</b></td>
                    <td colspan="2"><%=objSharedResourceMaintenanceBean.getDate_shared()%></td>
                </tr>
                <tr>
                    <td><b>Comment</b></td>
                    <td colspan="2"><%=objSharedResourceMaintenanceBean.getComment()%> </td>
                </tr>
                <tr>
                    <td><b>Email Shared With</b></td>
                    <td colspan="2"><%=objSharedResourceMaintenanceBean.getEmails_shared_with()%></td>
                </tr>
                <tr>
                    <td align="center" colspan="3"> <br/><input type="button"  value="Cancel" name="btnCancel" onclick="history.go(-1)" class="button"></td>
                </tr>
                <%
                               }
                         }
                %>
            </table>
        </form>
    </body>
</html>
