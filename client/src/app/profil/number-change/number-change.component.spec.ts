import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NumberChangeComponent } from './number-change.component';

describe('NumberChangeComponent', () => {
  let component: NumberChangeComponent;
  let fixture: ComponentFixture<NumberChangeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NumberChangeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NumberChangeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
