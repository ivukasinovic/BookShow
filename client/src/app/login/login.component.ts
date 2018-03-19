import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from '../auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [AuthenticationService]
})
export class LoginComponent implements OnInit {
  token: string;
  model: any = {};
  error = '';
  loading = false;

  constructor(private router: Router, private authenticationService: AuthenticationService) {
    const currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.token = currentUser && currentUser.token;
  }

  ngOnInit() {
  }

  login() {
    this.loading = true;
    this.authenticationService.login(this.model.username, this.model.password)
      .subscribe(
        (data: any) => {
          if (data) {
            this.token = data.token;
            localStorage.setItem('currentUser', JSON.stringify({username: this.model.username, token: this.token}));
            this.router.navigate(['/']);
            window.location.reload();
          }
        },
        error => {
          this.error = 'Pogresno korisnicko ime ili lozinka';
          this.loading = false;
        }
      );
  }

  logout(): void {
    // clear token remove user from local storage to log user out
    this.token = null;
    localStorage.removeItem('currentUser');
  }
}
