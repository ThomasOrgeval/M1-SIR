import {Component, OnInit} from '@angular/core';
import {PokeApiService} from "../poke-api.service";
import {PokeDetail, Pokemon} from "../pokemon";
import {PokeShareInfoService} from "../poke-share-info.service";

@Component({
  selector: 'app-my-component',
  templateUrl: './my-component.component.html',
  styleUrls: ['./my-component.component.scss'],
  providers: [PokeApiService, PokeShareInfoService]
})
export class MyComponentComponent implements OnInit {
  id: string = ''
  pokemon: string = ''
  pokemons: Pokemon[] = []
  pokeDetail: PokeDetail | undefined

  constructor(private pokeService: PokeApiService,
              private pokeShareInfoService: PokeShareInfoService) {
  }

  ngOnInit(): void {
    this.pokeService.getPokemons().subscribe((data) => {
      data.results.forEach((e, index) => {
        this.pokemons.push(new Pokemon(index, e.name, e.url))
      })
    })
  }

  button() {
    if (this.pokemon != '')
      this.pokeService.getPokemonInfo(this.pokemon).subscribe(data => {
        this.pokeDetail = data
        this.pokeShareInfoService.setValue(this.pokemon)
      })
  }
}
