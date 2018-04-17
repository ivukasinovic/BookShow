package bookshow.controller.film;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookshow.domain.movie.Purchase;
import bookshow.domain.movie.Ticket;
import bookshow.domain.users.User;
import bookshow.service.PurchaseService;
import bookshow.service.TicketService;
import bookshow.service.UserService;

@RestController
@RequestMapping(value = "ticket")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private PurchaseService purchaseService;
	
	@RequestMapping(
			value = "/get", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ticket>> getTickets(){
		return new ResponseEntity<>(ticketService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/get/{ticketId}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ticket> getTicketById(@PathVariable String ticketId){
		Long longId = new Long(Integer.parseInt(ticketId));
		return new ResponseEntity<>(ticketService.findOne(longId), HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/get-discounts/{showId}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ticket>> getTicketsOnDiscount(@PathVariable String showId){
		Long longId = new Long(Integer.parseInt(showId));
		return new ResponseEntity<>(ticketService.findBySeatAuditoriumShowIdAndDiscountGreaterThanAndPurchasedIsNull(longId, 0), HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/reserve/{username}", 
			method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ticket> reserveTicket(@RequestBody Ticket ticket, @PathVariable String username){
		User user = userService.findByUsername(username);
		Purchase p = new Purchase(user, new Date());
		purchaseService.save(p);
		ticket.setPurchased(p);
		return new ResponseEntity<>(ticketService.save(ticket), HttpStatus.OK);
	}
}
