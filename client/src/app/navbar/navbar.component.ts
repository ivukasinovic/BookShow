import {Component, OnInit} from '@angular/core';
import {AuthService} from '../auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
  providers: [AuthService]
})
export class NavbarComponent implements OnInit {
  logged = false;
  role: string;

  constructor(private router: Router, private authService: AuthService) {
  }

  ngOnInit() {
    this.role = localStorage.getItem('role');
    console.log('Rola je' + this.role);
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

}
