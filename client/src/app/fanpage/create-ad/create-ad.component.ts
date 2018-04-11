import {Component, OnInit} from '@angular/core';
import {UsedProp} from '../models/prop';
import {PropService} from '../prop.service';

@Component({
  selector: 'app-create-ad',
  templateUrl: './create-ad.component.html',
  styleUrls: ['./create-ad.component.css']
})
export class CreateAdComponent implements OnInit {
  usedProp: UsedProp;

  constructor(private propService: PropService) {
    this.usedProp = new UsedProp();

  }

  ngOnInit() {
  }

  create() {
    this.propService.createUsedProp(this.usedProp)
      .subscribe(
        resp => {
          if ((resp.status === 201) || (resp.status === 200)) {
            alert('Uspesno ste postavili oglas, ceka se potvrda administratora fan zone.');
            window.location.reload();
          }
        },
        err => {
          alert('Greska prilikom kreiranja oglasa, pokusajte ponovo. ');
        });
  }

}
