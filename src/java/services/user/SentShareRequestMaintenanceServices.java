package services.user;

import beans.user.SentShareRequestMaintenanceBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import services.common.DBConnection;

public class SentShareRequestMaintenanceServices {
public List getAllSentShareRequestMaintenance(){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    List listUser = null;
    SentShareRequestMaintenanceBean objSentShareRequestMaintenanceBean=null;
    try{
        conn=(Connection) DBConnection.connect();
        listUser=new ArrayList();
        pstmt=(PreparedStatement) conn.prepareStatement("select * from sharerequestmaster s1,userdetailmaster u1 where u1.user_id=s1.user_id");
        rs=pstmt.executeQuery();
        while(rs.next())
        {
            objSentShareRequestMaintenanceBean=new SentShareRequestMaintenanceBean();
            objSentShareRequestMaintenanceBean.setComment(rs.getString("comment"));
            objSentShareRequestMaintenanceBean.setId(rs.getString("id"));
            objSentShareRequestMaintenanceBean.setName(rs.getString("name"));
            objSentShareRequestMaintenanceBean.setRequest_date(rs.getString("request_date"));
            objSentShareRequestMaintenanceBean.setUser_id(rs.getString("user_id"));
            objSentShareRequestMaintenanceBean.setType(rs.getString("type"));
            objSentShareRequestMaintenanceBean.setTitle(rs.getString("title"));
            objSentShareRequestMaintenanceBean.setRequest_status(rs.getString("request_status"));
            objSentShareRequestMaintenanceBean.setShare_code(rs.getString("share_code"));
            objSentShareRequestMaintenanceBean.setRequest_id(rs.getString("request_id"));
            listUser.add(objSentShareRequestMaintenanceBean);
        }
    }
    catch(Exception e)
    {
        System.out.println(" error at getAllSentShareRequestMaintenance"+e);
    }
    finally{
        try{
            rs.close();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println("error at getAllSentShareRequestMaintenance"+e);
        }
    }
    System.out.println(listUser.size());
        return listUser;
}    
public SentShareRequestMaintenanceBean getSentShareRequestById(int id){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    SentShareRequestMaintenanceBean objSentShareRequestMaintenanceBean=null;
    try{
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("select * from sharerequestmaster s1,userdetailmaster u1 where s1.user_id=u1.user_id and id=?");
        pstmt.setInt(1, id);
        rs=pstmt.executeQuery();
        if(rs.next()){
            objSentShareRequestMaintenanceBean=new SentShareRequestMaintenanceBean();
            objSentShareRequestMaintenanceBean.setId(String.valueOf(rs.getInt("id")));
            objSentShareRequestMaintenanceBean.setComment(rs.getString("comment"));
            objSentShareRequestMaintenanceBean.setName(rs.getString("name"));
            objSentShareRequestMaintenanceBean.setRequest_date(rs.getString("request_date"));
            objSentShareRequestMaintenanceBean.setRequest_id(rs.getString("request_id"));
            objSentShareRequestMaintenanceBean.setRequest_status(rs.getString("request_status"));
            objSentShareRequestMaintenanceBean.setTitle(rs.getString("title"));
            objSentShareRequestMaintenanceBean.setType(rs.getString("type"));
            objSentShareRequestMaintenanceBean.setUser_id(rs.getString("user_id"));
            
            
            }
        System.out.println(pstmt.toString());
    }
    catch(Exception e){
        System.out.println("Error occur at getSentShareRequestById(int id)"+e);
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
    return objSentShareRequestMaintenanceBean;
}
public String getWebLinkPath(int id) {
        String path = "";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = (Connection) DBConnection.connect();
            pstmt = (PreparedStatement) conn.prepareCall("select * from weblinkmaster where id=? ");
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                path = rs.getString("upload_path");
            }
        } catch (Exception e) {
            System.out.print("Exception in getPath(int id) :  " + e);
        } finally {
            try {
                conn.close();
                pstmt.close();
                rs.close();
            } catch (Exception e) {
            }
        }
        return path;
    }
public String getBookPath(int id) {
        String path = "";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = (Connection) DBConnection.connect();
            pstmt = (PreparedStatement) conn.prepareCall("select * from bookdetailmaster where id=? ");
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                path = rs.getString("upload_path");
            }
        } catch (Exception e) {
            System.out.print("Exception in getPath(int id) :  " + e);
        } finally {
            try {
                conn.close();
                pstmt.close();
                rs.close();
            } catch (Exception e) {
            }
        }
        return path;
    }
public String getMultimediaPath(int id) {
        String path = "";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = (Connection) DBConnection.connect();
            pstmt = (PreparedStatement) conn.prepareCall("select * from multimediamaster where id=? ");
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                path = rs.getString("upload_path");
            }
        } catch (Exception e) {
            System.out.print("Exception in getPath(int id) :  " + e);
        } finally {
            try {
                conn.close();
                pstmt.close();
                rs.close();
            } catch (Exception e) {
            }
        }
        return path;
    }

}
