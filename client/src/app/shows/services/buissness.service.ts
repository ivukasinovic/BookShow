import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class BuissnessService {

  constructor(private http: HttpClient) { }

  getTodaysVisits(showId){
    return this.http.get("api/purchase/get-todays-visits/" + showId);
  } 

  getThisWeeksVisits(showId){
    return this.http.get("api/purchase/get-this-weeks-visits/" + showId);
  }

  getThisMonthsVisits(showId){
    return this.http.get("api/purchase/get-this-months-visits/" + showId);
  }

  getProfit(start, end, showId){
    var twoDates: any = {};
    twoDates.startDate = start;
    twoDates.endDate = end;
    return this.http.post("api/purchase/get-profit/"+showId, twoDates);
  }

}
