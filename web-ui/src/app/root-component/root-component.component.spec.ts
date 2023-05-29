import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RootComponentComponent } from './root-component.component';

describe('RootComponentComponent', () => {
  let component: RootComponentComponent;
  let fixture: ComponentFixture<RootComponentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RootComponentComponent]
    });
    fixture = TestBed.createComponent(RootComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
