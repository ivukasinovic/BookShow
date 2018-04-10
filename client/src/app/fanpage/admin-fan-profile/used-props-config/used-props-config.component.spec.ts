import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {UsedPropsConfigComponent} from './used-props-config.component';

describe('UsedPropsConfigComponent', () => {
  let component: UsedPropsConfigComponent;
  let fixture: ComponentFixture<UsedPropsConfigComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [UsedPropsConfigComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsedPropsConfigComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
