import { PlayMovieService } from './../../play-movie.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-cinema-repertoire',
  templateUrl: './cinema-repertoire.component.html',
  styleUrls: ['./../../shows.css'],
  providers: [PlayMovieService]
})
export class CinemaRepertoireComponent implements OnInit {
  private id;
  private repertoire=[];
  private role;

  constructor(private route: ActivatedRoute, private playMovieService: PlayMovieService, private router: Router) { }

  ngOnInit() {
    this.role = localStorage.getItem('role');
    this.route.params.subscribe(params => this.id = params['id']);
    this.playMovieService.getShowsRepertoire(this.id).subscribe((data: any) => this.repertoire = data);
  }

  edit(idMovie){
    this.router.navigate([this.router.url + '/edit-movie/', idMovie]);
  }

  remove(idMovie, objectForRemoval){

    var i = this.repertoire.indexOf(objectForRemoval);
    this.repertoire.splice(i, 1);
     //alert(objectForRemoval);

    this.playMovieService.removePlayMovie(idMovie).subscribe(data => null);
  }

}
