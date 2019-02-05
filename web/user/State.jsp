
<%@page import="java.util.ArrayList"%>
<%@page import="beans.user.StatemasterBean"%>
<%@page import="services.user.CSCServices"%>
<%@page import="java.util.List"%>

<% 
CSCServices objCSCServices=new CSCServices();
List <StatemasterBean>lststate=new ArrayList<StatemasterBean> ();
int countryId=Integer.parseInt(request.getParameter("id")); 
lststate=objCSCServices.getAllStateByCountryId(countryId);
System.out.println("state   "+lststate.size()+"     id  "+countryId);
if(lststate.size()>0 && lststate!=null)
{
    %>
    <select name="ddlState" id="ddlState" onchange="getCities(this.value);">
        <option value="0">select</option>
        <%
        for(int i=0;i<lststate.size();i++)
        {
       
            StatemasterBean objstatemasterBean=(StatemasterBean)lststate.get(i);
            System.out.println("   "+i+"   "+objstatemasterBean.getState_name());
            %>
            <option value="<%=objstatemasterBean.getState_id() %>"><%=objstatemasterBean.getState_name()%></option>
        <%
        } %>
    </select>
    <%
}
    %>