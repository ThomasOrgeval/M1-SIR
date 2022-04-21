import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from "@angular/material/dialog";
import {ApiService} from "../../../../service/api.service";
import {User} from "../../../../object";

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {
  user: User = new User(null, "")

  constructor(public dialogRef: MatDialogRef<AddUserComponent>,
              private apiService: ApiService) { }

  ngOnInit(): void {
  }

  save(): void {
    this.apiService.addUser(this.user).subscribe(() => {
    })
    this.dialogRef.close()
    window.location.reload()
  }
}
