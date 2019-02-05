package services.common;

import beans.common.LoginAdminBean;
import beans.common.LoginBean;
import beans.common.SignUpBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
public class CommonServices {
    public LoginBean authUser(String UserName,String Password)
    {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        LoginBean objLoginBean=null;
        try{
            conn=DBConnection.connect();
            pstmt=conn.prepareStatement("select * from usermaster where username=? and password=binary(?)");
            pstmt.setString(1,UserName);
            pstmt.setString(2,Password);
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                objLoginBean=new LoginBean();
                objLoginBean.setUser_id(rs.getString("user_id"));
                objLoginBean.setUsername(rs.getString("username"));
                objLoginBean.setPassword(rs.getString("password"));
                objLoginBean.setUser_status(rs.getString("user_status"));
               }
            

    }
    catch(Exception e)
    {
        System.out.println("authUser(String UserName,String Password) of common services"+e);
    }
        finally
        {
            try
            {
                rs.close();
                pstmt.close();
                conn.close();
            }
            catch(Exception e)
            {
                System.out.println("authUser(String UserName,String Password) of common services" +e);
            }
            return objLoginBean;
        }
    }
    public LoginAdminBean authAdmin(String UserName,String Password)
    {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        LoginAdminBean objLoginAdminBean=null;
        try{
            conn=DBConnection.connect();
            pstmt=conn.prepareStatement("select * from employeemaster where username=? and password=binary(?)");
            pstmt.setString(1,UserName);
            pstmt.setString(2,Password);
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                objLoginAdminBean=new LoginAdminBean();
                objLoginAdminBean.setEmployee_id(rs.getString("employee_id"));
                objLoginAdminBean.setUsername(rs.getString("username"));
                objLoginAdminBean.setPassword(rs.getString("password"));
                objLoginAdminBean.setUser_status(rs.getString("user_status"));
                

            }
        }
    catch(Exception e)
    {
        System.out.println("authAdmin(String UserName,String Password) of common services"+e);
    }
        finally
        {
            try
            {
                rs.close();
                pstmt.close();
                conn.close();
            }
            catch(Exception e)
            {
                System.out.println("authAdmin(String UserName,String Password) of common services" +e);
            }
            return objLoginAdminBean;
        }
            
    }
    public String getRandomCode(){
        Random r= new Random();
        char[] value={'a','K','L','M','N','O','P','0','1','2','k','4','5','g','h','g','h','i','j','B','C','D','E','F','u','v','w','x','y','z','A','3','G','H','I','J','S','l','m','n','o','p','q','r','s','t','T','U','V','W','X','Y','6','7','Q','R','b','c','d','e','f','Z','8','9'};
        String out="";
        for(int j=0;j<16;j++)
        {
            int num=r.nextInt(value.length);
            out+=value[num];
        }
        
        return out;
    }
    public String signUpUser(String email,String pwd){
        Connection conn = null;
        PreparedStatement pstmt = null;
        String code=getRandomCode();
        String result = "failed";
        try {
                conn = DBConnection.connect();
            

                pstmt = conn.prepareStatement("insert into usermaster(username ,password,user_type,user_status,confirmation_code,is_temp,registration_date) values(?,?,?,?,?,?,sysdate())");
                pstmt.setString(1, email);
                pstmt.setString(2, pwd);
                pstmt.setString(3, "user");
                pstmt.setString(4, "Inactive");
                pstmt.setString(5, code);
                pstmt.setInt(6, 0);
                System.out.println(pstmt.toString());
                int i = pstmt.executeUpdate();
                if (i > 0) {
                    result = "added";
                }
            System.out.println(pstmt.toString());
            
        } catch (Exception e) {
            System.out.println("signUpUser(SignUpBean objBean) of common services : " + e);
        } finally {
            try {
                
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("signUpUser(SignUpBean objBean) of DBoperations : " + e);
            }
        }
        return result;
    }
    public String updateSignUpUser(SignUpBean objBean) 
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        ResultSet rs = null;
        String result = "failed";
        try 
        {
            conn = DBConnection.connect();
                pstmt=conn.prepareStatement("update usermaster set User_Status=?,Is_Temp=?, registration_date=sysdate() where Username=?");
                
                pstmt.setString(1, "Active");
                pstmt.setInt(2, 1);
                pstmt.setString(3, objBean.getTxtUsername());
                System.out.println(pstmt.toString());
                int i = pstmt.executeUpdate();
                if (i > 0) {
                    result = "updated";
                }
            System.out.println(pstmt.toString());
        } 
        catch (Exception e) 
        {
            System.out.println("updateSignUpUser(SignUpBean objBean) of commonservices : " + e);
        } 
        finally 
        {
            try {
               
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("updateSignUpUser(SignUpBean objBean) of commonservices : " + e);
            }
        }
        return result;
    }
public LoginBean recoverPassword(String userName){
    Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        LoginBean objBean=null;
        try
        {
            conn=DBConnection.connect();
            pstmt=conn.prepareStatement("select user_id, username, password from usermaster where username = ?");
            pstmt.setString(1, userName);
            rs=pstmt.executeQuery();
            
            if(rs.next())
            {
               
                   objBean=new LoginBean();
                   objBean.setUser_id(rs.getString("user_id"));
                   objBean.setUsername(rs.getString("Username"));
                   objBean.setPassword(rs.getString("Password"));
            }
            System.out.println(pstmt.toString());
            
            
        }
        catch(Exception e)
        {
            System.out.println("getUserDetailByUsername(String userName) : of"+"DBoperations"+e);
        }
        finally
        {
            try
            {
                rs.close();
                pstmt.close();
                conn.close();
            }
            catch(Exception e)
            {
                System.out.println("getUserDetailByUsername(String userName) : of"+"DBoperations"+e);
            }
        }
        return objBean;
    }
  public String changePassword(String oldPwd,String newPwd,int userid)
    {
        Connection conn=null;
        PreparedStatement pstmt=null;
        PreparedStatement pstmt1=null;
        ResultSet rs=null;
       String msg="Unable to Change Password";
       try
       {    
           conn=DBConnection.connect();
           pstmt=conn.prepareStatement("select Password from usermaster where User_Id=? and Password=?");
           pstmt.setInt(1,userid);
           pstmt.setString(2,oldPwd);
           rs=pstmt.executeQuery();
           if(rs.next())
           {    
               pstmt1=conn.prepareStatement("update usermaster set Password=? where User_Id=?");
               pstmt1.setString(1,newPwd);
               pstmt1.setInt(2,userid);
               int r=pstmt1.executeUpdate();
               if(r>0)
               {
                   msg="Updated Successfully";
               }
           }
           else
           {
               msg="Current Password Does not Match";
           }
           
       }
       catch(Exception e)
       {
           System.out.println("in changePassword()"+e);
       }
       finally
       {
           try{
               rs.close();
               pstmt1.close();
               pstmt.close();
               conn.close();
           }
           catch(Exception e)
           {
             System.out.println("in changePassword()"+e);  
           }
       }
       return msg;
    }   
   public String  emailchecking(String email)
    {
        String msg="";
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        
        try
        {      
            conn=DBConnection.connect();
            pstmt=conn.prepareStatement("select * from usermaster where Username=?");
            pstmt.setString(1,email);
            rs=pstmt.executeQuery();
            System.out.println(pstmt);
            if(rs.next())
                 {   
                    msg="Email-Id already exists";
                 }
            else{
                         pstmt=conn.prepareStatement("select * from employeemaster where Email=?");
                            pstmt.setString(1,email);
                                rs=pstmt.executeQuery();
                                System.out.println(pstmt);
                                    if(rs.next())
                                    {
                                        msg="Email-Id already exists";
                                    }
            }
        }
        catch(Exception e)
        {
            System.out.println("in emailchecking()"+e);
        }
        finally
        {
            try
            {
                rs.close();
                pstmt.close();
                conn.close();
            }
            catch(Exception e)
            {
                System.out.println("");
            }
        }
        return msg;
        
    }
   public SignUpBean ConfirmationCode(String email)
    {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        SignUpBean objBean=null;
        try
        {
            conn=DBConnection.connect();
            pstmt=conn.prepareStatement("select * from usermaster where Username=?");
            pstmt.setString(1,email);
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                objBean=new SignUpBean();
                objBean. setTxtUsername(rs.getString("Username"));
                objBean.setTxtConfirmationCode(rs.getString("Confirmation_Code"));
                
            }
        }
            catch(Exception e)
            {
                System.out.println("in ConfirmationCode()"+e);
            }
            finally
             {
                 try
                 {
                     rs.close();
                     pstmt.close();
                     conn.close();
                     
                 }
                 catch(Exception e)
                 {
                     System.out.println();
                 }
             return objBean;
        }
        }
}
