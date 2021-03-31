import { ActionButtonComponent } from "./components/action-button/action-button.component";
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { RouterModule } from '@angular/router';

@NgModule({
    declarations: [ActionButtonComponent, HeaderComponent],
    exports: [ActionButtonComponent, HeaderComponent],
    imports: [CommonModule, RouterModule]
})
export class SharedComponentsModule {

}