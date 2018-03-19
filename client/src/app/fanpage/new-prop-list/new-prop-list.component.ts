import {Component, OnInit} from '@angular/core';
import {NewProp} from '../models/prop';
import {PropService} from '../prop.service';

@Component({
  selector: 'app-new-prop-list',
  templateUrl: './new-prop-list.component.html',
  styleUrls: ['./new-prop-list.component.css']
})
export class NewPropListComponent implements OnInit {

  result: any;
  newProps: NewProp[];

  constructor(private propService: PropService) {
  }

  ngOnInit() {
    this.propService.getNewProps().subscribe(
      (data: NewProp[]) => {
        this.newProps = data;
      },
      err => console.error(err),
      () => console.log('Uspesno ucitani novi rekviziti')
    );
  }

  reservation(id: number) {
    this.result = this.propService.reservation(id);
    console.log('Ivan' + this.result);
  }

}
