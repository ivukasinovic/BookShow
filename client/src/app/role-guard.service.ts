import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router} from '@angular/router';
import * as decode from 'jwt-decode';
import {AuthenticationService} from './auth.service';

@Injectable()
export class RoleGuardService implements CanActivate {
  constructor(public auth: AuthenticationService, public router: Router) {
  }

  canActivate(route: ActivatedRouteSnapshot): boolean {
    const expectedRole = route.data.expectedRole;
    const user = JSON.parse(localStorage.getItem('currentUser'));
    const tokenPayload = decode(user.token);
    console.log(tokenPayload);
    if (
      !this.auth.isAuthenticated() ||
      tokenPayload.role !== expectedRole) {
      this.router.navigate(['login']);
      return false;
    }
    return true;
  }

}
