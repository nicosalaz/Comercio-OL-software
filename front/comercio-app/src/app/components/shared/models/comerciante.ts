import { Municipio } from "./municipio";
import { Usuario } from "./usuario";

export interface Comerciante{
    comercianteId: number;
    nombre: string;
    telefono: string;
    correoElectronico: string;
    municipioId: Municipio;
    fechaRegistro: Date;
    estado: number;
    fechaActualizacion: Date;
    usuarioModifica: Usuario;
}