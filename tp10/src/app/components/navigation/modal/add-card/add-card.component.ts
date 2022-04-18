import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Card} from "../../../../object";
import {ApiService} from "../../../../service/api.service";

@Component({
  selector: 'app-add-card',
  templateUrl: './add-card.component.html',
  styleUrls: ['./add-card.component.scss']
})
export class AddCardComponent {

  constructor(public dialogRef: MatDialogRef<AddCardComponent>,
              private apiService: ApiService,
              @Inject(MAT_DIALOG_DATA) public col: string) {
  }

  onNoClick(): void {
    this.dialogRef.close()
  }

  save(): void {
    console.log(this.col)
    let card: Card = new Card(null, "test", this.col, "Spain", "test url", "adaz", "2022-07-18 22:09:43.000000", 4, ["test", "tag2"])
    this.apiService.addCard(card).subscribe((id) => {
      console.log(id)
    })
    this.dialogRef.close()
  }
}
