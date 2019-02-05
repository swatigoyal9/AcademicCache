

package email;

import java.util.Properties;
import java.util.Date;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendSMTP {

    String result = "failed";

    public String sendMail(String toEmailId, String subject,String text) {
        try {

//--[ Set up the default parameters
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.transport.protocol", "smtp");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", "587");
            p.put("mail.smtp.starttls.enable", "true");

//--[ Create the session and create a new mail message
            Authenticator auth = new SMTPAuthenticator("kainth786cu@gmail.com","rinki428cu");
            Session mailSession = Session.getInstance(p, auth);
            Message msg = new MimeMessage(mailSession);

//--[ Set the FROM, TO, DATE and SUBJECT fields
            msg.setFrom(new InternetAddress("kainth786cu@gmail.com"));
            String rec[] = toEmailId.split(";");


            int count = 1;
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(rec[0]));
            while (count < rec.length) {
                msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(rec[count]));
                count++;
            }

            msg.setSentDate(new Date());
            msg.setSubject(subject);

//--[ Create the body of the mail
            msg.setText(text);
            
            msg.setContent(text,"text/html");
//msg.addHeader("Content-type", "text/html; charset=UTF-8");
//--[ Ask the Transport class to send our mail message

            Transport trans = mailSession.getTransport();

            trans.connect();
            Address[] ad = msg.getAllRecipients();
            for (int i = 0; i < ad.length; i++) {

                try {
                    Address[] ad1 = new Address[1];
                    ad1[0] = ad[i];

                    trans.sendMessage(msg, ad1);
                    result = "sent";

                } catch (Exception e) {
                    continue;
                }
            }

        } catch (Exception E) {
            System.out.println("Something gone wrong while sending mail!");
            E.printStackTrace();
            return result;
        }

        return result;
    }
}