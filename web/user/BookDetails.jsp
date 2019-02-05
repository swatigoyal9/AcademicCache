
<%@page import="beans.user.AddEditNewBookBean"%>
<%@page import="services.user.WebLinkMaintenanceServices"%>
<%@page import="services.user.BooksMaintenanceServices"%>
<html>
    <head>
        <title>Book Details</title>
    </head>
    <body>
        <%
             BooksMaintenanceServices objBooksMaintenanceServices=new BooksMaintenanceServices();
            AddEditNewBookBean objAddEditNewBookBean=null;
        %>
        
        
        <%
            if(request.getParameter("edit_id")!=null)
                               {
                int id=Integer.parseInt(request.getParameter("edit_id"));
             objAddEditNewBookBean=objBooksMaintenanceServices.getBookDetailById(id);
                if(objAddEditNewBookBean!=null){
        %>
        <form action="AddEditBooksController.jsp" method="post">
                <table align="center">
                    <tr>
                        <td><label id="lblMsg">message</label></td>
                    </tr>
                    <tr>
                        <td>
                            <fieldset><legend><strong><em>Update Book Details</em></strong></legend>
                                <table>
                                    <tr>
                                                <td><input type="text" name="txtId" value="<%=objAddEditNewBookBean.getTxtId()%>" hidden/></td>
                                            </tr>
                                    <tr>
                                        <td><strong>Title</strong></td>
                                        <td><input type="text" name="txtTitle" id="txtTitle" value="<%=objAddEditNewBookBean.getTxtTitle()%>"></td>	
                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                    </tr>	
                                    <tr>
                                        <td><strong>Author</strong></td>
                                        <td><input type="text" name="txtAuthor" id="txtAuthor" value="<%=objAddEditNewBookBean.getTxtAuthor()%>"></td>			
                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Publication Year</strong></td>
                                        <td><input type="text" name="txtPublicationYear" id="txtPublicationYear" value="<%=objAddEditNewBookBean.getTxtPublicationYear()%>"></td>			
                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td valign="top"><strong>Description</strong></td>
                                        <td><textarea rows="3" cols="23"  name="taDescription" id="taDescription" ><%=objAddEditNewBookBean.getTaDescription()%></textarea></td>			
                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Category</strong></td>
                                        <td><input type="text" name="txtCategory" id="txtCategory" value="<%=objAddEditNewBookBean.getTxtCategory()%>"></td>			
                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td valign="top"><strong>Tags</strong></td>
                                        <td><textarea rows="3" cols="23"  name="taTags" id="taTags" ><%=objAddEditNewBookBean.getTaTags()%></textarea></td>			
                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td valign="top"><strong>Book Used For</strong></td>
                                        <td><textarea rows="3" cols="23"  name="taBookUsedFor"  id="taBookUsedFor" ><%=objAddEditNewBookBean.getTaBookUsedFor()%></textarea></td>			
                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Usage Year</strong></td>
                                        <td><input type="text" name="txtUsageYear" id="txtUsageYear" value="<%=objAddEditNewBookBean.getTxtUsageYear()%>"></td>			
                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                    </tr>
                                    <%
                        String st="";
                        String st1="";
                        
                        if(objAddEditNewBookBean.getRbAccessType().equalsIgnoreCase("Public")){
                            st="checked";
                        }
                                               else if(objAddEditNewBookBean.getRbAccessType().equalsIgnoreCase("Private")){
                                                   st1="Checked";
                                               }
                        
                    %>
                                    <tr>
                                        <td><strong>Access Type</strong></td>
                                        <td><input type="radio" name="rbAccessType" id="rbPublic" value="Public"<%=st%> checked>Public <input type="radio" name="rbAccessType" id="rbPrivate" value="Private" <%=st1%>>Private</td>
                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                    </tr>
                                </table>
                            </fieldset>
                        </td>
                    </tr> 
                    <tr>
                        <td align="center"><input type="submit" name="sbtnUpdate" id="sbtnUpdate" value="Update" class="button"> 
                            <input type="button" name="btnCancel" value="Cancel" class="button">
                        </td>			
                    </tr>
                    <%
                                   }
                         }
                %>
                </table>
        </form>
    </body>
</html>