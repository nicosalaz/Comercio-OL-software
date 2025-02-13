import { Municipio } from "./municipio";
import { Usuario } from "./usuario";

export interface CrearActualizarComerciante{
	nombre:string;
	telefono:string;
	correoElectronico:string;
	municipioId: number;
	usuarioModifica: number;
	estado:number;
}