import { TestBed, inject } from '@angular/core/testing';

import { SeatReserService } from './seat-reser.service';

describe('SeatReserService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SeatReserService]
    });
  });

  it('should be created', inject([SeatReserService], (service: SeatReserService) => {
    expect(service).toBeTruthy();
  }));
});
