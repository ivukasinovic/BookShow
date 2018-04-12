import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class ReservationService {

  constructor(private http: HttpClient) { }

  getShows(){
    return this.http.get("api/shows?type=all");
  }
  getShowById(id){
    return this.http.get("api/shows/"+ id);
  }

  getShowRepertoire(id){
    return this.http.get("api/get-show-repertoire/" + id);
  }
}
