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
  username: string;

  constructor(private propService: PropService) {
  }

  ngOnInit() {
    this.getUsedPropsNotFinished();
    this.username = localStorage.getItem('username');
  }

  getUsedPropsNotFinished() {
    this.propService.getUsedPropsNotFinished().subscribe(
      (data: UsedProp[]) => {
        this.usedProps = data;
      },
      err => console.error(err),
      () => console.log('Uspesno ucitani polovni rekviziti')
    );
  }

  decline(usedPropId: number) {
    this.propService.decline(usedPropId)
      .subscribe(resp => {
          alert('Uspesno odbijen oglas');
          window.location.reload();
        },
        error1 => alert('Nije uspelo odbijanje oglasa'));
  }

  accept(usedPropId: number) {
    this.propService.accept(usedPropId)
      .subscribe(resp => {
          alert('Uspesno odobren oglas');
          window.location.reload();
        },
        error1 => alert('Nije uspelo odobrenje oglasa'));
  }

  delete(usedPropId: number) {
    this.propService.delete(usedPropId)
      .subscribe(resp => {
          alert('Uspesno obrisan oglas');
          window.location.reload();
        },
        error1 => alert('Nije uspelo brisanje oglasa'));
  }

}
