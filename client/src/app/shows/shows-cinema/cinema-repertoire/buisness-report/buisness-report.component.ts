import { BuissnessService } from './../../../services/buissness.service';
import { ShowsService } from './../../../services/shows.service';
import { PlayMovieService } from './../../../services/play-movie.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-buisness-report',
  templateUrl: './buisness-report.component.html',
  styleUrls: ['./buisness-report.component.css'],
  providers: [ShowsService, PlayMovieService, BuissnessService]
})
export class BuisnessReportComponent implements OnInit {

  private showId;
  private show;
  private playmovies;
  private startDate;
  private endDate;
  private profit;
  private todaysVisits;
  private weeksVisits;
  private monthsVisits;


  constructor(private route: ActivatedRoute, private showService: ShowsService, 
    private playFilmService: PlayMovieService, private buissnessService: BuissnessService) { }

  ngOnInit() {
    this.route.params.subscribe(data => 
      {
        this.showId = data['id'];
        this.show = this.showService.getShowById(this.showId).subscribe(show => this.show = show);
        this.playFilmService.getShowsPlayMovies(this.showId).subscribe(playmovies => this.playmovies = playmovies);
        this.buissnessService.getTodaysVisits(this.showId).subscribe((todaysVisits:any) => this.todaysVisits = todaysVisits.value);
        this.buissnessService.getThisWeeksVisits(this.showId).subscribe((weeksVisits:any) => this.weeksVisits = weeksVisits.value);
        this.buissnessService.getThisMonthsVisits(this.showId).subscribe((monthsVisits:any) => this.monthsVisits = monthsVisits.value);

      });
  }

  getProfit(){
    if(!this.startDate || !this.endDate){
      alert("Odaberite datum");
      return;
    }
    this.buissnessService.getProfit(this.startDate, this.endDate, this.showId).subscribe((data:any) => 
    {
      this.profit = data.profit;
    })
  }

}
