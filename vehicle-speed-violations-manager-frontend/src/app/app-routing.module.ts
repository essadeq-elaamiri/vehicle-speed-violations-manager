import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InfractionDetailsComponent } from './infraction-details/infraction-details.component';
import { InfractionsComponent } from './infractions/infractions.component';

const routes: Routes = [
  {
    path:"",
    component:InfractionsComponent
  },
  {
    path:"infractionDetails/:infractionId",
    component:InfractionDetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
