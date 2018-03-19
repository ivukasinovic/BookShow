import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from '../auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
  providers: [AuthenticationService]
})
export class NavbarComponent implements OnInit {
  logged = false;

  constructor(private router: Router, private authenticationService: AuthenticationService) {
  }

  ngOnInit() {
    const user = JSON.parse(localStorage.getItem('currentUser'));
    if (user) {
      this.logged = true;
    } else {
      this.logged = false;
    }
  }

  logout() {
    this.authenticationService.logout();
    this.router.navigate(['/login']);
    window.location.reload();
  }

}
