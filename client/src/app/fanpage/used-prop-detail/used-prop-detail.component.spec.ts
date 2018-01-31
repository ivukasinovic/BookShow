import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsedPropDetailComponent } from './used-prop-detail.component';

describe('UsedPropDetailComponent', () => {
  let component: UsedPropDetailComponent;
  let fixture: ComponentFixture<UsedPropDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsedPropDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsedPropDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
