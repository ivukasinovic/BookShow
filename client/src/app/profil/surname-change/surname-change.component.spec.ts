import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SurnameChangeComponent } from './surname-change.component';

describe('SurnameChangeComponent', () => {
  let component: SurnameChangeComponent;
  let fixture: ComponentFixture<SurnameChangeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SurnameChangeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SurnameChangeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
