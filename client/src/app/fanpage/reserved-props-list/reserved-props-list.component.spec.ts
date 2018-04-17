import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservedPropsListComponent } from './reserved-props-list.component';

describe('ReservedPropsListComponent', () => {
  let component: ReservedPropsListComponent;
  let fixture: ComponentFixture<ReservedPropsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReservedPropsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservedPropsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
