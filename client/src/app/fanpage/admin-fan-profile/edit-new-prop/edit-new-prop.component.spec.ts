import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {EditNewPropComponent} from './edit-new-prop.component';

describe('EditNewPropComponent', () => {
  let component: EditNewPropComponent;
  let fixture: ComponentFixture<EditNewPropComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [EditNewPropComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditNewPropComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
