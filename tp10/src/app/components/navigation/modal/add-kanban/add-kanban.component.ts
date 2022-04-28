import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatDialogRef} from "@angular/material/dialog";
import {ApiService} from "../../../../service/api.service";
import {KanbanRes, User} from "../../../../object";
import {MatSelect} from "@angular/material/select";

@Component({
  selector: 'app-add-kanban',
  templateUrl: './add-kanban.component.html',
  styleUrls: ['./add-kanban.component.scss']
})
export class AddKanbanComponent implements OnInit, AfterViewInit {
  users!: User[]
  user: number = 1
  kanban: KanbanRes = new KanbanRes(null, "", new User(null, ""));
  @ViewChild('select') select!: MatSelect

  constructor(public dialogRef: MatDialogRef<AddKanbanComponent>,
              private apiService: ApiService) {
  }

  ngOnInit(): void {
    this.apiService.getUsers().subscribe((users) => {
      this.users = users
    })
  }

  ngAfterViewInit() {
    this.select.valueChange.subscribe(value => {
      console.log(value)
      this.user = value
    });
  }

  save(): void {
    this.apiService.addKanban(this.kanban).subscribe(() => {
    })
    this.dialogRef.close()
    window.location.reload()
  }
}
