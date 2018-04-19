import { ShowsService } from './../../../services/shows.service';
import { PlayMovieService } from './../../../services/play-movie.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-buisness-report',
  templateUrl: './buisness-report.component.html',
  styleUrls: ['./buisness-report.component.css'],
  providers: [ShowsService, PlayMovieService]
})
export class BuisnessReportComponent implements OnInit {

  private showId;
  private show;
  private playmovies;
  private startDate;
  private endDate;
  private profit;
  private chart = [];


  constructor(private route: ActivatedRoute, private showService: ShowsService, private playFilmService: PlayMovieService) { }

  ngOnInit() {
    this.route.params.subscribe(data => 
      {
        this.showId = data['id'];
        this.show = this.showService.getShowById(this.showId).subscribe(show => this.show = show);
        this.playFilmService.getShowsPlayMovies(this.showId).subscribe(playmovies => this.playmovies = playmovies);
      });
  }

  getProfit(){
    if(!this.startDate || !this.endDate){
      alert("Odaberite datum");
      return;
    }
    this.playFilmService.getProfit(this.startDate, this.endDate, this.showId).subscribe((data:any) => 
    {
      this.profit = data.profit;
    })
  }

}
