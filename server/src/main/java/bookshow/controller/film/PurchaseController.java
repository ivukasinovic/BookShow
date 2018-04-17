package bookshow.controller.film;

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

import bookshow.domain.DTOs.MonthlyProfit;
import bookshow.domain.DTOs.TwoDates;
import bookshow.domain.movie.Purchase;
import bookshow.domain.movie.Ticket;
import bookshow.service.PurchaseService;
import bookshow.service.TicketService;

@RestController
@RequestMapping(value = "/purchase")
public class PurchaseController {
	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired 
	private TicketService ticketService;

	@PreAuthorize("hasAuthority('ADMINSHOW')")
	@RequestMapping(
			value = "/get-profit/{showId}", 
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MonthlyProfit> getProjection(@RequestBody TwoDates twoDates, @PathVariable String showId){
		List<Purchase> purchases = purchaseService.findByDateGreaterThanAndDateLessThan(twoDates.getStartDate(),  twoDates.getEndDate());
		if(purchases.isEmpty())
			System.out.println("PRAZNO");
		double sum = 0;
		Long showIdLong = new Long(Integer.parseInt(showId));
		for(int i = 0; i < purchases.size(); i++){
			Ticket ticket = ticketService.findByPurchasedId(purchases.get(i).getId());
			if(ticket != null){
				if(ticket.getSeat().getAuditorium().getShow().getId().equals(showIdLong))
					sum += ticket.getProjection().getPrice();
			}
		}
		return new ResponseEntity<>(new MonthlyProfit(sum), HttpStatus.OK);
	}
}
