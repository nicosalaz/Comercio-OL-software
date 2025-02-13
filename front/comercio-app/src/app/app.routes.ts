import { Routes } from '@angular/router';
import { LoginComponent } from './components/shared/login/login.component';
import { ComerciantesComponent } from './components/comerciantes/comerciantes.component';

export const routes: Routes = [
    {path:'',pathMatch: 'full',redirectTo: 'auth'},
    {path:'auth',component:LoginComponent},
    {path:'comerciantes',component:ComerciantesComponent},
];
