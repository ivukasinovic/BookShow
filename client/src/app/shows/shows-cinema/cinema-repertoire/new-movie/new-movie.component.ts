import { ShowsService } from './../../../shows.service';
import { PlayMovieService } from './../../../play-movie.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-new-movie',
  templateUrl: './new-movie.component.html',
  styleUrls: ['./new-movie.component.css'],
  providers: [PlayMovieService, ShowsService]
})
export class NewMovieComponent implements OnInit {
  private id;
  private model: any = {};

  constructor(private route: ActivatedRoute, private playMovieService: PlayMovieService, private showsService: ShowsService, private router: Router) { }

  

  ngOnInit() {
    this.route.params.subscribe(params => this.id = params['id']);
    this.showsService.getShowById(this.id).subscribe((data: any) => this.model.show = data);
  }

  sendData(){
    this.playMovieService.createNewPlayMovie(this.model).subscribe(data => this.model = data);
    this.router.navigate(['/shows-cinema/', this.id]);
  }

}
