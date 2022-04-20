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
              @Inject(MAT_DIALOG_DATA) public obj: any) {
  }

  save(): void {
    console.log(this.obj)
    let card: Card = new Card(
      null,
      "test",
      this.obj.type,
      "Spain",
      "test url",
      "adaz",
      "2022-07-18",
      4,
      ["test", "tag2"],
      this.obj.kanban.id,
      null
    )

    this.apiService.addCard(card).subscribe((id) => {
      console.log(id)
    })
    this.dialogRef.close()
  }
}
