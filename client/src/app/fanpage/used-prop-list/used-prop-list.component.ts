import {Component, OnInit} from '@angular/core';
import {PropService} from '../prop.service';
import {Bid, UsedProp} from '../models/prop';


@Component({
  selector: 'app-used-prop-list',
  templateUrl: './used-prop-list.component.html',
  styleUrls: ['./used-prop-list.component.css']
})
export class UsedPropListComponent implements OnInit {
  public isCollapsed = false;
  usedProps: UsedProp[];
  bids: Bid[];
  selectedProp: number;
  price: number;
  currentUser: string;
  all: boolean;

  constructor(private propService: PropService) {
  }

  ngOnInit() {
    this.all = false;
    this.getUsedProps();
    this.currentUser = localStorage.getItem('username');
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

  getBids(usedPropId: number) {
    this.all = true;
    this.propService.getBids(usedPropId).subscribe(
      (data: Bid[]) => {
        this.bids = data;
      },
      err => console.error(err),
      () => console.log('Uspesno ucitane ponude za rekvizit' + usedPropId)
    );
    this.selectedProp = usedPropId;
    console.log('selektovana' + this.selectedProp);
  }

  getBidColl(usedPropId: number) {
    this.getBids(usedPropId);
    this.isCollapsed = !this.isCollapsed;
  }

  createBid() {
    this.propService.createBid(this.selectedProp, this.price);
    this.isCollapsed = !this.isCollapsed;
    this.getBids(this.selectedProp);
  }

  delete(usedPropId: number) {
    this.propService.deleteUsedProp(usedPropId)
      .subscribe(response => {
          if (response.status === 204) {
            alert('Uspesno obrisan oglas');
            window.location.reload();
          }
        },
        error1 => {
          alert('Nije uspelo brisanje oglasa');
        });
  }

}
