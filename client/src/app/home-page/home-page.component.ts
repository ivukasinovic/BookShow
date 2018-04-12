import { Component, OnInit } from '@angular/core';
import {AuthService} from '../auth.service';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css'],
  providers: [AuthService]
})
export class HomePageComponent implements OnInit {
  logged = false;
  role: string;
  username: string;
  korisnik : any = {}
  constructor(private router: Router, private authService: AuthService,private http: HttpClient) { }

  ngOnInit() {
    this.role = localStorage.getItem('role');
    this.username = localStorage.getItem('username');
    if (this.authService.isAuthenticated()) {
      this.logged = true;
    } else {
      this.logged = false;
    }

    if(this.logged === true){
      return this.http.get('api/getProfileInfo/'+this.username).subscribe(
        (data:any) => {
          this.korisnik = data;
        }
      )
    }
  }

  removeFromHistoy(name){
    return this.http.get('api/removeFromHistory/'+this.username+'/'+name).subscribe(
      (data:any) => {
        this.korisnik = data;
      }
    )
  }

}
