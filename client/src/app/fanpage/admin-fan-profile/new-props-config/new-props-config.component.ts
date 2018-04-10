import {Component, OnInit} from '@angular/core';
import {PropService} from '../../prop.service';
import {NewProp} from '../../models/prop';

@Component({
  selector: 'app-new-props-config',
  templateUrl: './new-props-config.component.html',
  styleUrls: ['./new-props-config.component.css']
})
export class NewPropsConfigComponent implements OnInit {
  newProps: NewProp[];

  constructor(private propService: PropService) {
  }

  ngOnInit() {
    this.getNewProps();
  }

  getNewProps() {
    this.propService.getNewProps()
      .subscribe((data: NewProp[]) => {
          this.newProps = data;
        },
        err => {
          alert('Nije uspelo ucitavanje tematskih rekvizita');
        });
  }


}
