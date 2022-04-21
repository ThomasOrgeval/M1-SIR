import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddKanbanComponent } from './add-kanban.component';

describe('AddKanbanComponent', () => {
  let component: AddKanbanComponent;
  let fixture: ComponentFixture<AddKanbanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddKanbanComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddKanbanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
