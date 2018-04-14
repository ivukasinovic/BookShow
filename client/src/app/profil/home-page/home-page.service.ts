import { Injectable } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class HomePageService {
  constructor(private http: HttpClient) { }



  getHistory(){
    return this.http.get('api/getHistory/'+localStorage.getItem('username'));
  }

  removeFromHistoy(poseta : String){
    return this.http.get('api/removeFromHistory/'+localStorage.getItem('username')+'/'+poseta); 
  }



}
