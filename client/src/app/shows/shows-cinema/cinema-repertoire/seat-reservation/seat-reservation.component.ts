import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { SeatReserService } from './seat-reser.service';
import { allResolved } from 'q';

@Component({
  selector: 'app-seat-reservation',
  templateUrl: './seat-reservation.component.html',
  styleUrls: ['./seat-reservation.component.css'],
  providers: [SeatReserService]
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
  
  constructor(private http : HttpClient, private route : ActivatedRoute, private seatReserService : SeatReserService) { }

  ngOnInit() {
    this.markiraj = true;
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
    }else {
      if(document.getElementById(id).style.backgroundColor !== "lightcoral")
      document.getElementById(id).style.backgroundColor = "lightgray"
    }

    if(document.getElementById(id).style.backgroundColor == "lightcoral") {
      alert("Ovo mesto je zauzeto!")
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
    this.seats.forEach(element => {
      if(document.getElementById(element.id).style.backgroundColor == "skyblue") {
       this.seatReserService.rezervisi(element,this.projectionId).subscribe(
         data =>{
          alert("Uspesna rezervacija");
          document.getElementById(element.id).style.backgroundColor = "lightcoral";
         }
       )
      } 
    });
  }

}
