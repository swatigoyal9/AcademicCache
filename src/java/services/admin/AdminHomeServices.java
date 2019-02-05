package services.admin;

import beans.admin.ManageEmployeeBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import services.common.DBConnection;

public class AdminHomeServices {
 public ManageEmployeeBean getAdminHomeDetails(String id){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    ManageEmployeeBean objManageEmployeeBean=new ManageEmployeeBean();
    int planId=0;
    try{
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("select * from employeemaster where employee_id=?");
        pstmt.setString(1, id);
        rs=pstmt.executeQuery();
       if(rs.next())
        {
         objManageEmployeeBean=new ManageEmployeeBean();
            objManageEmployeeBean.setContact_number(rs.getString("contact_number"));
            objManageEmployeeBean.setDoj(rs.getString("doj"));
            objManageEmployeeBean.setName(rs.getString("name"));   
            objManageEmployeeBean.setUser_status(rs.getString("user_status"));   
            objManageEmployeeBean.setEmail(rs.getString("email"));   
            objManageEmployeeBean.setGender(rs.getString("gender"));     
        }
        
    }
    catch(Exception e)
    {
        System.out.println("Exception occur  at getAllManagePlansUser"+e);
    }
    finally{
        try{
            rs.close();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println("Exception occur  at getAllManagePlansUser"+e);
        }
    }
        
        return objManageEmployeeBean;
}     
 
  public ManageEmployeeBean getProfileDetailById(String id){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    int userId=Integer.parseInt(id);
        ManageEmployeeBean objManageEmployeeBean=null;
    try{
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("select * from employeemaster where employee_id=?");
        pstmt.setString(1,id);
        rs=pstmt.executeQuery();
        if(rs.next()){
            objManageEmployeeBean=new ManageEmployeeBean();
            objManageEmployeeBean.setUsername(rs.getString("username"));
            objManageEmployeeBean.setName(rs.getString("name"));
            objManageEmployeeBean.setEmail(rs.getString("email"));
            objManageEmployeeBean.setUser_status(rs.getString("user_status"));
            objManageEmployeeBean.setUser_type(rs.getString("user_type"));
            objManageEmployeeBean.setContact_number(rs.getString("contact_number"));
            objManageEmployeeBean.setPassword(rs.getString("password"));
            System.out.println(pstmt.toString());
            }
       }
    catch(Exception e){
       System.out.println("Error occur at getPlanDetailById(int id)"+e);
    }
    finally{
        try{
            rs.close();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
          }
    return objManageEmployeeBean;
}
   

public String updateProfile(ManageEmployeeBean objBean,String id){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ManageEmployeeBean objManageEmployeeBean=null;
   // List list=null;
    String msg="Failed";
    try{
       // list=new ArrayList();
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("update employeemaster set name=?,username=?,password=?,user_type=?,user_status=?,email=?,contact_number=? where employee_id=?");
        pstmt.setString(1,objBean.getName());
        pstmt.setString(2,objBean.getUsername());
        pstmt.setString(3,objBean.getPassword());
        pstmt.setString(4,objBean.getUser_type());
        pstmt.setString(5,objBean.getUser_status());
        pstmt.setString(6,objBean.getEmail());
        pstmt.setString(7,objBean.getContact_number());
        pstmt.setString(8,id);
        System.out.println(pstmt.toString());
        int i=pstmt.executeUpdate();
        if(i>0)
        {
            msg="Record Updated";
        }
        }
    
    catch(Exception e){
        System.out.println("Exception occur at updateProfile(UserProfileBean objBean)"+e);
    }
    finally{
        try{
        pstmt.close();
        conn.close();
    }
        catch(Exception e){
            System.out.println(e);
        }
}
    return msg;
}
 
}
