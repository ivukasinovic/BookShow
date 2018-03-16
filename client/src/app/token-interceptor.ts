import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {Injectable} from '@angular/core';

@Injectable()
export class TokenInterceptor implements  HttpInterceptor {

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    if (request.url !== 'api/login') {
      console.log(request.url);
      const user = JSON.parse(localStorage.getItem('currentUser'));
      request = request.clone({headers: request.headers.set('Auth-Token', user.token)});
    }
    return next.handle(request);
  }
}
