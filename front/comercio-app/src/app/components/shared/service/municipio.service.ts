import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/enviroment.develoment';
import { Observable } from 'rxjs';
import { Municipio } from '../models/municipio';

@Injectable({
  providedIn: 'root',
})
export class MunicipioService {
  urlGeneral: string = environment.urlBack;
  constructor(private http: HttpClient) {}

  getAll(): Observable<Municipio> {
      const url = this.urlGeneral + "municipios/";
      return this.http.get<Municipio>(url);
    }
}
