/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services.user;

import beans.admin.AddEditEmployeeBean;
import beans.user.AddEditMultimediaDetail;
import beans.user.AddEditNewBookBean;
import beans.user.BooksMaintenanceBean;
import beans.user.CommonBean;
import beans.user.MultimediaMaintenanceBean;
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
public class MultimediaMaintenanceServices {
    public List getAllMultimediaMaimtenance() {
        Connection conn = null;
        List lstMultimediaMaintenance = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MultimediaMaintenanceBean objMultimediaMaintenanceBean=null; 
        try {
            lstMultimediaMaintenance=new ArrayList();
            conn = (Connection)DBConnection.connect();
            pstmt = conn.prepareStatement("select * from multimediamaster");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {
                    objMultimediaMaintenanceBean = new MultimediaMaintenanceBean();
                    objMultimediaMaintenanceBean.setId(rs.getString("Id"));
                    objMultimediaMaintenanceBean.setTitle(rs.getString("Title"));
                    objMultimediaMaintenanceBean.setAccess_type(rs.getString("Access_Type"));
                    objMultimediaMaintenanceBean.setUpload_date(rs.getString("Upload_Date")); 
                    objMultimediaMaintenanceBean.setMedia_type(rs.getString("Media_type")); 
                    objMultimediaMaintenanceBean.setUpload_date(rs.getString("Upload_Date")); 
                  
                    lstMultimediaMaintenance.add(objMultimediaMaintenanceBean);
                }
            }
        } catch (Exception e) {
            System.out.println("getAllManageEmployee() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getAllManageEmployee() of DBoperations : " + e);
            }
        }
        return lstMultimediaMaintenance;
    } 
    public String getPath(int id) {
        String path = "";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareCall("select * from multimediamaster where id=?");
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
    public List getMultimediaByTitle(String title){
        java.sql.Connection conn = null;
        List lstUser = null;
        java.sql.PreparedStatement pstmt = null;
        ResultSet rs = null;
        MultimediaMaintenanceBean objMultimediaMaintenanceBean=null;
        try {
            lstUser=new ArrayList();
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select title,access_type,upload_date from multimediamaster where title=?");
            pstmt.setString(1, title);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                objMultimediaMaintenanceBean=new MultimediaMaintenanceBean();
            objMultimediaMaintenanceBean.setTitle(rs.getString("title"));
            objMultimediaMaintenanceBean.setAccess_type(rs.getString("access_type"));
            objMultimediaMaintenanceBean.setUpload_date(rs.getString("upload_date"));
            lstUser.add(objMultimediaMaintenanceBean);
            System.out.println(pstmt.toString());
            }
        } 
        catch (Exception e) 
        {
            System.out.println("getMultimediaByTitle(String name)  of commonservices : " + e);
        }
        finally 
        {
            try 
            {
                rs.close();
                pstmt.close();
                conn.close();
            }
            catch (Exception e) 
            {
                System.out.println("getMultimediaByTitle(String name) of commonservices : " + e);
            }
        }
        return lstUser;
}
    public String deleteMultimedia(int id){
    com.mysql.jdbc.Connection conn=null;
    com.mysql.jdbc.PreparedStatement pstmt=null;
   // ResultSet rs=null;
    String msg="Failed";
    try{
        conn=(com.mysql.jdbc.Connection) DBConnection.connect();
        pstmt=(com.mysql.jdbc.PreparedStatement) conn.prepareStatement("delete from multimediamaster where id=?");
        pstmt.setInt(1, id);
        int i=pstmt.executeUpdate();
        if(i>0)
        {
            msg="Record deleted successfully";
        }
        
    }
    catch(Exception e){
        System.out.println("Exception at deleteMultimedia"+e);
    }
    finally{
        try{
           // rs.close();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    return msg;
}
    public AddEditMultimediaDetail getMultimediaDetailById(int id){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    AddEditMultimediaDetail objAddEditMultimediaDetail=null;
    try{
        conn= DBConnection.connect();
        pstmt=conn.prepareStatement("select * from multimediamaster where id=?");
        pstmt.setInt(1, id);
        rs=pstmt.executeQuery();
        if(rs.next()){
            objAddEditMultimediaDetail=new AddEditMultimediaDetail();
            objAddEditMultimediaDetail.setTxtId(String.valueOf(rs.getInt("id")));
            objAddEditMultimediaDetail.setTxtTitle(rs.getString("title"));
            System.out.println(rs.getString("title"));
            objAddEditMultimediaDetail.setTaDescription(rs.getString("description"));
            System.out.println(rs.getString("description"));
            objAddEditMultimediaDetail.setTxtLabel(rs.getString("label"));
            objAddEditMultimediaDetail.setTaUsedFor(rs.getString("used_for"));
            objAddEditMultimediaDetail.setTaTags(rs.getString("tags"));
            objAddEditMultimediaDetail.setTxtUsageYear(rs.getString("used_year"));
            objAddEditMultimediaDetail.setRbAccessType(rs.getString("access_type"));
            objAddEditMultimediaDetail.setDdlMediaType(rs.getString("media_type"));
            
        }
        System.out.println(pstmt.toString());
    }
    catch(Exception e){
        System.out.println("Error occur at getEmployeeDetailById"+e);
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
    return objAddEditMultimediaDetail;
}

public String updateMultimediaRecord(AddEditMultimediaDetail objBean){
    Connection conn=null;
    PreparedStatement pstmt=null;
    AddEditMultimediaDetail objBean1=null;
   // List list=null;
    String msg="Failed";
    try{
       // list=new ArrayList();
        conn= DBConnection.connect();
        pstmt=conn.prepareStatement("update multimediamaster set title=?,description=?,label=?,used_for=?,tags=?,used_year=?,access_type=?,media_type=? where id=?");
        pstmt.setString(1,objBean.getTxtTitle());
        pstmt.setString(2,objBean.getTaDescription());
        pstmt.setString(3,objBean.getTxtLabel());
        pstmt.setString(4,objBean.getTaUsedFor());
        pstmt.setString(5,objBean.getTaTags());
        pstmt.setString(6,objBean.getTxtUsageYear());
        pstmt.setString(7,objBean.getRbAccessType());
       pstmt.setString(8, objBean.getDdlMediaType());
       pstmt.setString(9, objBean.getTxtId());
        System.out.println(pstmt.toString());
        int i=pstmt.executeUpdate();
        
        if(i>0)
        {
            msg="Record Updated";
        }
        }
    
    catch(Exception e){
        System.out.println("Exception occur at updateMultimediaRecord"+e);
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

 public CommonBean currentMediaInfo(String multi_id)
     {
         int mid=Integer.parseInt(multi_id);
         Connection conn=null;
         PreparedStatement pstmt=null;
         ResultSet rs=null;
         CommonBean objCommonBean=null;
         try
         {
             conn=DBConnection.connect();
             pstmt=conn.prepareStatement("select * from multimediamaster where Id=?");
             pstmt.setInt(1,mid);
             
             rs=pstmt.executeQuery();
             if(rs.next())
             {
                 objCommonBean=new CommonBean();
                 objCommonBean.setTxtResourceId(rs.getInt("Id"));
                 objCommonBean.setTxtTitle(rs.getString("Title"));
             }
         }
         catch(Exception e)
         {
             System.out.println("in currentMediaInfo()"+e);
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
         return objCommonBean;
     }
 
public String addMultimediaDetail(AddEditMultimediaDetail objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "Not Added";
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("insert into multimediamaster(title,description,label,used_for,tags, used_year, access_type, media_type, upload_path,user_id, size)values(?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, objBean.getTxtTitle());
            pstmt.setString(2, objBean.getTaDescription());
            pstmt.setString(3, objBean.getTxtLabel());
            pstmt.setString(4, objBean.getTaUsedFor());
            pstmt.setString(5, objBean.getTaTags());
            pstmt.setString(6, objBean.getTxtUsageYear());
            pstmt.setString(7, objBean.getRbAccessType());
            pstmt.setString(8, objBean.getDdlMediaType());
            pstmt.setString(9, objBean.getFlAudio_VideoFile());
            pstmt.setString(10, objBean.getTxtuserId());
            pstmt.setInt(11,objBean.getFileSize());
            
            int i = pstmt.executeUpdate();
            System.out.println(pstmt.toString());
            if (i > 0) {
                result = "Added Successfull";
            }
        } catch (Exception e) {
            System.out.println("Exception in addMultimediaDetail : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
}
