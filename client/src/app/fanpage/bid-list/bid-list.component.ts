import {Component, Input, OnInit} from '@angular/core';
import {Bid} from '../models/prop';
import {PropService} from '../prop.service';
import {SharedService} from '../shared.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-bid-list',
  templateUrl: './bid-list.component.html',
  styleUrls: ['./bid-list.component.css']
})
export class BidListComponent implements OnInit {

  @Input() bids: Bid[];
  creatorUsedProp: boolean;
  usedPropId: number;
  biddingFinished: boolean;
  constructor(private propService: PropService, private sharedService: SharedService, private aRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.bids = this.sharedService.bids;
    this.creatorUsedProp = this.sharedService.creatorUsedProp;
    this.aRoute.params.subscribe(params => {
      this.usedPropId = params['id'];
    });
    this.biddingFinished = this.sharedService.biddingFinished;
  }

  acceptBid(bidId: number) {
    this.propService.acceptBid(this.usedPropId, bidId)
      .subscribe(resp => {
        if (resp.status === 204) {
          alert('Uspesno ste izabrali pobednika licitacije');
          this.router.navigate(['fanpage/my-ads']);
          window.location.reload();
        } else {
          alert('Greska!');
        }
      });
  }

  back() {
    window.history.back();
  }

}
