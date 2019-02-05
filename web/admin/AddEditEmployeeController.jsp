
<%@page import="beans.admin.AddEditEmployeeBean"%>
<%@page import="services.admin.ManageEmployeeServices"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="objBean" class="beans.admin.AddEditEmployeeBean">
            <jsp:setProperty name="objBean" property="*"/> 
        </jsp:useBean>
        <%
            ManageEmployeeServices objManageEmployeeServices=new ManageEmployeeServices();
             if(request.getParameter("sbtnSave")!=null){
                String msg1=objManageEmployeeServices.addEmployee(objBean);
                if(msg1.equalsIgnoreCase("failed")){
                    response.sendRedirect("AddNewEmployee_mp.jsp?msg1="+msg1);
                }
                else{
                response.sendRedirect("ManageEmployee_mp.jsp?msg1="+msg1);
                    }
             }
           if(request.getParameter("sbtnUpdate")!=null)
                                     {
                   String msg=objManageEmployeeServices.updateEmployeeRecord(objBean);
                   if(msg.equalsIgnoreCase("failed")){
                   response.sendRedirect("ViewAndEditEmployeeDetail_mp.jsp?msg="+msg);
               }
                                     else{
                       response.sendRedirect("ManageEmployee_mp.jsp?msg="+msg);
                                     }
                                     }
            
        %>
        
        <%
            if(request.getParameter("edit_id")!=null)
                               {
                int id=Integer.parseInt(request.getParameter("edit_id"));
                String status=request.getParameter("userStatus");
                String msg=objManageEmployeeServices.activeInactivateEmployee(id,status);
                
                       response.sendRedirect("ManageEmployee_mp.jsp?msg="+msg);
                                    
                                     }
        %>
    
                    
                    
                   
    </body>
</html>
