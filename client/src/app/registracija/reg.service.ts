import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpResponse} from '@angular/common/http';
import {Router} from '@angular/router';
import 'rxjs/add/operator/map';

@Injectable()
export class RegService {

  constructor(private router: Router, private http: HttpClient) { }

  registruj(username : string, password : string , name : string,
               surname : string, email : string,city:string, number : string) {
                
    return this.http.post('api/registration',{username:username, passwordHash: password, name: name,
                                              surname: surname, email: email,city:city, number:number})
  }

}