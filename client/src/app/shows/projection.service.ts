import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class ProjectionService {

  constructor(private http: HttpClient) { }

  saveProjection(playmovie, auditorium, time){
    var projection: any = {};
    projection.time = time;
    projection.playfilm = playmovie;
    projection.auditorium = auditorium;
    return this.http.post("api/projection/save", projection);
  }
}
