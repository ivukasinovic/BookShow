import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { SeatReserService } from './seat-reser.service';
import { allResolved } from 'q';
import {FriendsService} from '../../../../profil/friends/friends.service';
import { element } from 'protractor';

@Component({
  selector: 'app-seat-reservation',
  templateUrl: './seat-reservation.component.html',
  styleUrls: ['./seat-reservation.component.css'],
  providers: [SeatReserService,FriendsService]
})
export class SeatReservationComponent implements OnInit {

  private backgroundColor : String = "lightgray";
  numbers: any =  Array.from(Array(115)).map((x, i) => i );
  seats : any;
  id;
  projectionId;
  auditoriumId;
  rezervisana : any;
  markiraj : boolean = true;
  prozoviPrijatlejeProzor : boolean = false;
  prijatelji : any = {}
  brojac = 0;
  leviSelektovan;
  prijateljiZaPoziv = [];
  prijateljiIzListe = [];
  desniSelektovan;
  brojPrijatelja;
  i = 0;
  idSedista = [];
  
  constructor(private http : HttpClient, private route : ActivatedRoute,
     private seatReserService : SeatReserService, private friendsService: FriendsService) { }

  ngOnInit() {
    this.markiraj = true;
    this.brojac = 0;
   this.friendsService.getFriends().subscribe(
     data => {
      this.prijatelji = data;
      if(this.prijatelji.length > 0){
        this.leviSelektovan = this.prijatelji[0].username;
        this.brojPrijatelja = this.prijatelji.length;
        this.prijatelji.forEach(element => {
         // alert(element.username);
          this.prijateljiIzListe.push(element.username);
        });
      }
     }
   )

    
    this.prozoviPrijatlejeProzor = false;
    this.route.params.subscribe(params =>
      {
        this.id = params['auditoriumId'];
        this.projectionId = params['projectionId'];
        this.auditoriumId = params['auditoriumId'];
      });
    return this.http.get("api/getAllSeats/" + this.id).subscribe(
      data => {
        this.seats = data;
      }
    )
  }

  tolgeButton(id) {
   if(document.getElementById(id).style.backgroundColor == "lightgray"
      && document.getElementById(id).style.backgroundColor !== "lightcoral"){
      document.getElementById(id).style.backgroundColor = "skyblue";
      this.brojac++;
    }else {
      if(document.getElementById(id).style.backgroundColor !== "lightcoral")
      document.getElementById(id).style.backgroundColor = "lightgray";
      this.brojac--;
    }

    if(document.getElementById(id).style.backgroundColor == "lightcoral") {
      alert("Ovo mesto je zauzeto!");
      this.brojac++;
    }
  }

  markReserved(){
    if(this.markiraj == true){
       this.markiraj = false;
       this.seatReserService.getIds(this.projectionId,this.auditoriumId).subscribe(
       (data:any) => {  data.forEach(element => {
       //  alert(element.id);
          document.getElementById(element.id).style.backgroundColor = "lightcoral";});
      })
       }
    }

    /*markSeats(){
    this.rezervisana.forEach(key => {
      alert(this.rezervisana[key].id);
    })
  }*/

  rezervisi(){
    if(this.brojac === 0) {
      alert("Niste nista selektovali")
    }else if (this.prijateljiZaPoziv.length > this.brojac - 1) {
      this.brojac--;
      alert("Maksimalno smes da pozoves " + this.brojac + " prijatelja");
      this.brojac++;
    }else {
  

    this.seats.forEach(element => {
      if(document.getElementById(element.id).style.backgroundColor == "skyblue") {
        if(this.brojac > this.prijateljiZaPoziv.length){
       this.seatReserService.rezervisi(localStorage.getItem('username'),element,this.projectionId).subscribe(
         data =>{
          //alert("Uspesna rezervacija goreee");
          document.getElementById(element.id).style.backgroundColor = "lightcoral";
         }
       )
       this.brojac--;
      }

      /*if(this.brojac <= this.prijateljiZaPoziv.length && this.brojac >= 1)*/
      else {
        this.seatReserService.rezervisi(this.prijateljiZaPoziv[this.brojac - 1],element,this.projectionId).subscribe(
          data =>{
           //alert("Uspesna rezervacija doleeee");
           document.getElementById(element.id).style.backgroundColor = "lightcoral";
          }
        )  
        this.brojac--;      
      }



      } 
    });
    this.brojac = 0;
  }
  this.brojac = 0;
}


  dodaj(){
   this.prijateljiIzListe = this.prijateljiIzListe.filter(x => x !== this.leviSelektovan);
   this.prijateljiZaPoziv.push(this.leviSelektovan);
   this.leviSelektovan = this.prijateljiIzListe[0];
  }

  oduzmi() {
    this.prijateljiZaPoziv = this.prijateljiZaPoziv.filter(x => x !== this.desniSelektovan);
    this.prijateljiIzListe.push(this.desniSelektovan);
    this.desniSelektovan = this.prijateljiZaPoziv[0];
  }

}
