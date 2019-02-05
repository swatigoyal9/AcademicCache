<html>
    <head>
        <title>Change Password</title>
        <script type="text/javascript">
            var NewPassword = document.getElementById("txtNewPassword").value;
            var ConfirmPassword= document.getElementById("txtConfirmPassword").value;
            var Password= document.getElementById("txtCurrentPassword");
            var msg= document.getElementById("divmsg");
            
            if(isEmpty(Password)){
                msg.innerHTML="Enter Your Current Password"
                document.getElementById("txtCurrentPassword").focus();
            }
             if(isEmpty(NewPassword)){
                msg.innerHTML="Enter Your New Password"
                document.getElementById("txtNewPassword").focus();
            }
             if(isEmpty(ConfirmPassword)){
                msg.innerHTML="Enter Your Confirm Password"
                document.getElementById("txtCurrentPassword").focus();
            }
             if(NewPassword==ConfirmPassword){
                msg.innerHTML="Confirm Password Doesn't Match"
                document.getElementById("txtConfirmPassword").focus();
                document.getElementById("txtNewPassword")="";
                document.getElementById("txtConfirmPassword" )="";
            }
        </script>
    </head>
    <body>
        <form name="frm" action="../ChangePasswordServlet" method="post" onsubmit="return check()">
            <table border="0" align="center" rules="none">
                <tr>
                    
                    <td><label id="lblMsg"></label></td>
                    
                </tr>
                
                <tr>
                    <td>
                        <fieldset>
                            <legend><strong> <em> Change Password</em> </strong></legend>
                            <table  align="center" cellpadding="5" cellspacing="0" width="100%">
                                <tr><td><div id="divmsg" style="color:red"></div></td></tr>
                                <tr>
                                    <td><b>Current Password</b></td>
                                    <td><input type="password" id="txtCurrentPassword" name="txtCurrentPassword" /></td>
                                </tr>
                                <tr>
                                    <td><b>New Password</b> </td>
                                    <td><input type="password"  id="txtNewPassword" name="txtNewPassword"/></td>
                                </tr>
                                <tr>
                                    <td><b>Confirm Password</b></td>
                                    <td><input type="password"  id="txtConfirmPassword" name="txtConfirmPassword"/></td>
                                </tr>
                            </table>
                        </fieldset>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <input type="submit"  value="Change" name="sbtnChange" class="button">
                        <input type="reset"  value="Reset" name="rbtnReset" class="button">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>