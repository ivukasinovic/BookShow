import { Component, OnInit } from '@angular/core';
import { ShowsService } from '../shows.service';

@Component({
  selector: 'app-shows-theatre',
  templateUrl: './shows-theatre.component.html',
  styleUrls: ['./shows-theatre.component.css'],
  providers: [ShowsService]
})
export class ShowsTheatreComponent implements OnInit {
  private shows = [];

  constructor(private showsService: ShowsService) { }

  ngOnInit() {
    this.showsService.getAllTheatreShows().subscribe((data: any) => this.shows = data); 
  }

}
