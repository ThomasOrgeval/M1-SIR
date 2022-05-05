import {Component, OnInit} from '@angular/core';
import {Kanban} from "../../object";
import {ApiService} from "../../service/api.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  kanbans: Kanban[] = []

  constructor(private apiService: ApiService) {
  }

  ngOnInit(): void {
    this.apiService.getKanbans().subscribe((data) => {
      data.forEach((e) => {
        this.apiService.getUser(e.owner_id).subscribe((owner) => {
          this.kanbans.push(new Kanban(e.id!!, e.kanban, null, owner))
        })
      })
    })
  }

}
