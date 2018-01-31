import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UsedProp} from '../models/prop';
import {NewProp} from '../models/prop';


@Component({
  selector: 'app-funpage',
  templateUrl: './fanpage.component.html',
  styleUrls: ['./fanpage.component.css']
})
export class FanpageComponent implements OnInit {
  newProps: UsedProp[];
  usedProps: UsedProp[];
  newProp: NewProp;
  usedProp: UsedProp;
  id: number;

  constructor( private http: HttpClient) {

  }

  ngOnInit() {

  }
  getUsedProp(id: number) {
    return this.http.get<UsedProp>('api/getPropUsed/1').subscribe(data => {
      console.log(data.title);
    });
  }
  getUsedProps() {
    this.http.get<UsedProp[]>('/api/getPropNews').subscribe(data => this.usedProps);
    console.log(this.usedProps);

  }
  getNewProp(id: number) {
    return this.http.get<NewProp>('api/getPropNew/' + id).subscribe(data => {
      console.log(data.title);
    });
  }
}

