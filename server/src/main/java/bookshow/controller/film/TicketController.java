package bookshow.controller.film;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookshow.domain.Seat;
import bookshow.domain.movie.Projection;
import bookshow.domain.movie.Purchase;
import bookshow.domain.movie.Ticket;
import bookshow.domain.users.User;
import bookshow.service.ProjectionService;
import bookshow.service.PurchaseService;
import bookshow.service.TicketService;
import bookshow.service.UserService;
import bookshow.service.SeatService;


@RestController
@RequestMapping(value = "ticket")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private PurchaseService purchaseService;
	
	@Autowired
	private SeatService SeatService;
	
	@Autowired
	private ProjectionService ProjectionService;
	
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
		return new ResponseEntity<>(ticketService.findByProjectionAuditoriumShowIdAndDiscountGreaterThanAndPurchasedIsNull(longId, 0), HttpStatus.OK);
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
	

	@RequestMapping(value = "/reserveSeat/{username}/{projectionId}", 
			method = RequestMethod.POST, consumes = "application/json")		
	public ResponseEntity<Ticket> reserveSeat(@RequestBody Seat seat,
			@PathVariable("username")String username, @PathVariable("projectionId")Long projectionId) {
		User user = userService.findByUsername(username);
		Purchase p = new Purchase(user, new Date());
		purchaseService.save(p);
		Ticket ticket = new Ticket();
		ticket.setPurchased(p);
		ticket.setSeat(seat);
		ticket.setDiscount(0);
		Projection projection = ProjectionService.findOne(projectionId);
		ticket.setProjection(projection);
		return new ResponseEntity<>(ticketService.save(ticket), HttpStatus.OK);
	}
	
	

	@PreAuthorize("hasAuthority('ADMINSHOW')")
	@RequestMapping(
			value = "/remove-discount", 
			method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ticket> removeDiscount(@RequestBody Ticket ticket){
		ticket.setDiscount(0);
		return new ResponseEntity<>(ticketService.save(ticket), HttpStatus.OK);
	}

}
