import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../service/api.service";
import {Card, Kanban} from "../../object";
import {ActivatedRoute, Router} from "@angular/router";
import {MatDialog} from "@angular/material/dialog";
import {AddCardComponent} from "../navigation/modal/add-card/add-card.component";
import {EditCardComponent} from "../navigation/modal/edit-card/edit-card.component";

@Component({
  selector: 'app-kanban',
  templateUrl: './kanban.component.html',
  styleUrls: ['./kanban.component.scss']
})
export class KanbanComponent implements OnInit {
  id!: string | null;
  kanban!: Kanban
  cardTypes!: string[]

  constructor(private router: Router,
              private route: ActivatedRoute,
              private apiService: ApiService,
              public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id')
    if (this.id === null) this.router.navigate(['/'])

    this.apiService.getKanban(this.id!!).subscribe((data) => {
      if (!data) this.router.navigate(['/'])
      else {
        this.apiService.getCardsKanban(this.id!!).subscribe((cards) => {
            this.kanban = new Kanban(data.id!!, data.kanban, cards, data.owner)
        })
      }
    })

    this.apiService.getCardTypes().subscribe((data) => {
      this.cardTypes = data
    })
  }

  addCard(type: string, kanban: Kanban): void {
    this.dialog.open(AddCardComponent, {
      width: '450px',
      data: {type, kanban},
    });
  }

  editCard(card: Card): void {
    this.dialog.open(EditCardComponent, {
      width: '450px',
      data: card,
    });
  }

  deleteKanban() {
    this.apiService.deleteKanban(this.kanban.id).subscribe(() => {
    })
    window.location.replace("")
  }
}
