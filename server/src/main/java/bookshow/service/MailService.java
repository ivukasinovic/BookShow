package bookshow.service;

/**
 * Created by Ivan V. on 20-Apr-18
 */
public interface MailService {

    void sendActivationMail(String usernameToSend, String emailAdress);

    void sendNotification(String username, String email, String message);
}
