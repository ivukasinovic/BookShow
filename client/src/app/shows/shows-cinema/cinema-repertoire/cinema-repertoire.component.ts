import { ShowsService } from './../../shows.service';
import { PlayMovieService } from './../../play-movie.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { GoogleService } from '../../google.service';
import { MapsAPILoader } from '@agm/core';


@Component({
  selector: 'app-cinema-repertoire',
  templateUrl: './cinema-repertoire.component.html',
  styleUrls: ['./../../shows.css'],
  providers: [PlayMovieService, ShowsService, GoogleService]
})
export class CinemaRepertoireComponent implements OnInit {
  private id;
  private showsplaymovies=[];
  private role;
  private show;
  private lat;
  private lng;
  private zoom = 17;
  private date;
  private disableNewRepertoire;

  constructor(private route: ActivatedRoute, private playMovieService: PlayMovieService, 
              private router: Router, private showsService: ShowsService,config: NgbRatingConfig,
              private googleService: GoogleService, private mapsAPILoader: MapsAPILoader) {
    config.max = 5;
    config.readonly = true;
   }

  ngOnInit() {
    this.role = localStorage.getItem('role');
    this.route.params.subscribe(params => this.id = params['id']);
    this.showsService.getShowById(this.id).subscribe(data => 

      {
        this.show = data;
       this.showsService.addToHistory(this.id);
        this.mapsAPILoader.load().then(() => { 
          this.googleService.getGeoLocation(this.show.address).subscribe(data => {
              this.lat = data.lat();
              this.lng = data.lng();
          });
        });
      });
    this.playMovieService.getShowsPlayMovies(this.id).subscribe((data: any) => this.showsplaymovies = data); 

  }

  edit(idMovie){
    this.router.navigate([this.router.url + '/edit-movie/', idMovie]);
  }

  remove(idMovie, objectForRemoval){
    var i = this.showsplaymovies.indexOf(objectForRemoval);
    this.showsplaymovies.splice(i, 1);
    this.playMovieService.removePlayMovie(idMovie).subscribe(data => null);
  }

  createRepertoire(){
    if(this.date === undefined){
      alert("Selektujte datum");
      return;
    }
    this.playMovieService.saveRepertoire(this.show, this.date).subscribe(data => null);
    this.disableNewRepertoire = true;
  }

  myFunc($event){
    this.disableNewRepertoire = false;
    this.playMovieService.getRepertoire(this.show, this.date).subscribe(data => 
    {
      if(data){
        this.disableNewRepertoire = true;
        //alert(data);     
      }
    },
    err => null);
  }
}
