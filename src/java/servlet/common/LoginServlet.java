/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.common;

import beans.common.LoginAdminBean;
import beans.common.LoginBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.common.CommonServices;

/**
 *
 * @author student
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           HttpSession session=request.getSession();
           CommonServices objCommonServices=new CommonServices();
           LoginBean objLoginBean=null;
           LoginAdminBean objLoginAdminBean=null;
           RequestDispatcher rd=null;
           if(request.getParameter("sbtnLogin")!=null)
           {
               String userName=request.getParameter("txtUsername");
               String password=request.getParameter("txtPassword");
               objLoginBean=objCommonServices.authUser(userName, password);
               if(objLoginBean==null)
               {
                       
                       out.println("<p align=\"right\"  style=\"color:red\">Invalid Username and password</p>");
                    rd=request.getRequestDispatcher("Login_mp.jsp?msg=Invalid Username / Password");
                    rd.include(request, response);
                   
               }
               else
               {
                   if(objLoginBean.getUser_status().equalsIgnoreCase("inactive"))
                   {
                       out.println("<p align=\"right\"  style=\"color:red\">User Blocked By Admin</p>");
                    rd=request.getRequestDispatcher("Login_mp.jsp?msg=User Blocked By Admin");
                    rd.include(request, response);
                   }
                   else
                   {
                       session.setAttribute("userName", objLoginBean.getUsername());
                       session.setAttribute("userId", objLoginBean.getUser_id());
                       response.sendRedirect("user/Home_mp.jsp");
                       
                   }
               }   
           }
           if(request.getParameter("sbtnLoginAdmin")!=null)
           {
               String userName=request.getParameter("txtUsername");
               String password=request.getParameter("txtPassword");
               objLoginAdminBean=objCommonServices.authAdmin(userName, password);
               if(objLoginAdminBean==null)
               {
                        out.println("<p align=\"right\"  style=\"color:red\">Invalid Username and password</p>");
                    rd=request.getRequestDispatcher("LoginAdmin_mp.jsp?msg=Invalid Username / Password");
                    rd.include(request, response);
                   
               }
               else
               {
                   if(objLoginAdminBean.getUser_status().equalsIgnoreCase("inactive"))
                   {
                       
                       
                       out.println("<p align=\"right\"  style=\"color:red\">User Blocked By Admin</p>");
                    rd=request.getRequestDispatcher("LoginAdmin_mp.jsp?msg=User Blocked By Admin");
                    rd.include(request, response);
                   }
                   else
                   {
               System.out.println("hiii");
                       System.out.println("hello");
                       session.setAttribute("adminUserName", objLoginAdminBean.getUsername());
                       session.setAttribute("employeeId", objLoginAdminBean.getEmployee_id());
                       response.sendRedirect("admin/HomeAdmin_mp.jsp");
                       
                   }
               }
               
           }
        }
        finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
