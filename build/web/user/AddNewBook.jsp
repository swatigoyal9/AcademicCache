<html>
    <head>
        <title>Add New Book</title>
    </head>
    <body>
        <form action="../FileUploadServlet" method="post" enctype="multipart/form-data">
            <table align="center" >
                <tr>
                    <td><label id="lblMsg">message</label></td>
                </tr>
                <tr>
                    <td>
                        <fieldset><legend><strong><em>Add New Book</em></strong></legend>
                            <table>
                                <tr>
                                   <td><input type="text" name="txtuserId" id="txtTitle" hidden="" ></td>	
                                </tr>	
                                <tr>
                                    <td><strong>Title</strong></td>
                                    <td><input type="text" name="txtTitle" id="txtTitle"></td>	
                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                </tr>	
                                <tr>
                                    <td><strong>Author</strong></td>
                                    <td><input type="text" name="txtAuthor" id="txtAuthor"></td>			
                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                </tr>
                                <tr>
                                    <td><strong>Publication Year</strong></td>
                                    <td><input type="text" name="txtPublicationYear" id="txtPublicationYear"></td>			
                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                </tr>
                                <tr>
                                    <td valign="top"><strong>Description</strong></td>
                                    <td><textarea rows="3" cols="23"  name="taDescription" id="taDescription"></textarea></td>			
                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                </tr>
                                <tr>
                                    <td><strong>Category</strong></td>
                                    <td><input type="text" name="txtCategory" id="txtCategory"></td>			
                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                </tr>
                                <tr>
                                    <td valign="top"><strong>Tags</strong></td>
                                    <td><textarea rows="3" cols="23"  name="taTags" id="taTags"></textarea></td>			
                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                </tr>
                                <tr>
                                    <td valign="top"><strong>Book Used For</strong></td>
                                    <td><textarea rows="3" cols="23"  name="taBookUsedFor"  id="taBookUsedFor"></textarea></td>			
                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                </tr>
                                <tr>
                                    <td><strong>Usage Year</strong></td>
                                    <td><input type="text" name="txtUsageYear" id="txtUsageYear"></td>			
                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                </tr>
                                <tr>
                                    <td><strong>Access Type</strong></td>
                                    <td><input type="radio" name="rbAccessType" id="rbPublic" value="Public" checked>Public <input type="radio" name="rbAccessType" id="rbPrivate" value="Private">Private</td>
                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                </tr>
                                <tr>
                                    <td><strong>Book</strong></td>
                                    <td><input type="file" name="flBook" id="flBook"/></td>			
                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                </tr>
                            </table>
                        </fieldset>
                    </td>
                </tr> 
                <tr>
                    <td align="center" >
                        <input type="submit" name="sbtnSave" value="Save" class="button"> <input type="button" name="btnCancel" value="Cancel" class="button">
                    </td>			
                </tr>
            </table>
        </form>
    </body>
</html>
