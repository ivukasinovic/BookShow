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

  addToHistory(id){
    return this.http.get('/api/addToHistory/'+localStorage.getItem('username')+ '/'+ id).subscribe();
  }
}
