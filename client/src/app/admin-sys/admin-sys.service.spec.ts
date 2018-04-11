import { TestBed, inject } from '@angular/core/testing';

import { AdminSysService } from './admin-sys.service';

describe('AdminSysService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdminSysService]
    });
  });

  it('should be created', inject([AdminSysService], (service: AdminSysService) => {
    expect(service).toBeTruthy();
  }));
});
