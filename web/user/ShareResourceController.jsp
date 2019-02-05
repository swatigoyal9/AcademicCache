<%@page import="services.user.SharedResourceMaintenanceServices"%>
<%@page import="java.util.*,beans.user.*,services.user.*"%>
 <jsp:useBean id="objBean" class="beans.user.SharedResourceMaintenanceBean">
            <jsp:setProperty name="objBean" property="*"/> 
        </jsp:useBean>
<%
SharedResourceMaintenanceBean objSharedResourceMaintenanceBean=new SharedResourceMaintenanceBean();
    SharedResourceMaintenanceServices objSharedResourceMaintenanceServices=new SharedResourceMaintenanceServices();
   String type=request.getParameter("type");
   String id=request.getParameter("id");
   System.out.println(id);
   String title=request.getParameter("title");
   String uid=request.getParameter("uid");
   objSharedResourceMaintenanceBean=objSharedResourceMaintenanceServices.sharedResources(objBean,type,id,uid);
   if(type.equalsIgnoreCase("Book"))
             {
       response.sendRedirect("BooksMaintenance_mp.jsp");
                             }
     else if(type.equalsIgnoreCase("Audio")||type.equalsIgnoreCase("Video"))
                 {
       response.sendRedirect("MultimediaMaintenance_mp.jsp");
         
   }
      else if(type.equalsIgnoreCase("Web"))
                   {
       response.sendRedirect("WebLinkMaintenance_mp.jsp");
          
      }
%>