import { Component, OnInit } from '@angular/core';
import {PropService} from '../../fanpage/prop.service';
import {Rating} from '../../fanpage/models/prop';

@Component({
  selector: 'app-set-rating',
  templateUrl: './set-rating.component.html',
  styleUrls: ['./set-rating.component.css']
})
export class SetRatingComponent implements OnInit {
  rating: Rating;
  newRating: Rating;
  constructor(private propService: PropService) {
    this.newRating = new Rating();
    this.rating = new Rating();
  }

  ngOnInit() {
    this.getCurrentRating();
  }
  getCurrentRating() {
    this.propService.getCurrentRating()
      .subscribe((data: Rating) => {
        this.rating = data;
      },
        error1 => {alert('Nije moguce preuzeti trenutni rejting'); });
  }
  changeRating() {
    this.propService.changeRating(this.newRating)
      .subscribe(
        (data: Rating) => {
          alert('Uspesno promenjena skala');
          window.location.reload();
        },
        error1 => {alert('Nije uspela promena skale, proverite da li ste popunili vrednosti u odnosu bronzni<srebrni<zlatni'); }
      );
  }

}
