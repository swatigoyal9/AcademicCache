package services.user;

import beans.user.AddEditWebLinkBean;
import beans.user.CommonBean;
import beans.user.WebLinkMaintenanceBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import services.common.DBConnection;

public class WebLinkMaintenanceServices {
    public List getAllWebLinkMaintenance(){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    List listUser = null;
    WebLinkMaintenanceBean objWebLinkMaintenanceBean=null;
    try{
        conn=(Connection) DBConnection.connect();
        listUser=new ArrayList();
        pstmt=(PreparedStatement) conn.prepareStatement("select * from weblinkmaster");
        rs=pstmt.executeQuery();
        while(rs.next())
        {
            objWebLinkMaintenanceBean=new WebLinkMaintenanceBean();
            objWebLinkMaintenanceBean.setAccess_type(rs.getString("access_type"));
            objWebLinkMaintenanceBean.setCaregory(rs.getString("category"));
            objWebLinkMaintenanceBean.setCreation_date(rs.getString("creation_date"));
            objWebLinkMaintenanceBean.setDescription(rs.getString("description"));
            objWebLinkMaintenanceBean.setId(rs.getString("id"));
            objWebLinkMaintenanceBean.setLink(rs.getString("link"));
            objWebLinkMaintenanceBean.setTags(rs.getString("tags"));
            objWebLinkMaintenanceBean.setTitle(rs.getString("title"));
            objWebLinkMaintenanceBean.setUsed_for(rs.getString("used_for"));
            objWebLinkMaintenanceBean.setUser_id(rs.getString("user_id"));
            listUser.add(objWebLinkMaintenanceBean);
        }
    }
    catch(Exception e)
    {
        System.out.println("Exception occur  at getAllWebLinkMaintenance"+e);
    }
    finally{
        try{
            rs.close();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println("Exception occur  at getAllWebLinkMaintenance"+e);
        }
    }
    System.out.println(listUser.size());
        return listUser;
}
    public String addNewWebLink(AddEditWebLinkBean  objBean) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pstmt = null;
        
        String result = "failed";
        try {
            conn = DBConnection.connect();
            

                pstmt = conn.prepareStatement("insert into weblinkmaster(title ,link, description, used_for, category, Creation_Date, Access_type, tags, user_id) values(?,?,?,?,?,sysdate(),?,?,?)");
                //pstmt.setString(1, objBean.getTxtUserId());
                pstmt.setString(1, objBean.getTxtTitle());
                pstmt.setString(2, objBean.getTxtLink());
                pstmt.setString(3, objBean.getTaDescription());
                pstmt.setString(4, objBean.getTaUsedFor());
                pstmt.setString(5, objBean.getTxtCategory());
                pstmt.setString(6, objBean.getRbAccessType());
                pstmt.setString(7, objBean.getTaTags());
                pstmt.setString(8, objBean.getTxtuserId());
                System.out.println(pstmt.toString());
                int i = pstmt.executeUpdate();
                if (i > 0) {
                    result = "added";
                }
            
        } catch (Exception e) {
            System.out.println("addNewWebLink(AddEditWebLinkBean  objBean) of common services : " + e);
        } 
        finally 
        {
            try 
            {
                pstmt.close();
                conn.close();
            } 
            catch (Exception e) 
            {
                System.out.println("addNewWebLink(AddEditWebLinkBean  objBean) of DBoperations : " + e);
            }
        }
        return result;
    }
public AddEditWebLinkBean getWebLinkDetailById(int id){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    AddEditWebLinkBean objAddEditWebLinkBean=null;
    try{
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("select * from weblinkmaster where id=?");
        pstmt.setInt(1, id);
        rs=pstmt.executeQuery();
        if(rs.next()){
            objAddEditWebLinkBean=new AddEditWebLinkBean();
            objAddEditWebLinkBean.setRbAccessType(String.valueOf(rs.getString("access_type")));
            objAddEditWebLinkBean.setTaDescription(rs.getString("description"));
            objAddEditWebLinkBean.setTaTags(rs.getString("tags"));
            objAddEditWebLinkBean.setTaUsedFor(rs.getString("used_for"));
            objAddEditWebLinkBean.setTxtCategory(rs.getString("category"));
            objAddEditWebLinkBean.setTxtLink(rs.getString("link"));
            objAddEditWebLinkBean.setTxtTitle(rs.getString("title"));
            objAddEditWebLinkBean. setTxtuserId(rs.getString("user_id"));
            objAddEditWebLinkBean. setTxtId(rs.getString("id"));
        }
        System.out.println(pstmt.toString());
    }
    catch(Exception e){
        System.out.println("Error occur at getUserDetailById"+e);
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
    return objAddEditWebLinkBean;
}

public String updateWebLinkRecord(AddEditWebLinkBean objBean){
    Connection conn=null;
    PreparedStatement pstmt=null;
    AddEditWebLinkBean objAddEditWebLinkBean=null;
   // List list=null;
    String msg="Failed";
    try{
       // list=new ArrayList();
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("update weblinkmaster set access_type=?,description=?,tags=?,used_for=?,category=?,user_id=?,link=?,title=?,creation_date=sysdate() where id=?");
        pstmt.setString(1,objBean.getRbAccessType());
        pstmt.setString(2,objBean.getTaDescription());
        pstmt.setString(3,objBean.getTaTags());
        pstmt.setString(4,objBean.getTaUsedFor());
        pstmt.setString(5,objBean.getTxtCategory());
        pstmt.setString(6,objBean.getTxtuserId());
        pstmt.setString(7,objBean.getTxtLink());
       pstmt.setString(8, objBean. getTxtTitle());
       pstmt.setString(9, objBean.getTxtId());
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
public String deleteWebLink(int id){
    Connection conn=null;
    PreparedStatement pstmt=null;
   // ResultSet rs=null;
    String msg="Failed";
    try{
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("delete from weblinkmaster where id=?");
        pstmt.setInt(1, id);
        int i=pstmt.executeUpdate();
        if(i>0)
        {
            msg="Record deleted successfully";
        }
        
    }
    catch(Exception e){
        System.out.println("Exception at delete User"+e);
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
public List getWebLinkDetailByName(String name){
        java.sql.Connection conn = null;
        List lstUser = null;
        java.sql.PreparedStatement pstmt = null;
        ResultSet rs = null;
        WebLinkMaintenanceBean objLinkMaintenanceBean=null;
        try {
            lstUser=new ArrayList();
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select id,title,link,description,category, access_type,tags from weblinkmaster where title=?");
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();

            while(rs.next()) {
            objLinkMaintenanceBean=new WebLinkMaintenanceBean();
            objLinkMaintenanceBean.setId(String.valueOf(rs.getInt("id")));
            objLinkMaintenanceBean.setTitle(rs.getString("title"));
            objLinkMaintenanceBean.setLink(rs.getString("link"));
            objLinkMaintenanceBean.setDescription(rs.getString("description"));
            //objLinkMaintenanceBean.setUsed_for(rs.getString("user_for"));
            objLinkMaintenanceBean.setCaregory(rs.getString("category"));
            objLinkMaintenanceBean.setAccess_type(rs.getString("access_type"));
            objLinkMaintenanceBean.setTags(rs.getString("tags"));
            lstUser.add(objLinkMaintenanceBean);
                   System.out.println(rs.getString("id"));
                   System.out.println(pstmt.toString());
            }
        } 
        catch (Exception e) 
        {
            System.out.println("getWebLinkDetailByName(String name)  of commonservices : " + e);
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
                System.out.println("getWebLinkDetailByName(String name) of commonservices : " + e);
            }
        }
        return lstUser;
}

 public CommonBean currentWebInfo(String linkid)
     {
         int lid=Integer.parseInt(linkid);
         Connection conn=null;
         PreparedStatement pstmt=null;
         ResultSet rs=null;
         CommonBean objCommonBean=null;
         try
         {
             conn=(Connection) DBConnection.connect();
             pstmt=(PreparedStatement) conn.prepareStatement("select * from weblinkmaster where Id=?");
             pstmt.setInt(1,lid);
             
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
             System.out.println("in currentWebInfo()"+e);
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
 
}
