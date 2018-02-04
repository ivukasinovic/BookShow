import { Component, OnInit } from '@angular/core';
import {PropService} from '../prop.service';
import {Bid, UsedProp} from '../../models/prop';


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
  constructor(private propService: PropService) { }

  ngOnInit() {
    this.propService.getUsedProps().subscribe(
      (data: UsedProp[]) => {this.usedProps = data},
      err => console.error(err),
      () => console.log('Uspesno ucitani polovni rekviziti')
    );
  }
  getBids(usedPropId: number) {
    this.propService.getBids(usedPropId).subscribe(
      (data: Bid[]) => {this.bids = data},
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

}
