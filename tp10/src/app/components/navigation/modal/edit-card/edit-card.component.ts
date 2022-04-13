import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Card} from "../../../../object";
import {ApiService} from "../../../../service/api.service";

@Component({
  selector: 'app-edit-card',
  templateUrl: './edit-card.component.html',
  styleUrls: ['./edit-card.component.scss']
})
export class EditCardComponent {

  constructor(public dialogRef: MatDialogRef<EditCardComponent>,
              private apiService: ApiService,
              @Inject(MAT_DIALOG_DATA) public card: Card) {
  }

  save(): void {
    console.log(this.card)
    this.apiService.setCard(this.card).subscribe((id) => {
      console.log(id)
    })
    this.dialogRef.close()
  }
}
