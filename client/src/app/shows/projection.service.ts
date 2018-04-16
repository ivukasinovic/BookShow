import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class ProjectionService {

  constructor(private http: HttpClient) { }

  saveProjection(playmovie, auditorium, time, date, show, price){
    var projection: any = {};
    projection.time = time;
    projection.playfilm = playmovie;
    projection.auditorium = auditorium;
    projection.price = price;
    var dateShow: any = {};
    dateShow.date = date;
    dateShow.show = show;
    var repertoire: any = {};
    repertoire.dateShow = dateShow;
    projection.repertoire = repertoire;
    return this.http.post("api/projection/save", projection);
  }

  getByRepertoire(repertoire){
    return this.http.post("api/projection/get-by-repertoire", repertoire);
  }
}
