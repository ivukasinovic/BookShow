import { Injectable } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class HomePageService {
  constructor(private http: HttpClient) { }



  getHistory(){
    return this.http.get('api/getHistory/'+localStorage.getItem('username'));
  }

  removeFromHistoy(poseta : String){
    return this.http.get('api/removeFromHistory/'+localStorage.getItem('username')+'/'+poseta); 
  }

  getTickets() {
    return this.http.get('api/ticket/getReservedTickets/'+localStorage.getItem('username')); 
  }

  getUsersRatingForShow(showId, username){
    return this.http.get("api/rateshow/get/" + username + '/' + showId);
  }

  rateShow(showId, rating){
    var rateShow: any = {};
    rateShow.rating = rating;
    return this.http.put("api/rateshow/save/"+localStorage.getItem('username') +'/'+showId, rateShow);
  }

}
