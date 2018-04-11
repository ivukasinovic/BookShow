import { Component, OnInit } from '@angular/core';
import {ProfileService} from '../profile.service';

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

  constructor(private profileService : ProfileService) { }

  ngOnInit() {
  }

  changePassword() {
    //alert(this.oldPassword+" "+this.newPassword+" "+this.newPasswordRepeated)
    if(this.newPassword !== this.newPasswordRepeated){
      this.neUklapajuSe = true;
    }else {
      this.profileService.changePassword(this.newPassword);
    }
  }

}
