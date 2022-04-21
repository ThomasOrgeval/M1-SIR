import {Component, OnInit} from '@angular/core';
import {MatDialogRef} from "@angular/material/dialog";
import {ApiService} from "../../../../service/api.service";
import {KanbanRes, User} from "../../../../object";

@Component({
  selector: 'app-add-kanban',
  templateUrl: './add-kanban.component.html',
  styleUrls: ['./add-kanban.component.scss']
})
export class AddKanbanComponent implements OnInit {
  kanban: KanbanRes = new KanbanRes(null, "", 1)
  users!: User[]

  constructor(public dialogRef: MatDialogRef<AddKanbanComponent>,
              private apiService: ApiService) {
  }

  ngOnInit(): void {
    this.apiService.getUsers().subscribe((users) => {
        this.users = users
    })
  }

  save(): void {
    this.apiService.addKanban(this.kanban).subscribe(() => {})
    this.dialogRef.close()
    window.location.reload()
  }
}
