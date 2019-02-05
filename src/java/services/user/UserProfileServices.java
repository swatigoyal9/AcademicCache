package services.user;
import beans.admin.AddEditPlansAdminBean;
import beans.user.CitymasterBean;
import beans.user.CountrymasterBean;
import beans.user.StatemasterBean;
import beans.user.UserProfileBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import services.common.DBConnection;
public class UserProfileServices {
    public UserProfileBean getProfileDetailById(String id){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    int userId=Integer.parseInt(id);
        UserProfileBean objUserProfileBean=null;
    try{
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("select * from usermaster u1, userdetailmaster u2, countrymaster c1, statemaster s1, citymaster c2 where u1.user_id=u2.user_id and s1.country_id=c1.country_id and c2.state_id=s1.state_id and c2.city_id=u2.city_id and u1.user_id=?");
        pstmt.setInt(1, userId);
        rs=pstmt.executeQuery();
        if(rs.next()){
            objUserProfileBean=new UserProfileBean();
            objUserProfileBean.setUsername(rs.getString("username"));
            objUserProfileBean.setTxtName(rs.getString("name"));
            objUserProfileBean.setDdlQualification(rs.getString("qualification"));
            objUserProfileBean.setDdlCountry(rs.getString("country_id"));
            System.out.println((rs.getString("country_name")));
            objUserProfileBean.setDdlCountryName(rs.getString("country_name"));
            objUserProfileBean.setDdlState(rs.getString("state_id"));
            objUserProfileBean.setDdlStateName(rs.getString("state_name"));
            objUserProfileBean.setDdlCity(rs.getString("city_id"));
            objUserProfileBean.setDdlCityName(rs.getString("city_name"));
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
    return objUserProfileBean;
}
   

public String updateProfile(UserProfileBean objBean,String id){
    Connection conn=null;
    PreparedStatement pstmt=null;
    UserProfileBean objUserProfileBean=null;
   // List list=null;
    String msg="Failed";
    try{
       // list=new ArrayList();
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("update userdetailmaster set name=?,qualification=?,country_id=?,state_id=?,city_id=? where user_id=?");
        pstmt.setString(1,objBean.getTxtName());
        pstmt.setString(2,objBean.getDdlQualification());
        pstmt.setString(3,objBean.getDdlCountry());
        pstmt.setString(4,objBean.getDdlState());
        pstmt.setString(5,objBean.getDdlCity());
        pstmt.setString(6,id);
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