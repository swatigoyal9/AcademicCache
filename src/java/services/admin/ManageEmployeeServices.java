package services.admin;

import beans.admin.AddEditEmployeeBean;
import beans.admin.ManageEmployeeBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import services.common.DBConnection;

public class ManageEmployeeServices {
public List getAllManageEmployee(){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    List listUser = null;
    ManageEmployeeBean objManageEmployeeBean=null;
    try{
        conn=(Connection) DBConnection.connect();
        listUser=new ArrayList();
        pstmt=(PreparedStatement) conn.prepareStatement("select * from employeemaster");
        rs=pstmt.executeQuery();
        while(rs.next())
        {
            objManageEmployeeBean=new ManageEmployeeBean();
            objManageEmployeeBean.setEmployee_id(rs.getString("employee_id"));
            objManageEmployeeBean.setName(rs.getString("name"));
            objManageEmployeeBean.setEmail(rs.getString("email"));
            objManageEmployeeBean.setContact_number(rs.getString("contact_number"));
            objManageEmployeeBean.setUser_type(rs.getString("user_type"));
            objManageEmployeeBean.setUser_status(rs.getString("user_status"));
            objManageEmployeeBean.setCreate_date(rs.getString("create_date"));
            objManageEmployeeBean.setDoj(rs.getString("doj"));
            objManageEmployeeBean.setGender(rs.getString("gender"));
            objManageEmployeeBean.setPassword(rs.getString("password"));
            objManageEmployeeBean.setUsername(rs.getString("username"));
            listUser.add(objManageEmployeeBean);
        }
    }
    catch(Exception e)
    {
        System.out.println("Exception occur  at getAllManageEmployee"+e);
    }
    finally{
        try{
            rs.close();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println("Exception occur  at getAllManageEmployee"+e);
        }
    }
    System.out.println(listUser.size());
        return listUser;
}  
public String addEmployee(AddEditEmployeeBean objBean){
    Connection conn=null;
    String msg="Failed";
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    List listUser=null;
    AddEditEmployeeBean objAddEditEmployeeBean=null;
    try{
        conn=(Connection) DBConnection.connect();
        listUser=new ArrayList();
        pstmt=(PreparedStatement) conn.prepareStatement("insert into employeemaster (username,password,name,user_status,user_type,contact_number,email,doj,gender,create_date) values (?,?,?,?,?,?,?,?,?,sysdate())");
        pstmt.setString(1,objBean.getTxtUsername());
        pstmt.setString(2,objBean.getTxtPassword());
        pstmt.setString(3,objBean.getTxtName());
        pstmt.setString(4,objBean.getRbStatus());
        pstmt.setString(5,objBean.getDdlUserType());
        pstmt.setString(6,objBean.getTxtContact());
        pstmt.setString(7,objBean.getTxtEmail());
        pstmt.setString(8,objBean.getTxtDateOfJoining());
        pstmt.setString(9,objBean.getRbGender());
        int i=pstmt.executeUpdate();
        if(i>0){
            msg="Record Added";
        }
            
    }
    catch(Exception e){
        System.out.println("Exception at AddRecords"+e);
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
public AddEditEmployeeBean getEmployeeDetailById(int id){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    AddEditEmployeeBean objAddEditEmployeeBean=null;
    try{
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("select * from employeemaster where employee_id=?");
        pstmt.setInt(1, id);
        rs=pstmt.executeQuery();
        if(rs.next()){
            objAddEditEmployeeBean=new AddEditEmployeeBean();
            objAddEditEmployeeBean.setTxtEmployeeId(String.valueOf(rs.getInt("employee_id")));
            objAddEditEmployeeBean.setDdlUserType(rs.getString("user_type"));
            objAddEditEmployeeBean.setRbGender(rs.getString("gender"));
            objAddEditEmployeeBean.setRbStatus(rs.getString("user_status"));
            objAddEditEmployeeBean.setTxtContact(rs.getString("contact_number"));
            objAddEditEmployeeBean.setTxtDateOfJoining(rs.getString("doj"));
            objAddEditEmployeeBean.setTxtEmail(rs.getString("email"));
            System.out.println(rs.getString("name"));
            objAddEditEmployeeBean.setTxtName(rs.getString("name"));
            objAddEditEmployeeBean.setTxtUsername(rs.getString("username"));
            System.out.println(rs.getString("username"));
            
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
    return objAddEditEmployeeBean;
}

public String updateEmployeeRecord(AddEditEmployeeBean objBean){
    Connection conn=null;
    PreparedStatement pstmt=null;
    AddEditEmployeeBean objAddEditEmployeeBean=null;
   // List list=null;
    String msg="Failed";
    try{
       // list=new ArrayList();
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("update employeemaster set username=?,gender=?,contact_number=?,name=?,doj=?,user_type=?,user_status=?,email=? where employee_id=?");
        pstmt.setString(1,objBean.getTxtUsername());
        pstmt.setString(2,objBean.getRbGender());
        pstmt.setString(3,objBean.getTxtContact());
        pstmt.setString(4,objBean.getTxtName());
        pstmt.setString(5,objBean.getTxtDateOfJoining());
        pstmt.setString(6,objBean.getDdlUserType());
        pstmt.setString(7,objBean.getRbStatus());
       pstmt.setString(8, objBean.getTxtEmail());
       pstmt.setString(9, objBean.getTxtEmployeeId());
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
public String activeInactivateEmployee(int id,String status)
{
     Connection conn=null;
    PreparedStatement pstmt=null;
    AddEditEmployeeBean objAddEditEmployeeBean=null;
    String msg="Failed";
    String msg1=null;
    try{
        conn=(Connection) DBConnection.connect();
        if(status.equalsIgnoreCase("Active"))
        {
            msg1="Inactive";
        }
        else{
            msg1="Active";
        }
        pstmt=(PreparedStatement) conn.prepareStatement("update employeemaster set user_status=? where employee_id=?");
        pstmt.setString(1,msg1);
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
public List getEmployeeDetailByName(String name){
        java.sql.Connection conn = null;
        List lstUser = null;
        java.sql.PreparedStatement pstmt = null;
        ResultSet rs = null;
        ManageEmployeeBean objManageEmployeeBean=null;
        try {
            lstUser=new ArrayList();
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select employee_id,username,password,user_type,user_status,name, gender, contact_number, email, DOJ from employeemaster where name=?");
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                objManageEmployeeBean=new ManageEmployeeBean();
            objManageEmployeeBean.setEmployee_id(String.valueOf(rs.getInt("employee_id")));
            objManageEmployeeBean.setUsername(rs.getString("username"));
            objManageEmployeeBean.setPassword(rs.getString("password"));
            objManageEmployeeBean.setUser_type(rs.getString("user_type"));
            objManageEmployeeBean.setUser_status(rs.getString("user_status"));
            objManageEmployeeBean.setName(rs.getString("name"));
            objManageEmployeeBean.setGender(rs.getString("gender"));
            objManageEmployeeBean.setContact_number(rs.getString("contact_number"));
            objManageEmployeeBean.setEmail(rs.getString("email"));
            objManageEmployeeBean.setDoj(rs.getString("DOJ"));
            
                   lstUser.add(objManageEmployeeBean);
                   System.out.println(rs.getString("status"));
                   System.out.println(pstmt.toString());
            }
        } 
        catch (Exception e) 
        {
            System.out.println("getEmployeeDetailByName(String name)  of commonservices : " + e);
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

}
