import {Component, OnInit} from '@angular/core';

const now = new Date();

@Component({
  selector: 'app-create-ad',
  templateUrl: './create-ad.component.html',
  styleUrls: ['./create-ad.component.css']
})
export class CreateAdComponent implements OnInit {
  model;

  constructor() {
  }

  ngOnInit() {
  }


}
