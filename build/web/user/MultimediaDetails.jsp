<%@page import="beans.user.AddEditMultimediaDetail"%>
<%@page import="services.user.MultimediaMaintenanceServices"%>
<html>
    <head>
        <title>Multimedia Details</title>
    </head>
    <body>
        <%
             MultimediaMaintenanceServices objMultimediaMaintenanceServices=new MultimediaMaintenanceServices();
            AddEditMultimediaDetail objAddEditMultimediaDetail=null;
        %>
        
        
        <%
            if(request.getParameter("edit_id")!=null)
                               {
                int id=Integer.parseInt(request.getParameter("edit_id"));
             objAddEditMultimediaDetail=objMultimediaMaintenanceServices.getMultimediaDetailById(id);
                if(objAddEditMultimediaDetail!=null){
        %>
        <form action="AddEditMultimediaController.jsp" method="post">
            <table align="center" >
                <tr>
                    <td><label id="lblMsg">message</label></td>
                </tr>
                <tr>
                    <td>
                        <fieldset>
                            <legend><strong><em>Update Multimedia Details</em></strong></legend>
                            <table >
                                <tr>
                                                <td><input type="text" name="txtId" value="<%=objAddEditMultimediaDetail.getTxtId()%>" hidden/></td>
                                            </tr>
                                <tr>
                                    <td><strong>Title</strong></td>
                                    <td><input type="text" name="txtTitle" id="txtTitle" value="<%=objAddEditMultimediaDetail.getTxtTitle()%>"></td>	
                                    <td>&nbsp;</td>
                                </tr>	
                                <tr>
                                    <td><strong>Label</strong></td>
                                    <td><input type="text" name="txtLabel" id="txtLabel" value="<%=objAddEditMultimediaDetail.getTxtLabel()%>"></td>			
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td valign="top"><strong>Description</strong></td>
                                    <td><textarea rows="3" cols="23"  name="taDescription" id="taDescription"><%=objAddEditMultimediaDetail.getTaDescription()%></textarea></td>			
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td valign="top"><strong>Used For</strong></td>
                                    <td><textarea rows="3" cols="23"  name="taUsedFor" id="taUsedFor"><%=objAddEditMultimediaDetail.getTaUsedFor()%></textarea></td>			
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td><strong>Usage Year</strong></td>
                                    <td><input type="text" name="txtUsageYear" id="txtUsageYear" value="<%=objAddEditMultimediaDetail.getTxtUsageYear()%>"></td>			
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td valign="top"><strong>Tags</strong></td>
                                    <td><textarea rows="3" cols="23"  name="taTags" id="taTags"><%=objAddEditMultimediaDetail.getTaTags()%></textarea></td>			
                                    <td>&nbsp;</td>
                                </tr>
                                <%
                        String st="";
                        String st1="";
                        
                        if(objAddEditMultimediaDetail.getRbAccessType().equalsIgnoreCase("Public")){
                            st="checked";
                        }
                                               else if(objAddEditMultimediaDetail.getRbAccessType().equalsIgnoreCase("Private")){
                                                   st1="Checked";
                                               }
                        
                    %>
                                <tr>
                                        <td><strong>Access Type</strong></td>
                                        <td><input type="radio" name="rbAccessType" id="rbPublic" value="Public"<%=st%> checked>Public <input type="radio" name="rbAccessType" id="rbPrivate" value="Private" <%=st1%>>Private</td>
                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                    </tr>
                                <%
                        String str="";
                        String str1="";
                        if(objAddEditMultimediaDetail.getDdlMediaType().equalsIgnoreCase("Audio")){
                            str="Selected";
                        }
                                               else if(objAddEditMultimediaDetail.getDdlMediaType().equalsIgnoreCase("Video")){
                                                   str1="Selected";
                                               }
                        
                    %>
                                    <tr>
                                    <td><strong>Media Type</strong></td>
                                    <td>
                                        <select name="ddlMediaType" id="ddlMediaType">
                                            <option value="Select">Select</option>
                                            <option value="Audio" <%=str%>>Audio</option>
                                            <option value="Video" <%=str1%>>Video</option>
                                        </select>
                                    </td>	
                                    <td>&nbsp;</td>
                                </tr>
                            </table>
                        </fieldset>
                    </td>   
                </tr> 
                <tr>
                    <td align="right"><input type="submit" name="sbtnUpdate" value="Update" class="button"> <input type="button" name="btnCancel" value="Cancel" class="button"></td>			
                </tr>
                <%
                                   }
                         }
                %>
            </table>
        </form>
    </body>
</html>
