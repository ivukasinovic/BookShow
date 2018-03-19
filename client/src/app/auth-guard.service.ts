import {Injectable} from '@angular/core';
import {AuthenticationService} from './auth.service';
import {CanActivate, Router} from '@angular/router';

@Injectable()
export class AuthGuardService implements CanActivate {

  constructor(public auth: AuthenticationService, public router: Router) {
  }

  canActivate(): boolean {
    if (!this.auth.isAuthenticated()) {
      this.router.navigate(['login']);
      return false;
    }
    return true;
  }
}
