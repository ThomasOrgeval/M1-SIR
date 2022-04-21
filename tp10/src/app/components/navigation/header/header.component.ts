import {Component, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {AddKanbanComponent} from '../modal/add-kanban/add-kanban.component';
import {AddUserComponent} from "../modal/add-user/add-user.component";

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

  addUser() {
    this.dialog.open(AddUserComponent, {
      width: '450px',
    });
  }
}
