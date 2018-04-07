import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowsTheatreComponent } from './shows-theatre.component';

describe('ShowsTheatreComponent', () => {
  let component: ShowsTheatreComponent;
  let fixture: ComponentFixture<ShowsTheatreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowsTheatreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowsTheatreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
