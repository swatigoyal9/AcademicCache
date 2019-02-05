
<%@page import="beans.user.AddEditWebLinkBean"%>
<%@page import="services.user.WebLinkMaintenanceServices"%>
<html>
    <head>
        <title>Web Link Details</title>
    </head>
    <body>
        <%
             WebLinkMaintenanceServices objWebLinkMaintenanceServices=new WebLinkMaintenanceServices();
            AddEditWebLinkBean objAddEditWebLinkBean=null;
        %>
        
        
        <%
            if(request.getParameter("edit_id")!=null)
                               {
                int id=Integer.parseInt(request.getParameter("edit_id"));
             objAddEditWebLinkBean=objWebLinkMaintenanceServices.getWebLinkDetailById(id);
                if(objAddEditWebLinkBean!=null){
        %>
        <form action="AddEditWebLinkController.jsp" method="post">
            <table  align="center" >

                <tr>
                    <td>
                        <fieldset><legend><strong><em>Update Web Link Details</em></strong></legend>
                            <table >
                                <tr>
                                    <td><label id="lblMsg">message</label></td>
                                </tr>
                                 <tr>
                                                <td><input type="text" name="txtId" value="<%=objAddEditWebLinkBean.getTxtId()%>" hidden/></td>
                                            </tr>
                                <tr>
                                    <td><strong>Title</strong></td>
                                    <td><input type="text" name="txtTitle" id="txtTitle" value="<%=objAddEditWebLinkBean.getTxtTitle()%>"/></td>	
                                    <td width="10"></td>
                                </tr>	
                                <tr>
                                    <td><strong>Link</strong></td>
                                    <td><input type="text" name="txtLink" id="txtLink" value="<%=objAddEditWebLinkBean.getTxtLink()%>"/></td>			
                                    <td width="10"></td>
                                </tr>
                                <tr>
                                    <td valign="top"><strong>Description</strong></td>
                                    <td><textarea rows="3" cols="23"  name="taDescription" id="taDescription"><%=objAddEditWebLinkBean.getTaDescription()%></textarea></td>			
                                    <td width="10"></td>
                                </tr>
                                <tr>
                                    <td valign="top"><strong>Used For</strong></td>
                                    <td><textarea rows="3" cols="23"  name="taUsedFor" id="taUsedFor"><%=objAddEditWebLinkBean.getTaUsedFor()%></textarea></td>			
                                    <td width="10"></td>
                                </tr>
                                <tr>
                                    <td><strong>Category</strong></td>
                                    <td><input type="text" name="txtCategory" id="txtCategory" value="<%=objAddEditWebLinkBean.getTxtCategory()%>"></td>			
                                    <td width="10"></td>
                                </tr>
                                <tr>
                                    <%
                        String st="";
                        String st1="";
                        
                        if(objAddEditWebLinkBean.getRbAccessType().equalsIgnoreCase("Public")){
                            st="checked";
                        }
                                               else if(objAddEditWebLinkBean.getRbAccessType().equalsIgnoreCase("Private")){
                                                   st1="Checked";
                                               }
                        
                    %>
                                    <td><strong>Access Type</strong></td>
                                    <td><input type="radio" name="rbAccessType" id="rbPublic" value="Public"<%=st%> >Public 
                                        <input type="radio" name="rbAccessType" id="rbPrivate" value="Private" <%=st1%> >Private</td>			
                                    <td width="10"></td>
                                </tr>
                                <tr>
                                    <td valign="top"><strong>Tags</strong></td>
                                    <td><textarea rows="3" cols="23"  name="taTags" id="taTags"><%=objAddEditWebLinkBean.getTaTags()%></textarea></td>			
                                    <td width="10"></td>
                                </tr>
                            </table>
                        </fieldset>
                    </td>
                </tr> 
                <tr>
                    <td align="center"><input type="submit" name="sbtnUpdate" value="Update" class="button"> <input type="button" name="btnCancel" value="Cancel" class="button"></td>			
                </tr>
                <%
                                   }
                         }
                %>
            </table>
        </form>
    </body>
</html>