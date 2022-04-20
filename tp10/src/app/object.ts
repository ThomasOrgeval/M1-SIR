export class User {
  constructor(public id: number, public name: string) {
  }
}

export interface UserRes {
  id: number
  name: string
}

export class Kanban {
  constructor(public id: number, public kanban: string, public cards: Card[] | null, public owner: User | null) {
  }
}

export interface KanbanRes {
  id: number
  kanban: string
  owner_id: number
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
    public tags: string[] | null,
    public kanban_id: number | null,
    public user_id: number | null
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
