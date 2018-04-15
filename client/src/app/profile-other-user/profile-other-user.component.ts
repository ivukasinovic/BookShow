import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RouterModule, Routes} from '@angular/router';

@Component({
  selector: 'app-profile-other-user',
  templateUrl: './profile-other-user.component.html',
  styleUrls: ['./profile-other-user.component.css']
})
export class ProfileOtherUserComponent implements OnInit {

  korisnik : any = {}
  username : String;
  constructor(private http : HttpClient) { }

  ngOnInit() {
    return this.http.get('api/getProfileInfo/'+this.username).subscribe(
      (data:any) => {
        this.korisnik = data;
      }
    )   
  }

}
