
<html>
    <head>
        <title>Add New Employee</title>
    </head>
    <body>
        <table align="center">
            <tr>
                <td align="center">
                    <h3><u>Add New Employee</u></h3>
                </td>
            </tr>
            <tr>
                <td>

                    <fieldset>
                        <form action="AddEditEmployeeController.jsp" method="post">
                            <table align="center" cellpadding="5">
                                <tr>
                                    <td>Username</td>
                                    <td><input type="text" name="txtUsername" id="txtUsername"/></td>
                                </tr>
                                <tr>
                                    <td>Password</td>
                                    <td><input type="password" name="txtPassword" id="txtPassword"/></td>
                                </tr>
                                <tr>
                                    <td>User Status</td>
                                    <td><input type="radio" name="rbStatus" id="rbActive" value="Active"/>Active
                                        <input type="radio" name="rbStatus" id="rbInactive" value="Inactive"/>Inactive</td>
                                </tr>
                                <tr>
                                    <td>User Type</td>
                                    <td>
                                        <select id="ddlUserType" name="ddlUserType">
                                            <option value="select">Select</option>
                                            <option value="Administrator">Administrator</option>
                                            <option value="Employee">Employee</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Name</td>
                                    <td><input type="text" name="txtName" id="txtName"/></td>                                                </tr>
                                <tr>
                                    <td>Gender</td>
                                    <td>
                                        <input type="radio" name="rbGender" id="rbMale" value="Male"/>Male
                                        <input type="radio" name="rbGender" id="rbFemale" value="Female"/>Female</td>
                                </tr>
                                <tr>
                                    <td>Contact No.</td>
                                    <td><input type="text" name="txtContact" id="txtContact"/></td>
                                </tr>
                                <tr>
                                    <td>Email</td>
                                    <td><input type="text" name="txtEmail" id="txtEmail"/></td>                                                
                                </tr>
                                <tr>
                                    <td>Date Of Joining</td>
                                    <td><input type="text" name="txtDateOfJoining" id="txtDateOfJoining"/></td>
                                </tr>
                                <tr>
                                    <td align="center" colspan="2">
                                        <input type="submit" name="sbtnSave" value="Save" class="button"/>
                                        <input type="reset" name="rbtnReset" value="Reset" class="button"/>
                                        <input type="button" name="btnCancel" value="Cancel" class="button"/>
                                    </td>
                                </tr>
                            </table> 
                        </form>
                    </fieldset> 
                </td>
            </tr>
        </table>
    </body>
</html>