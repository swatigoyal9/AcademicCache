<%-- 
    Document   : SignUpController.jsp
    Created on : 4 Jul, 2013, 12:59:59 PM
    Author     : Aparchyanta
--%>

<%@page import="services.common.CommonServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="objBean" class="beans.common.SignUpBean">
            <jsp:setProperty name="objBean" property="*"/> 
        </jsp:useBean>
        <%
            CommonServices objCommonServices=new CommonServices();
            String email=request.getParameter("txtUsername");
            String pwd=request.getParameter("txtPassword");
             if(request.getParameter("sbtnRegister")!=null){
                String msg1=objCommonServices.signUpUser(email,pwd);
                if(msg1.equalsIgnoreCase("failed")){
                    response.sendRedirect("SignUp_mp.jsp?msg1="+msg1);
                }
                else{
                response.sendRedirect("Confirmation_mp.jsp?msg1="+msg1);
                    }
             }%>
                    
                    
                    <%
                
                if(request.getParameter("sbtnConfirm")!=null){
                    
                String msg=objCommonServices.updateSignUpUser(objBean);
                if(msg.equalsIgnoreCase("failed")){
                    response.sendRedirect("MembershipActivation_mp.jsp?msg="+msg);
                }
                else{
                    
                response.sendRedirect("Login_mp.jsp?msg="+msg);
                }
             }
            
             
             %>
    </body>
</html>
