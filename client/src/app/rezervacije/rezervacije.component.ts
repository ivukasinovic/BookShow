import { Component, OnInit } from '@angular/core';
import {HomePageService} from '../profil/home-page/home-page.service'
@Component({
  selector: 'app-rezervacije',
  templateUrl: './rezervacije.component.html',
  styleUrls: ['./rezervacije.component.css'],
  providers: [HomePageService]
})
export class RezervacijeComponent implements OnInit {
  karte : any = {}
  constructor(private homepageService : HomePageService) { }


  ngOnInit() {
    this.homepageService.getTickets().subscribe(
      data => this.karte = data
    )
  }

  cancelReservation(id) {
    this.homepageService.cancelReservation(id).subscribe(
    data => alert("Obrisan"));
  }

}
