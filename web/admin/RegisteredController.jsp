<%@page import="services.admin.ManageRegisteredUserServices"%>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <%
        ManageRegisteredUserServices objManageRegisteredUserServices=new ManageRegisteredUserServices();
              if(request.getParameter("edit_id")!=null)
                               {
                int id=Integer.parseInt(request.getParameter("edit_id"));
                String status=request.getParameter("userStatus");
                
               String msg=objManageRegisteredUserServices.activeInactivateUser(id, status);
                
                       response.sendRedirect("ManageRegisteredUsers_mp.jsp?msg="+msg);
                                    
                                     }
        %>
    </body>
</html>