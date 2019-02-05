package services.user;

import beans.user.ChangePlanBean;
import beans.user.ViewPlanBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import services.common.DBConnection;

public class ChangePlanServices {
   
     public List getAllManagePlans(){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    List listUser = null;
    ViewPlanBean objViewPlansBean=null;
    try{
        conn=(Connection) DBConnection.connect();
        listUser=new ArrayList();
        pstmt=(PreparedStatement) conn.prepareStatement("select * from planmaster");
        rs=pstmt.executeQuery();
        while(rs.next())
        {
            objViewPlansBean=new ViewPlanBean();
            objViewPlansBean.setTxtCost(rs.getString("cost"));
            objViewPlansBean.setRbStatus(rs.getString("status"));
            objViewPlansBean.setTxtValidity(rs.getString("validity_months"));
            objViewPlansBean.setTxtSpaceAllowed(rs.getString("space_allowed"));
            objViewPlansBean.setTxtPlanName(rs.getString("plan_name"));
            objViewPlansBean.setPlan_id(rs.getString("plan_id"));
            listUser.add(objViewPlansBean);
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
    System.out.println(listUser.size());
        
        return listUser;
}  
      public int getAllUserPlans(int id){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    ChangePlanBean objChangePlanBean=null;
    int planId=0;
    try{
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("select * from userplanmaster where user_id=?");
        pstmt.setInt(1, id);
        rs=pstmt.executeQuery();
       if(rs.next())
        {
         planId=rs.getInt("plan_id");   
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
        
        return planId;
}  
      public String updateUserPlan(String id,String plan_id){
    Connection conn=null;
    PreparedStatement pstmt=null;
    PreparedStatement pstmt1=null;
    ChangePlanBean objChangePlanBean=new ChangePlanBean();
    ResultSet rs=null;
    int mn=0;
    String msg="Failed";
    
    try{
        conn=(Connection) DBConnection.connect();
        pstmt1=(PreparedStatement) conn.prepareStatement("select validity_months from planmaster where plan_id=?");
        pstmt1.setString(1, plan_id);
        System.out.println(pstmt1.toString());
        rs=pstmt1.executeQuery();
        if(rs.next())
        {
            mn=rs.getInt("validity_months");
        }
        pstmt=(PreparedStatement) conn.prepareStatement("update userplanmaster set plan_id=?,plan_status=?,start_date=sysdate(),end_date=date_add(sysdate(),interval ? month) where user_id=?");
        pstmt.setString(1,plan_id);
        pstmt.setString(2,"Active");
        pstmt.setInt(3, mn);
        pstmt.setString(4,id);
        System.out.println(mn);
        System.out.println(pstmt.toString());
        int i=pstmt.executeUpdate();
        if(i>0)
        {
            msg="Record Updated";
        }
        }
    catch(Exception e){
        System.out.println("Exception occur at updateUserPlanRecord"+e);
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
    return msg;
}
}