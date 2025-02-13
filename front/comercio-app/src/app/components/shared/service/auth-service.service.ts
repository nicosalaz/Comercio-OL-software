import { Injectable } from '@angular/core';
import { environment } from '../../../environments/enviroment.develoment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthRequest } from '../models/authRequest';
import { AuthResponse } from '../models/authResponse';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  urlGeneral: string = environment.urlBack;
  constructor(private http: HttpClient) { }

  login(authLogin: AuthRequest): Observable<AuthResponse> {
    const url = this.urlGeneral + "auth/";
    return this.http.post<AuthResponse>(url, authLogin);
  }

  public set setUsuario(usuario: number) {
    localStorage.setItem("usuario", usuario.toString());
  }

  public get getUsuario(): number {
    return Number(localStorage.getItem("usuario"));
  }
}
