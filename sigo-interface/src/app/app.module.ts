import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeModule } from './home/home.module';
import { SimpleGuardService } from './core/simple-guard.service';
import { ActionButtonComponent } from './shared/components/action-button/action-button.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HomeModule
  ],
  providers: [SimpleGuardService],
  bootstrap: [AppComponent],
})
export class AppModule { }
