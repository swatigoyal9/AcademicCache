<%@page import="beans.admin.ManageReportAbuseBean"%>
<%@page import="services.admin.ManageReportAbuseServices"%>
<%@page import="java.util.*" %>
<html>
    <head>
        <title>Manage Report Abuse</title>
    </head>
    <body>
        <form action="#" method="get">
            <table align="center">
                <tr>
                    <td align="center">
                        <h3><u>Manage Report Abuse</u></h3>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        Title
                       <input type="text" name="txtSearch" id="txtSearch"/>
                        <input type="submit" name="sbtnSearch" value="Search" class="button"/>
                        &nbsp;<input  value="List All" id="sbtnListAll" name="sbtnListAll" type="submit" class="button"/>
                    </td>
                </tr>
                <tr>
                    <td>
        <%
            ManageReportAbuseServices objServices=new ManageReportAbuseServices();
            ManageReportAbuseBean objBean=new ManageReportAbuseBean();
            List<ManageReportAbuseBean> list=null;
            list=objServices.getALLManageReportAbuse();
                          if(request.getParameter("sbtnSearch")!=null){
                String title=request.getParameter("txtSearch");
                System.out.println(title+"hiiii");
                list=objServices.getReportAbuseDetailByTitle(title);
               System.out.println("hhhhh");
             }
            else
            {
                list = objServices.getALLManageReportAbuse();
                
            }
                          if(request.getParameter("sbtnListAll")!=null){
                             list=objServices.getALLManageReportAbuse(); 
                          }
        
        %>    
                        <table align="center" border="1"  cellpadding="10" cellspacing="0" width="100%" class="tblStyle">
                            <tr>
                                <th>S/No.</th>
                                <th>Resource&nbsp;Title</th>
                                <th>Type</th>
                                <th>Last&nbsp;Report&nbsp;Date</th>
                                <th>Uploaded&nbsp;By</th>
                                <th>Status</th>
                                <th>Links</th>
                            </tr>
                              <%
                               
                                 if(list!=null&&list.size()>0)
                                 {
                                     for(int a=0;a<list.size();a++)
                                     {
                                      
                                         objBean=list.get(a);
                                     
                                 
                            %>
                            <tr>
                                <td><%=a+1%></td>
                                <td><%=objBean.getTxtTitle()%></td>
                                <td><%=objBean.getTxtType()%></td>
                                <td><%=objBean.getReportDate()%></td>
                                <td><%=objBean.getTxtName()%></td>
                                <td><%=objBean.getUserStatus()%></td>
                                
                                <td><a href="ViewReportAbuseDetails_mp.jsp?user_id=<%=objBean.getTxtId()%>&title=<%=objBean.getTxtTitle()%>&report_id=<%=objBean.getTxtReportId()%>">ViewDetails</a></td>
                            </tr>
                            <%
                                    }
                                }
                                     else     {
                                   %>
                                   <tr><td colspan="7">
                                           <%
                                           out.println("No Record Found");
            %>
            </td></tr>
            <%
                                }  
            %>
                            
                        </table>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>