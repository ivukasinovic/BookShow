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

  updateShow(show){
    return this.http.put("api/shows/edit", show);
  }

  addToHistory(id){
    return this.http.get('/api/addToHistory/'+localStorage.getItem('username')+ '/'+ id).subscribe();
  }

  getAuditoriums(showId){
    return this.http.get('api/auditorium/get-by-show/'+showId);
  }
  getAuditorium(id){
    return this.http.get('api/auditorium/' + id);
  }

  getShowsRating(showId){
    return this.http.get("api/rateshow/calculate-show-rating/" + showId);
  }
}
