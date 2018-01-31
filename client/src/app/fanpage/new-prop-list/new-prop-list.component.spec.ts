import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewPropListComponent } from './new-prop-list.component';

describe('NewPropListComponent', () => {
  let component: NewPropListComponent;
  let fixture: ComponentFixture<NewPropListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewPropListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewPropListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
