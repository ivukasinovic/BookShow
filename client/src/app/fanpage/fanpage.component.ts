import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';


@Component({
  selector: 'app-funpage',
  templateUrl: './fanpage.component.html',
  styleUrls: ['./fanpage.component.css']
})
export class FanpageComponent implements OnInit {
  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  getMyAds() {
    this.router.navigate(['fanpage/my-ads']);
  }

}

