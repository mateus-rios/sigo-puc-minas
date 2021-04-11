import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NormasService {

  private normasUrl: string
  constructor(
    private httpClient: HttpClient
  ) { 
    this.normasUrl = environment.gestaNormasUrl
  }

  private headers() {
    const token = localStorage.getItem('token')
    return {
      headers: {
        'Authorization' : `Bearer ${token}`
      }
    }
  }

  create(request) {
    return this.httpClient.post(this.normasUrl, request, this.headers())
  }

  listAll(): Observable<any> {
    return this.httpClient.get(`${this.normasUrl}/all`, this.headers())
  }

  delete(uuid): Observable<any> {
    return this.httpClient.delete(`${this.normasUrl}/${uuid}`, this.headers())
  }
}
