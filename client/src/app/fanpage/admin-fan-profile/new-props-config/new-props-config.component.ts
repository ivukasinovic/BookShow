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
    this.getNewPropsAll();
  }

  getNewPropsAll() {
    this.propService.getNewPropsAll()
      .subscribe((data: NewProp[]) => {
          this.newProps = data;
        },
        err => {
          alert('Nije uspelo ucitavanje tematskih rekvizita');
        });
  }

  deleteNewProp(newPropId: number) {
    this.propService.deleteNewProp(newPropId)
      .subscribe(response => {
          alert('Uspesno obrisan rekvizit');
          window.location.reload();
        },
        err => {
          alert('Nije uspelo brisanje rekvizita');
        });
  }


}
