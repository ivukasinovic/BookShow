import { Component, OnInit } from '@angular/core';
import {PropService} from '../prop.service';
import {NewProp, UsedProp} from '../../models/prop';

@Component({
  selector: 'app-used-prop-list',
  templateUrl: './used-prop-list.component.html',
  styleUrls: ['./used-prop-list.component.css']
})
export class UsedPropListComponent implements OnInit {

  usedProps: UsedProp[];
  constructor(private newPropService: PropService) { }

  ngOnInit() {
    this.newPropService.getUsedProps().subscribe(
      (data: UsedProp[]) => {this.usedProps = data},
      err => console.error(err),
      () => console.log('Uspesno ucitani polovni rekviziti')
    );
  }

}
