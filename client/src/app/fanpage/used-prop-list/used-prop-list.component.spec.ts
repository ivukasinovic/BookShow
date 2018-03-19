import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {UsedPropListComponent} from './used-prop-list.component';

describe('UsedPropListComponent', () => {
  let component: UsedPropListComponent;
  let fixture: ComponentFixture<UsedPropListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [UsedPropListComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsedPropListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
