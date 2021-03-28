import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/core/auth.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  loginForm: FormGroup

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  login() {
    if (this.loginForm.valid) {      
      const credentials = this.loginForm.value
      this.authService.authenticate(credentials)
        .subscribe(
          res => {
            this.authService.saveSession(res)
            this.router.navigate(['main'])
          },
          error => {
            this.snackBar.open('Usuário ou senha inválidos. Verifique e tente novamente', 'OK')
          }
        )
    }
  }

}
