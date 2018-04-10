import { PlayMovieService } from './../../play-movie.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-cinema-repertoire',
  templateUrl: './cinema-repertoire.component.html',
  styleUrls: ['./cinema-repertoire.component.css'],
  providers: [PlayMovieService]
})
export class CinemaRepertoireComponent implements OnInit {
  private id;
  private repertoire=[];

  constructor(private route: ActivatedRoute, private playMovieService: PlayMovieService) { }

  ngOnInit() {
    this.route.params.subscribe(params => this.id = params['id']);
    this.playMovieService.getShowsRepertoire(this.id).subscribe((data: any) => this.repertoire = data);
  }

}
