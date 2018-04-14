import { Component, OnInit } from '@angular/core';
import {RegService} from '../reg.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-registracija',
  templateUrl: './registracija.component.html',
  styleUrls: ['./registracija.component.css'],
  providers: [RegService]
 
})
export class RegistracijaComponent implements OnInit {
  model: any = {};
  postojiUsername : String = "*Ili je username ili je email adresa vec zauzeta ili oboje";
  errorUsername = false;
  isteSifre : String = "*Sifre se poklapaju"
  errorSifre = false;
 
  
  
  constructor(private router: Router, private registrationService: RegService) { }

  ngOnInit() {
   /* console.log("usao je u registraciju")
    console.log( this.router.url);*/
  }

 registration(username : string, password : string ,passwordRepeat : string, name : string,
               surname : string, email : string,city:string, number : string)
{
  this.errorSifre = false;
  this.errorUsername = false;
 if(this.model.password !== this.model.passwordRepeat){
  this.errorSifre = true;
 } else {
   //alert("sifre se ne uklapaju")
   this.registrationService.registruj(this.model.username,this.model.password,this.model.name,
                                        this.model.surname,this.model.email,this.model.city,this.model.number)

   .subscribe(
    (data : any)=>{
      if(data) {
        this.router.navigate(['/']);
       alert("Dobili ste mail, potvrdite registraciju i aktivirajte nalog");
      }else {
        //console.log("data je false");
        this.errorUsername = true;     
      }
    },error =>{
      //console.log("upao je u error");
      this.errorUsername = true;
      
     
    }
    

   )
  }
 }

}