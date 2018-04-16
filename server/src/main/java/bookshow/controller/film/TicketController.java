package bookshow.controller.film;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookshow.domain.movie.Ticket;
import bookshow.service.TicketService;

@RestController
@RequestMapping(value = "ticket")
public class TicketController {
	@Autowired
	TicketService ticketService;
	
	@RequestMapping(
			value = "/get", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ticket>> getTickets(){
		return new ResponseEntity<>(ticketService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/get-discounts/{showId}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ticket>> getTicketsOnDiscount(@PathVariable String showId){
		Long longId = new Long(Integer.parseInt(showId));
		return new ResponseEntity<>(ticketService.findBySeatAuditoriumShowIdAndDiscountGreaterThan(longId, 0), HttpStatus.OK);
	}
}
