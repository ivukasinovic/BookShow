import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {UsedProp} from './models/prop';

@Injectable()
export class PropService {


  constructor(private http: HttpClient) {
  }

  getNewProps() {
    return this.http.get('/api/new-props');
  }

  getUsedProps() {
    return this.http.get('/api/used-props');
  }

  reservation(id: number) {
    return this.http.get('/api/new-props/reserve/' + id, {observe: 'response'});
  }

  getBids(usedPropId: number) {
    return this.http.get('/api/bids/used-prop/' + usedPropId);
  }

  createBid(usedPropId: number, price: number) {
    const bid = {
      price: price
    };
    return this.http.post('/api/bids/' + usedPropId, bid).subscribe();
  }

  createUsedProp(usedProp: UsedProp) {
    return this.http.post('/api/used-props', usedProp, {observe: 'response'});
  }

  getMyAds() {
    return this.http.get('api/used-props/user');
  }

  deleteUsedProp(id: number) {
    return this.http.delete('api/used-props/' + id, {observe: 'response'});
  }

  acceptBid(usedPropId: number, bidId: number) {

    return this.http.get('api/used-props/' + usedPropId + '/accept-bid/' + bidId, {observe: 'response'});
  }
}
