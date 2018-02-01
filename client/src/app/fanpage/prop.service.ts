import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class PropService {

  constructor(private http: HttpClient) { }
  getNewProps() {
    return this.http.get('/api/getNewProps');
  }
}
