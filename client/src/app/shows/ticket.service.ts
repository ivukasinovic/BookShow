import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class TicketService {

  constructor(private http: HttpClient) { }

  getTicketsOnSale(showId){
    return this.http.get("api/ticket/get-discounts/" + showId);
  }

}
