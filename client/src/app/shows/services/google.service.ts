import { Injectable } from '@angular/core';
import {} from '@types/googlemaps';
import { Observable } from 'rxjs/Observable';


@Injectable()
export class GoogleService {

  constructor() { }


  getGeoLocation(address: string): Observable<any> {
    console.log('Getting address: ', address);
    let geocoder = new google.maps.Geocoder();
    return Observable.create(observer => {
        geocoder.geocode({
            'address': address
        }, (results, status) => {
            if (status == google.maps.GeocoderStatus.OK) {
                observer.next(results[0].geometry.location);
                observer.complete();
            } else {
                console.log('Error: ', results, ' & Status: ', status);
                observer.error();
            }
        });
    });
  }
}
