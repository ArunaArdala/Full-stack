import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateParticipantStatusComponent } from './update-participant-status.component';

describe('UpdateParticipantStatusComponent', () => {
  let component: UpdateParticipantStatusComponent;
  let fixture: ComponentFixture<UpdateParticipantStatusComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateParticipantStatusComponent]
    });
    fixture = TestBed.createComponent(UpdateParticipantStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
