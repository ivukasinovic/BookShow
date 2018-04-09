import { Component, OnInit } from '@angular/core';
import {PropService} from '../../prop.service';
import {NewProp, Show} from '../../models/prop';

@Component({
  selector: 'app-create-new-prop',
  templateUrl: './create-new-prop.component.html',
  styleUrls: ['./create-new-prop.component.css']
})
export class CreateNewPropComponent implements OnInit {
  shows: Show[];
  newProp: NewProp;
  selectedShowId: number;
  constructor(private propService: PropService) {
    this.newProp = new NewProp();
  }

  ngOnInit() {
    this.getShows();
  }

  getShows() {
    this.propService.getShows().
      subscribe((data: Show[]) => {
        this.shows = data;
    },
      err => {
        alert('Nije uspelo preuzimanje bioskopa/pozorista, mozda ne postoji ni jedan u bazi.');
      } );
  }
  createProp() {
    this.propService.createNewProp(this.newProp, this.selectedShowId)
      .subscribe( response => {
        if (response.status === 201) {
          alert('Uspesno kreiran rekvizit!');
        }else {
          alert('Doslo je do greske');
        }
      });
  }
}
