export class User {
  constructor(public id: number, public name: string) {
  }
}

export interface UserRes {
  id: number
  name: string
}

export class Kanban {
  constructor(public id: number, public kanban: string, public cards: Card[], public owner: User) {
  }
}

export interface KanbanRes {
  id: number
  kanban: string
  cards: Card[]
  owner: User
}

export class Card {
  constructor(
    public id: number | null,
    public name: string,
    public type: string,
    public place: string,
    public url: string,
    public note: string,
    public end: string,
    public estimated: number,
    public tags: string[]
  ) {
  }
}

export interface CardRes {
  id: number
  name: string
  type: string
  place: string
  url: string
  note: string
  end: string
  estimated: number
  tags: string[]
}
