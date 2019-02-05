<%@page import="services.user.SharedResourceMaintenanceServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <%
            
            SharedResourceMaintenanceServices objSharedResourceMaintenanceServices=new SharedResourceMaintenanceServices();
            if (request.getParameter("delete_id") != null) {
            int id=Integer.parseInt(request.getParameter("delete_id"));
            String msg=objSharedResourceMaintenanceServices.deleteSharedResource(id);
            response.sendRedirect("SharedResourceMaintenance_mp.jsp?msg="+msg);
           
            } 
        %>
    </body>
</html>
