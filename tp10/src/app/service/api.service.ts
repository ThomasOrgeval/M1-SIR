import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Card, CardRes, KanbanRes, UserRes} from "../object";

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private endpoint = 'http://localhost:8080/'
  private kanban = this.endpoint + 'kanban/'
  private card = this.endpoint + 'card/'
  private cardType = this.endpoint + 'cardType/'
  private user = this.endpoint + 'user/'

  constructor(private http: HttpClient) {
  }

  /**
   * KANBANS
   */

  getKanbans(): Observable<KanbanRes[]> {
    return this.http.get<KanbanRes[]>(this.kanban);
  }

  getKanban(id: string): Observable<KanbanRes> {
    return this.http.get<KanbanRes>(this.kanban + id);
  }

  /**
   * CARDS
   */

  getCards(): Observable<CardRes[]> {
    return this.http.get<CardRes[]>(this.card);
  }

  getCard(id: number): Observable<CardRes> {
    return this.http.get<CardRes>(this.card + id);
  }

  setCard(card: Card): Observable<number> {
    return this.http.put<number>(this.card + card.id, card);
  }

  addCard(card: Card): Observable<number> {
    return this.http.post<number>(this.card, card);
  }

  deleteCard(id: number): Observable<void> {
    return this.http.delete<void>(this.card + id);
  }

  /**
   * USERS
   */

  getUsers(): Observable<UserRes[]> {
    return this.http.get<UserRes[]>(this.user);
  }

  getUser(id: number): Observable<UserRes> {
    return this.http.get<UserRes>(this.user + id);
  }

  getCardTypes(): Observable<string[]> {
    return this.http.get<string[]>(this.cardType);
  }
}
