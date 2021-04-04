import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { NormasService } from 'src/app/core/normas.service';

@Component({
  selector: 'app-gestao-normas',
  templateUrl: './gestao-normas.component.html',
  styleUrls: ['./gestao-normas.component.css']
})
export class GestaoNormasComponent implements OnInit {

  creating: boolean
  normasForm: FormGroup
  constructor(
    private formBuilder: FormBuilder,
    private normasService: NormasService,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit() {
    this.normasForm = this.createForm()
  }

  private createForm(): FormGroup {
    return this.formBuilder.group({
      name: ['', Validators.required],
      version: ['', Validators.required],
      validity: ['', Validators.required],
      iso: ['', Validators.required]
    });
  }

  create() {
    if (this.normasForm.valid) {
      const { name, validity, iso, version } = this.normasForm.value
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
            this.normasForm = this.createForm()
          },
          error => {
            this.creating = false
            this.snackBar.open('Ocorreu um erro ao realizar a operação, tente novamente mais tarde', 'OK', { duration: 3000 })
          }
        )
    }
  }
}
