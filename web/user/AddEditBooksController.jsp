<%-- 
    Document   : AddEditWebLinkController
    Created on : 4 Jul, 2013, 3:46:46 PM
    Author     : Aparchyanta
--%>


<%@page import="services.user.BooksMaintenanceServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="objBean" class="beans.user.AddEditNewBookBean">
            <jsp:setProperty name="objBean" property="*"/> 
        </jsp:useBean>
        <%
            
            BooksMaintenanceServices objBooksMaintenanceServices=new BooksMaintenanceServices();
            String userId=(String)session.getAttribute("userId");
            
            if (request.getParameter("delete_id") != null) 
            {
                int id=Integer.parseInt(request.getParameter("delete_id"));
                String msg=objBooksMaintenanceServices.deleteBook(id);
                response.sendRedirect("BooksMaintenance_mp.jsp?msg="+msg);
            } 
            if(request.getParameter("sbtnUpdate")!=null)
            {
                   objBean.setTxtuserId(userId);
                   String msg=objBooksMaintenanceServices.updateBookRecord(objBean);
                   if(msg.equalsIgnoreCase("failed"))
                   {
                       response.sendRedirect("BookDetails_mp.jsp?msg="+msg);
                   }
                   else
                   {
                       response.sendRedirect("BooksMaintenance_mp.jsp?msg="+msg);
                   }
          }
          if(request.getParameter("sbtnSave")!=null)
          {
                response.sendRedirect("FileUploadServlet.java");
          }
    %>
    </body>
</html>
