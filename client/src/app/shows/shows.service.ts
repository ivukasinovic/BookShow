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

  getLocation(term: string) {
    return this.http.get('http://maps.google.com/maps/api/geocode/json?address=' + term + 'CA&sensor=false');
 }
}
