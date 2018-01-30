import {Component, OnInit} from '@angular/core';
import {Location} from '@angular/common';
import {HttpClient} from '@angular/common/http';


@Component({
  selector: 'app-prop-detail',
  templateUrl: './prop-detail.component.html',
  styleUrls: ['./prop-detail.component.css']
})
export class PropDetailComponent implements OnInit {
  private propDetailUrl = 'api/funpage';

  constructor(private  location: Location,
              private  http: HttpClient) {
  }

  ngOnInit() {
  }


  goBack(): void {
    this.location.back();
  }

}
