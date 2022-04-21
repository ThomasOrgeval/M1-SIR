import {Component, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {AddKanbanComponent} from '../modal/add-kanban/add-kanban.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  addKanban() {
    this.dialog.open(AddKanbanComponent, {
      width: '450px',
    });
  }
}
