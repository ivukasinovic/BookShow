import {Component, Input, OnDestroy, OnInit} from '@angular/core';
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
  username: string;
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
    this.username = localStorage.getItem('username');
  }

  acceptBid(bidId: number) {
    this.propService.acceptBid(this.usedPropId, bidId)
      .subscribe(resp => {
          alert('Uspesno ste izabrali pobednika licitacije');
          this.router.navigate(['fanpage/my-ads']);
          window.location.reload();
      },
        error1 => {
        alert('Doslo je do greske!');
        window.location.reload();
        });
  }

  back() {
    window.history.back();
  }


}
