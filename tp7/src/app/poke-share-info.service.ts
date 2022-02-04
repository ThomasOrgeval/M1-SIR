import {Injectable} from '@angular/core';
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PokeShareInfoService {

  constructor() {
  }

  public value = new Subject<string>()

  setValue(val: string) {
    this.value.next(val)
  }

  getValue(): Subject<string> {
    return this.value
  }
}
