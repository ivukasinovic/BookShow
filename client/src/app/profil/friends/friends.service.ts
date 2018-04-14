import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class FriendsService {

  constructor(private http : HttpClient) { }

  getFriends(){
    return this.http.get('api/getFriends/'+localStorage.getItem('username'));
  }

  search(usernamePart : String, namePart : String, surnamePart : String){
   // alert(usernamePart)
   //alert(usernamePart + " " + namePart + " " + surnamePart);
    return this.http.get('api/searchPeople/'+usernamePart+'/'+namePart+'/'+surnamePart);
  }


  removeFriend(username) {
    return this.http.get('api/removeFriend/'+localStorage.getItem('username') + '/' + username);
  }

  declineRequest(username) {
    return this.http.get('api/declineRequest/'+localStorage.getItem('username') + '/' + username);
  }

  getRequests() {
    return this.http.get('api/getRequests/'+localStorage.getItem('username'));
  }

  getPending() {
    return this.http.get('api/getPending/'+localStorage.getItem('username'));
  }

  cancelRequest(username) {
    return this.http.get('api/cancelRequest/'+localStorage.getItem('username') + '/' + username);
  }
}
