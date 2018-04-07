import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ShowsService {

  constructor(private http: HttpClient) { }

  getAllTheatreShows(){
    return this.http.get("api/allShows?type=theatre");
  }

  getAllCinemaShows(){
    return this.http.get("api/allShows?type=cinema");
  }
}
