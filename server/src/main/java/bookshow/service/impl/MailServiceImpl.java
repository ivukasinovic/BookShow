package bookshow.service.impl;

import bookshow.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * Created by Ivan V. on 20-Apr-18
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendActivationMail(String usernameToSend, String emailAdress){
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
            String htmlMsg = "<h3>Aktiviranje naloga!</h3><br>"
                    + "<div>Dobrodosli "+usernameToSend+" na nas sajt <b>ISA projekta </b></div>"
                    + "<div>Kliknite <a href ="
                    + " \"http://localhost:4200/api/accountActivation/"+usernameToSend+"\">"
                    + "<u>ovde</u></a> kako biste aktivirali vas nalog.</div>";
            mimeMessage.setContent(htmlMsg, "text/html");
            helper.setTo(emailAdress);
            helper.setSubject("Automatski generisana poruka za aktiviranje naloga");
            mailSender.send(mimeMessage);
        } catch (Exception e) {
        }
    }
    public void sendNotification(String username, String email, String message){
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
            String htmlMsg = "<h3>Obavestenje za " + username +  "!</h3><br>"
                    + "<p>" + message +" </p>";
            mimeMessage.setContent(htmlMsg, "text/html");
            helper.setTo(email);
            helper.setSubject("(book-show) Obavestenje");
            mailSender.send(mimeMessage);
        } catch (Exception e) {
        }
    }
}
