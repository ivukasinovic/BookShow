import { Component, OnInit } from '@angular/core';
import {ProfileService} from '../profile.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-password-change',
  templateUrl: './password-change.component.html',
  styleUrls: ['./password-change.component.css'],
  providers: [ProfileService]
})
export class PasswordChangeComponent implements OnInit {
  newPasswordRepeated : String;
  newPassword : String;
  oldPassword : String;
  neUklapajuSe = false;
  porukaNeUklapajuSe : String = "*Lozinke se ne poklapaju";
  wrongPassword : String = "*Pogresna sifra";
  oldPasswordWrong = false;

  constructor(private profileService : ProfileService, private router :  Router) { }

  ngOnInit() {
   this.oldPasswordWrong = false;
   this.neUklapajuSe = false;
  }

  changePassword() {
    this.neUklapajuSe = false;
    this.oldPasswordWrong = false;
    //alert(this.oldPassword+" "+this.newPassword+" "+this.newPasswordRepeated)
    if(this.newPassword !== this.newPasswordRepeated){
      this.neUklapajuSe = true;
    }else {
      this.profileService.changePassword(this.newPassword,this.oldPassword).subscribe(
        response =>{
            if(response.status === 200){
            this.router.navigate(['/profil']);
            alert("Lozinka je uspesno promenjena");     
            }               
          },error=>{
            this.oldPasswordWrong = true;
          });
    }
  }

}
