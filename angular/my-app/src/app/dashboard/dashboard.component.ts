import { Component, OnInit } from '@angular/core';
import { analyzeAndValidateNgModules } from '@angular/compiler';
import { HEADER_OFFSET } from '@angular/core/src/render3/interfaces/view';
import { HeroService } from '../hero.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  
  heroes :any;
  topheroes :any;
  constructor(private heroservice: HeroService) { }


  ngOnInit() {
    this.heroes = this.heroservice.getheroes();
    this.topheroes  = this.heroes.slice(1,5);
  }

}
