/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services.user;

import beans.user.MultimediaMaintenanceBean;
import beans.user.ReceivedShareRequestMaintenanceBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import services.common.DBConnection;

/**
 *
 * @author Aparchyanta
 */
public class ReceivedShareRequestMaintenanceServices {
    public List getAllReceivedShareRequestMaintenance() {
        Connection conn = null;
        List lstRequest = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ReceivedShareRequestMaintenanceBean objReceivedShareRequestMaintenanceBean=null; 
        try {
            lstRequest=new ArrayList();
            conn = (Connection)DBConnection.connect();
            pstmt = conn.prepareStatement("select * from sharerequestmaster");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {
                    objReceivedShareRequestMaintenanceBean = new ReceivedShareRequestMaintenanceBean();
                    
                    objReceivedShareRequestMaintenanceBean.setId(String.valueOf(rs.getInt("id")));
            objReceivedShareRequestMaintenanceBean.setComment(rs.getString("comment"));
            objReceivedShareRequestMaintenanceBean.setRequest_id(String.valueOf(rs.getInt("request_id")));
            objReceivedShareRequestMaintenanceBean.setRequest_date(rs.getString("request_date"));
            objReceivedShareRequestMaintenanceBean.setShare_code(rs.getString("share_code"));
            objReceivedShareRequestMaintenanceBean.setRequest_status(rs.getString("request_status"));
            objReceivedShareRequestMaintenanceBean.setTitle(rs.getString("title"));
            objReceivedShareRequestMaintenanceBean.setType(rs.getString("type"));
            objReceivedShareRequestMaintenanceBean.setUser_id(rs.getString("user_id")); 
                  
                    lstRequest.add(objReceivedShareRequestMaintenanceBean);
                }
            }
        } catch (Exception e) {
            System.out.println("getAllReceivedShareRequestMaintenance() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getAllReceivedShareRequestMaintenance() of DBoperations : " + e);
            }
        }
        return lstRequest;
    } 
    public ReceivedShareRequestMaintenanceBean getReceivedShareRequestById(int id){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    ReceivedShareRequestMaintenanceBean objReceivedShareRequestMaintenanceBean=null;
    try{
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("select * from sharerequestmaster where request_id=?");
        pstmt.setInt(1,id);
        rs=pstmt.executeQuery();
        if(rs.next()){
            objReceivedShareRequestMaintenanceBean=new ReceivedShareRequestMaintenanceBean();
            objReceivedShareRequestMaintenanceBean.setId(String.valueOf(rs.getInt("id")));
            objReceivedShareRequestMaintenanceBean.setComment(rs.getString("comment"));
            objReceivedShareRequestMaintenanceBean.setRequest_id(String.valueOf(rs.getInt("request_id")));
            objReceivedShareRequestMaintenanceBean.setRequest_date(rs.getString("request_date"));
            objReceivedShareRequestMaintenanceBean.setShare_code(rs.getString("share_code"));
            objReceivedShareRequestMaintenanceBean.setRequest_status(rs.getString("request_status"));
            objReceivedShareRequestMaintenanceBean.setTitle(rs.getString("title"));
            objReceivedShareRequestMaintenanceBean.setType(rs.getString("type"));
            objReceivedShareRequestMaintenanceBean.setUser_id(rs.getString("user_id"));
            
            
            }
        System.out.println(pstmt.toString());
    }
    catch(Exception e){
        System.out.println("Error occur at getSharedResourceById(int id)"+e);
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
    return objReceivedShareRequestMaintenanceBean;
} 
    public String updateApprovedRecord(int id,String status){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ReceivedShareRequestMaintenanceBean objReceivedShareRequestMaintenanceBean=null;
   // List list=null;
    String msg="Failed";
    try{
       // list=new ArrayList();
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("update sharerequestmaster set request_status=? where request_id=?");
        pstmt.setString(1,status);
        pstmt.setInt(2,id);
        System.out.println(pstmt.toString());
        int i=pstmt.executeUpdate();
        
        if(i>0)
        {
            msg="Record Updated";
        }
        }
    
    catch(Exception e){
        System.out.println("Exception occur at updateEmployeeRecord"+e);
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
    public String updateDisapprovedRecord(int id,String status){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ReceivedShareRequestMaintenanceBean objReceivedShareRequestMaintenanceBean=null;
   // List list=null;
    String msg="Failed";
    try{
       // list=new ArrayList();
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("update sharerequestmaster set request_status=? where request_id=?");
        pstmt.setString(1,status);
        pstmt.setInt(2,id);
        System.out.println(pstmt.toString());
        int i=pstmt.executeUpdate();
        
        if(i>0)
        {
            msg="Record Updated";
        }
        }
    
    catch(Exception e){
        System.out.println("Exception occur at updateEmployeeRecord"+e);
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
