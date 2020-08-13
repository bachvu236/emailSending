package Application.service.impl;

import Application.service.EmailService;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

@Component
public class EmailServiceImpl implements EmailService {
    @Override
    public void sendEmail() {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new javax.mail.Authenticator()
                    {
                        //sender email
                        protected PasswordAuthentication getPasswordAuthentication(){
                            return new PasswordAuthentication("1611060166@hunre.edu.vn","23/06/1998");
                        }
                    }
            );
            //This is receiver email
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("trananhbac4897@gmail.com",false));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("trananhbac4897@gmail.com"));
            msg.setSubject("[Vũ Xuân Bách] This is a sending email test");
            msg.setSentDate(new Date());
            //Content part
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent("Dear Mr Bach," +
                    "This is sending email test ","text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            //Attach file
            MimeBodyPart attachPart = new MimeBodyPart();
            attachPart.attachFile("C:\\Users\\vxbach\\Documents\\TMS\\SRS-TMS.docx");
            multipart.addBodyPart(attachPart);
            msg.setContent(multipart);
            Transport.send(msg);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
