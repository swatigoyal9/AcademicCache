package services.admin;

import beans.admin.AddEditPlansAdminBean;
import beans.admin.ManagePlansAdminBean;
import beans.admin.ManageRegisteredUserBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import services.common.DBConnection;

public class ManageRegisteredUserServices {
public List getAllManageRegisteredUser(){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    List listUser = null;
    ManageRegisteredUserBean objManageRegisteredUserBean=null;
    try{
        conn=(Connection) DBConnection.connect();
        listUser=new ArrayList();
        pstmt=(PreparedStatement) conn.prepareStatement("select * from userdetailmaster u1,usermaster u2,statemaster s1,countrymaster c1,citymaster c2 where u1.user_id=u2.user_id and u1.city_id=c2.city_id and u1.country_id=c1.country_id and u1.state_id=s1.state_id ");
        rs=pstmt.executeQuery();
        while(rs.next())
        {
            objManageRegisteredUserBean=new ManageRegisteredUserBean();
            objManageRegisteredUserBean.setName(rs.getString("name"));
            objManageRegisteredUserBean.setQualification(rs.getString("qualification"));
            objManageRegisteredUserBean.setRegistration_date(rs.getString("registration_date"));
            objManageRegisteredUserBean.setUser_status(rs.getString("user_status"));
            objManageRegisteredUserBean.setUsername(rs.getString("username"));
            objManageRegisteredUserBean.setUser_id(rs.getString("user_id"));
            objManageRegisteredUserBean.setCity(rs.getString("city_name"));
            objManageRegisteredUserBean.setCountry(rs.getString("country_name"));
            objManageRegisteredUserBean.setState(rs.getString("state_name"));
            listUser.add(objManageRegisteredUserBean);
        }
    }
    catch(Exception e)
    {
        System.out.println("Exception occur  at getAllManageRegisteredUser"+e);
    }
    finally{
        try{
            rs.close();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println("Exception occur  at getAllManageRegisteredUser"+e);
        }
    }
    System.out.println(listUser.size());
        
        return listUser;
}        
  public List searchRegistereduserByName(String name){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    List listUser=null;
    ManageRegisteredUserBean objManageRegisteredUserBean=null;
    try{
        listUser=new ArrayList();
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("select * from usermaster u1,userdetailmaster u2 where u1.user_id=u2.user_id and u2.name like ?");
                pstmt.setString(1,name+"%");
                System.out.println(pstmt.toString());
                rs=pstmt.executeQuery();
               while(rs.next())
               {
            objManageRegisteredUserBean=new ManageRegisteredUserBean();
            objManageRegisteredUserBean.setName(rs.getString("name"));
            objManageRegisteredUserBean.setQualification(rs.getString("qualification"));
            objManageRegisteredUserBean.setRegistration_date(rs.getString("registration_date"));
            objManageRegisteredUserBean.setUser_status(rs.getString("user_status"));
            objManageRegisteredUserBean.setUsername(rs.getString("username"));
            listUser.add(objManageRegisteredUserBean);
               }
    }
    catch(Exception e)
    {
        System.out.println("Exception occur at searchUserByUsername"+e);
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
    System.out.println(listUser.size());
    return listUser;
}  
  public ManageRegisteredUserBean getUserDetailById(int id){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    ManageRegisteredUserBean objManageRegisteredUserBean=null;
    try{
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("select * from userdetailmaster u1,usermaster u2,statemaster s1,countrymaster c1,citymaster c2 where u1.user_id=u2.user_id and u1.city_id=c2.city_id and u1.country_id=c1.country_id and u1.state_id=s1.state_id and u1.user_id=?");
        pstmt.setInt(1, id);
        rs=pstmt.executeQuery();
        if(rs.next()){
            objManageRegisteredUserBean=new ManageRegisteredUserBean();
            objManageRegisteredUserBean.setCity(rs.getString("city_name"));
            objManageRegisteredUserBean.setCountry(rs.getString("country_name"));
            objManageRegisteredUserBean.setName(rs.getString("name"));
            objManageRegisteredUserBean.setQualification(rs.getString("qualification"));
            objManageRegisteredUserBean.setRegistration_date(rs.getString("registration_date"));
            objManageRegisteredUserBean.setState(rs.getString("state_name"));
            objManageRegisteredUserBean.setUser_id(rs.getString("user_id"));
            objManageRegisteredUserBean.setUser_status(rs.getString("user_status"));
            objManageRegisteredUserBean.setUsername(rs.getString("username"));
            
            
            }
        System.out.println(pstmt.toString());
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
    return objManageRegisteredUserBean;
}
   public String activeInactivateUser(int id, String status)
{
     Connection conn=null;
    PreparedStatement pstmt=null;
    ManageRegisteredUserBean objManageRegisteredUserBean=null;
    String msg="Failed";
    String msg1=null;
 
    
    try{
        conn=(Connection) DBConnection.connect();
        if(status.equalsIgnoreCase("Active"))
        {
            msg1="Inactive";
        }
        else{
            msg1="Active";
        }
        pstmt=(PreparedStatement) conn.prepareStatement("update usermaster set user_status=? where user_id=?");
        System.out.println(pstmt.toString());
        pstmt.setString(1,msg1);
        pstmt.setInt(2,id);
        System.out.println(pstmt.toString());
        int i=pstmt.executeUpdate();
        System.out.println(pstmt.toString());
        if(i>0)
        {
            msg="Record Updated";
        }
        }
    
    catch(Exception e){
        System.out.println("Exception occur at activeInactivateUser(int id,String status)"+e);
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
