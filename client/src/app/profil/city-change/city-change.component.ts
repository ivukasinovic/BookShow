import { Component, OnInit } from '@angular/core';
import {ProfileService} from '../profile.service';

@Component({
  selector: 'app-city-change',
  templateUrl: './city-change.component.html',
  styleUrls: ['./city-change.component.css'],
  providers: [ProfileService]
})
export class CityChangeComponent implements OnInit {
  model : any = {}
  constructor(private profileService : ProfileService) {}

  ngOnInit() {
  }

  changeCity(){
    this.profileService.changeCity(this.model.newCity);
  }

}
