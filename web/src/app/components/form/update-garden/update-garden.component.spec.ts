import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateGardenComponent } from './update-garden.component';

describe('UpdateGardenComponent', () => {
  let component: UpdateGardenComponent;
  let fixture: ComponentFixture<UpdateGardenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateGardenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateGardenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
