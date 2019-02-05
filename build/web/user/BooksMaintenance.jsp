<%@page import="services.user.BooksMaintenanceServices"%>
<%@page import="beans.user.BooksMaintenanceBean"%>
<%@page import="java.util.List"%>
<html>
    <head>
        <title>Book Maintenance Page</title>
    </head>
    <body>
        <form action="../DownloadServlet" method="post" enctype="multipart/form-data">
        <table align="center" border="0" rules="none" >
            
            <tr>
                <td align="center" colspan="2"><h1>Manage Books</h1></td>
            </tr>
            
            <tr>
                <td>
                    <input type="button" name="btnAddNewBook" value="Add New Book" onclick="window.location='AddNewBook_mp.jsp'" class="button"/>
                </td>
                <td align="right">
                    <font size="4">Title</font>
                    &nbsp;&nbsp;&nbsp;<input type="text"  name="txtTitle" id="txtTitle" value="" size="30"/>
                    <input  type="submit" name="sbtnList" id="sbtnList" value="List" class="button"/>
                    <input  type="submit" name="sbtnListAll" id="sbtnListAll" value="List All" class="button"/>
                </td>
            </tr>
            
            <tr>
                <td colspan="2"><label id="lblMsg">message</label></td>
            </tr>
            
            <tr>
                <td colspan="2">
                    <table border="1" width="100%" cellpadding="5" cellspacing="0" class="tblStyle">
                       <tr>
                            <th>Sr.No.</th>
                            <th>Title</th>
                            <th>Category</th>
                            <th>Date&nbsp;Uploaded</th>
                            <th>&nbsp;</th>
                        </tr> 
                        <% 
                                List<BooksMaintenanceBean> lst=null;
                                //ManageEmployeeBean objManageEmployeeBean=new ManageEmployeeBean();
                                BooksMaintenanceServices objBooksMaintenanceServices=new BooksMaintenanceServices();
                                lst=objBooksMaintenanceServices.getAllBookMaintenance();
                                if(request.getParameter("sbtnList")!=null){
                                    System.out.println("1");
                                    System.out.println("1");
                String name=request.getParameter("txtTitle");
                System.out.println("2");
                lst=objBooksMaintenanceServices.getBooksByTitle(name);
                System.out.println("3");
               
             }
            else
            {
                lst = objBooksMaintenanceServices.getAllBookMaintenance();
                
            }
            if(request.getParameter("sbtnListAll")!=null){
                             lst=objBooksMaintenanceServices.getAllBookMaintenance();
                          }
                                if(lst.size()>0){
                                for(int i=0;i<lst.size();i++)
                                {
                                BooksMaintenanceBean objBooksMaintenanceBean=(BooksMaintenanceBean)lst.get(i);
                            %>
                            <tr><td><%=i+1%></td>
                                <td><%=objBooksMaintenanceBean.getTitle()%></td>
                                <td><%=objBooksMaintenanceBean.getCategory()%></td>
                                <td><%=objBooksMaintenanceBean.getCreation_date()%></td>
                                <td><b><a href="BookDetails_mp.jsp?edit_id=<%=objBooksMaintenanceBean.getId()%>">View & Update</a>&nbsp;|&nbsp;<a href="ShareResource_mp.jsp?book_id=<%=objBooksMaintenanceBean.getId()%>&type=Book">Share</a>&nbsp;|&nbsp;<a href="AddEditBooksController.jsp?delete_id=<%=objBooksMaintenanceBean.getId()%>">Remove</a>&nbsp;|&nbsp;<a href="../DownloadServlet?bookId=<%=objBooksMaintenanceBean.getId()%>">Download</a></b></td>
                            </tr>
                            <% 
                                }
                                }
                                else
                                {
                                   %>
                                   <tr><td colspan="7">No record found</td></tr>
                   <%             }
         %>
                    </table>
                    
                </td>
            </tr>
        </table>
                  </form> 
</body>
</html>

