import { Component, OnInit } from '@angular/core';
import {FriendsService} from '../friends.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-search-users',
  templateUrl: './search-users.component.html',
  styleUrls: ['./search-users.component.css'],
  providers: [FriendsService]
})
export class SearchUsersComponent implements OnInit {
  model: any = {};
  rezultatiPretrage : any = {}
  constructor(private friendService : FriendsService, private router : Router) { }

  ngOnInit() {
  }

  search(){
    //alert(this.model.username + " " +this.model.name + " " +this.model.surname + " ");
    this.friendService.search(this.model.username ,this.model.name,this.model.surname).subscribe(
      (data : any) =>{
        this.rezultatiPretrage = data;
      }
    )
  }

  viewProfile(username : String){
    //alert(username);
    if(username === localStorage.getItem('username')) {
      this.router.navigate(['/profil']);
    }else{
    this.router.navigate(['/profile-other-user' + '/' + username]);
    }
  }

}
