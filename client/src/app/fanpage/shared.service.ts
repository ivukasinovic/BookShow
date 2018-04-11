import {Injectable} from '@angular/core';
import {Bid} from './models/prop';

@Injectable()
export class SharedService {
  bids: Bid[];
  creatorUsedProp: boolean;
  biddingFinished: boolean;

  constructor() {
  }

}
