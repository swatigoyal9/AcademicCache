<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <form action="LoginServlet" method="post">
            <table align="right" > 
                <tr>
                    <td>
                        <fieldset><legend><strong><em>&nbsp;Login&nbsp;</em></strong></legend>
                            <table cellpadding="5" >
                                <tr> 
                                    <td colspan="2" align="left">
                                        <label id ="lblMsg"></label>
                                    </td>
                                <tr>
                                    <td>User&nbsp;Name</td>
                                    <td><input  id="txtUsername" name="txtUsername"  type="text" /></td>

                                </tr>
                                <tr>
                                    <td>Password</td>
                                    <td><input  id="txtPassword" name="txtPassword" type="password" /></td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="right" >
                                        <input id="sbtnLogin"  name="sbtnLogin" type="submit" value="Login" class="button"/>
                                        <input id="rbtnReset" name="rbtnReset"  type="reset" value="Reset" class="button"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center" ><a href="ForgotPassword_mp.jsp">Forgot Password ?</a>&nbsp;&nbsp;<a href="SignUp_mp.jsp">Sign Up</a></td>
                                </tr>
                            </table>
                        </fieldset>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
