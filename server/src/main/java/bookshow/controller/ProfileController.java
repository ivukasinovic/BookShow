package bookshow.controller;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookshow.domain.users.User;
import bookshow.model.ChangingPasswordDTO;
import bookshow.service.UserService;
import io.jsonwebtoken.lang.Collections;

@RestController
public class ProfileController {
	
	@Autowired
	 private UserService UserService;
	
	@RequestMapping(value = "/getProfileInfo/{username}", method = RequestMethod.GET)
	public ResponseEntity<User> getLoggedUserData(@PathVariable("username") String username) {
		return new ResponseEntity<>(UserService.findByUsername(username),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/changeCity/{username}/{newCity}", method = RequestMethod.GET)
	public ResponseEntity<User> changeCity(@PathVariable("username") String username,
											@PathVariable("newCity") String newCity) {
		User u = UserService.findByUsername(username);
		u.setCity(newCity);
		UserService.save(u);
		return new ResponseEntity<>(UserService.findByUsername(username),HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/changeEmail/{username}/{newEmail}", method = RequestMethod.GET)
	public ResponseEntity<User> changeEmail(@PathVariable("username") String username,
											@PathVariable("newEmail") String newEmail) {
		User u = UserService.findByUsername(username);
		u.setEmail(newEmail);
		UserService.save(u);
		return new ResponseEntity<>(UserService.findByUsername(username),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/changeName/{username}/{newName}", method = RequestMethod.GET)
	public ResponseEntity<User> changeName(@PathVariable("username") String username,
											@PathVariable("newName") String newName) {
		User u = UserService.findByUsername(username);
		u.setName(newName);
		UserService.save(u);
		return new ResponseEntity<>(UserService.findByUsername(username),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/changeNumber/{username}/{newNumber}", method = RequestMethod.GET)
	public ResponseEntity<User> changeNumber(@PathVariable("username") String username,
											@PathVariable("newNumber") String newNumber) {
		User u = UserService.findByUsername(username);
		u.setNumber(newNumber);
		UserService.save(u);
		return new ResponseEntity<>(UserService.findByUsername(username),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/changeSurname/{username}/{newSurname}", method = RequestMethod.GET)
	public ResponseEntity<User> changeSurname(@PathVariable("username") String username,
											@PathVariable("newSurname") String newSurname) {
		User u = UserService.findByUsername(username);
		u.setSurname(newSurname);
		UserService.save(u);
		return new ResponseEntity<>(UserService.findByUsername(username),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/changeUsername/{username}/{newUsername}", 
			method = RequestMethod.GET, consumes = "application/json")
	public ResponseEntity<User> changeUsername(@PathVariable("username") String username,
											@PathVariable("newUsername") String newUsername) {
		User u = UserService.findByUsername(username);
		u.setUsername(newUsername);
		UserService.save(u);
		return new ResponseEntity<>(UserService.findByUsername(username),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<User> changePassword(@RequestBody ChangingPasswordDTO cpDTO) {
		
		/*
		 * System.out.println(cpDTO.getUsername());
		 * System.out.println(cpDTO.getNewPassword());
		 */

		User u = UserService.findByUsername(cpDTO.getUsername());
		if (new BCryptPasswordEncoder().matches(cpDTO.getOldPassword(), u.getPasswordHash())) {
			//System.out.println("JEDNAKE SU SIFREEEEEEEE");
			u.setPasswordHash(new BCryptPasswordEncoder().encode(cpDTO.getNewPassword()));
			u.setLastPasswordReset(Calendar.getInstance().getTime());
			UserService.save(u);
			return new ResponseEntity<>(UserService.findByUsername(cpDTO.getUsername()), HttpStatus.OK);
		} else {
			//System.out.println("NISU JEDNAKEEEE");
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);

		}
	}
	
	@RequestMapping(value = "/addToHistory/{username}/{showName}", method = RequestMethod.GET)
	public ResponseEntity<User> addToHistory(@PathVariable("username") String username,
										@PathVariable("showName") String showName){
		User u = UserService.findByUsername(username);
		if(u.getIstorijaPoseta().contains(showName)) {
			u.getIstorijaPoseta().remove(showName);
			u.getIstorijaPoseta().add(0,showName);
			
		}else {
			u.getIstorijaPoseta().add(0,showName);
		}		
		for(String s : u.getIstorijaPoseta()){
			System.out.println(s);
		}
		
		UserService.save(u);
		return new ResponseEntity<>(UserService.findByUsername(username),HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/removeFromHistory/{username}/{showName}", method = RequestMethod.GET)
	public ResponseEntity<User> removeFromHistory(@PathVariable("username") String username,
			@PathVariable("showName") String showName){
		User u = UserService.findByUsername(username);
		u.getIstorijaPoseta().remove(showName);
		UserService.save(u);
		return new ResponseEntity<>(UserService.findByUsername(username),HttpStatus.OK);
		
	}


}
