import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestaoNormasComponent } from './gestao-normas.component';

describe('GestaoNormasComponent', () => {
  let component: GestaoNormasComponent;
  let fixture: ComponentFixture<GestaoNormasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestaoNormasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GestaoNormasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
