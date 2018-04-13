import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-friends',
  templateUrl: './friends.component.html',
  styleUrls: ['./friends.component.css']
})
export class FriendsComponent implements OnInit {

  korisnik : any = {}
  username : String = localStorage.getItem('username');

  constructor(private http : HttpClient) { }

  ngOnInit() {
    return this.http.get('api/getProfileInfo/'+this.username).subscribe(
      (data:any) => {
        this.korisnik = data;
      }
    )
  }


}
