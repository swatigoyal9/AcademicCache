/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package properties;

import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author sumit
 */
public class ReadFromProperties {

    Properties p = null;
    InputStream is = null;

    public ReadFromProperties() {
        try {
            p = new Properties();
            is = getClass().getResourceAsStream("RootProperties.properties");
        } catch (Exception e) {
            System.out.println("in constructor of ReadFromProperties: " + e);
        }
    }

    public String getbookPath() {
        String path = null;
        try {
            p.load(is);
            path = p.getProperty("book_path");
        } catch (Exception e) {
            System.out.println(e);
        }
        return path;
    }
    
    public String getDownloadBookPath() {
        String path = null;
        try {
            p.load(is);
            path = p.getProperty("download_book_path");
        } catch (Exception e) {
            System.out.println(e);
        }
        return path;
    }
     public String getDownloadMultimediaPath() {
        String path = null;
        try {
            p.load(is);
            path = p.getProperty("download_multimedia_path");
        } catch (Exception e) {
            System.out.println(e);
        }
        return path;
    }
public String getDownloadReportAbusePath() {
        String path = null;
        try {
            p.load(is);
            path = p.getProperty("download_report_abuse_path");
        } catch (Exception e) {
            System.out.println(e);
        }
        return path;
    }
     public String getreportabusePath() {
        String path = null;
        try {
            p.load(is);
            path = p.getProperty("report_abuse_path");
        } catch (Exception e) {
            System.out.println(e);
        }
        return path;
    }

      public String getmultimediaPath() {
        String path = null;
        try {
            p.load(is);
            path = p.getProperty("multimedia_path");
        } catch (Exception e) {
            System.out.println(e);
        }
        return path;
    }


    public String getEmailId() {
        String emailid = null;
        try {
            p.load(is);
            emailid = p.getProperty("emailid");
        } catch (Exception e) {
            System.out.println("in getEmailId of ReadFromProperties: " + e);
        }
        return emailid;
    }

    public String getPassword() {
        String password = null;
        try {
            p.load(is);
            password = p.getProperty("password");
        } catch (Exception e) {
            System.out.println("in getPassword of ReadFromProperties: " + e);
        }
        return password;
    }
}
