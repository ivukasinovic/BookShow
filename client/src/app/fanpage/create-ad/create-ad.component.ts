import {Component, OnInit} from '@angular/core';
import {UsedProp} from '../models/prop';
import {PropService} from '../prop.service';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-create-ad',
  templateUrl: './create-ad.component.html',
  styleUrls: ['./create-ad.component.css']
})
export class CreateAdComponent implements OnInit {
  usedProp: UsedProp;
  mesec: string;
  dan: string;
  model: NgbDateStruct;
  date: { year: number, month: number }
  time = {hour: 13, minute: 30};

  constructor(private propService: PropService) {
    this.usedProp = new UsedProp();

  }

  ngOnInit() {
  }

  create() {
    this.mesec = (this.model.month < 10) ? '0' + this.model.month.toString() : this.model.month.toString();
    this.time.hour -= 2;
    this.dan = (this.model.day < 10) ? '0' + this.model.day.toString() : this.model.day.toString();
    this.usedProp.activeUntil = this.model.year.toString() + '-' + this.mesec + '-' + this.dan.toString() + 'T' +
      this.time.hour.toString() + ':' + this.time.minute.toString() + ':' + '00Z';   // 'T03:03:30Z'; // 'T03:03:30Z';
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
