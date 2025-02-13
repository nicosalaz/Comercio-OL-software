import { Injectable } from '@angular/core';
import { environment } from '../../../environments/enviroment.develoment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CrearActualizarComerciante } from '../models/crearActualizarComerciante';
import { Comerciante } from '../models/comerciante';

@Injectable({
  providedIn: 'root',
})
export class ComercianteService {
  urlGeneral: string = environment.urlBack;
  constructor(private http:HttpClient) {}
  
  crear(crearActualizarComerciante:CrearActualizarComerciante):Observable<Boolean>{
    const url = this.urlGeneral+"comerciantes/crear";
    return this.http.post<Boolean>(url,crearActualizarComerciante);
  }

  actualizar(crearActualizarComerciante:CrearActualizarComerciante,comercianteId:number):Observable<Boolean>{
    const url = this.urlGeneral+"comerciantes/actualizar/"+comercianteId;
    return this.http.put<Boolean>(url,crearActualizarComerciante);
  }

  eliminar(comercianteId:number):Observable<Boolean>{
    const url = this.urlGeneral+"comerciantes/eliminar/"+comercianteId;
    return this.http.delete<Boolean>(url);
  }

  getById(comercianteId:number):Observable<Comerciante>{
    const url = this.urlGeneral+"comerciantes/"+comercianteId;
    return this.http.get<Comerciante>(url);
  }

  getAll():Observable<Comerciante[]>{
    const url = this.urlGeneral+"comerciantes/";
    return this.http.get<Comerciante[]>(url);
  }
}
