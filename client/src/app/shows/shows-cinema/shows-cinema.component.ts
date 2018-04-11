import { Component, OnInit } from '@angular/core';
import { ShowsService } from '../shows.service';
import {Router} from '@angular/router';


@Component({
  selector: 'app-shows-cinema',
  templateUrl: './shows-cinema.component.html',
  styleUrls: ['../shows.css'],
  providers: [ShowsService]
})
export class ShowsCinemaComponent implements OnInit {
  private shows = [];

  constructor(private showsService: ShowsService, private router: Router) { }

  ngOnInit() {
    this.showsService.getAllCinemaShows().subscribe((data: any) => this.shows = data); 
  }

  showRepertoire(id){
    this.router.navigate(['/shows-cinema/', id]);
  }

}
