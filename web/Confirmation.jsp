<html>
    <head>
        <title></title>
    </head>
    <body>
        <h1 align="center" >Registration</h1>
        <table align="center">
            <tr>
                <td>
                    <fieldset>
                        <%
                                if(request.getParameter("msg1")!=null)
                                {
                                    
                        %>
                        <label id="lblMsg"><font style="color: maroon">Your Account has been created and  verfication code is also sent on your emial_id.</font></label>
                        <p><font size="4"><b><i>Confirmation Code</i></b> or link has been sent to your Email Id
                            as provided.<br>
                            Please check your Email for further instruction.
                            <br>
                            <br>
                            Please <a href="MembershipActivation_mp.jsp">Click Here</a> to go further to activate your account.</font>
                        </p>
                        </fieldset>
                         <%
                                       }
                                      else
                                       {
                         %>
                         <label id="lblMsg"><font style="color: maroon"><%=request.getParameter("msg1")%></font></label>
                          <p>Please <a href="ConfirmationServlet?email=<%=request.getParameter("email")%>">Try Again</a> to send the mail. <a href="SignUp_mp.jsp">Back to SignUp Form</p>
                              
                          <%
                          
                                        }
                                   
                            %>
                    
                </td>  
            </tr>
        </table>                    
    </body>
</html>