import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BuisnessReportComponent } from './buisness-report.component';

describe('BuisnessReportComponent', () => {
  let component: BuisnessReportComponent;
  let fixture: ComponentFixture<BuisnessReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BuisnessReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BuisnessReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
