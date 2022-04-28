import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Card} from "../../../../object";
import {ApiService} from "../../../../service/api.service";
import {DateAdapter} from "@angular/material/core";
import {FormBuilder, FormGroup} from "@angular/forms";
import * as moment from "moment";

@Component({
  selector: 'app-edit-card',
  templateUrl: './edit-card.component.html',
  styleUrls: ['./edit-card.component.scss']
})
export class EditCardComponent implements OnInit {
  cardTypes!: string[]
  myForm !: FormGroup

  constructor(private _adapter: DateAdapter<any>,
              public dialogRef: MatDialogRef<EditCardComponent>,
              private apiService: ApiService,
              private fb: FormBuilder,
              @Inject(MAT_DIALOG_DATA) public card: Card) {
  }

  ngOnInit(): void {
    this._adapter.setLocale('fr')

    this.apiService.getCardTypes().subscribe((data) => {
      this.cardTypes = data
    })

    this.myForm = this.fb.group({
      end: [this.card.end, []],
    })
  }

  save(): void {
    this.apiService.setCard(this.card).subscribe(() => {
    })
    this.dialogRef.close()
  }

  changeDatePicker(): any {
    this.card.end = moment(this.myForm.value.end).format('YYYY-MM-DD');
  }

  delete() {
    this.apiService.deleteCard(this.card.id!!).subscribe(() => {
    })
    this.dialogRef.close()
    window.location.reload()
  }
}
