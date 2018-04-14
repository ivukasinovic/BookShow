import { Component, OnInit } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { ProfileService } from './profile.service';
import { FriendsService } from './friends/friends.service'

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css'],
  providers: [ProfileService,FriendsService]
})
export class ProfilComponent implements OnInit {

  username : String = localStorage.getItem('username')
  korisnik : any = {}
  prijatelji : any = {}
  
  constructor(private profileSerivce: ProfileService, private friendsService : FriendsService) { }

  ngOnInit() {
    this.profileSerivce.getProfileInfo().subscribe(
      (data:any) => {
        this.korisnik = data;
      }
    )

    //get prijatelje
    this.friendsService.getFriends().subscribe(
      (data:any) => {
        this.prijatelji = data;
      }
    )
  }

  removeFromFriends(username){
    this.friendsService.removeFriend(username).subscribe(
      data => {
        this.prijatelji = data;
      }
    )
  }
}
