import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class TicketService {

  constructor(private http: HttpClient) { }

  getTicketsOnSale(showId){
    return this.http.get("api/ticket/get-discounts/" + showId);
  }

  reserveTicket(ticket, username){
    return this.http.put("api/ticket/reserve/" + username, ticket);
  }

  getTicketById(ticketId){
    return this.http.get("api/ticket/get/"+ticketId);
  }

  removeDiscount(ticket){
    return this.http.put("api/ticket/remove-discount", ticket);
    
  }

}
