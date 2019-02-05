<html>
    <head>
        <title></title>
    </head>
    <body>
        <form action="ForgetPasswordServlet" method="post">
            <table border="0" cellpadding="5" cellspacing="0" align="center">
                <tr>
                    <td align="center"><h1>Forgot Password</h1></td>
                </tr>
                <tr>
                    <td><label id="lblMsg">message</label></td>
                </tr>
                <tr>
                    <td>
                        <fieldset>
                            <div><strong>If you have forgotten your password, you can have it recover.
                                    <br />
                                    Please enter your username address below to do so.</strong><br />
                                <br />
                                <label>  An email with the instructions to recover your password will be sent to you.</label>
                            </div>
                            <table border="0" cellpadding="5" cellspacing="0">
                                <tr>
                                    <td><strong>Username</strong></td>
                                    <td><input id="txtUsername" name="txtUsername" type="text" /></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td align="right"><input id="sbtnSubmit" name="sbtnSubmit" type="submit" value="Submit"  class="button"/>
                                        <input id="btnCancel" name="btnCancel" type="button" value="Cancel" class="button" />
                                    </td>
                                </tr>
                            </table>
                            <hr/>
                            <div>
                                Your Password has been sent to your email id.<br/>
                                Please check your email for further instruction.<br/>
                                Please <a href="Login_mp.jsp">Click here</a> to go back to the login page.
                            </div>
                        </fieldset>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>