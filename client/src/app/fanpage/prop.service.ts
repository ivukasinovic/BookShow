import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class PropService {

  result: any;

  constructor(private http: HttpClient) { }
  getNewProps() {
    return this.http.get('/api/newProps');
  }
  getUsedProps() {
    return this.http.get('/api/usedProps');
  }
  reservation(id: number) {
    this.http.get('/api/newProps/reservation/' + id, {observe: 'response'})
      .subscribe(response => {
        this.result = response.statusText;
      });
    return this.result;
  }
}
