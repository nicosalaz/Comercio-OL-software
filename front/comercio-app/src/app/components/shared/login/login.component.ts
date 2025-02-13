import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { AuthServiceService } from '../service/auth-service.service';
import { AuthRequest } from '../models/authRequest';

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  formLogin: FormGroup = new FormGroup({
    correo: new FormControl(),
    clave: new FormControl(),
    condiciones: new FormControl(false)
  });
  usuario:AuthRequest;

  constructor(private authService: AuthServiceService) {}

  autenticar() {
    console.log(this.formLogin.value.condiciones);
    if (this.formLogin.value.condiciones) {
      this.usuario = {
        correo: this.formLogin.value.correo,
        clave:this.formLogin.value.clave
      }
      this.authService.login(this.usuario).subscribe((res)=>{
        console.dir(res.token);
      });
    }
  }
}
