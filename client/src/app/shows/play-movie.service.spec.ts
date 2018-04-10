import { TestBed, inject } from '@angular/core/testing';

import { PlayMovieService } from './play-movie.service';

describe('PlayMovieService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PlayMovieService]
    });
  });

  it('should be created', inject([PlayMovieService], (service: PlayMovieService) => {
    expect(service).toBeTruthy();
  }));
});
