import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SigninComponent } from './home/signin/signin.component';
import { MainComponent } from './home/main/main.component';
import { SimpleGuardService } from './core/simple-guard.service';
import { GestaoNormasComponent } from './home/gestao-normas/gestao-normas.component';
import { ListagemComponent } from './home/gestao-normas/listagem/listagem.component';

const routes: Routes = [
  {
    path: '',
    component: SigninComponent
  },
  {
    path: 'main',
    component: MainComponent,
    canActivate: [SimpleGuardService]
  },
  {
    path: 'gestao-normas',
    component: GestaoNormasComponent,
    canActivate: [SimpleGuardService]
  },
  {
    path: 'gestao-normas/list',
    component: ListagemComponent,
    canActivate: [SimpleGuardService]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
