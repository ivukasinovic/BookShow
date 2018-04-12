package bookshow.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookshow.domain.users.User;
import bookshow.service.UserService;

@RestController
public class FriendsController {

	@Autowired
	private UserService UserService;

	@RequestMapping(value = "/searchPeople/{usernamePart}/{namePart}/{surnamePart}", method = RequestMethod.GET)
	public ResponseEntity<List<User>> searchPeople(@PathVariable("usernamePart") String usernamePart,
			@PathVariable("namePart") String namePart, @PathVariable("surnamePart") String surnamePart) {
		/*
		System.out.println(usernamePart);
		System.out.println(namePart);
		System.out.println(surnamePart);*/
		
		List<User> lista = UserService.findAll();
		List<User> retVal = new ArrayList<User>();
		if(usernamePart.trim() != "") {
			for(User u : lista){
				if(u.getUsername().contains(usernamePart)) {
					retVal.add(u);
				}
			}
		}
		if(namePart.trim() != "") {
			for(User u : lista){
				if(u.getUsername().contains(namePart)) {
					retVal.add(u);
				}
			}
		}
		if(surnamePart.trim() != "") {
			for(User u : lista){
				if(u.getUsername().contains(surnamePart)) {
					retVal.add(u);
				}
			}
		}
		
		return new ResponseEntity<>(retVal,HttpStatus.OK);
	}

}
