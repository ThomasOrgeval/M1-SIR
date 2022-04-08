import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Card} from "../../../../object";

@Component({
  selector: 'app-edit-card',
  templateUrl: './edit-card.component.html',
  styleUrls: ['./edit-card.component.scss']
})
export class EditCardComponent {

  constructor(public dialogRef: MatDialogRef<EditCardComponent>,
              @Inject(MAT_DIALOG_DATA) public card: Card) {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
