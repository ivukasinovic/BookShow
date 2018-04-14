import { Component, OnInit } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { ActivatedRoute, Router } from '@angular/router';
import { ProfileService } from '../../profil/profile.service'
import { AnonymousSubscription } from 'rxjs/Subscription';
import {FriendsService} from '../friends/friends.service';

@Component({
  selector: 'app-profile-other-user',
  templateUrl: './profile-other-user.component.html',
  styleUrls: ['./profile-other-user.component.css'],
  providers: [ProfileService,FriendsService]
})
export class ProfileOtherUserComponent implements OnInit {

  private username;
  korisnik : any = {}
  friends : boolean;
  padding : boolean;
  requested : boolean;
  constructor(private route: ActivatedRoute,
             private profileservice : ProfileService,
             private friendsservice : FriendsService,
             private router : Router) { }

  ngOnInit() {  
    this.friends=false;
    this.route.params.subscribe
    (params => this.username = params['username']);


    this.profileservice.getProfileInfoOther(this.username).subscribe(
      (data : any) => {
        this.korisnik = data;
        //alert(this.korisnik.username)
      }
    )

    this.profileservice.checkFriendship(this.username).subscribe(
      (data : any) => {
        this.friends = data;
        //alert(this.friends);
      }
    )

    this.profileservice.checkPadding(this.username).subscribe(
      (data : any) => {
        this.padding = data;
        //alert(this.friends);
      }
    )

    this.profileservice.checkRequested(this.username).subscribe(
      (data : any) => {
        this.requested = data;
        //alert(this.friends);
      }
    )
  
  }

  sendFriendRequest(username : String){
    this.padding = true;
    this.requested = false;
    this.friends = false;
    this.profileservice.sendFriendRequest(username).subscribe( )
  }

  confirmRequest(username : String) {
    this.padding = false;
    this.requested = false;   
    this.friends = true;
    this.profileservice.confirmRequest(username).subscribe()
  }

  removeFriend(username){
    this.padding = false;
    this.requested = false;   
    this.friends = false;
    this.friendsservice.removeFriend(username).subscribe();
  }

  declineRequest(username) {
    this.padding = false;
    this.requested = false;   
    this.friends = false;  
    this.friendsservice.declineRequest(username).subscribe();
  }


}
