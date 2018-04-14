import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ShowsService {

  constructor(private http: HttpClient) { }

  getAllShowsByType(type){
    return this.http.get('api/shows?type='+type);
  }

  getShowById(id) {
    return this.http.get('/api/shows/' + id);
  }

  getAuditoriums(showId){
    return this.http.get('api/auditorium/get-by-show/'+showId);
  }
  getAuditorium(id){
    return this.http.get('api/auditorium/' + id);
  }
}
