import { Component, OnInit } from '@angular/core';
import {ProfileService} from '../profile.service';

@Component({
  selector: 'app-surname-change',
  templateUrl: './surname-change.component.html',
  styleUrls: ['./surname-change.component.css'],
  providers: [ProfileService]
})
export class SurnameChangeComponent implements OnInit {

  model : any = {}
  constructor(private profileService : ProfileService) { }

  ngOnInit() {
  }

  changeSurname(){
    this.profileService.changeSurname(this.model.newSurname);
  }

}
