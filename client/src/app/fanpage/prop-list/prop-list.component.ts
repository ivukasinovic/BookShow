import { Component, OnInit } from '@angular/core';
import {FanpageService} from '../fanpage-services/fanpage.service';

@Component({
  selector: 'app-prop-list',
  templateUrl: './prop-list.component.html',
  styleUrls: ['./prop-list.component.css']
})
export class PropListComponent implements OnInit {

  constructor(private fanpageService: FanpageService) { }

  ngOnInit() {
  }

}
