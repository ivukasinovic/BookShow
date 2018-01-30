import {Component, OnInit} from '@angular/core';
import {FanpageService} from './fanpage-services/fanpage.service';
import {Observable} from 'rxjs/Observable';
import {HttpClient} from '@angular/common/http';
import {UsedProp} from '../models/prop';
import {NewProp} from '../models/prop';
import {Response} from '@angular/http';
import { map } from 'rxjs/operators';


@Component({
  selector: 'app-funpage',
  templateUrl: './funpage.component.html',
  styleUrls: ['./funpage.component.css']
})
export class FunpageComponent implements OnInit {
  newProps: UsedProp[];
  usedProps: UsedProp[];
  newProp: NewProp;
  usedProp: UsedProp;
  id: number;

  constructor(private fanPageService: FanpageService, private http: HttpClient) {

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

