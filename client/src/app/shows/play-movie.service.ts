import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class PlayMovieService {

  constructor(private http: HttpClient) { }

  createNewPlayMovie(data){
    return this.http.post("api/new-play-film", data);
  }

  updatePlayMovie(data){
    return this.http.put("api/update-play-film", data);
  }

  getShowsPlayMovies(id){
    return this.http.get("api/get-playfilms-by-show/"+id);
  }

  getPlayMovieById(id){
    return this.http.get("api/get-play-film/"+ id);
  }

  removePlayMovie(id){
    return this.http.delete("api/delete-play-film/"+id);
  }

  getRepertoire(show, date){
    var dateShow: any = {};
    dateShow.show = show;
    dateShow.date = date;
    return this.http.post("api/repertoire/get", dateShow);
  }

  saveRepertoire(show, date){
    var repertoire: any = {};
    var dateShow: any = {};
    dateShow.show = show;
    dateShow.date = date;
    repertoire.dateShow = dateShow;
    return this.http.post("api/repertoire/save", repertoire);
  }

  getProfit(start, end, showId){
    var twoDates: any = {};
    twoDates.startDate = start;
    twoDates.endDate = end;
    return this.http.post("api/purchase/get-profit/"+showId, twoDates);
  }

}
