import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InfractionsComponent } from './infractions/infractions.component';
import { HttpClientModule } from '@angular/common/http';
import { InfractionDetailsComponent } from './infraction-details/infraction-details.component';

@NgModule({
  declarations: [
    AppComponent,
    InfractionsComponent,
    InfractionDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
