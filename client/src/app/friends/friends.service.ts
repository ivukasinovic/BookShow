import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class FriendsService {

  constructor(private http : HttpClient) { }

  search(usernamePart : String, namePart : String, surnamePart : String){
    alert("dosao je do servisa!!!");
    return this.http.get('api/searchPeople/'+usernamePart+'/'+namePart+'/'+surnamePart).
    subscribe()
  }
}
