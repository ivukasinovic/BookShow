import { TestBed, inject } from '@angular/core/testing';

import { BuissnessService } from './buissness.service';

describe('BuissnessService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BuissnessService]
    });
  });

  it('should be created', inject([BuissnessService], (service: BuissnessService) => {
    expect(service).toBeTruthy();
  }));
});
