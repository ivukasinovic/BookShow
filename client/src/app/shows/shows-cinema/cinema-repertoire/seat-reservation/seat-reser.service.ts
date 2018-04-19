import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class SeatReserService {

  constructor(private http: HttpClient) { }

  rezervisi(seat,projectionId) {
    //alert(seat.id);
    return this.http.post("api/ticket/reserveSeat/" + localStorage.getItem('username') + "/" +projectionId,seat);
  }

  getIds(projectionId,auditoriumId) {
    return this.http.get("api/getResevedSeatIds/" + auditoriumId + "/" + projectionId);
  }

}
