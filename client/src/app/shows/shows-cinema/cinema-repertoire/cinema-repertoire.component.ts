import { ShowsService } from './../../shows.service';
import { PlayMovieService } from './../../play-movie.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbRatingConfig } from '@ng-bootstrap/ng-bootstrap';



@Component({
  selector: 'app-cinema-repertoire',
  templateUrl: './cinema-repertoire.component.html',
  styleUrls: ['./../../shows.css'],
  providers: [PlayMovieService, NgbRatingConfig, ShowsService]
})
export class CinemaRepertoireComponent implements OnInit {
  private id;
  private repertoire=[];
  private role;
  private show;

  constructor(private route: ActivatedRoute, private playMovieService: PlayMovieService, 
            private router: Router, config: NgbRatingConfig, private showsService: ShowsService,
         ) {
    config.max = 5;
    config.readonly = true;
   }

  ngOnInit() {
    this.role = localStorage.getItem('role');
    this.route.params.subscribe(params => this.id = params['id']);
    this.showsService.getShowById(this.id).subscribe(data => 
      {this.show = data
        this.showsService.addToHistory(this.id);
            });
    this.playMovieService.getShowsRepertoire(this.id).subscribe((data: any) => this.repertoire = data);
    
  }

  edit(idMovie){
    this.router.navigate([this.router.url + '/edit-movie/', idMovie]);
  }

  remove(idMovie, objectForRemoval){

    var i = this.repertoire.indexOf(objectForRemoval);
    this.repertoire.splice(i, 1);

    this.playMovieService.removePlayMovie(idMovie).subscribe(data => null);
  }

}
