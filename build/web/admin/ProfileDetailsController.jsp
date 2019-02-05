<%@page import="services.admin.AdminHomeServices"%>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
         <jsp:useBean id="objBean" class="beans.admin.ManageEmployeeBean">
            <jsp:setProperty name="objBean" property="*"/> 
        </jsp:useBean>
        <%
        AdminHomeServices objAdminHomeServices=new AdminHomeServices();
            if(request.getParameter("sbtnUpdate")!=null)
                                     {
                   String msg=objAdminHomeServices.updateProfile(objBean,request.getParameter("employee_id"));
                   if(msg.equalsIgnoreCase("failed")){
                   response.sendRedirect("ProfileDetails_mp.jsp?msg="+msg);
               }
                                     else{
                       response.sendRedirect("HomeAdmin_mp.jsp?msg="+msg);
                                     }
                                     }
            
        %>
        
    </body>
</html>
