import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HeroService {
  heroes = [{ name : 'blast', rank : 1},{ name : 'tornado', rank : 2},{ name : 'Silver fang', rank : 3},{ name : 'Childemperor', rank : 4},
  { name : 'Metal Knight', rank : 5},{ name : 'Kng', rank : 6},{ name : 'Drive Knight', rank : 7},{ name : 'Pig god', rank : 8},{ name : 'firestorm', rank : 9},{ name : 'Gurilla man', rank : 10}];
  getheroes() : any {
    return this.heroes;
  }
  constructor() { }
}
