import { Component, OnInit } from '@angular/core';
import {NewProp} from '../models/prop';
import {PropService} from '../prop.service';

@Component({
  selector: 'app-reserved-props-list',
  templateUrl: './reserved-props-list.component.html',
  styleUrls: ['./reserved-props-list.component.css']
})
export class ReservedPropsListComponent implements OnInit {
  newProps: NewProp[];
  constructor(private propService: PropService) { }

  ngOnInit() {
    this.getMyReservedProps();
  }
  getMyReservedProps() {
    this.propService.getMyReservedProps()
      .subscribe((data: NewProp[]) => {
        this.newProps = data;
        if (data.length === 0) {
          alert('Nema rezervisanih rekvizita');
        }
      },
        err => {
          alert('Nije uspelo ucitavanje rezervisanih rekvizita');
        });
  }
  deleteReservation(newPropId: number) {
    this.propService.deleteReservation(newPropId)
      .subscribe(response => {
        if (response.status === 204) {
          alert('Uspešno otkazana rezervacija');
          window.location.reload();
        }}, error1 => {alert('Nije uspelo otkazivanje rezervacije, pokusajte ponovo');
      });
  }

}
