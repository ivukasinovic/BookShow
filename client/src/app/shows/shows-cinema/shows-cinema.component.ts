import { ShowsService } from './../services/shows.service';
import { NgbRatingConfig } from '@ng-bootstrap/ng-bootstrap';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-shows-cinema',
  templateUrl: './shows-cinema.component.html',
  styleUrls: ['../shows.css'],
  providers: [ShowsService]
})
export class ShowsCinemaComponent implements OnInit {
  private shows;
  private type;
  private role;
  private ocene = [];

  constructor(private showsService: ShowsService, private router: Router, config: NgbRatingConfig, 
              private route: ActivatedRoute) {
    config.max = 5;
    config.readonly = true;
   }

  ngOnInit() {
    this.role = localStorage.getItem('role');
    this.route.params.subscribe(params => this.type = params['type']);
    this.showsService.getAllShowsByType(this.type).subscribe(data =>{
      this.shows = data
      for(var i = 0; i < this.shows.length; i++){
        this.showsService.getShowsRating(this.shows[i].id).subscribe((rateShow:any) =>{
          this.ocene.push(rateShow.value);
        })
      }
    });
  }

  showRepertoire(id){
    this.router.navigate([this.router.url + '/' + id]);
  }

  editShow(id){
    this.router.navigate([this.router.url + '/edit/' + id]);
  }
}
