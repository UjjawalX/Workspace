import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { HeroService } from '../hero.service';
import { forEach } from '@angular/router/src/utils/collection';

@Component({
  selector: 'app-hero-details',
  templateUrl: './hero-details.component.html',
  styleUrls: ['./hero-details.component.css']
})
export class HeroDetailsComponent implements OnInit {

  id : any;
  heroes: any;
  hero : any;
  constructor(private routes: ActivatedRoute, private heroService: HeroService) { }

  ngOnInit() {
    //this.routes.paramMap.pipe(switchMap((parms: ParamMap) => this.id = parms.get('id')));
    this.id=this.routes.snapshot.paramMap.get('id');
    this.heroes = this.heroService.getheroes();
    this.heroes.forEach(element => {
      if(element.name == this.id){
        this.hero = element;
      }
    });
    
  }
}
