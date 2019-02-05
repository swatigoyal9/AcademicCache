/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.common;

import beans.common.LoginBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.common.CommonServices;

/**
 *
 * @author Aparchyanta
 */
@WebServlet(name = "ForgetPasswordServlet", urlPatterns = {"/ForgetPasswordServlet"})
public class ForgetPasswordServlet extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           //HttpSession session=request.getSession();
           CommonServices objCommonServices=new CommonServices();
           LoginBean objLoginBean=null;
           if(request.getParameter("sbtnSubmit")!=null)
           {
               String userName=request.getParameter("txtUsername");
               
               objLoginBean=objCommonServices.recoverPassword(userName);
               response.sendRedirect("ForgotPassword_mp.jsp");
           }
        }
        finally {            
            out.close();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
}
