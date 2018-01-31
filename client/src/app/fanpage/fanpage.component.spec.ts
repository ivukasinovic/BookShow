import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FanpageComponent } from './fanpage.component';

describe('FanpageComponent', () => {
  let component: FanpageComponent;
  let fixture: ComponentFixture<FanpageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FanpageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FanpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
