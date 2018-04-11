import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-admin-sys',
  templateUrl: './admin-sys.component.html',
  styleUrls: ['./admin-sys.component.css']
})
export class AdminSysComponent implements OnInit {

  constructor(private  router: Router) {
  }

  ngOnInit() {
    this.router.navigate(['/adminsys/register-show']);
  }

}
