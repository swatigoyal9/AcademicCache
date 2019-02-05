<html>
    <head>
        <title></title>
    </head>
    <body>
        <form action="../MultimediaServlet" method="post" enctype="multipart/form-data">
            <h2 align="center"></h2>
            <table align="center">
                <tr>
                    <td><label id="lblMsg">message</label></td>
                </tr>
                <tr>
                    <td>
                        <fieldset><legend><strong><em>Add New Multimedia Resource</em></strong></legend>
                            <table>
                                <tr>
                                   <td><input type="text" name="txtuserId" id="txtTitle" hidden="" ></td>	
                                </tr>	
                                <tr>
                                    <td><strong>Title</strong></td>
                                    <td><input type="text" name="txtTitle" id="txtTitle"></td>			
                                </tr>	
                                <tr>
                                    <td><strong>Label</strong></td>
                                    <td><input type="text" name="txtLabel" id="txtLabel"></td>			
                                </tr>
                                <tr>
                                    <td valign="top"><strong>Description</strong></td>
                                    <td><textarea rows="3" cols="23"  name="taDescription" id="taDescription"></textarea></td>			
                                </tr>
                                <tr>
                                    <td valign="top"><strong>Used For</strong></td>
                                    <td><textarea rows="3" cols="23"  name="taUsedFor" id="taUsedFor"></textarea></td>			
                                </tr>
                                <tr>
                                    <td><strong>Usage Year</strong></td>
                                    <td><input type="text" name="txtUsageYear" id="txtUsageYear"></td>			
                                </tr>
                                <tr>
                                    <td valign="top"><strong>Tags</strong></td>
                                    <td><textarea rows="3" cols="23"  name="taTags" id="taTags"></textarea></td>			
                                </tr>
                                <tr>
                                    <td><strong>Access Type</strong></td>
                                    <td><input type="radio" name="rbAccessType" id="rbPublic" value="Public" checked>Public <input type="radio" name="rbAccessType" id="rbPrivate" value="Private">Private</td>			
                                </tr>
                                <tr>
                                    <td><strong>Media Type</strong></td>
                                    <td>
                                        <select name="ddlMediaType" id="ddlMediaType">
                                            <option value="Select">Select</option>
                                            <option value="Audio">Audio</option>
                                            <option value="Video">Video</option>
                                        </select>
                                    </td>			
                                </tr>
                                <tr>
                                    <td><strong>Audio/Video File</strong></td>
                                    <td><input type="file" name="f1Audio_Video" id="f1Audio_Video"/></td>			
                                </tr>
                            </table>
                        </fieldset>
                    </td>
                </tr> 
                <tr>
                    <td align="center"><input type="submit" name="sbtnMSave" value="Save" class="button"/> <input type="button" name="btnCancel" value="Cancel" class="button"></td>			
                </tr>
            </table>
        </form>
    </body>
</html>