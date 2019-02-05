/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services.common;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author student
 */
public class DBConnection {
     public static Connection connect(){
     Connection conn=null;
        try
     {
         
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql:///academiccache","root","");
     
     }
        catch(Exception e)
     {
         System.out.println(e);
     }
   return conn;
    }

   
    
}
