import { Component, OnInit } from '@angular/core';
import { ShowsService } from '../shows.service';

@Component({
  selector: 'app-shows-cinema',
  templateUrl: './shows-cinema.component.html',
  styleUrls: ['./shows-cinema.component.css'],
  providers: [ShowsService]
})
export class ShowsCinemaComponent implements OnInit {
  private shows = [];

  constructor(private showsService: ShowsService) { }

  ngOnInit() {
    this.showsService.getAllCinemaShows().subscribe((data: any) => this.shows = data); 
  }

}
