package services.admin;

import beans.admin.ManageEmployeeBean;
import beans.admin.ManageReportAbuseBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import properties.ReadFromProperties;
import services.common.DBConnection;

public class ManageReportAbuseServices {
    public List<ManageReportAbuseBean> getALLManageReportAbuse()
    {
      Connection conn=null;
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      ResultSet rs1=null;
      ManageReportAbuseBean objBean=null;
      List list=null;
        
       try
        {
            conn=(Connection) DBConnection.connect();
            list=new ArrayList();
            pstmt=(PreparedStatement) conn.prepareStatement("select a.Report_Id,a.Id,a.Type,a.Response,b.Description,b.Report_User_Id,date_format(b.Report_Date,'%a %b %d %Y %h:%i  %p') as Report_Time,c.Name,d.User_Status from reportmaster as a inner join reportdetails as b on a.Report_Id=b.Report_Id inner join userdetailmaster as c on b.Report_User_Id=c.User_Id inner join usermaster as d on c.User_Id=d.User_Id");
            rs=pstmt.executeQuery();
            System.out.println(pstmt.toString());
            System.out.println("hii1");
            while(rs.next())
            {   
                
               if(rs.getString("Type").equalsIgnoreCase("Book"))
                {
                    pstmt=(PreparedStatement) conn.prepareStatement("select Title,Size from bookdetailmaster where Id=?");
                    pstmt.setInt(1,rs.getInt("Id"));
                    rs1=pstmt.executeQuery();
                    System.out.println(pstmt.toString());
                    if(rs1.next())
                    {
                        objBean=new ManageReportAbuseBean();
                        objBean.setTxtReportId(rs.getInt("Report_Id"));
                        objBean.setTxtResourceId(rs.getInt("Id"));
                        objBean.setTaResponse(rs.getString("Response"));
                        objBean.setTxtDescription(rs.getString("Description"));
                        objBean.setTxtSize(rs1.getInt("Size"));
                        objBean.setTxtId(rs.getInt("Report_User_Id"));
                        objBean.setTxtTitle(rs1.getString("Title"));
                        objBean.setTxtType(rs.getString("Type"));
                        objBean.setReportDate(rs.getString("Report_Time"));
                        objBean.setTxtName(rs.getString("Name"));
                        objBean.setUserStatus(rs.getString("User_Status"));
                        list.add(objBean);
            System.out.println("hi");
                    }
                    
                }
               else if(rs.getString("Type").equalsIgnoreCase("Audio") || rs.getString("Type").equalsIgnoreCase("Video"))
               {
                   
                   pstmt=(PreparedStatement) conn.prepareStatement("select Title,Size from multimediamaster where Id=?");
                   pstmt.setInt(1,rs.getInt("Id"));
                   rs1=pstmt.executeQuery();
                   System.out.println(pstmt);
                    if(rs1.next())
                    {
                        objBean=new ManageReportAbuseBean();
                        objBean.setTxtReportId(rs.getInt("Report_Id"));
                        objBean.setTxtResourceId(rs.getInt("Id"));
                        objBean.setTaResponse(rs.getString("Response"));
                        objBean.setTxtDescription(rs.getString("Description"));
                        objBean.setTxtSize(rs1.getInt("Size"));
                        objBean.setTxtId(rs.getInt("Report_User_Id"));
                        objBean.setTxtTitle(rs1.getString("Title"));
                        objBean.setTxtType(rs.getString("Type"));
                        objBean.setReportDate(rs.getString("Report_Time"));
                        objBean.setTxtName(rs.getString("Name"));
                        objBean.setUserStatus(rs.getString("User_Status"));
                        list.add(objBean);
                    }
                    
                   
               }
            }
        }
            catch(Exception e)
            {
                System.out.println("in getALLManageReportAbuse()"+e);
            }
            finally
             {
                 try
                 {
                     rs1.close();
                     rs.close();
                     pstmt.close();
                     conn.close();
                 }
                 catch(Exception e)
                 {
                     System.out.println();
           
                }
              }
             return list;
          }

    public List getReportAbuseDetailByTitle(String title){
        Connection conn = null;
        List lstUser = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ManageReportAbuseBean objManageReportAbuseBean=null;
        try {
            lstUser=new ArrayList();
            conn = (Connection) DBConnection.connect();
            pstmt = (PreparedStatement) conn.prepareStatement("select * from resourcesharemaster r1, userdetailmaster u1, usermaster u2, reportdetails r2 where r1.user_id=u1.user_id and u1.user_id=r2.report_user_id and u1.user_id=u2.user_id and title=?");
            pstmt.setString(1, title);
            rs = pstmt.executeQuery();
            System.out.println(pstmt.toString());

            while(rs.next()) {
                objManageReportAbuseBean=new ManageReportAbuseBean();
            objManageReportAbuseBean.setTxtTitle(rs.getString("title"));
            objManageReportAbuseBean.setTxtType(rs.getString("type"));
            objManageReportAbuseBean.setReportDate(rs.getString("report_date"));
            objManageReportAbuseBean.setTxtName(rs.getString("name"));
            objManageReportAbuseBean.setUserStatus(rs.getString("user_status"));
            objManageReportAbuseBean.setTxtReportId(rs.getInt("Report_Id"));
                        System.out.println("hello");
                        objManageReportAbuseBean.setTxtResourceId(rs.getInt("Id"));
                        objManageReportAbuseBean.setTxtDescription(rs.getString("Description"));
            lstUser.add(objManageReportAbuseBean);
            }
        } 
        catch (Exception e) 
        {
            System.out.println("getReportAbuseDetailsByTitle(String name): " + e);
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
                System.out.println("getEmployeeDetailByName(String name) of commonservices : " + e);
            }
        }
        return lstUser;
}
      public ManageReportAbuseBean getCurrentResourceAbuse(String user_id,String title,String report_id)
    {
        int uid=Integer.parseInt(user_id);
        int rid=Integer.parseInt(report_id);
        String fileName=null;
        java.sql.Connection conn = null;
        List lstUser = null;
        java.sql.PreparedStatement pstmt = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ManageReportAbuseBean objBean=null;
        try
        {
            conn=DBConnection.connect();
            pstmt=conn.prepareStatement("select a.Report_Id,a.Id,a.Type,a.Response,b.Attachment_Path,b.Report_User_Id,b.Description,date_format(b.Report_Date,'%a %b %d %Y %h:%i  %p') as Report_Time,c.Name,d.User_Status from reportmaster as a inner join reportdetails as b on a.Report_Id=b.Report_Id inner join userdetailmaster as c on b.Report_User_Id=c.User_Id inner join usermaster as d on c.User_Id=d.User_Id where b.Report_User_Id=? and a.Report_Id=?");
            pstmt.setInt(1,uid);
            pstmt.setInt(2,rid);
            rs=pstmt.executeQuery();
            System.out.println(pstmt);
           if(rs.next())
            {   
                
               if(rs.getString("Type").equalsIgnoreCase("Book"))
                {   
                    System.out.println("in book");
                    pstmt=conn.prepareStatement("select a.Name as Report_User from userdetailmaster as a inner join reportdetails as b on a.User_Id=b.Report_User_Id where b.Report_User_Id=?");
                    pstmt.setInt(1,uid);
                    rs2=pstmt.executeQuery();System.out.println(pstmt);
                    if(rs2.next())
                    {    
                        pstmt=conn.prepareStatement("select Title,Size from bookdetailmaster where Id=? and Title=?");
                        pstmt.setInt(1,rs.getInt("Id"));
                        pstmt.setString(2,title);
                        rs1=pstmt.executeQuery();System.out.println(pstmt);
                        if(rs1.next())
                        {
                            objBean=new ManageReportAbuseBean();
                            fileName=rs.getString("Attachment_Path");
                            File file=new File(fileName);
                            //path = rs.getString("Upload_Path");
                            //path=new ReadFromProperties().getDownloadMultimediaPath()+"/"+user_id+"_Users_Multimedia"+"/"+path;
                            if(file.isFile())
                            {
                             fileName=new ReadFromProperties().getDownloadReportAbusePath()+"/"+user_id+"_Report_Abuse"+"/"+fileName;
                            }    
                            else
                            {
                            fileName="File Not Exists";
                            }
                        objBean.setTxtReportUser(rs2.getString("Report_User"));    
                        objBean.setTxtReportId(rs.getInt("Report_Id"));
                        objBean.setTxtResourceId(rs.getInt("Id"));
                        objBean.setTxtFileName(fileName);
                        objBean.setTaResponse(rs.getString("Response"));
                        objBean.setTxtDescription(rs.getString("Description"));
                        objBean.setTxtSize(rs1.getInt("Size"));
                        objBean.setTxtId(rs.getInt("Report_User_Id"));
                        objBean.setTxtTitle(rs1.getString("Title"));
                        objBean.setTxtType(rs.getString("Type"));
                        objBean.setReportDate(rs.getString("Report_Time"));
                        objBean.setTxtName(rs.getString("Name"));
                        objBean.setUserStatus(rs.getString("User_Status"));
                        
                    }
                    
                }
              }
               else if(rs.getString("Type").equalsIgnoreCase("Audio") || rs.getString("Type").equalsIgnoreCase("Video"))
               {    
                    System.out.println("in audio");
                    pstmt=conn.prepareStatement("select a.Name as Report_User from userdetailmaster as a inner join reportdetails as b on a.User_Id=b.Report_User_Id where b.Report_User_Id=?");
                    pstmt.setInt(1,uid);
                    rs2=pstmt.executeQuery();System.out.println(pstmt);
                    if(rs2.next())
                    {    
                            pstmt=conn.prepareStatement("select Title,Size from multimediamaster where Id=? and Title=?");
                            pstmt.setInt(1,rs.getInt("Id"));
                            pstmt.setString(2,title);
                            rs1=pstmt.executeQuery();System.out.println(pstmt);
                            if(rs1.next())
                            {
                                objBean=new ManageReportAbuseBean();
                                fileName=rs.getString("Attachment_Path");
                                //System.out.println(fileName);
                                //File file=new File(fileName);
                                String path=new ReadFromProperties().getreportabusePath()+"//"+user_id+"_Report_Abuse";
                                path+=File.separator+fileName;
                                File file=new File(path);
                                if(file.isFile())
                                {
                                    //fileName=new ReadFromProperties().getDownloadReportAbusePath()+"/"+user_id+"_Report_Abuse"+"/"+fileName;
                                    fileName=fileName;
                                }    
                               else
                                {
                                    fileName="File Not Exists";
                                }
                                System.out.println(fileName);
                                objBean.setTxtReportUser(rs2.getString("Report_User"));
                                objBean.setTxtReportId(rs.getInt("Report_Id"));
                                objBean.setTxtResourceId(rs.getInt("Id"));
                                objBean.setTxtFileName(fileName);
                                objBean.setTaResponse(rs.getString("Response"));
                                objBean.setTxtDescription(rs.getString("Description"));
                                objBean.setTxtSize(rs1.getInt("Size"));
                                objBean.setTxtId(rs.getInt("Report_User_Id"));
                                objBean.setTxtTitle(rs1.getString("Title"));
                                objBean.setTxtType(rs.getString("Type"));
                                objBean.setReportDate(rs.getString("Report_Time"));
                                objBean.setTxtName(rs.getString("Name"));
                                objBean.setUserStatus(rs.getString("User_Status"));
                        
                    }
                    
                   
               }
            }
        }
     }
            catch(Exception e)
            {
                System.out.println("in getCurrentResourceAbuse()"+e);
            }
            finally
             {
                 try
                 {
                     rs1.close();
                     rs.close();
                     pstmt.close();
                     conn.close();
                 }
                 catch(Exception e)
                 {
                     System.out.println();
           
                }
              }
             return objBean;
    }
    public String blockUser(String uid,ManageReportAbuseBean objBean,int manager_id)
    {
        String msg="Unable to Block User";
        java.sql.Connection conn = null;
        List lstUser = null;
        java.sql.PreparedStatement pstmt = null;
        java.sql.PreparedStatement pstmt1 = null;
        java.sql.PreparedStatement pstmt2 = null;
        ResultSet rs = null;
        ManageReportAbuseBean objManageReportAbuseBean=null;
        int user_id=Integer.parseInt(uid);
        try
        {
            conn=DBConnection.connect();
            pstmt=conn.prepareStatement("select User_Status from usermaster where User_Id=?");
            pstmt.setInt(1,user_id);
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                if(rs.getString("User_Status").equals("Blocked"))
                {
                    msg="User Already Blocked";
                }   
              else
              {  
                pstmt1=conn.prepareStatement("update reportmaster set Response=?,Response_Date=sysdate(),response_user_id=? where Report_Id=?");
                pstmt1.setString(1,objBean.getTaResponse());
                pstmt1.setInt(2,objBean.getTxtReportId());
                pstmt1.setInt(3,manager_id);
                int r=pstmt1.executeUpdate();
                if(r>0)
                {   
                        pstmt2=conn.prepareStatement("update usermaster set User_Status=? where User_Id=?");
                        pstmt2.setString(1,"Blocked");
                        pstmt2.setInt(2,user_id);
                        int rs1=pstmt2.executeUpdate();
                        if(rs1>0)
                        {
                             msg="Blocked";
                        }
                }       
            }
        }
        }
        catch(Exception e)
        {
            System.out.println("in blockUser()"+e);
        }
        finally
        {
            try
            {
                pstmt.close();
                conn.close();
            }
            catch(Exception e)
            {
                System.out.println();
            }
        }
        return msg;
    }
    
    public String delUser(String title,String type,ManageReportAbuseBean objBean,int manager_id)
    {
        String msg="Unable to Delete User";
        
        java.sql.Connection conn = null;
        List lstUser = null;
        java.sql.PreparedStatement pstmt = null;
        ResultSet rs = null;
        ManageReportAbuseBean objManageReportAbuseBean=null;
        try
        {
           conn=DBConnection.connect();
            
           if(type.equalsIgnoreCase("Book"))
           {
                    pstmt=conn.prepareStatement("select * from bookdetailmaster where Id=?");
                    pstmt.setInt(1,objBean.getTxtResourceId());
                    rs=pstmt.executeQuery();
                    if(rs.next())
                    {
                           String fileName=rs.getString("Upload_Path");
                           System.out.println(fileName);
                           ReadFromProperties obj=new ReadFromProperties();
                           String uploadPath=obj.getbookPath();
                           System.out.println(uploadPath);
                           String path=uploadPath+ File.separator +rs.getInt("User_Id")+"_Users_Book"+ File.separator +fileName;
                           System.out.println(path);
                           File file=new File(path);
                             if(file.isFile())
                                {   
                                    file.delete();
                                }
                        pstmt=conn.prepareStatement("delete from bookdetailmaster where Title=? and Id=?");
                        pstmt.setString(1,title);
                        pstmt.setInt(2,objBean.getTxtResourceId());
                        int rs1=pstmt.executeUpdate();
                        if(rs1>0)
                        {    
                             pstmt=conn.prepareStatement("update reportmaster set Response=?,Response_Date=sysdate(),response_user_id=? where Report_Id=?");
                             pstmt.setString(1,objBean.getTaResponse());
                             pstmt.setInt(2,manager_id);
                             pstmt.setInt(3,objBean.getTxtReportId());
                             int r=pstmt.executeUpdate();
                             if(r>0)
                            {    
                                msg="User's Resource Deleted";
                            }
                       
                         }
                    }
                }           
           else if(type.equalsIgnoreCase("Audio") || type.equalsIgnoreCase("Video"))
           {
                    
                    pstmt=conn.prepareStatement("select Upload_Path from multimediamaster where Id=?");
                    pstmt.setInt(1,objBean.getTxtResourceId());
                    rs=pstmt.executeQuery();
                    if(rs.next())
                    {
                           String fileName=rs.getString("Upload_Path");
                           System.out.println(fileName);
                           ReadFromProperties obj=new ReadFromProperties();
                           String uploadPath=obj.getmultimediaPath();
                           System.out.println(uploadPath);
                           String path=uploadPath+ File.separator +rs.getInt("User_Id")+"_Users_Multimedia"+ File.separator +fileName;
                           System.out.println(path);
                           File file=new File(path);
                           if(file.isFile())
                           {   
                                    file.delete();
                           }
                          
                            pstmt=conn.prepareStatement("delete from multimediamaster where Title=? and Id=?");
                            pstmt.setString(1,title);
                            pstmt.setInt(2,objBean.getTxtResourceId());
                            int rs2=pstmt.executeUpdate();
                            if(rs2>0)
                            {
                                 pstmt=conn.prepareStatement("update reportmaster set Response=?,Response_Date=sysdate(),response_user_id=? where Report_Id=?");
                                 pstmt.setString(1,objBean.getTaResponse());
                                 pstmt.setInt(2,manager_id);
                                 pstmt.setInt(3,objBean.getTxtReportId());
                                 int r=pstmt.executeUpdate();
                                 if(r>0)
                                 {    
                                     msg="User's Resource Deleted";
                                  }
                       
                            }
                     }
                }
        } 
        catch(Exception e)
        {
            System.out.println("in delUser()"+e);
        }
        finally
        {
            try
            {
                pstmt.close();
                conn.close();
            }
            catch(Exception e)
            {
                System.out.println();
            }
        }
        return msg;
    }
     
     public String cancelReportAbuse(ManageReportAbuseBean objBean)
     {
         String msg="Unable to Cancel";
         java.sql.Connection conn = null;
        List lstUser = null;
        java.sql.PreparedStatement pstmt = null;
        ResultSet rs = null;
        ManageReportAbuseBean objManageReportAbuseBean=null;
        //int user_id=Integer.parseInt(uid);
         try
         {
             conn=DBConnection.connect();
               pstmt=conn.prepareStatement("delete from reportdetails where Report_Id=?");
               System.out.println(pstmt);
               pstmt.setInt(1,objBean.getTxtReportId());
                int r=pstmt.executeUpdate();
                if(r>0)
                {
                    pstmt=conn.prepareStatement("delete from reportmaster where Report_Id=?");
                    System.out.println(pstmt);
                    pstmt.setInt(1,objBean.getTxtReportId());
                    int r1=pstmt.executeUpdate();
                    if(r1>0)
                    {
                        msg="Resource Report Abuse Cancelled";
                    }
                    
                }
         }
     
         catch(Exception e)
         {
             System.out.println("in cancelReportAbuse()"+e);
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
                 System.out.println();
             }
         }
         return msg;
}
}
