import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {NewPropDetailComponent} from './new-prop-detail.component';

describe('NewPropDetailComponent', () => {
  let component: NewPropDetailComponent;
  let fixture: ComponentFixture<NewPropDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [NewPropDetailComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewPropDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
