import { ShowsService } from './../../../services/shows.service';
import { ProjectionService } from './../../../services/projection.service';
import { PlayMovieService } from './../../../services/play-movie.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-edit-projection',
  templateUrl: './edit-projection.component.html',
  styleUrls: ['./edit-projection.component.css'],
  providers: [ProjectionService, PlayMovieService, ShowsService]
})
export class EditProjectionComponent implements OnInit {

  private projectionId;
  private projection: any = {};
  private showId;
  private playMovies;
  private auditoriums;
  private showType;
  private playMovieId;
  private auditoriumId;

  constructor(private route: ActivatedRoute, private projectionService: ProjectionService, 
              private playMovieService: PlayMovieService, private showService: ShowsService,
              private router: Router) { }

  ngOnInit() {
    this.route.params.subscribe(params =>
      { 
        this.showId = params['id'];
        this.showType = params['type'];
        this.playMovieService.getShowsPlayMovies(this.showId).subscribe(data => {
          this.playMovies = data;
        });
        this.showService.getAuditoriums(this.showId).subscribe(data => {
          this.auditoriums = data;
        });

        this.projectionId = params['projectionId'];
        this.projectionService.getProjection(this.projectionId).subscribe(data => 
          {
            this.projection = data
            this.playMovieId = this.projection.playfilm.id;
            this.auditoriumId = this.projection.auditorium.id;
          });
      });
  }

  sendData(){
    var playMovie;
    var auditorium;
    this.playMovieService.getPlayMovieById(this.playMovieId).subscribe(data => {
      playMovie = data
      this.showService.getAuditorium(this.auditoriumId).subscribe(data => {
        auditorium = data;
        this.projection.playfilm = playMovie;
        this.projection.auditorium = auditorium;
        this.projectionService.editProjection(this.projection).subscribe(data => this.router.navigate(['/shows/'+ this.showType + '/' + this.showId]));
      })
    });
  }

}
