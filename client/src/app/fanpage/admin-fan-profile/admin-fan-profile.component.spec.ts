import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {AdminFanProfileComponent} from './admin-fan-profile.component';

describe('AdminFanProfileComponent', () => {
  let component: AdminFanProfileComponent;
  let fixture: ComponentFixture<AdminFanProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [AdminFanProfileComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminFanProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
