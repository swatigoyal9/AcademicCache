<html>
    <head>
        <title></title>
    </head>
    <body>
        <form action="SignUpController.jsp" method="post">
            <h1 align="center">Registration</h1>
            <table align="center" >
                <tr>
                    <td>
                        <fieldset><legend><strong>Sign Up</strong></legend>
                            <table >
                              
                                <tr>
                                    <td><strong>Email-Id</strong></td>
                                    <td><input type="text" name="txtUsername" id="txtUsername"/></td>
                                </tr>
                                <tr>
                                    <td><strong>Password</strong></td>
                                    <td><input type="password" name="txtPassword" id="txtPassword"/></td>
                                </tr>
                                <tr>
                                    <td><strong>Confirm Password</strong></td>
                                    <td><input type="password" name="txtConfirmPassword" id="txtConfirmPassword"  /></td>
                                </tr>
                            </table>
                        </fieldset>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <input  type="submit" value="Register" id="sbtnRegister"  name="sbtnRegister" onclick="window.location='Confirmation_mp.jsp'" class="button"/>
                        <input type="reset" value="Reset" name="btnReset" id="btnReset" class="button"/>
                        <input type="button" value="Cancel" name="btnCancel" id="btnCancel" class="button"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>