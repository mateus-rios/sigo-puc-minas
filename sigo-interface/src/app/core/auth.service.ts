import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { environment } from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private httpClient: HttpClient
  ) { }

  authenticate({username, password}) {
    return this.httpClient.post(environment.loginUrl, {username, password})
  }

  saveSession(token) {
    localStorage.setItem('token', token)
  }
}
