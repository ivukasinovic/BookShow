import {Component, OnInit} from '@angular/core';
import {UsedProp} from '../../models/prop';
import {PropService} from '../../prop.service';

@Component({
  selector: 'app-used-props-config',
  templateUrl: './used-props-config.component.html',
  styleUrls: ['./used-props-config.component.css']
})
export class UsedPropsConfigComponent implements OnInit {
  usedProps: UsedProp[];

  constructor(private propService: PropService) {
  }

  ngOnInit() {
    this.getUsedProps();
  }

  getUsedProps() {
    this.propService.getUsedProps().subscribe(
      (data: UsedProp[]) => {
        this.usedProps = data;
      },
      err => console.error(err),
      () => console.log('Uspesno ucitani polovni rekviziti')
    );
  }

}
