import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Injectable()
export class AuthenticationService {

  constructor(private router: Router, private http: HttpClient) {
  }

  login(username: string, password: string ) {
    return this.http.post('api/login', {username: username, password: password});
  }
  getToken(): String{
    const user = JSON.parse(localStorage.getItem('currentUser'));
    return user.token;
  }
  logout() {
    localStorage.removeItem('currentUser');

  }
}
