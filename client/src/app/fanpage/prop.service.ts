import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Bid} from './models/prop';

@Injectable()
export class PropService {

  result: any;
  bidd: Bid;

  constructor(private http: HttpClient) {
  }

  getNewProps() {
    return this.http.get('/api/newProps');
  }

  getUsedProps() {
    return this.http.get('/api/usedProps');
  }

  reservation(id: number) {
    this.http.get('/api/newProps/reservation/' + id, {observe: 'response'})
      .subscribe(response => {
        this.result = response.statusText;
      });
    return this.result;
  }

  getBids(usedPropId: number) {
    return this.http.get('/api/bids/usedProp/' + usedPropId);
  }

  createBid(usedPropId: number, price: number) {
    const bid = {
      price: price
    };
    return this.http.post('/api/bids/' + usedPropId, bid).subscribe();
  }
}
