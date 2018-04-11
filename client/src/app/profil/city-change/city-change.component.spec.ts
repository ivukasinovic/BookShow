import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CityChangeComponent } from './city-change.component';

describe('CityChangeComponent', () => {
  let component: CityChangeComponent;
  let fixture: ComponentFixture<CityChangeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CityChangeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CityChangeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
