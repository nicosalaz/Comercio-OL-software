import { Rol } from "./rol";

export interface Usuario{
    usuarioId: number;
    nombre:string;
    correElectronico:string;
    clave: string;
    rolId:Rol;
}