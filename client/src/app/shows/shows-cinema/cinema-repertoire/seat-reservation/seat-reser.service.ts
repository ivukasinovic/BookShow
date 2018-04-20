import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class SeatReserService {

  constructor(private http: HttpClient) { }

  rezervisi(username,seat,projectionId) {
    if(username !== null){
        alert("Rezervisa je " + username);
       return this.http.post("api/ticket/reserveSeat/" + username + "/" +projectionId,seat);
    }
  }

  rezervisiZaPrijatelja(username,seat,projectionId) {
    if(username !== undefined){
      alert("Rezervisa je " + username);
     return this.http.post("api/ticket/reserveSeatForFriend/"+localStorage.getItem('username') + "/"+username + "/" +projectionId,seat);
  }
  }

  getIds(projectionId,auditoriumId) {
    return this.http.get("api/getResevedSeatIds/" + auditoriumId + "/" + projectionId);
  }

}
