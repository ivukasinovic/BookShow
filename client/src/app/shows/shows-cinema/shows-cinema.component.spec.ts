import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowsCinemaComponent } from './shows-cinema.component';

describe('ShowsCinemaComponent', () => {
  let component: ShowsCinemaComponent;
  let fixture: ComponentFixture<ShowsCinemaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowsCinemaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowsCinemaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
