import { TicketService } from './../../services/ticket.service';
import { ProjectionService } from './../../services/projection.service';
import { GoogleService } from './../../services/google.service';
import { ShowsService } from './../../services/shows.service';
import { PlayMovieService } from './../../services/play-movie.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MapsAPILoader } from '@agm/core';
import { NgbRatingConfig } from '@ng-bootstrap/ng-bootstrap';
import {AuthService} from '../../../auth.service'


@Component({
  selector: 'app-cinema-repertoire',
  templateUrl: './cinema-repertoire.component.html',
  styleUrls: ['./../../shows.css'],
  providers: [PlayMovieService, ShowsService, GoogleService, ProjectionService, TicketService, AuthService]
})
export class CinemaRepertoireComponent implements OnInit {
  private id;
  private showsplaymovies;
  private role;
  private show;
  private lat;
  private lng;
  private zoom = 17;
  private date;
  private disableNewRepertoire;
  private projections;
  private repertoire;
  private tickets;
  private deletedResponse;
  private ticket;
  username: string;
  private logged : boolean;

  constructor(private route: ActivatedRoute, private playMovieService: PlayMovieService, 
              private router: Router, private showsService: ShowsService,config: NgbRatingConfig,
              private googleService: GoogleService, private mapsAPILoader: MapsAPILoader,
              private projectionService: ProjectionService, private ticketService: TicketService,
              private authService : AuthService) {
    config.max = 5;
    config.readonly = true;
   }

  ngOnInit() {
    this.role = localStorage.getItem('role');
    this.username = localStorage.getItem('username');
    if (this.authService.isAuthenticated()) {
      this.logged = true;
    } else {
      this.logged = false;
    }

    this.role = localStorage.getItem('role');
    this.route.params.subscribe(params =>
      {
        this.id = params['id']
        this.ticketService.getTicketsOnSale(this.id).subscribe(data => this.tickets = data);
      });
    this.showsService.getShowById(this.id).subscribe(data => 
      {
        this.show = data;
        if(localStorage.getItem('username') !== null){
         this.showsService.addToHistory(this.id);
        }
        this.mapsAPILoader.load().then(() => { 
          this.googleService.getGeoLocation(this.show.address).subscribe(data => {
              this.lat = data.lat();
              this.lng = data.lng();
          });
        });
      });
    this.playMovieService.getShowsPlayMovies(this.id).subscribe(data => this.showsplaymovies = data); 
    
  }

  edit(idMovie){
    this.router.navigate([this.router.url + '/edit-movie/', idMovie]);
  }
/*
  remove(idMovie, objectForRemoval){
    var i = this.showsplaymovies.indexOf(objectForRemoval);
    this.showsplaymovies.splice(i, 1);
    this.playMovieService.removePlayMovie(idMovie).subscribe(data => null);
  }*/

  navigateToNewProjection(){
    this.router.navigate([this.router.url + '/new-projection/' + this.date]);
  }

  createRepertoire(){
    if(this.date === undefined){
      alert("Selektujte datum");
      return;
    }
    this.playMovieService.saveRepertoire(this.show, this.date).subscribe(data => null);
    this.disableNewRepertoire = true;
  }

  dateChanged($event){
    this.projections = null;
    this.disableNewRepertoire = false;
    this.playMovieService.getRepertoire(this.show, this.date).subscribe(data => 
    {
      if(data){
        this.disableNewRepertoire = true;
        this.repertoire = data;
        this.projectionService.getByRepertoire(this.repertoire).subscribe(projections => {
          this.projections = projections;
        })   
      }
    },
    err => null);
  }

  reserveTicket(ticketId, objectForRemoval){
    if(localStorage.getItem('username') !== null){
      this.ticketService.getTicketById(ticketId).subscribe(data => 
      {
        this.ticket = data;
        this.ticketService.reserveTicket(this.ticket, localStorage.getItem('username')).subscribe(data =>
          {
            var i = this.tickets.indexOf(objectForRemoval);
            this.tickets.splice(i, 1);
          })
      })
      
    }  
  }

  editProjection(projectionId){
    this.router.navigate([this.router.url + '/edit/' + projectionId]);
  }

  removeProjection(projectionId, objectForRemoval){
    this.projectionService.removeProjection(projectionId).subscribe(data => {
      this.deletedResponse = data;
      if(this.deletedResponse.response === 'deleted'){
        var i = this.projections.indexOf(objectForRemoval);
        this.projections.splice(i, 1);
      }else{
        alert("Nije moguce brisanje zbog karata koje su u prodaji za datu projekciju");
      }
    })
  }

  removeDiscount(ticketId, objectForRemoval){
    var ticket;
    this.ticketService.getTicketById(ticketId).subscribe(data =>{
      ticket = data;
      this.ticketService.removeDiscount(ticket).subscribe(data =>{
        var i = this.tickets.indexOf(objectForRemoval);
        this.tickets.splice(i, 1);
      });
    })
    
  }
}
