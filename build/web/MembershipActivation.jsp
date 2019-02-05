<html>
    <head>
        <title></title>
    </head>
    <body>
        <table border="0" cellpadding="0" cellspacing="0" align="center" >
            <tr>
                <td align="center"><h1>Membership Activation</h1></td>
            </tr>
            <tr>
                <td>
                    Please enter the following required information as provided in the
                    <strong><em>Registration Activation email</em></strong> to proceed with activation your account.
                    <p></p>
                </td>
            </tr>
            <tr>
                <td align="center">
                    <fieldset  style="width: 350px;" ><legend><strong>Confirmation Details</strong></legend>
                        <form action="SignUpController.jsp" method="post">
                            <table border="0" cellpadding="5" cellspacing="0" style="margin: 0 auto;" >
                                  
                                <tr>
                                    <td>
                                        <strong>Username</strong>
                                    </td>
                                    <td align="right">
                                        <input   id="txtUsername" name="txtUsername"    type="text" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <strong>Confirmation Code</strong>
                                    </td>
                                    <td>
                                        <input  id="txtConfirmationCode" name="txtConfirmationCode" type="text" />
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" colspan="2">
                                        <input id="sbtnConfirm"  type="submit" value="Confirm" name="sbtnConfirm"  class="button"/>
                                        <input id="btnCancel"  type="button" value="Cancel" name="btnCancel"  class="button" onclick="history.go(-1)"/>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </fieldset>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>
                    <p>Account activated successfully.Please <a href="#">click here</a> to proceed for dash board.</p>
                </td>
            </tr>
        </table>
    </body>
</html>