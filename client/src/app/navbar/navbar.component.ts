import {Component, OnInit} from '@angular/core';
import {AuthService} from '../auth.service';
import {Router} from '@angular/router';
import { FriendsService } from '../profil/friends/friends.service'

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
  providers: [AuthService,FriendsService]
})
export class NavbarComponent implements OnInit {
  logged = false;
  role: string;
  username: string;

  constructor(private router: Router, private authService: AuthService, private friendsservice : FriendsService) {
  }

  ngOnInit() {
    this.role = localStorage.getItem('role');
    this.username = localStorage.getItem('username');
    if (this.authService.isAuthenticated()) {
      this.logged = true;
    } else {
      this.logged = false;
    }

  }

  logout() {
    this.authService.logout();
    this.logged = false;
    this.router.navigate(['/login']);
    window.location.reload();
  }

  navigateTheatre(){
    this.router.navigateByUrl('/login', {skipLocationChange: true}).then(()=>
    this.router.navigate(['shows/theatre']));
  }

  navigateCinema(){
    this.router.navigateByUrl('/login', {skipLocationChange: true}).then(()=>
    this.router.navigate(['shows/cinema']));
  }

}
