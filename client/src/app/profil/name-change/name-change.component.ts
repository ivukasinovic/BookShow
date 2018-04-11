import { Component, OnInit } from '@angular/core';
import {ProfileService} from '../profile.service';


@Component({
  selector: 'app-name-change',
  templateUrl: './name-change.component.html',
  styleUrls: ['./name-change.component.css'],
  providers: [ProfileService]
})
export class NameChangeComponent implements OnInit {

  model : any = {}
  constructor(private profileService : ProfileService) {}

  ngOnInit() {
  }

  changeName() {
    this.profileService.changeName(this.model.newName);
  }
}
