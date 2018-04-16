import { Component, OnInit } from '@angular/core';
import { FriendsService } from '../friends.service';
import { ProfileService } from '../../../profil/profile.service';

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.css'],
  providers:[FriendsService,ProfileService]
})
export class RequestsComponent implements OnInit {

  zahtevi : any = {};
  constructor(private friendsService : FriendsService, private profileService : ProfileService) { }

  ngOnInit() {
    this.friendsService.getRequests().subscribe(
      data => {
        this.zahtevi = data;
      }
    )
  }

  acceptRequest(username){
    this.friendsService.confirmRequest(username).subscribe(
      data => {
        this.zahtevi = data;
      }
    )
  }

  declineRequest(username){
    this.friendsService.declineRequest(username).subscribe(
      data => {
        this.zahtevi = data;
      }     
    );
  }
}
