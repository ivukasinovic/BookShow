import {Component, OnInit} from '@angular/core';
import {User} from '../../models/prop';
import {PropService} from '../../prop.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-personal-edit',
  templateUrl: './personal-edit.component.html',
  styleUrls: ['./personal-edit.component.css']
})
export class PersonalEditComponent implements OnInit {
  user: User;

  constructor(private propService: PropService, private router: Router) {
    this.user = new User();
  }

  ngOnInit() {
    this.getUser();
    console.log('Kaze jovas da ne radi: ' + localStorage.getItem('username'));
  }

  getUser() {
    this.propService.getUser()
      .subscribe((data: User) => {
          this.user = data;
        },
        error1 => {
          alert('Doslo je do greske, nije moguce prikupiti podatke o korisniku.');
        });
  }

  editUser() {
    this.propService.editUser(this.user)
      .subscribe(resp => {
          alert('Uspela promena!');
          this.router.navigate(['/adminfan']);
        },
        error1 => {
          alert('Nije uspela promene');
        });
  }
}
