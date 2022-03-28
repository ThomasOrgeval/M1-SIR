import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserRes} from "./user";

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  user = '/api/user/'

  constructor(private http: HttpClient) { }

  getUsers(): Observable<UserRes[]> {
    return this.http.get<UserRes[]>(this.user);
  }
}
