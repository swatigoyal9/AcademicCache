package services.admin;

import beans.admin.AddEditPlansAdminBean;
import beans.admin.ManageEmployeeBean;
import beans.admin.ManagePlansAdminBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import services.common.DBConnection;

public class ManagePlansAdminServices {

public List getAllManagePlansAdmin(){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    List listUser = null;
    ManagePlansAdminBean objManagePlansAdminBean=null;
    try{
        conn=(Connection) DBConnection.connect();
        listUser=new ArrayList();
        pstmt=(PreparedStatement) conn.prepareStatement("select * from planmaster");
        rs=pstmt.executeQuery();
        while(rs.next())
        {
            objManagePlansAdminBean=new ManagePlansAdminBean();
            objManagePlansAdminBean.setCost(rs.getString("cost"));
            objManagePlansAdminBean.setStatus(rs.getString("status"));
            objManagePlansAdminBean.setValidity_months(rs.getString("validity_months"));
            objManagePlansAdminBean.setSpace_allowed(rs.getString("space_allowed"));
            objManagePlansAdminBean.setPlan_name(rs.getString("plan_name"));
            objManagePlansAdminBean.setPlan_id(rs.getString("plan_id"));
            objManagePlansAdminBean.setCreation_date(rs.getString("creation_date"));
            listUser.add(objManagePlansAdminBean);
        }
    }
    catch(Exception e)
    {
        System.out.println("Exception occur  at getAllManagePlansAdmin"+e);
    }
    finally{
        try{
            rs.close();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println("Exception occur  at getAllManagePlansAdmin"+e);
        }
    }
    System.out.println(listUser.size());
        
        return listUser;
}  
    public String addNewPlan(AddEditPlansAdminBean  objBean) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pstmt = null;
        
        String result = "failed";
        try {
            conn = DBConnection.connect();
            

                pstmt = conn.prepareStatement("insert into planmaster(Plan_Name ,Space_Allowed, Cost, Validity_Months, Status, Creation_Date) values(?,?,?,?,?,sysdate())");
                //pstmt.setString(1, objBean.getTxtUserId());
                pstmt.setString(1, objBean.getTxtPlanName());
                pstmt.setString(2, objBean.getTxtSpaceAllowed());
                pstmt.setString(3, objBean.getTxtCost());
                pstmt.setString(4, objBean.getTxtValidity());
                pstmt.setString(5, objBean.getRbStatus());
                System.out.println(pstmt.toString());
                int i = pstmt.executeUpdate();
                if (i > 0) {
                    result = "added";
                }
            
        } catch (Exception e) {
            System.out.println("addNewPlan(ManagePlansAdminBean objBean) of common services : " + e);
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
                System.out.println("addNewPlan(ManagePlansAdminBean objBean) of DBoperations : " + e);
            }
        }
        return result;
    }
    public String activeInactivatePlan(int id, String status)
{
     Connection conn=null;
    PreparedStatement pstmt=null;
    AddEditPlansAdminBean objAddEditPlansAdminBean=null;
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
        pstmt=(PreparedStatement) conn.prepareStatement("update planmaster set status=? where plan_id=?");
        System.out.println(pstmt.toString());
        pstmt.setString(1,msg1);
        pstmt.setInt(2,id);
        System.out.println(pstmt.toString());
        int i=pstmt.executeUpdate();
        System.out.println(pstmt.toString());
        if(i>0)
        {
            msg="Record Updated";
        }
        }
    
    catch(Exception e){
        System.out.println("Exception occur at activeInactivatePlan(int id,String status)"+e);
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
    public AddEditPlansAdminBean getPlanDetailById(int id){
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    AddEditPlansAdminBean objAddEditPlansAdminBean=null;
    try{
        conn=(Connection) DBConnection.connect();
        pstmt=(PreparedStatement) conn.prepareStatement("select plan_id,plan_name,space_allowed,cost,validity_months,status from planmaster where plan_id=?");
        pstmt.setInt(1, id);
        rs=pstmt.executeQuery();
        if(rs.next()){
            objAddEditPlansAdminBean=new AddEditPlansAdminBean();
            objAddEditPlansAdminBean.setPlan_id(String.valueOf(rs.getInt("plan_id")));
            objAddEditPlansAdminBean.setTxtPlanName(rs.getString("plan_name"));
            objAddEditPlansAdminBean.setTxtSpaceAllowed(rs.getString("space_allowed"));
            objAddEditPlansAdminBean.setTxtCost(rs.getString("cost"));
            objAddEditPlansAdminBean.setTxtValidity(rs.getString("validity_months"));
            objAddEditPlansAdminBean.setRbStatus(rs.getString("status"));
            
            
            }
        System.out.println(pstmt.toString());
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
    return objAddEditPlansAdminBean;
}
    public List getPlanDetailByName(String name){
        java.sql.Connection conn = null;
        List lstUser = null;
        java.sql.PreparedStatement pstmt = null;
        ResultSet rs = null;
        ManagePlansAdminBean objManagePlansAdminBean=null;
        try {
            lstUser=new ArrayList();
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select plan_id,plan_name,space_allowed,cost,validity_months,status from planmaster where plan_name=?");
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                objManagePlansAdminBean=new ManagePlansAdminBean();
            objManagePlansAdminBean.setPlan_id(String.valueOf(rs.getInt("plan_id")));
            objManagePlansAdminBean.setPlan_name(rs.getString("plan_name"));
            objManagePlansAdminBean.setSpace_allowed(rs.getString("space_allowed"));
            objManagePlansAdminBean.setCost(rs.getString("cost"));
            objManagePlansAdminBean.setValidity_months(rs.getString("validity_months"));
            objManagePlansAdminBean.setStatus(rs.getString("status"));
                   lstUser.add(objManagePlansAdminBean);
                   System.out.println(rs.getString("status"));
                   System.out.println(pstmt.toString());
            }
        } 
        catch (Exception e) 
        {
            System.out.println("getPlanDetailByName(String name)  of commonservices : " + e);
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
                System.out.println("getPlanDetailByName(String name) of commonservices : " + e);
            }
        }
        return lstUser;
}
}

