import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SigninComponent } from './home/signin/signin.component';
import { MainComponent } from './home/main/main.component';
import { SimpleGuardService } from './core/simple-guard.service';

const routes: Routes = [
  {
    path: '',
    component: SigninComponent
  },
  {
    path: 'main',
    component: MainComponent,
    canActivate: [SimpleGuardService]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
