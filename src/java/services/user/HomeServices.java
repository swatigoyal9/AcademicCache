package services.user;

import beans.user.ChangePlanBean;
import beans.user.HomeBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import services.common.DBConnection;

public class HomeServices {
 public HomeBean getHomeDetails(int id){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    HomeBean objHomeBean=null;
    int planId=0;
    try{
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("select * from userplanmaster u1,planmaster p1 where p1.plan_id=u1.plan_id and user_id=?");
        pstmt.setInt(1, id);
        rs=pstmt.executeQuery();
       if(rs.next())
        {
         objHomeBean=new HomeBean();
            objHomeBean.setEnd_date(rs.getString("end_date"));
            objHomeBean.setPlan_id(rs.getString("plan_id"));
            objHomeBean.setPlan_name(rs.getString("plan_name"));   
            objHomeBean.setSpace(rs.getInt("space_allowed"));   
            objHomeBean.setUser_id(rs.getString("user_id"));   
            objHomeBean.setStart_date(rs.getString("start_date"));   
            objHomeBean.setFree_space(objHomeBean.getSpace()-objHomeBean.getUsed_space());   
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
        
        return objHomeBean;
}      
}
