import { TestBed } from '@angular/core/testing';

import { SimpleGuardService } from './simple-guard.service';

describe('SimpleGuardService', () => {
  let service: SimpleGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SimpleGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
