import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { NormasService } from 'src/app/core/normas.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  creating: boolean
  normasForm
  constructor(
    private formBuilder: FormBuilder,
    private normasService: NormasService,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit() {
    this.normasForm = this.formBuilder.group({
      name: ['', Validators.required],
      version: ['', Validators.required],
      validity: ['', Validators.required],
      iso: ['', Validators.required]
    })
  }

  create() {
    if (this.normasForm.valid) {
      const {name, validity, iso, version} = this.normasForm.value
      const request = {
        name,
        validity: validity.format('DD/MM/YYYY'),
        iso,
        version
      }
      this.creating = true
      this.normasService.create(request)
        .subscribe(
          res => {
            this.creating = false
            this.snackBar.open('Norma incluída com sucesso', 'OK', { duration: 3000 })
          },
          error => {
            this.creating = false
            this.snackBar.open('Ocorreu um erro ao realizar a operação, tente novamente mais tarde', 'OK', { duration: 3000 })
          }
        )
    }
  }

}
