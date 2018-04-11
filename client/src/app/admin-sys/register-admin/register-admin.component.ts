import {Component, OnInit} from '@angular/core';
import {User} from '../../fanpage/models/prop';
import {AdminSysService} from '../admin-sys.service';

@Component({
  selector: 'app-register-admin',
  templateUrl: './register-admin.component.html',
  styleUrls: ['./register-admin.component.css']
})
export class RegisterAdminComponent implements OnInit {
  user: User;
  username: string;

  constructor(private adminSysService: AdminSysService) {
    this.user = new User();
  }

  ngOnInit() {
    this.username = localStorage.getItem('username');
  }

  registerAdmin() {
    this.adminSysService.registerAdmin(this.user)
      .subscribe((data: User) => {
          alert('Uspesno registrovan administrator!');
        },
        error1 => {
          alert('Nije uspela registracija administratora');
        });
  }

}
