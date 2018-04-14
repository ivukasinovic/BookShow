import { Injectable } from '@angular/core';
import { NameChangeComponent } from './name-change/name-change.component';
import { SurnameChangeComponent } from './surname-change/surname-change.component';
import { EmailChangeComponent } from './email-change/email-change.component';
import { CityChangeComponent } from './city-change/city-change.component';
import { NumberChangeComponent } from './number-change/number-change.component';
import { PasswordChangeComponent } from './password-change/password-change.component';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import { Response } from '@angular/http';


@Injectable()
export class ProfileService {
  constructor(private http : HttpClient, private router : Router) { }

  sendFriendRequest(korisnik){
    alert(localStorage.getItem('username') + " salje zahtev korisniku " + korisnik);
    return this.http.get('api/sendRequest/'+localStorage.getItem('username')+'/'+korisnik)
  }

  confirmRequest(korisnik) {
    return this.http.get('api/confirmRequest/'+localStorage.getItem('username')+'/'+korisnik)
  }

  checkFriendship(korisnik){
    //alert(korisnik);
    return this.http.get('api/checkFriendship/'+localStorage.getItem('username')+'/'+korisnik)
  }

  checkPadding(korisnik){
    return this.http.get('api/checkPadding/'+localStorage.getItem('username')+'/'+korisnik)
  }

  checkRequested(korisnik){
    return this.http.get('api/checkRequested/'+localStorage.getItem('username')+'/'+korisnik)
  }

  getProfileInfo(){
    return this.http.get('api/getProfileInfo/'+localStorage.getItem('username'))
  }

  getProfileInfoOther(username : String){
    return this.http.get('api/getProfileInfo/'+username)
  }

  changeUsername(newUsername : String){
    return this.http.get('/api/changeUsername/'+localStorage.getItem('username')+'/'+newUsername).
    subscribe(
      (data)=> {
        alert("Uspesno je promenjeno korisnicko ime");
        this.router.navigate(['/profil']);
      }
    ),error=> {
      alert("Neispravan unos");
    }
  }

  changeName(newName : String){
    return this.http.get('/api/changeName/'+localStorage.getItem('username')+'/'+newName).
    subscribe(
      (data)=> {
        alert("Uspesno je promenjeno ime");
        this.router.navigate(['/profil']);
      }
    ),error=> {
      alert("Neispravan unos");
    }
  }

  changeSurname(newSurname : String){
    return this.http.get('/api/changeSurname/'+localStorage.getItem('username')+'/'+newSurname).
    subscribe(
      (data)=> {
        alert("Uspesno je promenjeno prezime");
        this.router.navigate(['/profil']);
      }
    ),error=> {
      alert("Neispravan unos");
    }
  }

  changeEmail(newEmail : String){
    return this.http.get('/api/changeEmail/'+localStorage.getItem('username')+'/'+newEmail).
    subscribe(
      (data)=> {
        alert("Uspesno je promenjena email adresa");
        this.router.navigate(['/profil']);
      }
    ),error=> {
      alert("Neispravan unos");
    }
  }    
  
  changeCity(newCity : String){
    return this.http.get('/api/changeCity/'+localStorage.getItem('username')+'/'+newCity).
    subscribe(
      (data)=> {
        alert("Uspesno je promenjen grad");
        this.router.navigate(['/profil']);
      }
    ),error=> {
      alert("Neispravan unos");
    }
  }
    
  
  changeNumber(newNumber : String){
    return this.http.get('/api/changeNumber/'+localStorage.getItem('username')+'/'+newNumber).
    subscribe(
      (data)=> {
        alert("Uspesno je promenjen broj telefona");
        this.router.navigate(['/profil']);
      }
    ),error=> {
      alert("Neispravan unos");
    }
  }

  changePassword(newPassword : String, oldPassword : String) {
    return this.http.post("/api/changePassword",
    {newPassword : newPassword ,username : 
      localStorage.getItem('username'),oldPassword:oldPassword}, {observe: 'response'})
    
    
  }


}
