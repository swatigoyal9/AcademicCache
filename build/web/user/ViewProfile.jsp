
<%@page import="java.util.ArrayList"%>
<%@page import="services.user.CSCServices"%>
<%@page import="beans.user.CountrymasterBean"%>
<%@page import="java.util.List"%>
<%@page import="beans.user.UserProfileBean"%>
<%@page import="services.user.UserProfileServices"%>
<html>
    <head>
        <title>View Profile Details</title>
        <script type="text/javascript">
        var xmlObject;
            function getObject(){
                try{
                    xmlObject=new XMLHttpRequest();
                }
                catch(e){
                    try{
                        xmlObject=new ActiveXObject("Microsoft.XMLHTTP");
                    }
                    catch(e2){
                        xmlObject= new ActiveXObject("Msxml2.XMLHTTP");
                    }    
                }
            } 
            function getStates(val){
                getObject();
                 alert("hello");
               // var countryId=document.getElementById("ddlCountry").value;
                alert(val);
                var url="State.jsp?id="+val;
                 
                xmlObject.onreadystatechange=function(){
                    if (xmlObject.readyState==4){
                        document.getElementById("divState").innerHTML=xmlObject.responseText;
                        document.getElementById("divCity").innerHTML="<select><option value=\"0\">Select</option></select>";
                        
                    }
                }
                xmlObject.open("GET",url,true);
                xmlObject.send(null);
                
            }
            function getCities(val1){
                getObject();
                alert("city")
               // var stateId=document.getElementById("ddlState").value;
                var url="City.jsp?id="+val1;
               xmlObject.onreadystatechange=function(){
                    if (xmlObject.readyState==4){
                        document.getElementById("divCity").innerHTML=xmlObject.responseText;
                        
                    }
                }
                 xmlObject.open("GET",url,true);
                xmlObject.send(null);
               
                }
 </script> 
    </head>
    <body>
        <%
            String userId=(String)session.getAttribute("userId");
            UserProfileBean objBean=new UserProfileBean();
           System.out.println(userId);
            UserProfileServices objUserProfileServices=new UserProfileServices();
            objBean=objUserProfileServices.getProfileDetailById(userId);
                if(objBean!=null){
        %>
        <form action="EditProfileController.jsp" method="post">
            <table align="center">
                <tr>
                    <td align="center">
                        <h3><u>View Plan Details</u></h3>
                    </td>
                </tr>
                <tr>
                    <td>
                        <fieldset>
                            <table align="center" cellpadding="5">
                                <tr>
                                    <td>UserName</td>
                                    <td><label><%=objBean.getUsername()%></label></td>
                                </tr>
                                <tr>
                                    <tr>
                                    <td><strong>Name</strong></td>
                                    <td><input type="text" name="txtName" id="txtName" value="<%=objBean.getTxtName()%>"/></td>
                                </tr>
                                <%
                        String str="";
                        String str1="";
                        String str2="";
                        String str3="";
                        String str4="";
                        String str5="";
                        if(objBean.getDdlQualification().equalsIgnoreCase("BCA")){
                            str="Selected";
                        }
                        else if(objBean.getDdlQualification().equalsIgnoreCase("MCA")){
                            str1="Selected";
                        }
                        else if(objBean.getDdlQualification().equalsIgnoreCase("B Tech")){
                            str2="Selected";
                        }
                        else if(objBean.getDdlQualification().equalsIgnoreCase("M Tech")){
                            str3="Selected";
                        }
                        else if(objBean.getDdlQualification().equalsIgnoreCase("BSC IT")){
                            str4="Selected";
                        }
                        else if(objBean.getDdlQualification().equalsIgnoreCase("MSC IT")){
                            str5="Selected";
                        } 
                    %>
                                <tr>
                                   <td><strong>Qualification</strong></td>
                                    <td>
                                        <select id="ddlQualification" name="ddlQualification">
                                            <option value="Select" selected="selected">Select</option>
                                            <option value="BCA" <%=str%>>BCA</option>
                                            <option value="MCA" <%=str1%>>MCA</option>
                                            <option value="B Tech" <%=str2%>>B Tech</option>
                                            <option value="M Tech" <%=str3%>>M Tech</option>
                                            <option value="BSC IT" <%=str4%>>BSC IT</option>
                                            <option value="MSC IT" <%=str5%>>MSC IT</option>
                                        </select>
                                    </td>
                                </tr>
                                    <%
                                      List <CountrymasterBean>lstcountry=new ArrayList<CountrymasterBean> ();
                                        CSCServices objCSCServices=new CSCServices();
                                        lstcountry=objCSCServices.getAllCountry();
                                        if(lstcountry.size()>0 && lstcountry!=null)
                                        {
                                      %>
                                    <tr>
                                    <td><strong>Country</strong></td>
                                    <td><select id="ddlCountry" name="ddlCountry" onchange="getStates(this.value);">
                                    <option value="0">select</option>
                                            <%   
                                             for(int i=0;i<lstcountry.size();i++)
                                            {
                                                CountrymasterBean objcountrymasterBean=(CountrymasterBean)lstcountry.get(i);
                                                  
                                            if( objcountrymasterBean.getCountry_id()==objBean.getDdlCountry())
                                    {
                                                                     
                                     
                %>    
                 <option value="<%=objBean.getDdlCountry()%>" selected="selected"><%=objBean.getDdlCountryName()%></option>         
                    
                <%
                                    }
                                    else
                                    {                             
               %> 
               <option value="<%=objcountrymasterBean.getCountry_id()%>"><%=objcountrymasterBean.getCountry_name()%></option>
               <%
                                     }
                                                                 }
                                                           }%>
                                        
                                            
                                            
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td><strong>State</strong></td>
                                    <td>
                                        <div id="divState">
                                            <select id="ddlState" name="ddlState" onchange="getCities(this.value);">
                                                <option>Select</option>
                                            </select>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td><strong>City</strong></td>
                                    <td>
                                        <div id="divCity">
                                            <select id="ddlCity" name="ddlCity">
                                                <option>Select</option>
                                            </select>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                    <td colspan="1" align="center" height="40" valign="bottom">
                        <input type="submit" name="sbtnUpdate" value="Update" id="sbtnUpdate" class="button">
                        <input type="button" name="btnCancel" value="Cancel" id="btnCancel" class="button" onclick="history.go(-1)"/>
                    </td>
                </tr>
                                <%
                                    }
                            %>
                            </table> 
                        </fieldset>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>