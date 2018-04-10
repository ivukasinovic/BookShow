import { PlayMovieService } from './../../../play-movie.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-movie',
  templateUrl: './edit-movie.component.html',
  styleUrls: ['./../../../shows.css'],
  providers: [PlayMovieService]
})
export class EditMovieComponent implements OnInit {

  private movieId;
  private showId;
  private movieModel: any = {};
  constructor(private route: ActivatedRoute, private playMovieService: PlayMovieService, private router: Router) { }

  ngOnInit() {
    this.route.params.subscribe(params => this.movieId = params['movieId']);
    this.route.params.subscribe(params => this.showId = params['id']);
    this.playMovieService.getPlayMovieById(this.movieId).subscribe((data: any) => this.movieModel = data);
  }

  sendData(){
    this.movieModel.id = this.movieId;
    this.playMovieService.updatePlayMovie(this.movieModel).subscribe(data => {
      this.router.navigate(['/shows-cinema/', this.showId]);
    });
  }


}
