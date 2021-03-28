import { NgModule } from '@angular/core';
import { SigninComponent } from './signin/signin.component';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { MainComponent } from './main/main.component';
import { HttpClientModule } from '@angular/common/http';
import { MatInputModule } from '@angular/material/input';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSliderModule } from '@angular/material/slider'
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { SharedComponentsModule } from '../shared/shared.module';

@NgModule({
    declarations: [SigninComponent, MainComponent],
    imports: [
        ReactiveFormsModule,
        RouterModule,
        HttpClientModule,
        MatInputModule,
        MatFormFieldModule,
        BrowserAnimationsModule,
        MatSliderModule,
        MatSnackBarModule,
        SharedComponentsModule
    ]
})
export class HomeModule {

}