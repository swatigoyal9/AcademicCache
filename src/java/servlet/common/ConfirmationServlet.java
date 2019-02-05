package servlet.common;

import beans.common.LoginBean;
import beans.common.SignUpBean;
import beans.user.SharedResourceMaintenanceBean;
import services.common.CommonServices;
import services.user.SharedResourceMaintenanceServices;
import email.SendSMTP;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ConfirmationServlet", urlPatterns = {"/ConfirmationServlet"})
public class ConfirmationServlet extends HttpServlet {

    LoginBean objBean,objBean1=null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
                if(request.getParameter("sbtnRegister")!=null)
                {
                        String email=request.getParameter("txtUsername");
                        String pwd=request.getParameter("txtPassword");
                        String confirmpwd=request.getParameter("txtConfirmPassword");
                        CommonServices objServices=new CommonServices();
                        String msg=objServices.emailchecking(email);
                            if(msg.equalsIgnoreCase("Email-Id already exists"))
                            {
                                response.sendRedirect("SignUp_mp.jsp?msg="+msg);
                            }
                            else
                            {    
                                    String Confirmation_Code=objServices.getRandomCode();
                                    String result=new SendSMTP().sendMail(email,"Confirmation Code","Your Confirmation Code is :"+Confirmation_Code);
                                    if(result.equals("sent"))
                                    {
                                         msg=objServices.signUpUser(email,pwd);
                                        if(msg.equals("Successfully Registered"))
                                         {      
                                            response.sendRedirect("Confirmation_mp.jsp?msg=Verfication Sent");
                                         }        
                                    }
                                    else
                                    {
                                            response.sendRedirect("Confirmation_mp.jsp?msg=Error in Sending Mail"+"&email="+request.getParameter("email"));
                                    }
                            }
                        
                        
                 }
                else if(request.getParameter("sbtnConfirmation")!=null)
                {
                    String un=request.getParameter("txtUsername");
                    CommonServices objServices=new CommonServices();
                  SignUpBean  objBean=new SignUpBean();
                    objBean=objServices.ConfirmationCode(un);
                    if(objBean!=null)
                    {
                        String result=new SendSMTP().sendMail(objBean.getTxtUsername(),"Confirmation Code","Your Confirmation Code is :"+objBean.getTxtConfirmationCode());
                        if(result.equals("sent"))
                        {
                            response.sendRedirect("BlockedConfirmation_mp.jsp?msg=Verfication Sent");
                        }
                        else
                        {
                           response.sendRedirect("BlockedConfirmation_mp.jsp?msg=Error in Sending Mail"+"&email="+un); 
                        }
                    }
                }
                 else if( request.getParameter("blocked_email")!=null)
                {
                    String un=request.getParameter("blocked_email");
                    CommonServices objServices=new CommonServices();
                    SignUpBean objBean=new SignUpBean();
                    objBean=objServices.ConfirmationCode(un);
                    if(objBean!=null)
                    {
                        String result=new SendSMTP().sendMail(objBean.getTxtUsername(),"Confirmation Code","Your Confirmation Code is :"+objBean.getTxtConfirmationCode());
                        if(result.equals("sent"))
                        {
                            response.sendRedirect("BlockedConfirmation_mp.jsp?msg=Verfication Sent");
                        }
                        else
                        {
                           response.sendRedirect("BlockedConfirmation_mp.jsp?msg=Error in Sending Mail"+"&email="+un); 
                        }
                    }
                }
               
                
                else if(request.getParameter("sbtnShare")!=null)
                {
                    SharedResourceMaintenanceBean  objBean=new SharedResourceMaintenanceBean();
                    objBean.setComment(request.getParameter("taComment"));
                    objBean.setEmails_shared_with(request.getParameter("taEmailId"));
                    objBean.setTitle(request.getParameter("txtTitle"));
                    objBean.setType(request.getParameter("type"));
                    objBean.setUser_id(request.getParameter("uid"));
                    objBean.setResourceId(request.getParameter("id"));
                    objBean.setId(request.getParameter("id"));
                    System.out.println(objBean.getResourceId()+"iddd11");
                    SharedResourceMaintenanceServices objServices=new SharedResourceMaintenanceServices();
                   SharedResourceMaintenanceBean shareBean=new SharedResourceMaintenanceBean();
                    shareBean=objServices.sharedResources(objBean);
                    if(objBean!=null)
                    {
                        String path=null;
                        String message=null;
                        if(objBean.getType().equalsIgnoreCase("web"))
                        {   
                         path="http://localhost:8091/AcademicCache/Download_mp.jsp?sh_code="+shareBean.getShare_code();
                         message = "<html>" +
                            "<head><title></title></head>" +
                            "<body>" +
                            "Click here :&nbsp;<a href=\"" + path + "\">"+path+"</a> " +
                            "</body>" +
                            "</html>";
                        }
                        else
                        {
                          path=shareBean.getUpload_path();
                            message = "<html>" +
                            "<head><title></title></head>" +
                            "<body>" +
                            "Click here :&nbsp;<a href=\"" + path + "\">"+path+"</a> " +
                            "</body>" +
                            "</html>";
                        } 
                    System.out.println(shareBean.getEmails_shared_with());
                        String result=new SendSMTP().sendMail(shareBean.getEmails_shared_with(),"Requested Download Link","Your Download Link:");
                        if(result.equals("sent"))
                        {
                            response.sendRedirect("user/Home_mp.jsp?msg=Mail Sent");
                        }
                        else
                        {
                           response.sendRedirect("user/Home_mp.jsp?msg=Error in Sending Mail"); 
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