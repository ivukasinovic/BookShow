import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {NewProp, UsedProp, User} from './models/prop';

@Injectable()
export class PropService {


  constructor(private http: HttpClient) {
  }

  getNewProps() {
    return this.http.get('/api/new-props');
  }

  getNewPropsAll() {
    return this.http.get('/api/new-props/all');
  }

  getNewProp(newPropId: number) {
    return this.http.get('/api/new-props/' + newPropId);
  }

  editNewProp(newProp: NewProp, showId: number) {
    newProp.fanAdmin = null;
    newProp.show = null;
    return this.http.put('api/new-props/' + showId, newProp);
  }

  createNewProp(newProp: NewProp, showId: number) {
    console.log('Uzeo' + showId);
    return this.http.post('api/new-props/' + showId, newProp, {observe: 'response'});
  }

  deleteNewProp(newPropId: number) {
    return this.http.delete('api/new-props/' + newPropId, {observe: 'response'});
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

  getShows() {
    return this.http.get('api/all-shows?type=all');
  }

  getUser() {
    const username = localStorage.getItem('username');
    return this.http.get('api/users/by-username?username=' + username);
  }

  editUser(user: User) {
    return this.http.put('api/users', user, {observe: 'response'});
  }

  changePassword(oldPw: string, newPw: string) {
    return this.http.get('api/users/change-password?oldPw=' + oldPw + '&newPw=' + newPw, {observe: 'response'});
  }

}
