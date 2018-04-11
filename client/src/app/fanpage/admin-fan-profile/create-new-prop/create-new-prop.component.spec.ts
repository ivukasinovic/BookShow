import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {CreateNewPropComponent} from './create-new-prop.component';

describe('CreateNewPropComponent', () => {
  let component: CreateNewPropComponent;
  let fixture: ComponentFixture<CreateNewPropComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CreateNewPropComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateNewPropComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
