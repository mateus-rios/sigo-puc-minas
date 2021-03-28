import { ActionButtonComponent } from "./components/action-button/action-button.component";
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@NgModule({
    declarations: [ActionButtonComponent],
    exports: [ActionButtonComponent],
    imports: [CommonModule]
})
export class SharedComponentsModule {
    
}