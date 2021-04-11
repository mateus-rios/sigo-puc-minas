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
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { SharedComponentsModule } from '../shared/shared.module';
import { MatDatepickerModule } from '@angular/material/datepicker'
import { MatMomentDateModule, MomentDateAdapter } from '@angular/material-moment-adapter';
import { MatNativeDateModule, MAT_DATE_FORMATS, MAT_DATE_LOCALE, DateAdapter } from '@angular/material/core';
import { GestaoNormasComponent } from './gestao-normas/gestao-normas.component';
import { ListagemComponent } from './gestao-normas/listagem/listagem.component';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';


const DATE_INPUT_FORMATS = {
    parse: {
        dateInput: 'DD/MM/YYYY',
    },
    display: {
        dateInput: 'DD/MM/YYYY',
        monthYearLabel: 'MMMM YYYY',
        dateA11yLabel: 'LL',
        monthYearA11yLabel: 'MMMM YYYY',
    },
}

@NgModule({
    declarations: [
        SigninComponent,
        MainComponent,
        GestaoNormasComponent,
        ListagemComponent
    ],
    imports: [
        ReactiveFormsModule,
        RouterModule,
        HttpClientModule,
        MatInputModule,
        MatFormFieldModule,
        BrowserAnimationsModule,
        MatSliderModule,
        MatSnackBarModule,
        SharedComponentsModule,
        MatDatepickerModule,
        MatListModule,
        MatNativeDateModule,
        MatMomentDateModule,
        MatIconModule,
        MatButtonModule
    ],
    providers: [
        MatDatepickerModule,
        { provide: MAT_DATE_FORMATS, useValue: DATE_INPUT_FORMATS },
        { provide: MAT_DATE_LOCALE, useValue: 'pt-br' },
        { provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE] },
    ]
})
export class HomeModule {

}