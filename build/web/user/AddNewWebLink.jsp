<html>
    <head>
        <title>Add New Web Link</title>
    </head>
    <body>
        <form action="AddEditWebLinkController.jsp" method="post">
            <table  align="center">
                <tr>
                    <td><label id="lblMsg">message</label></td>
                </tr>

                <tr>
                    <td>
                        <fieldset><legend><strong><em>Add New Web Link</em></strong></legend>
                            <table>
                                <tr>
                                    
                                    <td><input type="text" name="txtuserId" id="txtTitle" hidden="" ></td>	
                                    
                                </tr>	
                                <tr>
                                    <td><strong>Title</strong></td>
                                    <td><input type="text" name="txtTitle" id="txtTitle"></td>	
                                    <td width="10"></td>
                                </tr>	
                                <tr>
                                    <td><strong>Link</strong></td>
                                    <td><input type="text" name="txtLink" id="txtLink"></td>			
                                    <td width="10"></td>
                                </tr>
                                <tr>
                                    <td colspan="3" >
                                        <small> (Link should start from http:// <b>OR</b> https://  only)</small>
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="top"><strong>Description</strong></td>
                                    <td><textarea rows="3" cols="23"  name="taDescription" id="taDescription"></textarea></td>			
                                    <td width="10"></td>
                                </tr>
                                <tr>
                                    <td valign="top"><strong>Used For</strong></td>
                                    <td><textarea rows="3" cols="23"  name="taUsedFor" id="taUsedFor"></textarea></td>			
                                    <td width="10"></td>
                                </tr>
                                <tr>
                                    <td><strong>Category</strong></td>
                                    <td><input type="text" name="txtCategory" id="txtCategory"></td>			
                                    <td width="10"></td>
                                </tr>
                                <tr>
                                    <td><strong>Access Type</strong></td>
                                    <td><input type="radio" name="rbAccessType" id="rbPublic" value="Public" checked>Public <input type="radio" name="rbAccessType" id="rbPrivate" value="Private">Private</td>			
                                    <td width="10"></td>
                                </tr>
                                <tr>
                                    <td valign="top"><strong>Tags</strong></td>
                                    <td><textarea rows="3" cols="23"  name="taTags" id="taTags"></textarea></td>			
                                    <td width="10"></td>
                                </tr>
                            </table>
                        </fieldset>
                    </td>
                </tr> 
                <tr>
                    <td align="center"><input type="submit" name="sbtnSave" value="Save" class="button"> <input type="button" name="btnCancel" value="Cancel" class="button"></td>			
                </tr>
            </table>
        </form>
    </body>
</html>
