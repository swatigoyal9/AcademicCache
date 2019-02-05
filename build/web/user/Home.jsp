<%@page import="beans.user.HomeBean"%>
<%@page import="services.user.HomeServices"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <form action="#">
            <%
                String userId=(String)session.getAttribute("userId");
                                 int id=Integer.parseInt(userId);
            HomeServices objHomeServices=new HomeServices();
            HomeBean objHomeBean=null;
               objHomeBean=objHomeServices.getHomeDetails(id);
                if(objHomeBean!=null){
        %>
            <table align="center" >
                <tr>
                    <td colspan="3" align="center">
                        <h3><u>Home</u></h3>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table cellpadding="5">
                            <tr>
                                <td colspan="2">
                                    <fieldset>
                                        <table align="center" cellpadding="5" >
                                            <tr>
                                                <td><b/>Plan Name</td>
                                                <td><label><%=objHomeBean.getPlan_name()%></label></td>
                                            </tr>
                                            <tr>
                                                <td><b/>Start Date</td>
                                                <td><label><%=objHomeBean.getStart_date()%></label></td>
                                                <td><b/>Expiry Date</td>
                                                <td><label><%=objHomeBean.getEnd_date()%></label></td>
                                            </tr>
                                            <tr>
                                                <td><b/>Total Memory</td>
                                                <td><label><%=objHomeBean.getSpace()%> MB</label></td>    
                                            </tr>
                                            <%
                                                int ts=objHomeBean.getSpace();
                                                int us=objHomeBean.getUsed_space();
                                                int fs=objHomeBean.getFree_space();
                                                int fsp=(fs*100)/ts;
                                                int usp=(us*100)/ts;
                                            %>
                                            <tr>
                                                <td><b/>Used Space</td>
                                                <td><label><%=us%> MB</label></td>
                                                <td>&nbsp;<%=usp%> %</td>
                                            </tr>
                                            <tr>
                                                <td><b/>Free Space</td>
                                                <td><label><%=fs%> MB</label></td>
                                                <td>&nbsp;<%=fsp%> %</td>
                                        </table> 
                                    </fieldset>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
                                            <%
                                                                                       }
                                            %>
        </form>
    </body>
</html>
