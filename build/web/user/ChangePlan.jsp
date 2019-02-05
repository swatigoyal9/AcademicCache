<%@page import="beans.user.ChangePlanBean"%>
<%@page import="services.user.ChangePlanServices"%>
<%@page import="java.util.List"%>
<%@page import="beans.user.ViewPlanBean"%>
<html>
    <head>
        <title>Change Plan Page</title>
    </head>
    <body>
        <form method="post" action="ChangePlanController.jsp">
            <table border="0" align="center" width="80%" rules="none">
                <tr>
                    <td align="center">
                        <h3>Change Plan</h3>
                    </td>
                </tr>
                <tr>
                    <td><label id="lblMsg">message</label></td>
                </tr>
                <tr>
                    <td align="center">
                        <table align="center" border="1" rules="" width="100%" class="tblStyle">
                            <tr>
                                <th></th>
                                <th>Plan Name</th>
                                <th>Space (in MB)</th>
                                <th>Cost ($)</th>
                                <th>Validity (in months)</th>
                            </tr>
                            <%
                                 String userId=(String)session.getAttribute("userId");
                                 int id=Integer.parseInt(userId);
                                 List<ViewPlanBean> list=null;
                                 ChangePlanServices objChangePlansServices=new ChangePlanServices();
                                 list=objChangePlansServices.getAllManagePlans();
                                
                                 int planId=objChangePlansServices.getAllUserPlans(id);
                                 String val="";
                                 System.out.println(planId);
                                 if(list.size()>0)
                                 {
                                    for(int i=0;i<list.size();i++)
                                    {
                                        ViewPlanBean objViewPlanBean=(ViewPlanBean)list.get(i);
                                        String planId1=objViewPlanBean.getPlan_id().toString();
                                        int pla=Integer.parseInt(planId1);
                                        System.out.println("pla==="+pla);
                                        if(pla==planId)
                                         {
                                            val="checked";
                                           
                                         }
                                        else{
                                            val="";
                                        }
                                        
                                                                               
                            %>
                               <tr>
                                   <td align="center"><input type="radio" name="rbPlan" value="<%=objViewPlanBean.getPlan_id()%>" <%=val%>/></td>
                              
                               <td><%=objViewPlanBean.getTxtPlanName()%></td>
                               <td><%=objViewPlanBean.getTxtSpaceAllowed()%></td>
                               <td><%=objViewPlanBean.getTxtCost()%></td>
                               <td><%=objViewPlanBean.getTxtValidity()%></td>
                            </tr>
                            <%
                                      }
                                 }
                            %>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <br/><input type="submit"  name="sbtnChangePlan" value="Change Plan" class="button"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>