/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services.user;

import beans.user.CitymasterBean;
import beans.user.CountrymasterBean;
import beans.user.StatemasterBean;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import services.common.DBConnection;
public class CSCServices {
    
    public List getAllStateByCountryId(int countryId)
{
    java.sql.Connection conn=null;
    java.sql.PreparedStatement pstmt=null;
    ResultSet rs=null;
    StatemasterBean objstatemasterBean=null;
    List lststate=null;
    try
    {
        lststate=new ArrayList<StatemasterBean> ();
        conn=DBConnection.connect();
        pstmt=conn.prepareStatement("select * from statemaster where country_id=?");
        pstmt.setInt(1, countryId);
        rs=pstmt.executeQuery();
        System.out.println(pstmt.toString());
        while(rs.next())
        {
            objstatemasterBean=new StatemasterBean();
            objstatemasterBean.setState_id(String.valueOf(rs.getInt("state_id")));
            objstatemasterBean.setState_name(rs.getString("state_name"));
           lststate.add(objstatemasterBean);
            
        }
        
    }
    catch(Exception e)
    {
        System.out.println("error"+e);
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
               System.out.println("heloo"+e);
           }
       }
        
    return lststate;
    
}


public List getAllCityByStateId(int stateId)
{
    java.sql.Connection conn=null;
    java.sql.PreparedStatement pstmt=null;
    ResultSet rs=null;
    CitymasterBean objcitymasterBean=null;
    List lstcity=null;
    try
    {
        lstcity=new ArrayList<CitymasterBean> ();
        conn=DBConnection.connect();
        pstmt=conn.prepareStatement("select * from citymaster where state_id=?");
        pstmt.setInt(1, stateId);
        rs=pstmt.executeQuery();
        System.out.println(pstmt.toString());
        while(rs.next())
        {
            objcitymasterBean=new CitymasterBean();
            objcitymasterBean.setCity_id(String.valueOf(rs.getInt("city_id")));
            objcitymasterBean.setCity_name(rs.getString("city_name"));
           lstcity.add(objcitymasterBean);
            
        }
        
    }
    catch(Exception e)
    {
        System.out.println("error"+e);
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
               System.out.println("heloo"+e);
           }
       }
        
    return lstcity;
    
}
public List getAllCountry()
{
    java.sql.Connection conn=null;
    java.sql.PreparedStatement pstmt=null;
    ResultSet rs=null;
    CountrymasterBean objcountrymasterBean=null;
    List lstcountry=null;
    try
    {
        lstcountry=new ArrayList<CountrymasterBean> ();
        conn=DBConnection.connect();
        pstmt=conn.prepareStatement("select * from countrymaster");
        rs=pstmt.executeQuery();
        System.out.println(pstmt.toString());
        while(rs.next())
        {
            objcountrymasterBean=new CountrymasterBean();
            objcountrymasterBean.setCountry_id(String.valueOf(rs.getInt("country_id")));
            objcountrymasterBean.setCountry_name(rs.getString("country_name"));
            lstcountry.add(objcountrymasterBean);
            
        }
        
    }
    catch(Exception e)
    {
        System.out.println("error"+e);
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
               System.out.println("heloo"+e);
           }
       }
        
    return lstcountry;
    
}



}
