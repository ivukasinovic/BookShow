import {inject, TestBed} from '@angular/core/testing';

import {PropService} from './prop.service';

describe('PropService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PropService]
    });
  });

  it('should be created', inject([PropService], (service: PropService) => {
    expect(service).toBeTruthy();
  }));
});
