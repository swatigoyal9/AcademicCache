package servlet.common;

import beans.user.AddEditNewBookBean;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import services.user.BooksMaintenanceServices;
import services.user.MultimediaMaintenanceServices;

@MultipartConfig
@WebServlet(name = "FileUploadServlet", urlPatterns = {"/FileUploadServlet"})
public class FileUploadServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        final String uploadDir = "D:\\Advance java\\Upload";

        if (request.getParameter("sbtnSave") != null) {
            try {

                String msg = null;
                boolean fileUploadFlag = false;
                Part filePart = request.getPart("flBook");
                System.out.println("filePart" + filePart);
                out.println(filePart);
                final String fileInfo = filePart.getHeader("content-disposition");
                out.println(fileInfo);
                final String fileName = getFileName(fileInfo);
                System.out.println("filePart" + fileName);
                final int fileSize = (int) filePart.getSize();
                if (fileName != null && !fileName.trim().isEmpty()) {
                    InputStream in = null;
                    FileOutputStream fos = null;
                    try {
                        in = filePart.getInputStream();
                        File f = new File(uploadDir + File.separator + fileName);
                        File parentFolder = f.getParentFile();
                        if (!parentFolder.isDirectory()) {
                            parentFolder.mkdirs();
                        }
                        if (f.isFile()) {
                            msg = "File Already Exists";
                        } else {

                            fos = new FileOutputStream(f);
                            final int buffer_size = 4096;
                            byte[] buffer = new byte[buffer_size];
                            int temp = 0;
                            while ((temp = in.read(buffer, 0, buffer_size)) != -1) {
                                fos.write(buffer, 0, temp);
                                fos.flush();
                            }

                            fileUploadFlag = true;
                        }
                    } catch (Exception e) {
                        msg = "File Not Uploaded";
                    } finally {
                        if (in != null) {
                            in.close();
                        }
                        if (fos != null) {
                            fos.close();
                        }
                    }

                } else {
                    msg = "Please Select File";
                }
                if (fileUploadFlag == true) {
                    HttpSession session = request.getSession();
                    String userId = (String) session.getAttribute("userId");
                    AddEditNewBookBean objBean = new AddEditNewBookBean();

                    objBean.setTxtuserId(userId);
                    objBean.setTxtTitle(request.getParameter("txtTitle"));
                    objBean.setTxtAuthor(request.getParameter("txtAuthor"));
                    objBean.setTxtPublicationYear(request.getParameter("txtPublicationYear"));
                    objBean.setTaDescription(request.getParameter("taDescription"));
                    objBean.setTxtCategory(request.getParameter("txtCategory"));
                    objBean.setTaTags(request.getParameter("taTags"));
                    objBean.setTaBookUsedFor(request.getParameter("taBookUsedFor"));
                    objBean.setTxtUsageYear(request.getParameter("txtUsageYear"));
                    objBean.setRbAccessType(request.getParameter("rbAccessType"));
                    objBean.setFileSize(fileSize);
                    objBean.setFlBook(uploadDir+File.separator+fileName);
                    BooksMaintenanceServices objBook = new BooksMaintenanceServices();
                    msg = objBook.addBookDetail(objBean);
                }
                
                System.out.println("msg = "+msg);
                response.sendRedirect("user/BooksMaintenance_mp.jsp?msg=" + msg);

            } finally {
                out.close();
            }
        }
       


}

    /**
     *
     * @param header
     * @return Name of File
     */
    private String getFileName(String header) {
        try {
            /*
             * split header by regex ; because Header contains three values
             * separated by ; & it contains form-data ,name,filename given as
             * below e.g. form-data; name="fl"; filename="abc.txt"
             *
             */
            String arrHeader[] = header.split(";");
            /**
             * fileName contains Name of file as given below
             * filename="manjeetSQLDump_11022012.sql" for actual file Name need
             * to substring fileName by finding first&Last Index of " (double
             * code) ASCII CODE of " (double code) is 34
             */
            String fileName = arrHeader[2].trim();
            fileName = fileName.substring(fileName.indexOf(34) + 1, fileName.lastIndexOf(34));
            return fileName;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
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
