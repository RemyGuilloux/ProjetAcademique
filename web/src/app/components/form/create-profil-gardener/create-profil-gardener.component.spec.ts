import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateProfilGardenerComponent } from './create-profil-gardener.component';

describe('CreateProfilGardeningComponent', () => {
  let component: CreateProfilGardenerComponent;
  let fixture: ComponentFixture<CreateProfilGardenerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateProfilGardenerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateProfilGardenerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
