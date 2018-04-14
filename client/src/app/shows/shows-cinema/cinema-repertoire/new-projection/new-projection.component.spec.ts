import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewProjectionComponent } from './new-projection.component';

describe('NewProjectionComponent', () => {
  let component: NewProjectionComponent;
  let fixture: ComponentFixture<NewProjectionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewProjectionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewProjectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
