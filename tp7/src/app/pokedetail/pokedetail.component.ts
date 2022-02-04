import {Component, Input, OnInit} from '@angular/core';
import {PokeDetail} from "../pokemon";
import {PokeShareInfoService} from "../poke-share-info.service";

@Component({
  selector: 'app-pokedetail',
  templateUrl: './pokedetail.component.html',
  styleUrls: ['./pokedetail.component.scss'],
  providers: [PokeShareInfoService]
})
export class PokedetailComponent implements OnInit {

  @Input('detail')
  detail: PokeDetail

  constructor(private pokeShareInfoService: PokeShareInfoService) {
    this.pokeShareInfoService.getValue().subscribe(e => e)
  }

  ngOnInit(): void {
    this.pokeShareInfoService.getValue()
    console.log(this.detail)
  }

}
