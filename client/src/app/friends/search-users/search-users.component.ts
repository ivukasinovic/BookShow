import { Component, OnInit } from '@angular/core';
import {FriendsService} from '../friends.service'

@Component({
  selector: 'app-search-users',
  templateUrl: './search-users.component.html',
  styleUrls: ['./search-users.component.css']
})
export class SearchUsersComponent implements OnInit {
  model: any = {};
  constructor(private friendsService : FriendsService) { }

  ngOnInit() {
  }

  search(){
    this.friendsService.search(this.model.username , this.model.name ,this.model.surname);
    //alert(this.model.username + " " + this.model.name + " " + this.model.surname);
  }

}
