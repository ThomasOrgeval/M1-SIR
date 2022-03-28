import {Component, OnInit} from '@angular/core';
import {ApiService} from "./api.service";
import {User} from "./user";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'tp10';
  users: User[] = []

  constructor(private apiService: ApiService) {
  }

  ngOnInit(): void {
    this.apiService.getUsers().subscribe((data) => {
      data.forEach((e, index) => {
        this.users.push(new User(index, e.name))
      })
    })
    console.log(this.users)
  }
}
