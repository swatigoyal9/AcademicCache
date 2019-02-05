<html>
    <head>
        <title></title>
    </head>
    <body>
        
        <table align="center">
            <tr>
                <td>
                    <fieldset>
                        <%
                                if(request.getParameter("msg")!=null)
                                {
                        %>
                                    <label id="lblMsg"><font style="color: maroon"><%=request.getParameter("msg")%></font></label>
                        <%
                                 }
                        %>
                        <%
                            if(request.getParameter("msg")==null)
                           {   
                        %>
                        <p><font size="4"><b>Dear User,</b> Your account is not still activated.<br>
                            To activate your Account please click on Activation button:<br/>
                        <form action="ConfirmationServlet" method="post">
                            <input type="text" name="txtUsername" id="txtUsername" readonly value="<%=request.getParameter("email")%>"/>
                            <br/>
                           
                            <input type="submit" name="sbtnConfirmation" value="Click Here for Activation" class="button"/>
                        </form>
                            <br/>
                           
                           Otherwise, You'll not be able to Login into your Account.This is the security constraint you should go through it.
                           <%
                            }
                        %> 
                           <%
                                    if(request.getParameter("msg")!=null)
                                    {
                                        if(request.getParameter("msg").equalsIgnoreCase("Verfication Sent"))
                                         { 
                           %>
                            <br>
                            Please <a href="MembershipActivation_mp.jsp">Click Here</a> to go further to activate your account.
                            <%
                                         }
                                        else
                                        {
                            %> 
                                  <br/>  Please <a href="ConfirmationServlet?&blocked_email=<%=request.getParameter("email")%>">Try Again</a> to send the mail.
                             <%           }    
                                    }  
                                        
                            %>
                        </p>
                    </fieldset>
                </td>  
            </tr>
        </table>                    
    </body>
</html>