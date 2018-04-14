import { Component, OnInit } from '@angular/core';
import {FriendsService} from './friends.service'


@Component({
  selector: 'app-friends',
  templateUrl: './friends.component.html',
  styleUrls: ['./friends.component.css'],

})
export class FriendsComponent implements OnInit {

  prijatelji : any = {}
  username : String = localStorage.getItem('username');

  constructor(private friednsService : FriendsService) { }

  ngOnInit() {  
    this.friednsService.getFriends().subscribe(
      (data:any) => {
        this.prijatelji = data;
      }
    )
  }

  removeFriend(username) {
    this.friednsService.removeFriend(username).subscribe(
      (data:any) => {
        this.prijatelji = data;
      }
    );
  }




}
