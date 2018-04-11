import { Component, OnInit } from '@angular/core';
import {ProfileService} from '../profile.service';

@Component({
  selector: 'app-email-change',
  templateUrl: './email-change.component.html',
  styleUrls: ['./email-change.component.css'],
  providers: [ProfileService]
})
export class EmailChangeComponent implements OnInit {

  model : any = {}
  constructor(private profileService : ProfileService) {}

  ngOnInit() {
  }

  changeEmail(){
    this.profileService.changeEmail(this.model.newEmail);
  }
}
