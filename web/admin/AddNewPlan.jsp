
<html>
    <head>
        <title>Add New Design</title>
    </head>
    <body>
        <form action="AddEditPlanController.jsp">
            <table align="center">
                <tr>
                    <td align="center">
                        <h3><u>Add New Plan</u></h3>
                    </td>
                </tr>
                <tr>
                    <td>

                        <fieldset>
                            <table align="center">
                                <tr>
                                    <td>Plan Name</td>
                                    <td><input type="text" name="txtPlanName" id="txtPlanName"/></td>
                                </tr>
                                <tr>
                                    <td>Space Allowed</td>
                                    <td><input type="text" name="txtSpaceAllowed" id="txtSpaceAllowed"/>&nbsp;(MB)</td>
                                </tr>
                                <tr>
                                    <td>Validity</td>
                                    <td><input type="text" name="txtValidity" id="txtValidity"/>&nbsp;Month</td>
                                </tr>
                                <tr>
                                    <td>Cost</td>
                                    <td><input type="text" name="txtCost" id="txtCost"/>&nbsp;INR</td>                                                </tr>
                                <tr>
                                    <td>Status</td>
                                    <td>
                                        <input type="radio" name="rbStatus" id="rbActive" value="Active"/>Active

                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input type="radio" name="rbStatus" id="rbInactive" value="Inactive"/>Inactive</td>
                                </tr>
                                <tr>
                                    <td align="center" colspan="2">
                                        <input type="submit" name="sbtnSave" value="Save" class="button"/>
                                        <input type="reset" name="rbtnReset" value="Reset" class="button"/>
                                        <input type="button" name="btnCancel" value="Cancel" class="button" onclick="history.go(-1)"/>
                                    </td>
                                </tr>
                            </table> 
                        </fieldset>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>