import { NgbRatingConfig } from '@ng-bootstrap/ng-bootstrap';
import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../auth.service'
import {HomePageService} from './home-page.service'

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css'],
  providers: [AuthService,HomePageService]
})
export class HomePageComponent implements OnInit {
  logged = false;
  role: string;
  username: string;
  korisnik : any = {}
  istorija : any = {}
  karte : any = {};
  ocene: any = [];


  constructor(private authService: AuthService,
    private homepageService : HomePageService, config: NgbRatingConfig) { 
      config.max = 5;
    }

  ngOnInit() {
    this.role = localStorage.getItem('role');
    this.username = localStorage.getItem('username');
    if (this.authService.isAuthenticated()) {
      this.logged = true;
    } else {
      this.logged = false;
    }


    if(this.logged === true){
      this.homepageService.getHistory().subscribe(
        data => this.istorija = data    
    )
    
    this.homepageService.getTickets().subscribe(data => {
        this.karte = data;
        for(var i = 0; i < this.karte.length; i++){
          this.homepageService.getUsersRatingForShow(this.karte[i].projection.auditorium.show.id, localStorage.getItem('username')).subscribe((rateShow:any) =>{
            this.ocene.push(rateShow.value);
          })
        }
        
      })
    }

}
removeFromHistoy(poseta){
  this.homepageService.removeFromHistoy(poseta).subscribe(
    (data:any) => {
      this.istorija = data;

    })
}

rejtujBioskop(i, showId){
  if(!this.ocene[i]){
    alert("selektujte ocenu")
    return;
 }
  this.homepageService.rateShow(showId, this.ocene[i]).subscribe(data =>{
    null;
  })
}

}
