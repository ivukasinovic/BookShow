import { Component, OnInit } from '@angular/core';
import { FriendsService } from '../friends.service';

@Component({
  selector: 'app-pending',
  templateUrl: './pending.component.html',
  styleUrls: ['./pending.component.css'],
  providers:[FriendsService]
})
export class PendingComponent implements OnInit {

  pending : any = {};
  constructor(private friendsService : FriendsService) { }

  ngOnInit() {
    this.friendsService.getPending().subscribe(
      data => {
        this.pending = data;
      }
    )
  }

  cancelRequest(username) {
    this.friendsService.cancelRequest(username).subscribe(
      data => {
        this.pending = data;
      }
    )
  }

}
