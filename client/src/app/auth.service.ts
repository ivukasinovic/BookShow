import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {JwtHelperService} from '@auth0/angular-jwt';

@Injectable()
export class AuthenticationService {
  constructor(private router: Router, private http: HttpClient) {
  }

  public isAuthenticated(): boolean {
    const jwtHelper: JwtHelperService = new JwtHelperService();
    const user = JSON.parse(localStorage.getItem('currentUser'));
    if (user) {
      return !jwtHelper.isTokenExpired(user.token);
    }
    return false;
  }

  login(username: string, password: string) {
    return this.http.post('api/login', {username: username, password: password});
  }

  getToken(): string {
    const user = JSON.parse(localStorage.getItem('currentUser'));
    return user.token;
  }

  logout() {
    localStorage.removeItem('currentUser');

  }
}
