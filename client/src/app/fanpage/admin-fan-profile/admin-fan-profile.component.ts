import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-admin-fan-profile',
  templateUrl: './admin-fan-profile.component.html',
  styleUrls: ['./admin-fan-profile.component.css']
})
export class AdminFanProfileComponent implements OnInit {

  constructor(private router: Router) {
  }

  ngOnInit() {
    this.router.navigate(['adminfan/new-props-config']);
  }

}
