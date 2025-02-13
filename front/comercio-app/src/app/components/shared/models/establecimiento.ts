import { Comerciante } from "./comerciante";
import { Usuario } from "./usuario";

export interface Establecimiento{
    establecimientoId: number;
    nombre: string;
    ingresos: number;
    cantidadEmpleados: number;
    comercianteId:Comerciante;
    fechaActualizacion: Date;
    usuarioModifica: Usuario;
}