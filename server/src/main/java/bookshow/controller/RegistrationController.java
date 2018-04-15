package bookshow.controller;



import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookshow.domain.users.RatingType;
import bookshow.domain.users.Role;
import bookshow.domain.users.User;
import bookshow.service.UserService;

@RestController
public class RegistrationController {

	@Autowired
    private UserService UserService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		
		/*List<User> users = UserService.findAll();
		for(User u : users){
			System.out.println("------> " + u.getUsername() + " " + Boolean.toString(u.isActivated()));
		}*/
		
		User newUser = UserService.findByUsername(user.getUsername());
		User mailUser = UserService.findByEmail(user.getEmail());
		
		if(newUser != null){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		if(mailUser!=null) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		newUser = user;
		newUser.setActivated(false);
		newUser.setRole(Role.USER);

		newUser.setFriendList("");
		newUser.setIstorijaPoseta("");
		newUser.setFriendRequests("");
		newUser.setPendingRequests("");

		newUser.setPasswordHash(new BCryptPasswordEncoder().encode(user.getPasswordHash()));	
		newUser.setPoints((long) 0);
		newUser.setType(RatingType.DEFAULT);
		sendMail(newUser.getUsername(),newUser.getEmail());
		UserService.save(newUser);

		return new ResponseEntity<>(newUser,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/accountActivation/{username}", method = RequestMethod.GET)
	public ResponseEntity<User> activateUser(@PathVariable("username") String username) {
		User activatedUser = UserService.findByUsername(username);
		activatedUser.setActivated(true);
		UserService.save(activatedUser);
		return new ResponseEntity<>(activatedUser,HttpStatus.OK);
		
	}
	
	public void sendMail(String usernameToSend, String emailAdress){
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
}
