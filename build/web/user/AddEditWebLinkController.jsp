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
        <jsp:useBean id="objBean" class="beans.user.AddEditWebLinkBean">
            <jsp:setProperty name="objBean" property="*"/> 
        </jsp:useBean>
        <%
            
            WebLinkMaintenanceServices objWebLinkMaintenanceServices=new WebLinkMaintenanceServices();
            String userId=(String)session.getAttribute("userId");
            System.out.println("user "+userId);
             if(request.getParameter("sbtnSave")!=null){
                objBean.setTxtuserId(userId);
                String msg1=objWebLinkMaintenanceServices.addNewWebLink(objBean);
                if(msg1.equalsIgnoreCase("failed"))
                {
                    response.sendRedirect("AddNewWebLink_mp.jsp?msg1="+msg1);
                }
                else
                {
                response.sendRedirect("WebLinkMaintenance_mp.jsp?msg1="+msg1);
                    }
             }
            if(request.getParameter("sbtnUpdate")!=null)
                                     {
                objBean.setTxtuserId(userId);
                   String msg=objWebLinkMaintenanceServices.updateWebLinkRecord(objBean);
                   if(msg.equalsIgnoreCase("failed")){
                   response.sendRedirect("WebLinkDetails_mp.jsp?msg="+msg);
               }
                                     else{
                       response.sendRedirect("WebLinkMaintenance_mp.jsp?msg="+msg);
                                     }
                                     }
            if (request.getParameter("delete_id") != null) {
            int id=Integer.parseInt(request.getParameter("delete_id"));
                objBean.setTxtuserId(userId);
            String msg=objWebLinkMaintenanceServices.deleteWebLink(id);
            response.sendRedirect("WebLinkMaintenance_mp.jsp?msg="+msg);
           
            } 
    %>
    </body>
</html>
