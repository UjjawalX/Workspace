import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router'
import { DashboardComponent } from '../dashboard/dashboard.component';
import { Route } from '@angular/compiler/src/core';
import { HeroesComponent } from '../heroes/heroes.component';
import { HeroDetailsComponent } from '../hero-details/hero-details.component';


const routes: Routes = [{
  path: "dashboard",
  component: DashboardComponent
},
{
  path: "heroes",
  component: HeroesComponent
},
{
  path: "heroes/hero-detail/:id",
  component: HeroDetailsComponent
},
{
  path: "dashboard/hero-detail/:id",
  component: HeroDetailsComponent
}];
@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule],
  declarations: []
})
export class AngularRouteModule { }
