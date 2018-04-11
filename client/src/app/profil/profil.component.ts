import { Component, OnInit } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {

  username : String = localStorage.getItem('username')
  korisnik : any = {}
  
  constructor(private http: HttpClient) { }

  ngOnInit() {
    return this.http.get('api/getProfileInfo/'+this.username).subscribe(
      (data:any) => {
        this.korisnik = data;
      }
    )
  }
}
