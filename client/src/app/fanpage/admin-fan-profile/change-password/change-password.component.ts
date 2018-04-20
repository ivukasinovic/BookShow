import {Component, OnInit} from '@angular/core';
import {PropService} from '../../prop.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {
  oldPw: string;
  newPw1: string;
  newPw2: string;

  constructor(private propService: PropService, private router: Router) {
  }

  ngOnInit() {

  }

  changePassword() {
    if (this.newPw1 !== this.newPw2) {
      alert('Nove lozinka mora biti ista u oba polja');
      return;
    }
    this.propService.changePassword(this.oldPw, this.newPw1)
      .subscribe(response => {
          if (response.status === 200) {
            alert('Uspesno promenjena lozinka');
            this.router.navigate(['/adminfan']);
          }
        },
        err => {
          alert('Nije uspela promena lozinke, proverite polja');
        });
  }

}
