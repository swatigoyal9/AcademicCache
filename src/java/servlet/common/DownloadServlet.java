/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.common;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import services.user.BooksMaintenanceServices;
import services.user.MultimediaMaintenanceServices;
import services.user.SentShareRequestMaintenanceServices;

/**
 *
 * @author student
 */
@WebServlet(name = "DownloadServlet", urlPatterns = {"/DownloadServlet"})
public class DownloadServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        BufferedOutputStream bos = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        if(request.getParameter("bookId")!=null)
        {
            try 
            {
                int id = Integer.parseInt(request.getParameter("bookId"));
                BooksMaintenanceServices objBooksMaintenanceServices = new BooksMaintenanceServices();
                String path = objBooksMaintenanceServices.getPath(id);
                System.out.println(path + "path");
                File f = new File(path);
                System.out.println(f);
                fis = new FileInputStream(f);
                System.out.println("heii");
                bis = new BufferedInputStream(fis);
                bos = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/octet-stream");
                response.setContentLength(bis.available());
                response.addHeader("Content-Disposition", "attachment;filename=\"" + f.getName() + "\"");
                String str = response.getHeader("Content-Disposition");
                int count;
                int buffer_size = 4096;
                byte buffer[] = new byte[buffer_size];
                while ((count = bis.read(buffer, 0, buffer_size)) != -1) {
                    bos.write(buffer, 0, count);
                }
                bos.flush();
            } 
        
        catch (Exception e) {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.println(e);
        } finally {
            try {
                fis.close();
                bis.close();
                bos.close();

            } catch (Exception e) {
        }
    }     
    
}
        if(request.getParameter("multimediaId")!=null)
        {
            try 
            {
                int id = Integer.parseInt(request.getParameter("multimediaId"));
                MultimediaMaintenanceServices objMultimediaMaintenanceServices = new MultimediaMaintenanceServices();
                String path = objMultimediaMaintenanceServices.getPath(id);
                System.out.println(path + "path");
                File f = new File(path);
                System.out.println(f);
                fis = new FileInputStream(f);
                System.out.println("heii");
                bis = new BufferedInputStream(fis);
                bos = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/octet-stream");
                response.setContentLength(bis.available());
                response.addHeader("Content-Disposition", "attachment;filename=\"" + f.getName() + "\"");
                String str = response.getHeader("Content-Disposition");
                int count;
                int buffer_size = 4096;
                byte buffer[] = new byte[buffer_size];
                while ((count = bis.read(buffer, 0, buffer_size)) != -1) {
                    bos.write(buffer, 0, count);
                }
                bos.flush();
            } 
        
        catch (Exception e) {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.println(e);
        } finally {
            try {
                fis.close();
                bis.close();
                bos.close();

            } catch (Exception e) {
        }
    }     
    
}
        if(request.getParameter("id")!=null && request.getParameter("type").equalsIgnoreCase("Book"))
    {
         try 
            {
                int id = Integer.parseInt(request.getParameter("id"));
                SentShareRequestMaintenanceServices objSentShareRequestMaintenanceServices = new SentShareRequestMaintenanceServices();
                String path = objSentShareRequestMaintenanceServices.getBookPath(id);
                System.out.println(path + "path");
                File f = new File(path);
                System.out.println(f);
                fis = new FileInputStream(f);
                bis = new BufferedInputStream(fis);
                bos = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/octet-stream");
                response.setContentLength(bis.available());
                response.addHeader("Content-Disposition", "attachment;filename=\"" + f.getName() + "\"");
                String str = response.getHeader("Content-Disposition");
                int count;
                int buffer_size = 4096;
                byte buffer[] = new byte[buffer_size];
                while ((count = bis.read(buffer, 0, buffer_size)) != -1) {
                    bos.write(buffer, 0, count);
                }
                bos.flush();
            } 
        
        catch (Exception e) {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.println(e);
        } finally {
            try {
                fis.close();
                bis.close();
                bos.close();

            } catch (Exception e) {
        }
    }     
        
    }
        if(request.getParameter("id")!=null && request.getParameter("type").equalsIgnoreCase("WebLink"))
    {
         try 
            {
                int id = Integer.parseInt(request.getParameter("id"));
                
                SentShareRequestMaintenanceServices objSentShareRequestMaintenanceServices = new SentShareRequestMaintenanceServices();
                String path = objSentShareRequestMaintenanceServices.getWebLinkPath(id);
                System.out.println(path + "path");
                File f = new File(path);
                System.out.println(f);
                fis = new FileInputStream(f);
                bis = new BufferedInputStream(fis);
                bos = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/octet-stream");
                response.setContentLength(bis.available());
                response.addHeader("Content-Disposition", "attachment;filename=\"" + f.getName() + "\"");
                String str = response.getHeader("Content-Disposition");
                int count;
                int buffer_size = 4096;
                byte buffer[] = new byte[buffer_size];
                while ((count = bis.read(buffer, 0, buffer_size)) != -1) {
                    bos.write(buffer, 0, count);
                }
                bos.flush();
            } 
        
        catch (Exception e) {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.println(e);
        } finally {
            try {
                fis.close();
                bis.close();
                bos.close();

            } catch (Exception e) {
        }
    }     
        
    }
        if(request.getParameter("id")!=null && (request.getParameter("type").equalsIgnoreCase("Audio")||request.getParameter("type").equalsIgnoreCase("Video")))
    {
         try 
            {
                int id = Integer.parseInt(request.getParameter("id"));
                
                SentShareRequestMaintenanceServices objSentShareRequestMaintenanceServices = new SentShareRequestMaintenanceServices();
                String path = objSentShareRequestMaintenanceServices.getMultimediaPath(id);
                System.out.println(path + "path");
                File f = new File(path);
                System.out.println(f);
                fis = new FileInputStream(f);
                bis = new BufferedInputStream(fis);
                bos = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/octet-stream");
                response.setContentLength(bis.available());
                response.addHeader("Content-Disposition", "attachment;filename=\"" + f.getName() + "\"");
                String str = response.getHeader("Content-Disposition");
                int count;
                int buffer_size = 4096;
                byte buffer[] = new byte[buffer_size];
                while ((count = bis.read(buffer, 0, buffer_size)) != -1) {
                    bos.write(buffer, 0, count);
                }
                bos.flush();
            } 
        
        catch (Exception e) {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.println(e);
        } finally {
            try {
                fis.close();
                bis.close();
                bos.close();

            } catch (Exception e) {
        }
    }     
        
    }
    }
    
    
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("hello");
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("hello");
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
