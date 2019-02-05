/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services.user;

import beans.admin.AddEditEmployeeBean;
import beans.admin.ManageEmployeeBean;
import beans.admin.ManagePlansAdminBean;
import beans.admin.ManageRegisteredUserBean;
import beans.user.AddEditNewBookBean;
import beans.user.BooksMaintenanceBean;
import beans.user.CommonBean;
import beans.user.HomeBean;
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
public class BooksMaintenanceServices {

    public List getAllBookMaintenance() {
        Connection conn = null;
        List lstBooksMaintenance = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        BooksMaintenanceBean objBooksMaintenanceBean = null;
        try {
            lstBooksMaintenance = new ArrayList();
            conn = (Connection) DBConnection.connect();
            pstmt = conn.prepareStatement("select Id, Title, Category, Creation_Date from bookdetailmaster");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {
                    objBooksMaintenanceBean = new BooksMaintenanceBean();

                    objBooksMaintenanceBean.setId(rs.getString("Id"));
                    objBooksMaintenanceBean.setTitle(rs.getString("Title"));
                    objBooksMaintenanceBean.setCategory(rs.getString("Category"));
                    objBooksMaintenanceBean.setCreation_date(rs.getString("Creation_Date"));

                    lstBooksMaintenance.add(objBooksMaintenanceBean);
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
        return lstBooksMaintenance;
    }

    public String getPath(int id) {
        String path = "";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareCall("select * from bookdetailmaster where id=?");
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

    public List getBooksByTitle(String title) {
        java.sql.Connection conn = null;
        List lstUser = null;
        java.sql.PreparedStatement pstmt = null;
        ResultSet rs = null;
        BooksMaintenanceBean objBooksMaintenanceBean = null;
        try {
            lstUser = new ArrayList();
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select title,category,creation_date from bookdetailmaster where title=?");
            pstmt.setString(1, title);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                objBooksMaintenanceBean = new BooksMaintenanceBean();
                objBooksMaintenanceBean.setTitle(rs.getString("title"));
                objBooksMaintenanceBean.setCategory(rs.getString("category"));
                objBooksMaintenanceBean.setCreation_date(rs.getString("creation_date"));
                lstUser.add(objBooksMaintenanceBean);
                System.out.println(pstmt.toString());
            }
        } catch (Exception e) {
            System.out.println("getBooksByTitle(String name)  of commonservices : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getBooksByTitle(String name) of commonservices : " + e);
            }
        }
        return lstUser;
    }

    public CommonBean currentBook(String bid)
     {
         int book_id=Integer.parseInt(bid);
         Connection conn=null;
         PreparedStatement pstmt=null;
         CommonBean objCommonBean=null;
         ResultSet rs=null;
         
         try
         {
             conn=DBConnection.connect();
             pstmt=conn.prepareStatement("select * from bookdetailmaster where Id=?");
             pstmt.setInt(1,book_id);
             
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
             System.out.println("in currentBook()"+e);
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
    
    public String deleteBook(int id) {
        com.mysql.jdbc.Connection conn = null;
        com.mysql.jdbc.PreparedStatement pstmt = null;
        // ResultSet rs=null;
        String msg = "Failed";
        try {
            conn = (com.mysql.jdbc.Connection) DBConnection.connect();
            pstmt = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("delete from bookdetailmaster where id=?");
            pstmt.setInt(1, id);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                msg = "Record deleted successfully";
            }

        } catch (Exception e) {
            System.out.println("Exception at deleteBook" + e);
        } finally {
            try {
                // rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return msg;
    }

    public AddEditNewBookBean getBookDetailById(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        AddEditNewBookBean objAddEditNewBookBean = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select * from bookdetailmaster where id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                objAddEditNewBookBean = new AddEditNewBookBean();
                objAddEditNewBookBean.setTxtId(String.valueOf(rs.getInt("id")));
                objAddEditNewBookBean.setTxtTitle(rs.getString("title"));
                objAddEditNewBookBean.setTxtAuthor(rs.getString("author"));
                objAddEditNewBookBean.setTxtPublicationYear(rs.getString("publication_year"));
                objAddEditNewBookBean.setTaDescription(rs.getString("description"));
                objAddEditNewBookBean.setTxtCategory(rs.getString("category"));
                objAddEditNewBookBean.setTaTags(rs.getString("tags"));
                objAddEditNewBookBean.setTaBookUsedFor(rs.getString("used_for"));
                objAddEditNewBookBean.setTxtUsageYear(rs.getString("used_year"));
                objAddEditNewBookBean.setRbAccessType(rs.getString("access_type"));

            }
            System.out.println(pstmt.toString());
        } catch (Exception e) {
            System.out.println("Error occur at getBookDetailById" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return objAddEditNewBookBean;
    }

    public String updateBookRecord(AddEditNewBookBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        AddEditNewBookBean objBean1 = null;
        // List list=null;
        String msg = "Failed";
        try {
            // list=new ArrayList();
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("update bookdetailmaster set title=?,author=?,publication_year=?,description=?,category=?,tags=?,used_for=?,used_year=?,access_type=? where id=?");
            pstmt.setString(1, objBean.getTxtTitle());
            pstmt.setString(2, objBean.getTxtAuthor());
            pstmt.setString(3, objBean.getTxtPublicationYear());
            pstmt.setString(4, objBean.getTaDescription());
            pstmt.setString(5, objBean.getTxtCategory());
            pstmt.setString(6, objBean.getTaTags());
            pstmt.setString(7, objBean.getTaBookUsedFor());
            pstmt.setString(8, objBean.getTxtUsageYear());
            pstmt.setString(9, objBean.getRbAccessType());
            pstmt.setString(10, objBean.getTxtId());
            System.out.println(pstmt.toString());
            int i = pstmt.executeUpdate();

            if (i > 0) {
                msg = "Record Updated";
            }
        } catch (Exception e) {
            System.out.println("Exception occur at updateBookRecord" + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return msg;
    }

    public String addBookDetail(AddEditNewBookBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "failed";
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("insert into bookdetailmaster(title,author,publication_year,description, category, tags, used_for, used_year, access_type, upload_path,user_id, size,creation_date) values(?,?,?,?,?,?,?,?,?,?,?,?,now())");
            pstmt.setString(1, objBean.getTxtTitle());
            pstmt.setString(2, objBean.getTxtAuthor());
            pstmt.setString(3, objBean.getTxtPublicationYear());
            pstmt.setString(4, objBean.getTaDescription());
            pstmt.setString(5, objBean.getTxtCategory());
            pstmt.setString(6, objBean.getTaTags());
            pstmt.setString(7, objBean.getTaBookUsedFor());
            pstmt.setString(8, objBean.getTxtUsageYear());
            pstmt.setString(9, objBean.getRbAccessType());
            pstmt.setString(10, objBean.getFlBook());
            pstmt.setString(11, objBean.getTxtuserId());
            pstmt.setInt(12, objBean.getFileSize());
            int i = pstmt.executeUpdate();
            System.out.println("addBookDetail : " + pstmt.toString());
            if (i > 0) {
                result = "Added";
            }
        } catch (Exception e) {
            System.out.println("Exception in addBookDetail : " + e);
        } 
        finally {
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