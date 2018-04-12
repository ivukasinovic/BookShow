import {Component, OnInit} from '@angular/core';
import {PropService} from '../../prop.service';
import {NewProp, Show} from '../../models/prop';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-create-new-prop',
  templateUrl: './create-new-prop.component.html',
  styleUrls: ['./create-new-prop.component.css']
})
export class CreateNewPropComponent implements OnInit {
  shows: Show[];
  newProp: NewProp;
  selectedShowId: number;
  newPropId: number;

  constructor(private propService: PropService, private aRoute: ActivatedRoute, private  router: Router) {
    this.newProp = new NewProp();
  }

  ngOnInit() {
    this.getShows();
    this.aRoute.params.subscribe(params => {
      this.newPropId = params['id'];
    });
    if (this.newPropId) {
      this.getNewProp();
    }
  }

  getShows() {
    this.propService.getShows().subscribe((data: Show[]) => {
        this.shows = data;
      },
      err => {
        alert('Nije uspelo preuzimanje bioskopa/pozorista, mozda ne postoji ni jedan u bazi.');
      });
  }

  createProp() {
    this.propService.createNewProp(this.newProp, this.selectedShowId)
      .subscribe(response => {
          alert('Uspesno kreiran rekvizit!');
          this.router.navigate(['adminfan/new-props-config']);
      },
        error1 => {
        alert('Doslo je do greske, proverite sva polja!');
        });
  }

  getNewProp() {
    this.propService.getNewProp(this.newPropId)
      .subscribe((data: NewProp) => {
          this.newProp = data;
        },
        error1 => {
          alert('Doslo je do greske, nije moguca izmena');
          this.router.navigate(['adminfan/new-props-config']);
        });
  }

  editProp() {
    this.propService.editNewProp(this.newProp, this.selectedShowId)
      .subscribe(response => {
          alert('Uspesno izmenjen rekvizit!');
          this.router.navigate(['adminfan/new-props-config']);
        },
        err => {
          alert('Doslo je do greske');
        });
  }
}
