import {Component, OnInit} from '@angular/core';
import {PropService} from '../prop.service';
import {Bid, UsedProp} from '../models/prop';
import {Router} from '@angular/router';
import {SharedService} from '../shared.service';

@Component({
  selector: 'app-my-ads',
  templateUrl: './my-ads.component.html',
  styleUrls: ['./my-ads.component.css']
})
export class MyAdsComponent implements OnInit {
  usedProps: UsedProp[];

  constructor(private propService: PropService, private router: Router, private sharedService: SharedService) {
  }

  ngOnInit() {
    this.getMyAds();
  }

  getMyAds() {
    this.propService.getMyAds()
      .subscribe((response: UsedProp[]) => {
        this.usedProps = response;
      });
  }

  deleteUsedProp(id: number) {
    this.propService.deleteUsedProp(id)
      .subscribe(resp => {
        if (resp.status === 204) {
          alert('Uspesno obrisan oglas i sve licitacije');
        } else {
          alert('Nije uspelo brisanje oglasa, doslo je do greske.');
        }
      });
  }

  getBids(usedPropId: number, usedPropBid: number) {
    if (usedPropBid) {
      this.sharedService.biddingFinished = true;
    }else {
      this.sharedService.biddingFinished = false;
    }
    this.propService.getBids(usedPropId).subscribe(
      (data: Bid[]) => {
        if (data.length === 0) {
          alert('Za odabrani oglas nema ni jedne ponude');
        } else {
          this.sharedService.bids = data;
          this.sharedService.creatorUsedProp = true;
          this.router.navigate(['/fanpage/used-prop/' + usedPropId + '/bids']);
        }
      },
      err => console.error(err)
    );
  }

}
