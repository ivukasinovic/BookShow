import { Component, OnInit } from '@angular/core';
import { ReservationService } from '../reservation.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css'],
  providers: [ReservationService]
})
export class ReservationComponent implements OnInit {

  private shows;
  private show;
  private repertoire;
  private selectedShowId;
  

  constructor(private reservationService: ReservationService) { }

  ngOnInit() {
    this.reservationService.getShows().subscribe(data => this.shows = data);
  }

  showSelected($event){
    this.reservationService.getShowById(this.selectedShowId).subscribe(data => this.show = data);
    this.reservationService.getShowRepertoire(this.selectedShowId).subscribe(data => this.repertoire = data);
  }

  playMovieSelected($event){
    alert("aaa");
  }

}
