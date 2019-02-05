<%@page import="services.user.MultimediaMaintenanceServices"%>

<%@page import="beans.user.MultimediaMaintenanceBean"%>
<%@page import="java.util.List"%>
<html>
    <head>
        <title>Multimedia Maintenance</title>
    </head>
    <body>
                   <center> <label id ="lblMsg">lblMsg</label></center>                         
                   <form action="../DownloadServlet" method="post" enctype="multipart/form-data">
                   <table border="1" cellpadding="0" cellspacing="0" align="center" rules='none'>
            <tr>
                <td align="center">
                   <h1> <strong> Multimedia </strong></h1></td>
            </tr>
                     <tr>
                <td>
                        <table border="0" cellpadding="5" cellspacing="0" width="100%" >
                            <tr>
                                <td align="left">
                                    <input  id="btnAddNewResource" value="Add New Resource" name="btnAddNewResource"  type="button" onclick="window.location='AddNewMultimedia_mp.jsp'" class="button">&nbsp;
                                </td>
                                <td align="right">
                                    Title&nbsp;&nbsp;<input id="txtName" size="10" name="txtName" type="text">
                                    &nbsp;<input id="sbtnList" value="List" name="sbtnList" type="submit" class="button">
                                    &nbsp;<input  value="List All" id="sbtnListAll" name="sbtnListAll" type="submit" class="button">
                                </td>
                            </tr>
                        </table>
                </td>
            </tr>
            <tr>
                <td>
                    <table border="1" cellpadding="3" cellspacing="0">
                        <tr>
                            <th>Sr.No.</th>
                            <th>Title</th>
                            <th>Category</th>
                            <th>Date&nbsp;Uploaded</th>
                            <th>&nbsp;</th>
                        </tr>

                        
                        <% 
                                List<MultimediaMaintenanceBean> lst=null;
                                //ManageEmployeeBean objManageEmployeeBean=new ManageEmployeeBean();
                                MultimediaMaintenanceServices objMultimediaMaintenanceServices=new MultimediaMaintenanceServices();
                                lst=objMultimediaMaintenanceServices.getAllMultimediaMaimtenance();
                                if(request.getParameter("sbtnList")!=null){
                String name=request.getParameter("txtName");
                lst=objMultimediaMaintenanceServices.getMultimediaByTitle(name);
               
             }
            else
            {
                lst = objMultimediaMaintenanceServices.getAllMultimediaMaimtenance();
                
            }
            if(request.getParameter("sbtnListAll")!=null){
                             lst=objMultimediaMaintenanceServices.getAllMultimediaMaimtenance();
                          }
                                if(lst.size()>0){
                                    
                                
                                for(int i=0;i<lst.size();i++)
                                {
                                MultimediaMaintenanceBean objMultimediaMaintenanceBean=(MultimediaMaintenanceBean)lst.get(i);
                                System.out.println(objMultimediaMaintenanceBean.getMedia_type());
                            %>
                            <tr><td><%=i+1%></td>
                                <td><%=objMultimediaMaintenanceBean.getTitle()%></td>
                                <td><%=objMultimediaMaintenanceBean.getAccess_type()%></td>
                                <td><%=objMultimediaMaintenanceBean.getUpload_date()%></td>
                                
                                <td>
                                <a href="MultimediaDetails_mp.jsp?edit_id=<%=objMultimediaMaintenanceBean.getId()%>">View&nbsp;&amp;&nbsp;Update</a>&nbsp;|&nbsp;<a href="ShareResource_mp.jsp?m_id=<%=objMultimediaMaintenanceBean.getId()%>&type=<%=objMultimediaMaintenanceBean.getMedia_type()%>">Share</a>&nbsp;|&nbsp;<a href="AddEditMultimediaController.jsp?delete_id=<%=objMultimediaMaintenanceBean.getId()%>">Remove</a>&nbsp;|&nbsp;<a href="../DownloadServlet?multimediaId=<%=objMultimediaMaintenanceBean.getId()%>">Download</a>
                            </td>
                                
         </tr>
         <% 
                                }
                                }
                                else{
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

