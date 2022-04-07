import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../service/api.service";
import {Kanban} from "../../object";
import {ActivatedRoute, Router} from "@angular/router";

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
              private apiService: ApiService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id')
    if (this.id === null) this.router.navigate(['/'])
    
    this.apiService.getKanban(this.id!!).subscribe((data) => {
      if (!data) this.router.navigate(['/'])
      else this.kanban = new Kanban(data.id, data.kanban, data.cards, data.owner)
    })

    this.apiService.getCardTypes().subscribe((data) => {
      this.cardTypes = data
    })
  }

  addCard(col: string) {

  }
}
