<%-- 
    Document   : AddEditWebLinkController
    Created on : 4 Jul, 2013, 3:46:46 PM
    Author     : Aparchyanta
--%>

<%@page import="services.user.MultimediaMaintenanceServices"%>
<%@page import="services.user.WebLinkMaintenanceServices"%>
<%@page import="services.admin.ManagePlansAdminServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="objBean" class="beans.user.AddEditMultimediaDetail">
            <jsp:setProperty name="objBean" property="*"/> 
        </jsp:useBean>
        <%
            
            MultimediaMaintenanceServices objMultimediaMaintenanceServices=new MultimediaMaintenanceServices();
            if (request.getParameter("delete_id") != null) {
            int id=Integer.parseInt(request.getParameter("delete_id"));
            String msg=objMultimediaMaintenanceServices.deleteMultimedia(id);
            response.sendRedirect("MultimediaMaintenance_mp.jsp?msg="+msg);
            } 
            if(request.getParameter("sbtnUpdate")!=null)
                                     {
                
                   String msg=objMultimediaMaintenanceServices.updateMultimediaRecord(objBean);
                   if(msg.equalsIgnoreCase("failed")){
                   response.sendRedirect("MultimediaDetails_mp.jsp?msg="+msg);
               }
                                     else{
                       response.sendRedirect("MultimediaMaintenance_mp.jsp?msg="+msg);
                                     }
                                     }
            if(request.getParameter("sbtnSave")!=null)
          {
                response.sendRedirect("FileUploadServlet.java");
          }
    %>
    </body>
</html>
