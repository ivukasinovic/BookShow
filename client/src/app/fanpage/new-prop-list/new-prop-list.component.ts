import { Component, OnInit } from '@angular/core';
import {NewProp} from '../../models/prop';
import {PropService} from '../prop.service';

@Component({
  selector: 'app-new-prop-list',
  templateUrl: './new-prop-list.component.html',
  styleUrls: ['./new-prop-list.component.css']
})
export class NewPropListComponent implements OnInit {

  newProps: NewProp[];
  public props;
  constructor(private newPropService: PropService) { }
  ngOnInit() {
    this.newPropService.getNewProps().subscribe(
      (data: NewProp[]) => {this.newProps = data},
      err => console.error(err),
      () => console.log('Uspesno ucitani novi rekviziti')
    );
  }

}
