<%@page import="services.user.ChangePlanServices"%>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <%
        ChangePlanServices objChangePlanServices=new ChangePlanServices();
            String userId=(String)session.getAttribute("userId");
            System.out.println("user "+userId);
            String plan_id=request.getParameter("rbPlan");
            if(request.getParameter("sbtnChangePlan")!=null)
            {
                  // objBean.setPlan_id(plan_id);
                   //objBean.setPlan_status("Active");
                  // objBean.setUser_id(userId);
                   //objBean.setUser_plan_id(plan_id);
                   String msg=objChangePlanServices.updateUserPlan(userId,plan_id);
                   if(msg.equalsIgnoreCase("failed"))
                   {
                       response.sendRedirect("ChangePlanController.jsp?msg="+msg);
                   }
                   else
                   {
                       response.sendRedirect("Home_mp.jsp?msg="+msg);
                   }
          }
        %>
    </body>
</html>
