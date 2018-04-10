import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class PlayMovieService {

  constructor(private http: HttpClient) { }

  createNewPlayMovie(data){
    return this.http.post("api/new-play-film", data);
  }

  getShowsRepertoire(id){
    return this.http.get("api/get-show-repertoire/"+id);
  }

}
