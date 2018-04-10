import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {NewPropsConfigComponent} from './new-props-config.component';

describe('NewPropsConfigComponent', () => {
  let component: NewPropsConfigComponent;
  let fixture: ComponentFixture<NewPropsConfigComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [NewPropsConfigComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewPropsConfigComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
