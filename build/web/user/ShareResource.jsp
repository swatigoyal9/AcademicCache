<%@page import="services.user.WebLinkMaintenanceServices"%>
<%@page import="services.user.MultimediaMaintenanceServices"%>
<%@page import="services.user.BooksMaintenanceServices"%>
<%@page import="beans.user.CommonBean"%>
<html>
    <head>
        <title>Share Resource</title>
    </head>
    <body>
        <%
            String uid=(String)session.getAttribute("userId");
            CommonBean objBean=null;
            String type=null;
            String id=null;
            if(request.getParameter("book_id")!=null)
                {
                
                BooksMaintenanceServices objServices=new BooksMaintenanceServices();
                objBean=new CommonBean();
                id=request.getParameter("book_id");
                type=request.getParameter("type");
                System.out.println("bookk");
                objBean=objServices.currentBook(request.getParameter("book_id"));
                
                 }
               else if(request.getParameter("m_id")!=null)
                {
                    MultimediaMaintenanceServices objServices=new MultimediaMaintenanceServices();
                    objBean=new CommonBean();
                    System.out.println("multimediaS");
                id=request.getParameter("m_id");
                type=request.getParameter("type");
                    objBean=objServices.currentMediaInfo(request.getParameter("m_id"));
                    
                }
                
                               else if(request.getParameter("w_id")!=null)
                               {
                                   WebLinkMaintenanceServices objServices=new WebLinkMaintenanceServices();
                                   objBean=new CommonBean();
                                   System.out.println("weblink");
                id=request.getParameter("w_id");
                type=request.getParameter("type");
                                   objBean=objServices.currentWebInfo(request.getParameter("w_id"));
                               }  
        %>
        <form action="../ConfirmationServlet" method="post">
            
            <table  align="center" >
                <tr>
                    <td>
                        <fieldset>
                            <legend><strong><em>Share Resource</em></strong></legend>
                            <table >
                                <tr><td><input type="text" id="id" name="id" value="<%=id%>" hidden/></td></tr>
                                <tr><td><input type="text" id="uid" name="uid" value="<%=uid%>" hidden/></td></tr>
                                <tr><td><input type="text" id="type" name="type" value="<%=type%>" hidden/></td></tr>
                                <tr>
                                    <td><strong>Title</strong></td>
                                    <td><input type="text" readonly name="txtTitle" id="txtTitle" size="26" value="<%=objBean.getTxtTitle()%>"/></td>			
                                    <td>&nbsp;</td>
                                </tr>	
                                <tr>
                                    <td valign="top"><strong>Comment</strong></td>
                                    <td><textarea rows="10" cols="40" name="taComment" id="taComment" ></textarea></td>			
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td valign="top"><strong>Email Id</strong></td>
                                    <td><textarea rows="10" cols="40" name="taEmailId" id="taEmailId"></textarea></td>			
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="2"><small>Separate multiple email-id's with semicolon (;)</small></td>
                                </tr>

                            </table>
                        </fieldset>
                    </td>
                </tr> 
                <tr>
                    <td align="right"><input   type="submit" name="sbtnShare" value="Share" class="button"> <input type="button" name="btnCancel" value="Cancel" class="button" onclick="history.go(-1)"></td>			
                </tr>	
            </table>
        </form>
    </body>
</html>