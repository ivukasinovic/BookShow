import { ShowsService } from './../services/shows.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-edit-show',
  templateUrl: './edit-show.component.html',
  styleUrls: ['../shows.css'],
  providers: [ShowsService]
})
export class EditShowComponent implements OnInit {

  private show: any = {};
  private id;
  private type;

  constructor(private showService: ShowsService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.route.params.subscribe(data =>
      {
        this.id = data['id'];
        this.type = data['type'];
        this.showService.getShowById(this.id).subscribe(data => this.show = data);
      });
  }

  sendData(){
    this.showService.updateShow(this.show).subscribe(data => this.router.navigate(['shows/' + this.type]));    
  }

}
