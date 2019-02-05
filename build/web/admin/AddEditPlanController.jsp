<%@page import="services.admin.ManagePlansAdminServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="objBean" class="beans.admin.AddEditPlansAdminBean">
            <jsp:setProperty name="objBean" property="*"/> 
        </jsp:useBean>
        <%
            ManagePlansAdminServices objManagePlansAdminServices=new ManagePlansAdminServices();
             if(request.getParameter("sbtnSave")!=null){
                
                String msg1=objManagePlansAdminServices.addNewPlan(objBean);
                if(msg1.equalsIgnoreCase("failed"))
                {
                    response.sendRedirect("AddNewPlan_mp.jsp?msg1="+msg1);
                }
                else
                {
                response.sendRedirect("ManagePlansAdmin_mp.jsp?msg1="+msg1);
                    }
             }%>
             <%
            if(request.getParameter("edit_id")!=null)
                               {
                int id=Integer.parseInt(request.getParameter("edit_id"));
                String status=request.getParameter("userStatus");
                String msg=objManagePlansAdminServices.activeInactivatePlan(id,status);
                
                       response.sendRedirect("ManagePlansAdmin_mp.jsp?msg="+msg);
                                    
                                     }
        %>
    </body>
</html>
