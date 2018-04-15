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
import bookshow.model.ArrayListDatabaseHandler;
import bookshow.service.UserService;

@RestController
public class FriendsController {

	@Autowired
	private UserService UserService;
	private ArrayListDatabaseHandler handler;

	@RequestMapping(value = "/searchPeople/{usernamePart}/{namePart}/{surnamePart}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<String>> searchPeople(@PathVariable("usernamePart") String usernamePart,
			@PathVariable("namePart") String namePart, @PathVariable("surnamePart") String surnamePart) {
		
		List<User> lista = UserService.findAll();
		ArrayList<String> retVal = new ArrayList<String>();
		
		for(User u : lista) {
			if(u.getUsername().toLowerCase().contains(usernamePart.toLowerCase().trim())
					&& u.getName().toLowerCase().contains(namePart.toLowerCase().trim())
					&& u.getSurname().toLowerCase().contains(surnamePart.toLowerCase().trim())){
				retVal.add(u.getUsername());
			}
		}
		
		return new ResponseEntity<>(retVal,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/checkFriendship/{username}/{korisnik}",
					method = RequestMethod.GET)
	public boolean checkFriendship(@PathVariable("username") String username,
								  @PathVariable("korisnik") String korisnik) {
		User u = UserService.findByUsername(username);
		ArrayList<String> lista = new ArrayList<String>();
		handler = new ArrayListDatabaseHandler();
		lista = handler.StringToArrayList(u.getFriendList());
		if(lista.contains(korisnik)) {
			return true;
		}	
		return false;
		
	}
	
	
	@RequestMapping(value = "/sendRequest/{username}/{korisnik}",
	method = RequestMethod.GET)
	public ResponseEntity<User> sendRequest(@PathVariable("username") String username,
											@PathVariable("korisnik") String korisnik){
		
		//prvi je poslao drugom zahtev
		//prvi dobija u pending drugog
		//drugi dobija u requests prvog
		
		User prvi  = UserService.findByUsername(username);
		User drugi = UserService.findByUsername(korisnik);
		
		handler = new ArrayListDatabaseHandler();
		
		ArrayList<String> listaPrvog = new ArrayList<String>();
		ArrayList<String> listaDrugog = new ArrayList<String>();
		
		listaPrvog = handler.StringToArrayList(prvi.getPendingRequests());
		listaDrugog = handler.StringToArrayList(drugi.getFriendRequests());
		
		listaPrvog.add(korisnik);
		listaDrugog.add(username);
		
		prvi.setPendingRequests(handler.ArrayListToString(listaPrvog));
		drugi.setFriendRequests(handler.ArrayListToString(listaDrugog));
		
		UserService.save(prvi);
		UserService.save(drugi);
		return new ResponseEntity<>(prvi,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/checkPadding/{username}/{korisnik}", method = RequestMethod.GET)
	public boolean checkPadding(@PathVariable("username") String username, @PathVariable("korisnik") String korisnik) {
		User u = UserService.findByUsername(username);
		ArrayList<String> lista = new ArrayList<String>();
		handler = new ArrayListDatabaseHandler();
		lista = handler.StringToArrayList(u.getPendingRequests());
		if (lista.contains(korisnik)) {
			return true;
		}
		return false;
	}
	
	@RequestMapping(value = "/checkRequested/{username}/{korisnik}", method = RequestMethod.GET)
	public boolean checkRequested(@PathVariable("username") String username, @PathVariable("korisnik") String korisnik) {
		User u = UserService.findByUsername(username);
		ArrayList<String> lista = new ArrayList<String>();
		handler = new ArrayListDatabaseHandler();
		lista = handler.StringToArrayList(u.getFriendRequests());
		if (lista.contains(korisnik)) {
			return true;
		}
		return false;
	}

	@RequestMapping(value = "/confirmRequest/{username}/{korisnik}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<User>> confirmRequest(@PathVariable("username") String username, @PathVariable("korisnik") String korisnik) {
		handler = new ArrayListDatabaseHandler();
		//	scenario : prvi prihvata zahtev koji mu je poslao drugi
		//	iz liste zahteva prvog se uklanja drugi
		//	iz liste pendinga drugog se uklanja prvi
		//	prvom se dodaje drugi u listu prijatelja i obrnuto
		
		User prvi  = UserService.findByUsername(username);
		User drugi = UserService.findByUsername(korisnik);
		
		handler = new ArrayListDatabaseHandler();
		
		ArrayList<String> listaPrvog = new ArrayList<String>();
		ArrayList<String> listaDrugog = new ArrayList<String>();
		
		listaPrvog  = handler.StringToArrayList(prvi.getFriendRequests());
		listaDrugog = handler.StringToArrayList(drugi.getPendingRequests());
		
		listaPrvog.remove(drugi.getUsername());
		listaDrugog.remove(prvi.getUsername());
		
		prvi.setFriendRequests(handler.ArrayListToString(listaPrvog));
		drugi.setPendingRequests(handler.ArrayListToString(listaDrugog));
		
		ArrayList<String> listaPrijateljaPrvog = new ArrayList<String>();
		ArrayList<String> listaPrijateljaDrugog = new ArrayList<String>();
				
		listaPrijateljaPrvog = handler.StringToArrayList(prvi.getFriendList());
		listaPrijateljaDrugog = handler.StringToArrayList(drugi.getFriendList());
		
		listaPrijateljaPrvog.add(korisnik);
		listaPrijateljaDrugog.add(username);
		
		prvi.setFriendList(handler.ArrayListToString(listaPrijateljaPrvog));
		drugi.setFriendList(handler.ArrayListToString(listaPrijateljaDrugog));
		
		UserService.save(prvi);
		UserService.save(drugi);
		
		ArrayList<User> retVal = new ArrayList<User>();
		for(String s : listaPrvog){
			retVal.add(UserService.findByUsername(s));
		}
		
		return new ResponseEntity<>(retVal,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/removeFriend/{username}/{korisnik}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<User>> removeFriend(
			@PathVariable("username") String username,
			@PathVariable("korisnik") String korisnik){
		User u = UserService.findByUsername(username);
		ArrayList<String> lista = new ArrayList<String>();
		handler = new ArrayListDatabaseHandler();
		lista = handler.StringToArrayList(u.getFriendList());
		lista.remove(korisnik);
		
		ArrayList<User> retVal = new ArrayList<User>();
		
		for(String s : lista) {
			retVal.add(UserService.findByUsername(s));
		}
		
		User drugi = UserService.findByUsername(korisnik);
		ArrayList<String> listaDrugoga = new ArrayList<String>();
		listaDrugoga = handler.StringToArrayList(drugi.getFriendList());
		listaDrugoga.remove(username);
		
		u.setFriendList(handler.ArrayListToString(lista));
		drugi.setFriendList(handler.ArrayListToString(listaDrugoga));
		
		UserService.save(u);
		UserService.save(drugi);
		return new ResponseEntity<>(retVal,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/declineRequest/{username}/{korisnik}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<User>> declineRequest(
			@PathVariable("username") String username,
			@PathVariable("korisnik") String korisnik){
		
		// prvi ne prihvata zahtev drugog
		// iz liste zahteva prvog se brise drugi
		// iz lista pending-a drugog se brise prvi
		
		User prvi  = UserService.findByUsername(username);
		User drugi = UserService.findByUsername(korisnik);
		
		handler = new ArrayListDatabaseHandler();
		
		ArrayList<String> listaPrvog = new ArrayList<String>();
		ArrayList<String> listaDrugog = new ArrayList<String>();
		
		listaPrvog  = handler.StringToArrayList(prvi.getFriendRequests());
		listaDrugog = handler.StringToArrayList(drugi.getPendingRequests());
		
		listaPrvog.remove(drugi.getUsername());
		listaDrugog.remove(prvi.getUsername());
		
		prvi.setFriendRequests(handler.ArrayListToString(listaPrvog));
		drugi.setPendingRequests(handler.ArrayListToString(listaDrugog));
		
		UserService.save(prvi);
		UserService.save(drugi);
		
		ArrayList<User> retVal = new ArrayList<User>();
		for(String s : listaPrvog){
			retVal.add(UserService.findByUsername(s));
		}
		
		return new ResponseEntity<>(retVal,HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/getRequests/{username}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<User>> getRequests(@PathVariable("username") String username){
		
		User user = UserService.findByUsername(username);
		handler = new ArrayListDatabaseHandler();	
		ArrayList<String> listaZahteva = new ArrayList<String>();	
		listaZahteva = handler.StringToArrayList(user.getFriendRequests());	
		ArrayList<User> retVal = new ArrayList<User>();	
		for(String s : listaZahteva) {
			retVal.add(UserService.findByUsername(s));
		}
		return new ResponseEntity<>(retVal,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/getPending/{username}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<User>> getPending(@PathVariable("username") String username){
		
		User user = UserService.findByUsername(username);
		handler = new ArrayListDatabaseHandler();	
		ArrayList<String> listPendinga = new ArrayList<String>();	
		listPendinga = handler.StringToArrayList(user.getPendingRequests());	
		ArrayList<User> retVal = new ArrayList<User>();	
		for(String s : listPendinga) {
			retVal.add(UserService.findByUsername(s));
		}
		return new ResponseEntity<>(retVal,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cancelRequest/{username}/{korisnik}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<User>> cancelRequest(@PathVariable("username") String username,
			@PathVariable("korisnik") String korisnik){
		
		User prvi  = UserService.findByUsername(username);
		User drugi = UserService.findByUsername(korisnik);
		
		ArrayList<String> listaPrvog = new ArrayList<String>();
		ArrayList<String> listaDrugog = new ArrayList<String>();
		
		listaPrvog  = handler.StringToArrayList(prvi.getPendingRequests());
		listaDrugog = handler.StringToArrayList(drugi.getFriendRequests());	
		
		listaPrvog.remove(drugi.getUsername());
		listaDrugog.remove(prvi.getUsername());
		
		prvi.setPendingRequests(handler.ArrayListToString(listaPrvog));
		drugi.setFriendRequests(handler.ArrayListToString(listaDrugog));
		
		UserService.save(prvi);
		UserService.save(drugi);
		
		ArrayList<User> retVal = new ArrayList<User>();
		for(String s : listaPrvog){
			retVal.add(UserService.findByUsername(s));

		}
		
		return new ResponseEntity<>(retVal,HttpStatus.OK);
	}
}

