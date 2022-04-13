import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-add-card',
  templateUrl: './add-card.component.html',
  styleUrls: ['./add-card.component.scss']
})
export class AddCardComponent {

  constructor(public dialogRef: MatDialogRef<AddCardComponent>,
              @Inject(MAT_DIALOG_DATA) public col: string) { }

  onNoClick(): void {
    this.dialogRef.close()
  }
}
