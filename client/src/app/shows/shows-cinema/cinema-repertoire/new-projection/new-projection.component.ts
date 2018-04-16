import { ShowsService } from './../../../shows.service';
import { ActivatedRoute, Router } from '@angular/router';
import { PlayMovieService } from './../../../play-movie.service';
import { Component, OnInit } from '@angular/core';
import { ProjectionService } from '../../../projection.service';

@Component({
  selector: 'app-new-projection',
  templateUrl: './new-projection.component.html',
  styleUrls: ['./../../../shows.css'],
  providers: [ProjectionService, PlayMovieService, ShowsService]
})
export class NewProjectionComponent implements OnInit {

  private showId;
  private time;
  private playMovies;
  private selectedPlayMovieId;
  private auditoriums;
  private selectedAuditoriumId;
  private date;
  private showType;
  private show;
  private price;

  constructor(private route: ActivatedRoute, private projectionService: ProjectionService,
     private playMovieService: PlayMovieService, private showService: ShowsService, private router: Router) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.showId = params['id'];
      this.playMovieService.getShowsPlayMovies(this.showId).subscribe(data => {
        this.playMovies = data;
      });
      this.showService.getShowById(this.showId).subscribe(data => this.show = data);
      this.showService.getAuditoriums(this.showId).subscribe(data => {
        this.auditoriums = data;
      });
    });
    this.route.params.subscribe(params => this.date = params['date']);
    this.route.params.subscribe(params => this.showType = params['type']);
    
  }

  sendData(){
    var playMovie;
    var auditorium;
    this.playMovieService.getPlayMovieById(this.selectedPlayMovieId).subscribe(data => {
      playMovie = data
      this.showService.getAuditorium(this.selectedAuditoriumId).subscribe(data => {
        auditorium = data;
        this.projectionService.saveProjection(playMovie, auditorium, this.time, this.date, this.show, this.price).subscribe(data => this.router.navigate(['/shows/'+ this.showType + '/' + this.showId]));
      })
    });

  }
}
