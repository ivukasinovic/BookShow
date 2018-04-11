import { Component, OnInit } from '@angular/core';
import {ProfileService} from '../profile.service';

@Component({
  selector: 'app-number-change',
  templateUrl: './number-change.component.html',
  styleUrls: ['./number-change.component.css'],
  providers: [ProfileService]
})
export class NumberChangeComponent implements OnInit {

  model : any = {}
  constructor(private profileService : ProfileService) { }

  ngOnInit() {
  }

  changeNumber(){
    this.profileService.changeNumber(this.model.newNumber);
  }

}
