import { ShowsService } from './../../../services/shows.service';
import { PlayMovieService } from './../../../services/play-movie.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-new-movie',
  templateUrl: './new-movie.component.html',
  styleUrls: ['./../../../shows.css'],
  providers: [PlayMovieService, ShowsService]
})
export class NewMovieComponent implements OnInit {
  private id;
  private type;
  private model: any = {};

  constructor(private route: ActivatedRoute, private playMovieService: PlayMovieService, private showsService: ShowsService, private router: Router) { }

  

  ngOnInit() {
    this.route.params.subscribe(params => this.id = params['id']);
    this.route.params.subscribe(params => this.type = params['type']);
    this.showsService.getShowById(this.id).subscribe((data: any) => this.model.show = data);
  }

  sendData(){
    this.playMovieService.createNewPlayMovie(this.model).subscribe(data => {
      this.model = null
      this.router.navigate(['/shows/' + this.type + '/' + this.id]);
    });
    
  }

}
