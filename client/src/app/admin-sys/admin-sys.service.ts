import { Injectable } from '@angular/core';
import {Show, User} from '../fanpage/models/prop';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class AdminSysService {

  constructor(private http: HttpClient) { }

  registerShow(show: Show) {
    return this.http.post('/api/shows', show);
  }
  registerAdmin(user: User) {
    return this.http.post('/api/users', user);
  }
}
