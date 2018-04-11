import { Component, OnInit } from '@angular/core';
import {Show} from '../../fanpage/models/prop';
import {AdminSysService} from '../admin-sys.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register-show',
  templateUrl: './register-show.component.html',
  styleUrls: ['./register-show.component.css']
})
export class RegisterShowComponent implements OnInit {
  show: Show;
  constructor(private adminSysService: AdminSysService, private router: Router) {
    this.show = new Show();
  }

  ngOnInit() {
  }
  registerShow() {
    this.adminSysService.registerShow(this.show)
      .subscribe((data: Show) => {
        alert('Uspesno kreirano!');
        this.router.navigate(['/adminsys']);
      },
        error1 => {
        alert('Nije uspelo kreiranje, proverite podatke pa pokusajte ponovo');
        });
  }

}
