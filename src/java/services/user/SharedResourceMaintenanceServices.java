package services.user;
import beans.user.SharedResourceMaintenanceBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import properties.ReadFromProperties;
import services.common.DBConnection;

public class SharedResourceMaintenanceServices {
public List getAllSharedResourceMaintenance(){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    List listUser = null;
    SharedResourceMaintenanceBean objSharedResourceMaintenanceBean=null;
    try{
        conn=(Connection) DBConnection.connect();
        listUser=new ArrayList();
        pstmt=(PreparedStatement) conn.prepareStatement("select * from resourcesharemaster");
        rs=pstmt.executeQuery();
        while(rs.next())
        {
            objSharedResourceMaintenanceBean=new SharedResourceMaintenanceBean();
            objSharedResourceMaintenanceBean.setId(String.valueOf(rs.getInt("id")));
            objSharedResourceMaintenanceBean.setComment(rs.getString("comment"));
            objSharedResourceMaintenanceBean.setDate_shared(rs.getString("date_shared"));
            objSharedResourceMaintenanceBean.setEmails_shared_with(rs.getString("emails_shared_with"));
            objSharedResourceMaintenanceBean.setUser_id(String.valueOf(rs.getInt("user_id")));
            objSharedResourceMaintenanceBean.setType(rs.getString("type"));
            objSharedResourceMaintenanceBean.setTitle(rs.getString("title"));
            objSharedResourceMaintenanceBean.setShare_id(String.valueOf(rs.getInt("share_id")));
            objSharedResourceMaintenanceBean.setShare_code(rs.getString("share_code"));
            listUser.add(objSharedResourceMaintenanceBean);
        }
    }
    catch(Exception e)
    {
        System.out.println("Exception occur  at getAllSharedResourceMaintenance"+e);
    }
    finally{
        try{
            rs.close();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println("Exception occur  at getAllSharedResourceMaintenance"+e);
        }
    }
    System.out.println(listUser.size());
        return listUser;
}    
 public SharedResourceMaintenanceBean getSharedResourceById(int id){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    SharedResourceMaintenanceBean objSharedResourceMaintenanceBean=null;
    try{
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("select * from resourcesharemaster where share_id=?");
        pstmt.setInt(1,id);
        rs=pstmt.executeQuery();
        if(rs.next()){
            objSharedResourceMaintenanceBean=new SharedResourceMaintenanceBean();
            objSharedResourceMaintenanceBean.setId(rs.getString("id"));
            objSharedResourceMaintenanceBean.setComment(rs.getString("comment"));
            objSharedResourceMaintenanceBean.setDate_shared(rs.getString("date_shared"));
            objSharedResourceMaintenanceBean.setEmails_shared_with(rs.getString("emails_shared_with"));
            objSharedResourceMaintenanceBean.setShare_code(rs.getString("share_code"));
            objSharedResourceMaintenanceBean.setShare_id(String.valueOf(rs.getInt("share_id")));
            objSharedResourceMaintenanceBean.setTitle(rs.getString("title"));
            objSharedResourceMaintenanceBean.setType(rs.getString("type"));
            objSharedResourceMaintenanceBean.setUser_id(rs.getString("user_id"));
            
            
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
    return objSharedResourceMaintenanceBean;
} 
   public String random()
    {
        Random r=new Random();
        String str[]= {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"};
        String CODE="";
        for(int i=0;i<16;i++)
        {
            CODE=CODE+str[r.nextInt(6)];
        }
        return CODE;
    }
   
  public SharedResourceMaintenanceBean sharedResources(SharedResourceMaintenanceBean objBean)
     {
         Connection conn=null;
         PreparedStatement pstmt=null;
         ResultSet rs=null;
         String Code=random();
        String path=null;
         try
     {
         
         conn=(Connection) DBConnection.connect();
         pstmt=(PreparedStatement) conn.prepareStatement("insert into resourcesharemaster (Id,Title,Type,Share_Code,Date_Shared,Comment,Emails_Shared_With,User_Id) values(?,?,?,?,sysdate(),?,?,?);");
         pstmt.setString(1,objBean.getId());
         pstmt.setString(2,objBean.getTitle());
         pstmt.setString(3,objBean.getType());
         pstmt.setString(4,Code);
         pstmt.setString(5,objBean.getComment());
         pstmt.setString(6,objBean.getEmails_shared_with());
         pstmt.setString(7,objBean.getUser_id());
         int r=pstmt.executeUpdate();
         System.out.println(pstmt.toString());
         if(r>0)
         {        
                System.out.println("1");
                 if(objBean.getType().equalsIgnoreCase("Book"))
                 {    
                 pstmt=(PreparedStatement) conn.prepareStatement("select a.Upload_Path,a.Id,b.Emails_Shared_With,b.Share_Code from bookdetailmaster as a inner join resourcesharemaster as b on b.Id=a.Id where b.Id=?");
                 pstmt.setString(1,objBean.getResourceId());
                 rs=pstmt.executeQuery();
                 System.out.println(pstmt.toString());
         System.out.println(pstmt.toString());
                        if(rs.next())
                              {    
                                objBean=new SharedResourceMaintenanceBean();
                                path=new ReadFromProperties().getDownloadBookPath()+"/"+objBean.getUser_id()+"_Users_Book"+"/"+rs.getString("Upload_Path");
                                objBean.setEmails_shared_with(rs.getString("Emails_Shared_With"));
                                objBean.setShare_code(Code);
                                objBean.setUpload_path(path);
                                objBean.setResourceId(rs.getString("Id"));
                              }
                 }
                else if(objBean.getType().equalsIgnoreCase("Audio") || objBean.getType().equalsIgnoreCase("Video"))
                 {
                     System.out.println("2");
                     pstmt=(PreparedStatement) conn.prepareStatement("select a.Upload_Path,a.Id,b.Emails_Shared_With,b.Share_Code from multimediamaster as a inner join resourcesharemaster as b on b.Id=a.Id where b.Id=?");
                     pstmt.setString(1,objBean.getResourceId());
                     System.out.println(pstmt);
                     rs=pstmt.executeQuery();
                    if(rs.next())
                        {    
                                    objBean=new SharedResourceMaintenanceBean();
                                    path=new ReadFromProperties().getDownloadMultimediaPath()+"/"+objBean.getUser_id()+"_Users_Multimedia"+"/"+rs.getString("Upload_Path");
                                    objBean.setEmails_shared_with(rs.getString("Emails_Shared_With"));
                                    objBean.setShare_code(Code);
                                    objBean.setUpload_path(path);
                                    objBean.setResourceId(rs.getString("Id"));
                        }
                 }
                 
                else if(objBean.getType().equalsIgnoreCase("web"))
                {
                    System.out.println("2");
                     pstmt=(PreparedStatement) conn.prepareStatement("select a.Link,a.Id,b.Emails_Shared_With,b.Share_Code from weblinkmaster as a inner join resourcesharemaster as b on b.Id=a.Id where b.Id=?");
                     pstmt.setString(1,objBean.getResourceId());
                     System.out.println(pstmt);
                     rs=pstmt.executeQuery();
                    if(rs.next())
                        {    
                                    objBean=new SharedResourceMaintenanceBean();
                                    objBean.setEmails_shared_with(rs.getString("Emails_Shared_With"));
                                    objBean.setShare_code(Code);
                                    objBean.setUpload_path(rs.getString("Link"));
                                    objBean.setResourceId(rs.getString("Id"));
                        }
                    
                }
                 
           } 
     }
     catch(Exception e)
     {
         System.out.println("in shareResources()"+e);
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
             
         }
     }
     return objBean;
     }
  
 public String deleteSharedResource(int id){
    Connection conn=null;
    PreparedStatement pstmt=null;
   // ResultSet rs=null;
    String msg="Failed";
    try{
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("delete from resourcesharemaster where share_id=?");
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
   public SharedResourceMaintenanceBean getCurrentShareResourceDetail(String sh_id,String type)
     {
         Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    SharedResourceMaintenanceBean objBean= new SharedResourceMaintenanceBean();
         try
         {
             conn= (Connection) DBConnection.connect();
             pstmt=(PreparedStatement) conn.prepareStatement("select * from resourcesharemaster where Id=? and Type=?");
             pstmt.setInt(1,Integer.parseInt(sh_id));
             pstmt.setString(2,type);
             rs=pstmt.executeQuery();
             if(rs.next())
             {
                 
                 objBean=new SharedResourceMaintenanceBean();
                 objBean.setEmails_shared_with(rs.getString("Emails_Shared_With"));
                 objBean.setTitle(rs.getString("Title"));
                 objBean.setType(rs.getString("Type"));
                 objBean.setDate_shared(rs.getString("Date_Shared"));
                 objBean.setComment(rs.getString("Comment"));
                 
                 
             }
             
             
             
         }
         catch(Exception e)
     {
         System.out.println("in getCurrentShareResourceDetail()"+e);
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
             
         }
     }
     return objBean;
         
     }
}
