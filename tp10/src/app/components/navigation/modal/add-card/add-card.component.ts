import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Card, User} from "../../../../object";
import {ApiService} from "../../../../service/api.service";
import {DateAdapter} from "@angular/material/core";
import {FormBuilder, FormGroup} from "@angular/forms";
import * as moment from 'moment';

@Component({
  selector: 'app-add-card',
  templateUrl: './add-card.component.html',
  styleUrls: ['./add-card.component.scss']
})
export class AddCardComponent implements OnInit {
  cardTypes!: string[]
  users!: User[]
  myForm !: FormGroup

  card: Card = new Card(
    null,
    "default name card",
    this.obj.type,
    "",
    "",
    "",
    "2022-01-01",
    0,
    [],
    this.obj.kanban.id,
    null
  )

  constructor(private _adapter: DateAdapter<any>,
              public dialogRef: MatDialogRef<AddCardComponent>,
              private apiService: ApiService,
              private fb: FormBuilder,
              @Inject(MAT_DIALOG_DATA) public obj: any) {
  }

  ngOnInit(): void {
    this._adapter.setLocale('fr')

    this.apiService.getUsers().subscribe((users) => {
      this.users = users
    })

    this.apiService.getCardTypes().subscribe((data) => {
      this.cardTypes = data
    })

    this.myForm = this.fb.group({
      end: [moment(), []],
    })
  }

  save(): void {
    this.apiService.addCard(this.card).subscribe(() => {
    })
    this.dialogRef.close()
    window.location.reload()
  }

  changeDatePicker(): any {
    this.card.end = moment(this.myForm.value.end).format('YYYY-MM-DD');
  }
}
