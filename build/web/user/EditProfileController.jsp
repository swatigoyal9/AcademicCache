<jsp:useBean id="objBean" class="beans.user.UserProfileBean">
    <jsp:setProperty name="objBean" property="*"/>    
</jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Beans.User.*,Services.User.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controller Page</title>
    </head>
    <body>
        <%
          if(request.getParameter("sbtnUpdate")!=null)
          { 
              System.out.println(objBean.getDdlCity());
            services.user.UserProfileServices objUserProfileServices=new services.user.UserProfileServices();
            String user_id=(String)session.getAttribute("userId");
            String msg=objUserProfileServices.updateProfile(objBean,user_id); 
            if(msg.equals("Account Updated"))
            {    
                response.sendRedirect("Home_mp.jsp?msg="+msg);
            }
            else
            {
                response.sendRedirect("ViewProfile_mp.jsp?msg="+msg);
            }
           } 
           
                  
            
        %>
    </body>
</html>
