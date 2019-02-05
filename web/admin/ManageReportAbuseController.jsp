<%@page import="java.util.*,beans.admin.*,services.admin.*" %>
<jsp:useBean id="objBean" class="beans.admin.ManageReportAbuseBean">
    <jsp:setProperty name="objBean" property="*"/>
</jsp:useBean>
<%

            ManageReportAbuseServices objServices = new ManageReportAbuseServices();
          if(request.getParameter("sbtnBlock")!=null)
          {              
               
               String msg = objServices.blockUser(request.getParameter("user_id"),objBean,(Integer)session.getAttribute("userId")); 
              String title=request.getParameter("title");
              String uid=request.getParameter("user_id");
              if (msg.equalsIgnoreCase("Blocked")) 
              {
                  response.sendRedirect("ManageReportAbuse_mp.jsp?msg="+msg);
              }
              else
              {
                  response.sendRedirect("ViewReportAbuseDetails_mp.jsp?msg="+msg+"&user_id="+uid+"&title="+title+"&report_id="+objBean.getTxtReportId());

               }
          }
          
                   else if(request.getParameter("sbtnCancel")!=null)
                   {
                       
                       
                        String msg = objServices.cancelReportAbuse(objBean); 
                        String uid=request.getParameter("user_id");
                        String title=request.getParameter("title");
                        if (msg.equalsIgnoreCase("Resource Report Abuse Cancelled"))
                        {
                                response.sendRedirect("ManageReportAbuse_mp.jsp?msg="+msg);
                         }
                        else 
                        {
                                 response.sendRedirect("ViewReportAbuseDetails_mp.jsp?msg="+msg+"&user_id="+uid+"&title="+title+"&report_id="+objBean.getTxtReportId());

                         }
                       
                       
                   }
            
            
                       else if(request.getParameter("sbtnDelete")!=null)
                       { 
                           
                            String msg = objServices.delUser(request.getParameter("title"),request.getParameter("type"),objBean,(Integer)session.getAttribute("userId"));
                            String uid=request.getParameter("user_id");
                            String title=request.getParameter("title");
                           if (msg.equalsIgnoreCase("User's Resource Deleted")) 
                             {
                                    response.sendRedirect("ManageReportAbuse_mp.jsp?msg="+msg);
                             } 
                            else {
                                        response.sendRedirect("ViewReportAbuseDetails_mp.jsp?msg="+msg+"&user_id="+uid+"&title="+title+"&report_id="+objBean.getTxtReportId());

                                 }  
                       }   


%>