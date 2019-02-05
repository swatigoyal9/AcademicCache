<%@page import="java.util.ArrayList"%>
<%@page import="beans.user.CitymasterBean"%>
<%@page import="services.user.CSCServices"%>
<%@page import="java.util.List"%>
<%
    CSCServices objCSCServices = new CSCServices();
    List <CitymasterBean>lstcity = new ArrayList<CitymasterBean> ();
    int stateId = Integer.parseInt(request.getParameter("id"));
lstcity=objCSCServices.getAllCityByStateId(stateId);
System.out.println("city  "+lstcity.size()+"    sate id "+stateId);

if(lstcity.size()>0 && lstcity!=null)
{
%>
<select name="ddlCity" id="ddlCity">
    <option value="0">select</option>
    <%
        for (int i = 0; i < lstcity.size(); i++) {
            CitymasterBean objcitymasterBean = (CitymasterBean) lstcity.get(i);
           System.out.println("nme   "+objcitymasterBean.getCity_name());
    %>
    <option value="<%=objcitymasterBean.getCity_id()%>"><%=objcitymasterBean.getCity_name()%></option>
    <%
            } 
    %>
</select>
<%}%>
